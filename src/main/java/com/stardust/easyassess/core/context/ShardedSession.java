package com.stardust.easyassess.core.context;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

public class ShardedSession extends AbstractContext implements ContextSession {

    private HttpSession session;

    private String domain = "";

    public ShardedSession(HttpSession session, String domain) {
        this.session = session;
        this.domain = domain;
    }

    public void clear() {
        session.invalidate();
    }

    public void clear(String domain) {
        List<String> keys = Collections.list(session.getAttributeNames());
        for (String key : keys) {
            if (key.startsWith(domain + "_")) {
                session.removeAttribute(key);
            }
        }
    }

    public void remove(String index) {
        session.removeAttribute(domain + "_" + index);
    }

    protected Object getter(String index) {
        return session.getAttribute(domain + "_" + index);
    }

    protected void setter(String index, Object val) {
        session.setAttribute(domain + "_" + index, val);
    }
}
