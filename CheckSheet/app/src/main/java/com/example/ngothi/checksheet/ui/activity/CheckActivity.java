package com.example.ngothi.checksheet.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.example.ngothi.checksheet.R;

public class CheckActivity extends AppCompatActivity {
int check=1200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
    }
    public void quaylai3(View v){
        finish();
    }
    public void ketthuc3(View v){
        finish();
    }
}
