package com.enfotriz.signupfacebook;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;

public class Sharedpref {

    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;
    private final Gson gson;

    // constructor sharedpref
    public Sharedpref (Context context) {
        sharedPreferences = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();  // Initialize Gson object
    }

    // Save user data
    public void saveUser(ModelUser user) {
        String userJson = gson.toJson(user);  // Convert user object to Json
        editor.putString("user", userJson);
        editor.commit();  // Apply changes
    }

    // Retrieve data
    public ModelUser getUser() {
        String userJson = sharedPreferences.getString("user", null);
        if (userJson != null) {
            return gson.fromJson(userJson, ModelUser.class);  // Convert Json back to user object
        }
        return null;
    }
    // clear user data
    public void clearUser() {
        editor.remove("user");
        editor.apply();
    }
}
