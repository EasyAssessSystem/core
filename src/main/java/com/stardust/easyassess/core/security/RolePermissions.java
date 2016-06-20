package com.stardust.easyassess.core.security;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RolePermissions implements Serializable {
    private Long role;

    private List<Permission> permissions = new ArrayList<Permission>();

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
