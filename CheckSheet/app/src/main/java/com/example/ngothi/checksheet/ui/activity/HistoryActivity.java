package com.example.ngothi.checksheet.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ngothi.checksheet.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HistoryActivity extends AppCompatActivity {
Button ma0,ma1,ma2,ma3,cc01,cc02,cc03,cc11,cc12,cc13,cc21,cc22,cc23,cc31,cc32,cc33;
    EditText txttimkiem;
    int k=0,vt=1;

    String data="",seq="",c1="",c2="",c3="";
    String sdcard="storage/emulated/0/Documents/text.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ma0= (Button)  findViewById(R.id.maseq0);
        ma1= (Button)  findViewById(R.id.maseq1);
        ma2= (Button)  findViewById(R.id.maseq2);
        ma3= (Button)  findViewById(R.id.maseq3);
        cc01=(Button) findViewById(R.id.c01);
        cc02=(Button) findViewById(R.id.c02);
        cc03=(Button) findViewById(R.id.c03);
        cc11=(Button) findViewById(R.id.c11);
        cc12=(Button) findViewById(R.id.c12);
        cc13=(Button) findViewById(R.id.c13);
        cc21=(Button) findViewById(R.id.c21);
        cc22=(Button) findViewById(R.id.c22);
        cc23=(Button) findViewById(R.id.c23);
        cc31=(Button) findViewById(R.id.c31);
        cc32=(Button) findViewById(R.id.c32);
        cc33=(Button) findViewById(R.id.c33);
        txttimkiem = (EditText) findViewById(R.id.TxttimKiem);

        try {
            Scanner scan=new Scanner(new File(sdcard));

            while(scan.hasNext())
            {
                data+=scan.nextLine()+"\n";
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            for(int i=1;i<data.length();i++)
            {
                if(data.charAt(i)!='\n')
                {
                    if(data.charAt(i)!='|')
                    {
                        switch (vt)
                        {
                            case 1:// sqe
                                seq=seq+data.charAt(i);
                                break;
                            case 2:
                                c1=c1+data.charAt(i);
                                break;
                            case 3:
                                c2=c2+data.charAt(i);
                                break;
                            case 4:
                                c3=c3+data.charAt(i);
                                break;
                        }
                    }
                    else
                    {
                        if(vt==4)
                            vt=0;
                        vt++;

                    }
                }
                else
                {
                    switch (k)
                    {
                        case 0:
                            cc01.setText(c1);
                            cc02.setText(c2);
                            cc03.setText(c3);
                            ma0.setText(seq);
                            k++;
                            seq="";
                            c1="";
                            c2="";
                            c3="";
                            break;
                        case 1:
                            cc11.setText(c1);
                            cc12.setText(c2);
                            cc13.setText(c3);
                            ma1.setText(seq);
                            k++;
                            seq="";
                            c1="";
                            c2="";
                            c3="";
                            break;
                        case 2:
                            cc21.setText(c1);
                            cc22.setText(c2);
                            cc23.setText(c3);
                            ma2.setText(seq);
                            k++;
                            seq="";
                            c1="";
                            c2="";
                            c3="";
                            break;
                        case 3:
                            cc31.setText(c1);
                            cc32.setText(c2);
                            cc33.setText(c3);
                            ma3.setText(seq);
                            k=0;
                            seq="";
                            c1="";
                            c2="";
                            c3="";
                            break;
                    }
                }
            }


    }
    public void click_maseq0(View v){
        Intent intent = new Intent(HistoryActivity.this, paperSheetActivity.class);
        Bundle ten_image = new Bundle();
        ten_image.putString("Seq", ma0.getText().toString());
        ten_image.putString("c1",cc01.getText().toString());
        ten_image.putString("c2",cc02.getText().toString());
        ten_image.putString("c3",cc03.getText().toString());
        ten_image.putString("goi","doc");
        intent.putExtra("GoiTen2",ten_image);
        startActivity(intent);
    }
    public void click_maseq1(View v){
        Intent intent = new Intent(HistoryActivity.this, paperSheetActivity.class);
        Bundle ten_image = new Bundle();
        ten_image.putString("Seq", ma1.getText().toString());
        ten_image.putString("c1",cc11.getText().toString());
        ten_image.putString("c2",cc12.getText().toString());
        ten_image.putString("c3",cc13.getText().toString());
        ten_image.putString("goi","doc");
        intent.putExtra("GoiTen2",ten_image);
        startActivity(intent);
    }
    public void click_maseq2(View v){
        Intent intent = new Intent(HistoryActivity.this, paperSheetActivity.class);
        Bundle ten_image = new Bundle();
        ten_image.putString("Seq", ma2.getText().toString());
        ten_image.putString("c1",cc21.getText().toString());
        ten_image.putString("c2",cc22.getText().toString());
        ten_image.putString("c3",cc23.getText().toString());
        ten_image.putString("goi","doc");
        intent.putExtra("GoiTen2",ten_image);
        startActivity(intent);
    }
    public void click_maseq3(View v){
        Intent intent = new Intent(HistoryActivity.this, paperSheetActivity.class);
        Bundle ten_image = new Bundle();
        ten_image.putString("Seq", ma3.getText().toString());
        ten_image.putString("c1",cc31.getText().toString());
        ten_image.putString("c2",cc32.getText().toString());
        ten_image.putString("c3",cc33.getText().toString());
        ten_image.putString("goi","doc");
        intent.putExtra("GoiTen2",ten_image);
        startActivity(intent);
    }
    public void back_his(View v){
        finish();
    }
    public void timkiem(View v)
    {
        int index_sh;
        String timSqe;
        timSqe= txttimkiem.getText().toString();

      index_sh= data.indexOf(timSqe);
    if(index_sh<0)
        {
            Toast.makeText(HistoryActivity.this,"Không có số Seq.",Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent = new Intent(HistoryActivity.this, paperSheetActivity.class);
            Bundle ten_image = new Bundle();
            ten_image.putString("Seq", timSqe);
            ten_image.putString("c1",data.substring(index_sh+timSqe.length()+1,index_sh+timSqe.length()+3));
            ten_image.putString("c2",data.substring(index_sh+timSqe.length()+4,index_sh+timSqe.length()+6));
            ten_image.putString("c3",data.substring(index_sh+timSqe.length()+7,index_sh+timSqe.length()+9));
            ten_image.putString("goi","doc");
            intent.putExtra("GoiTen2",ten_image);
            startActivity(intent);
        }
    }
}
