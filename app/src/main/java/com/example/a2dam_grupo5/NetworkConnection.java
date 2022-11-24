package com.example.a2dam_grupo5;

import android.net.Uri;
import android.util.Log;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkConnection {
    private static final String LOG_TAG =
            NetworkConnection.class.getSimpleName();
    private static final String URL_SERVErNODE =
            "https://127.0.0.1:3000/auth/user/:";
    private static final String URL_mUser = "";
    private static final String URL_pass = "/passwd/:";
    private static final String URL_mPass = "";

    static String getLogin(String mUser, String mPass){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String loginJSONString = null;
        mUser=URL_mUser;
        mPass=URL_mPass;

        try {
            Uri builtURI = Uri.parse(URL_SERVErNODE).buildUpon()
                    .appendQueryParameter(URL_mUser,"")
                    .appendQueryParameter(URL_pass,"")
                    .appendQueryParameter(URL_mPass,"")
                    .build();
            URL requestURL = new URL(builtURI.toString());

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                return null;
            }
            loginJSONString = builder.toString();

            Log.d(LOG_TAG, loginJSONString);



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return loginJSONString;
    }
}