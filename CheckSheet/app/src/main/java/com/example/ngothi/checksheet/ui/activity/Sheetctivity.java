package com.example.ngothi.checksheet.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ngothi.checksheet.R;
import java.io.File;

public class Sheetctivity extends AppCompatActivity {
    Dialog dialog;
    int number = 1;
    ImageView image, image12;
    TextView textseq, index;
    String seq, c1, c2, c3;
    int REQUEST_ID_IMAGE_CAPTURE = 1000;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheetctivity);
        image = (ImageView) findViewById(R.id.icon_check);
        textseq = (TextView) findViewById(R.id.textSeq);
        index = (TextView) findViewById(R.id.index);
        image12 = (ImageView) findViewById(R.id.image12);
        Intent Myintent = this.getIntent();
        Bundle packageFromCaller = Myintent.getBundleExtra("GoiTen1");
        seq = packageFromCaller.getString("Seq");
        textseq.setText(seq);
    }

    void number_check(int i, int c) {
        switch (i) {
            case 1:
                image.setImageResource(R.drawable.lopoto);
                if (c == 0)
                    c1 = "OK";
                else
                    c1 = "NG";
                number++;
                index.setText("2");
                break;
            case 2:
                image.setImageResource(R.drawable.denpha);
                if (c == 0)
                    c2 = "OK";
                else
                    c2 = "NG";
                number++;
                index.setText("3");
                break;
            case 3:

                if (c == 0)
                    c3 = "OK";
                else
                    c3 = "NG";
                Intent intent = new Intent(Sheetctivity.this, paperSheetActivity.class);
                Bundle ten_image = new Bundle();
                ten_image.putString("Seq", seq);
                ten_image.putString("c1", c1);
                ten_image.putString("c2", c2);
                ten_image.putString("c3", c3);
                ten_image.putString("goi", "ghi");
                intent.putExtra("GoiTen2", ten_image);
                startActivity(intent);
                break;
        }
    }

    public void ok1(View v) {
        number_check(number, 0);
    }

    public void NG1(View v) {
        number_check(number, 1);
    }

    public void chup1(View v) {
        Intent intent = new Intent(Sheetctivity.this, CameraMain.class);
        startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Bundle packageFromCaller = data.getBundleExtra("GoiTen");
                String tenFile = packageFromCaller.getString("tenfile");
                // Toast.makeText(MainActivity.this,tenFile,Toast.LENGTH_LONG).show();
                File imgFile = new File(tenFile);
                if (imgFile.exists()) {
                    Bitmap myBitmap1 = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                    image12.setImageBitmap(myBitmap1);
                }
            }
        }
    }
}