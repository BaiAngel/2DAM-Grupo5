package com.example.a2dam_grupo5;

import android.os.AsyncTask;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class FetchLog extends AsyncTask<String, Void, String> {
    private WeakReference<EditText> mUser;
    private WeakReference<EditText> mPass;

    FetchLog(EditText mUser, EditText mPass) {
        this.mUser = new WeakReference<>(mUser);
        this.mPass = new WeakReference<>(mPass);
    }

    @Override
    protected String doInBackground(String... strings) {

        return NetworkConnection.getLogin(String mUser, String mPass);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            int i = 0;
            String User = null;
            String Pass = null;
            while (i < itemsArray.length() &&
                    (Pass == null && User == null)) {
                // Get the current item information.
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                // Try to get the author and User from the current item,
                // catch if either field is empty and move on.
                try {
                    User = volumeInfo.getString("User");
                    Pass = volumeInfo.getString("Pass");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Move to the next item.
                i++;
            }
            // If both are found, display the result.
            if (User != null && Pass != null) {
                mUser.get().setText(User);
                mPass.get().setText(Pass);
            } else {
                // If none are found, update the UI to
                // show failed results.
                mUser.get().setText("");
                mPass.get().setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // If onPostExecute does not receive a proper JSON string,
            // update the UI to show failed results.
            mUser.get().setText("");
            mPass.get().setText("");
        }
    }
}
