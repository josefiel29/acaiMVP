package com.example.acaimvp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class FakeQuestions extends AppCompatActivity {
    public static final String EXTRA_TEXT = "Answered";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions); //activity_display_message

        Button buttonSend;
        buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Thanks for your answer!", Toast.LENGTH_LONG).show();
                setContentView(R.layout.activity_home);
//                Intent intent = new Intent(getApplicationContext(), Home.class);
//                intent.putExtra(EXTRA_TEXT,"Answered");
//                startActivity(intent);
                finish();
            }
        });

    }

}



