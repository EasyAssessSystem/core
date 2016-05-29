package com.stardust.easyassess.core.security;


import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthenticationClient {

    private String authenticationServer = "";

    public AuthenticationClient(String authenticationServer) {
        this.authenticationServer = authenticationServer;
    }

    private String getResponseString(InputStream inputStream) throws Exception {
        byte[] data = read(inputStream);
        String objectString = new String(data);
        return objectString.replaceAll("\\u0000","").replaceAll("\n","");
    }

    private byte[] read(InputStream inputStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer);
        }
        inputStream.close();
        return outputStream.toByteArray();
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
                APIAuthentication apiAuthentication
                        = gson.fromJson(getResponseString(conn.getInputStream()), APIAuthentication.class);
                return apiAuthentication;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
