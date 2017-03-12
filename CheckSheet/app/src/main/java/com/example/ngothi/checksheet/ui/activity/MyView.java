package com.example.ngothi.checksheet.ui.activity;

import android.view.MotionEvent;
import android.view.View;
import  android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;


/**
 * Created by ngothi on 10/31/2016.
 */

public class MyView extends View implements View.OnTouchListener {
    Bitmap originalbitmap;
    Bitmap image;

    float x=0,y=0;

    Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public MyView(Context context) {
        super(context);
        setWillNotDraw(false);

        setOnTouchListener(this);
    }

    public MyView(Context context, AttributeSet attr) {
        super(context, attr);
        setWillNotDraw(false);
        setOnTouchListener(this);
    }

    public void setBitmap(Bitmap bitmap) {
        this.originalbitmap = bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(originalbitmap,new Rect(0,0,originalbitmap.getWidth(),originalbitmap.getHeight()),new Rect(0,0,getMeasuredWidth(),getMeasuredHeight()),new Paint());
        if(x+y>0){
            circlePaint.setColor(Color.RED);
            circlePaint.setStrokeWidth(8);
            circlePaint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(x,y,80, circlePaint);
        }
    }

    public Bitmap saveBitmap(){
        buildDrawingCache();
        return getDrawingCache();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        Log.e("TAG","x:"+x+" - y"+y);
        invalidate();
        return true;
    }
}
