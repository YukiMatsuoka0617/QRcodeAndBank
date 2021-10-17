package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyInfoActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mBankNameEditText;
    private EditText mBankBranchNameEditText;
    private EditText mAccountNumberEditText;
    private EditText mAccountHolderEditText;

    public static final String SEPARATOR = "/";
    public static final String HEADER = "qr_code";
    public static final String QR_CODE = "QRCode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        mBankNameEditText = findViewById(R.id.bank_name_edit);
        mBankBranchNameEditText = findViewById(R.id.bank_branch_name_edit);
        mAccountNumberEditText = findViewById(R.id.account_number_edit);
        mAccountHolderEditText = findViewById(R.id.account_holder_edit);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qrCodeString = HEADER + SEPARATOR +
                        mBankNameEditText.getText().toString() + SEPARATOR +
                        mBankBranchNameEditText.getText().toString() + SEPARATOR +
                        mAccountNumberEditText.getText().toString() + SEPARATOR +
                        mAccountHolderEditText.getText().toString();
                Log.d("test", ""+qrCodeString);
                Intent intent = new Intent(getApplicationContext(), QRCodeActivity.class);
                intent.putExtra(QR_CODE,qrCodeString);
                startActivity(intent);
            }
        });
    }
}