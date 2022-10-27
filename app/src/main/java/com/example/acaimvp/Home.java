package com.example.acaimvp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Home extends AppCompatActivity {

    public boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); //activity_display_message

        CardView cardView1, cardView2;
        cardView1 = findViewById(R.id.cardview1);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.office.com/Pages/DesignPageV2.aspx?subpage=design&FormId=4IeeTxP4U06aJmqIPfGkIyvs9pqq6WJNm_Zh94SsYHRUNUdFT1E3OE84RDI4MDhIQVZSM1FBVDZPWi4u&Token=6cc91985a7ca4e78b9a51dc9d4fbf342"));
//                startActivity(browserIntent);
                Toast.makeText(getApplicationContext(), "You already answered it", Toast.LENGTH_LONG).show();
            }
        });

        cardView2 = findViewById(R.id.cardview2);

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                if (!flag) {
                    Intent intent = new Intent(getApplicationContext(), FakeQuestions.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "You already answered it", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        flag = true;
        TextView status2 = findViewById(R.id.status2);
        status2.setText("Answered");
        status2.setTextColor(Color.parseColor("green"));

    }

}



