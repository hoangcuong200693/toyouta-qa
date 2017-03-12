package com.example.ngothi.checksheet.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.ngothi.checksheet.R;

public class ScanActivity extends AppCompatActivity {
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        edittext =(EditText) findViewById(R.id.textSeq1);
    }
    public void Scan2(View v)
    {
        Intent intent = new Intent(ScanActivity.this, Sheetctivity.class);
        Bundle ten_image = new Bundle();
        ten_image.putString("Seq", edittext.getText().toString());
        intent.putExtra("GoiTen1",ten_image);
        startActivity(intent);
    }
    public void back1(View v)
    {
        finish();
    }
}
