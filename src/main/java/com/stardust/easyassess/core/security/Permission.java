package com.stardust.easyassess.core.security;


public class Permission {

    private String path = "";
    private String desc = "";

    private boolean POST = false;
    private boolean GET = false;
    private boolean PUT = false;
    private boolean DELETE = false;
    private String menuRef = "";


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean getPOST() {
        return POST;
    }

    public void setPOST(boolean POST) {
        this.POST = POST;
    }

    public boolean getGET() {
        return GET;
    }

    public void setGET(boolean GET) {
        this.GET = GET;
    }

    public boolean getPUT() {
        return PUT;
    }

    public void setPUT(boolean PUT) {
        this.PUT = PUT;
    }

    public boolean getDELETE() {
        return DELETE;
    }

    public void setDELETE(boolean DELETE) {
        this.DELETE = DELETE;
    }

    public String getMenuRef() {
        return menuRef;
    }

    public void setMenuRef(String menuRef) {
        this.menuRef = menuRef;
    }

    public boolean allowed(String uri, String method) {
        if (uri.contains(getPath()) && getMethodPermission(method)) {
            return true;
        }
        return false;
    }

    private boolean getMethodPermission(String method) {
        if (method.equalsIgnoreCase("GET")) return  this.getGET();
        if (method.equalsIgnoreCase("PUT")) return  this.getPUT();
        if (method.equalsIgnoreCase("POST")) return  this.getPOST();
        if (method.equalsIgnoreCase("DELETE")) return  this.getDELETE();
        return false;
    }
}
