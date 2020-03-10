package com.example.cocktail_android.screenactivities.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cocktail_android.R;
import com.example.cocktail_android.redis.controllers.MachineController;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_users);

        MachineController.currentActivity = "admin_users";
    }
}
