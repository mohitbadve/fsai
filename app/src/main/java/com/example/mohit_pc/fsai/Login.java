package com.example.mohit_pc.fsai;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Login.this,MainActivity.class));
            }
        };
        Handler h = new Handler();
        h.postDelayed(r,3000);

    }
}
