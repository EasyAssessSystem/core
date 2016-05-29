package com.stardust.easyassess.core.security;


import java.util.ArrayList;
import java.util.List;

public class APIAuthentication {

    private List<RolePermissions> roles = new ArrayList<RolePermissions>();

    public List<RolePermissions> getRoles() {
        return roles;
    }

    public void setRoles(List<RolePermissions> roles) {
        this.roles = roles;
    }
}