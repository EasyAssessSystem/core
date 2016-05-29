package com.stardust.easyassess.core.security;


public class PermissionChangeListener {
    private String name;
    private int port;
    private String updatePath;

    public PermissionChangeListener(String name, int port, String updatePath) {
        this.name = name;
        this.port = port;
        this.updatePath = updatePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUpdatePath() {
        return updatePath;
    }

    public void setUpdatePath(String updatePath) {
        this.updatePath = updatePath;
    }
}
