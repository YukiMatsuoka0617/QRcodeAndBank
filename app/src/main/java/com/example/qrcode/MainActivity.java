package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonInfo = findViewById(R.id.my_information);
        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInfoIntent = new Intent(getApplicationContext(), MyInfoActivity.class);
                startActivity(myInfoIntent);
            }
        });

        Button buttonTransfer = findViewById(R.id.money_transfer);
        buttonTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInfoIntent = new Intent(getApplicationContext(), MoneyTransferActivity.class);
                startActivity(myInfoIntent);
            }
        });
    }
}