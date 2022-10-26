package com.example.acaimvp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); //activity_display_message

        CardView cardView1, cardView2;
        cardView1 = findViewById(R.id.cardview1);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.office.com/Pages/DesignPageV2.aspx?subpage=design&FormId=4IeeTxP4U06aJmqIPfGkIyvs9pqq6WJNm_Zh94SsYHRUNUdFT1E3OE84RDI4MDhIQVZSM1FBVDZPWi4u&Token=6cc91985a7ca4e78b9a51dc9d4fbf342"));
                startActivity(browserIntent);
            }
        });

        cardView2 = findViewById(R.id.cardview2);

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.office.com/pages/responsepage.aspx?id=4IeeTxP4U06aJmqIPfGkIyvs9pqq6WJNm_Zh94SsYHRUNUdFT1E3OE84RDI4MDhIQVZSM1FBVDZPWi4u"));
                startActivity(browserIntent);
            }
        });
        // Get the Intent that started this activity and extract the string
        //Intent intent = getIntent();

    }

}



