package com.example.ngothi.checksheet.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ngothi.checksheet.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class paperSheetActivity extends AppCompatActivity {
    String seq, c1, c2, c3, goi;
    String data = "";
    TextView index, pcheck1, pcheck2, pcheck3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper_sheet);
        index = (TextView) findViewById(R.id.in_seq);
        pcheck1 = (TextView) findViewById(R.id.p_check1);
        pcheck2 = (TextView) findViewById(R.id.p_check2);
        pcheck3 = (TextView) findViewById(R.id.p_check3);
        Intent Myintent = this.getIntent();
        Bundle packageFromCaller = Myintent.getBundleExtra("GoiTen2");
        seq = packageFromCaller.getString("Seq");
        c1 = packageFromCaller.getString("c1");
        c2 = packageFromCaller.getString("c2");
        c3 = packageFromCaller.getString("c3");
        goi = packageFromCaller.getString("goi");
        index.setText("Seq.=" + seq);
        pcheck1.setText(c1);
        pcheck2.setText(c2);
        pcheck3.setText(c3);

    }

    public void xong(View v) {
        String sdcard = "storage/emulated/0/Documents/text.txt";
        if (goi.compareTo("ghi") == 0) {
            try {
                Scanner scan = new Scanner(new File(sdcard));
                while (scan.hasNext()) {
                    data += scan.nextLine() +"\n";
                }
                scan.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(sdcard));
                writer.write(data);
                writer.write(seq + "|" + c1 + "|" + c2 + "|" + c3 + "|");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Intent intent1 = new Intent(paperSheetActivity.this, MainActivity.class);
            startActivity(intent1);
        }


        if (goi.compareTo("doc") == 0) {
            finish();
        }
    }
}
