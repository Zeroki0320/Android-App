package com.exercise.android.piechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    class Panel extends View {
        public Panel (Context context) {
            super(context);
        }

        String title = "Fund Portfolio";
        String items[] = {"Financials", "Properties", "Utilities", "Others"};
        int data[] = {52, 25, 11, 12};
        int rColor[] = {0xffff0000, 0xffffff00, 0xff32cd32, 0xff880055};
        float cDegree = 0;
        float pie = 0;

        @Override
        public void onDraw(Canvas c) {
            super.onDraw(c);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);


            // Make the entire canvas in white
            paint.setColor(Color.WHITE);
            c.drawPaint(paint);

            // Draw the pie chart
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            int diameter = Math.min(this.getWidth(),this.getHeight())-100;
            for (int i = 0; i < data.length; i++) {
                pie = data[i] * 360 / 100;

                // define the diameter of the arc
                RectF rec=new RectF(50,150,diameter+50,150+diameter);
                paint.setColor(rColor[i]);
                c.drawArc(rec,cDegree,pie,true,paint);
                cDegree=cDegree+pie;

                // Draw the arc
                // ...
            }

            // Draw the title
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(40);
            paint.setTypeface(Typeface.SERIF);
            c.drawText(title, 20, 50, paint);

            int vertSpace = getHeight() - 100;
            paint.setTextSize(20);
            for (int i = items.length - 1; i >= 0; i--) {
                // Draw the legend rect (20px SQ)
                // ...
                paint.setColor(rColor[i]);
                c.drawRect(c.getWidth()/2+100,diameter+300+pie,c.getWidth()/2+120,diameter+320+pie,paint);


                // Draw the label
                // ...
                paint.setColor(Color.BLACK);
                c.drawText(items[i],c.getWidth()/2+130,diameter+320+pie,paint);
                pie=pie-30;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Panel(this));
    }
}
