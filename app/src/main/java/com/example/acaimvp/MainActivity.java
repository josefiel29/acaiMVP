package com.example.acaimvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;
    private EditText nameTxt, passwordTxt;
    private String name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLogin = findViewById(R.id.button);
        nameTxt = findViewById(R.id.name);
        passwordTxt = findViewById(R.id.password);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameTxt.getText().toString();
                password = passwordTxt.getText().toString();

                if (name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username or Password cannot be empty!", Toast.LENGTH_LONG).show();
                } else {
                    login();
                }

            }
        });

    }

    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setRegister(nameTxt.getText().toString());
        loginRequest.setPassword(passwordTxt.getText().toString());

        Call <LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call <LoginResponse> call, Response <LoginResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successfully logged in.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                } else {
                    try {
                        Toast.makeText(MainActivity.this, "Invalid credentials ", Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this, "Server returned error: " + response.errorBody().string(), Toast.LENGTH_LONG).show();
                        Log.e("Fiel", response.errorBody().string());
                    } catch (IOException e) {
                        Toast.makeText(MainActivity.this, "Server returned unknown error " , Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call <LoginResponse> call, Throwable t) {
                Log.e("Fiel", t.toString() + t.getLocalizedMessage());
                t.printStackTrace();
            }
        });

    }

}