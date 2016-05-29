package com.stardust.easyassess.core.security;


import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthenticationClient {

    private String authenticationServer = "";

    public AuthenticationClient(String authenticationServer) {
        this.authenticationServer = authenticationServer;
    }

    public RolePermissions getRolePermissions(Long role) {
        try {
            String authPath = authenticationServer + "/get/" + role;
            HttpURLConnection conn = (HttpURLConnection) new URL(authPath).openConnection();
            conn.setRequestProperty("Accept", "application/json;charset:utf-8");
            conn.setConnectTimeout(5000);
            conn.setUseCaches(false);
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestMethod("GET");
            Gson gson = new Gson();

            if (conn.getResponseCode() == 200) {
                Reader reader = new InputStreamReader(conn.getInputStream());
                RolePermissions rolePermissions
                        = gson.fromJson(reader, RolePermissions.class);
                return rolePermissions;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public RolePermissions saveRolePermissions(RolePermissions permissions) {
        try {
            String authPath = authenticationServer + "/save";
            HttpURLConnection conn = (HttpURLConnection) new URL(authPath).openConnection();
            conn.setRequestProperty("Accept", "application/json;charset:utf-8");
            conn.setConnectTimeout(5000);
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestMethod("PUT");
            Gson gson = new Gson();

            byte[] outputBytes = gson.toJson(permissions).getBytes("UTF-8");
            OutputStream os = conn.getOutputStream();
            os.write(outputBytes);
            os.close();

            if (conn.getResponseCode() == 200) {
                return permissions;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public APIAuthentication register(PermissionChangeListener observer) {
        try {
            String authPath = authenticationServer + "/register";
            HttpURLConnection conn = (HttpURLConnection) new URL(authPath).openConnection();
            conn.setRequestProperty("Accept", "application/json;charset:utf-8");
            conn.setConnectTimeout(5000);
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestMethod("PUT");
            Gson gson = new Gson();

            byte[] outputBytes = gson.toJson(observer).getBytes("UTF-8");
            OutputStream os = conn.getOutputStream();
            os.write(outputBytes);
            os.close();

            if (conn.getResponseCode() == 200) {
                Reader reader = new InputStreamReader(conn.getInputStream());
                APIAuthentication apiAuthentication
                        = gson.fromJson(reader, APIAuthentication.class);
                return apiAuthentication;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
