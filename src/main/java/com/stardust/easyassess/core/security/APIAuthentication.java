package com.stardust.easyassess.core.security;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class APIAuthentication implements Serializable {

    private List<RolePermissions> roles = new ArrayList<RolePermissions>();

    public List<RolePermissions> getRoles() {
        return roles;
    }

    public void setRoles(List<RolePermissions> roles) {
        this.roles = roles;
    }
}