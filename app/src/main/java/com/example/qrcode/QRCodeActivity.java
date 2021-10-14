package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRCodeActivity extends AppCompatActivity {

    private ImageView mImageView;
    int qrCodeSize = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        String qrCode = getIntent().getStringExtra(MyInfoActivity.QR_CODE);
        Log.d("test", ""+qrCode);

        mImageView = findViewById(R.id.qr_code);

        try{
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            //QRコードをBitmapで作成
            Bitmap bitmap = barcodeEncoder.encodeBitmap(qrCode, BarcodeFormat.QR_CODE,
                    qrCodeSize, qrCodeSize);
            mImageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Log.e("test","Error = " + e);
        }
    }
}