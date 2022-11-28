package com.example.a2dam_grupo5;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class FetchUser extends AsyncTask<String, Void, String> {
    private String mUserData;
    private String mPassData;

    FetchUser(String mUser, String mPass) {
        this.mUserData = mUser;
        this.mPassData = mPass;
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkConnection.getLogin(mUserData, mPassData);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray usuarios = jsonObject.getJSONArray("0");

            JSONObject usuarioss = usuarios.getJSONObject(0);

            String nombre = usuarioss.getString("nom");
            String pass = usuarioss.getString("pass");
            mUserData = nombre;
            mPassData = pass;

        } catch (JSONException e) {
            e.printStackTrace();
            mUserData = "";
            mPassData = "";
        }

    }
}
