package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MoneyTransferActivity extends AppCompatActivity {
    private Button mButton;
    private EditText mBankNameEditText;
    private EditText mBankBranchNameEditText;
    private EditText mAccountNumberEditText;
    private EditText mAccountHolderEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_transfer);

        mBankNameEditText = findViewById(R.id.bank_name_edit);
        mBankBranchNameEditText = findViewById(R.id.bank_branch_name_edit);
        mAccountNumberEditText = findViewById(R.id.account_number_edit);
        mAccountHolderEditText = findViewById(R.id.account_holder_edit);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentIntegrator(MoneyTransferActivity.this).initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String[] splitString = null;
        if (result != null) {
            String qrCodeString = result.getContents();
            if (qrCodeString != null) {
                splitString = qrCodeString.split(MyInfoActivity.SEPARATOR);
                Log.d("test", ""+splitString.length);
            }
            if (splitString.length == 5){
                if (splitString[0].equals(MyInfoActivity.HEADER)) {
                    mBankNameEditText.setText(splitString[1]);
                    mBankBranchNameEditText.setText(splitString[2]);
                    mAccountNumberEditText.setText(splitString[3]);
                    mAccountHolderEditText.setText(splitString[4]);
                    Log.d("test", "Copy OK");
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}