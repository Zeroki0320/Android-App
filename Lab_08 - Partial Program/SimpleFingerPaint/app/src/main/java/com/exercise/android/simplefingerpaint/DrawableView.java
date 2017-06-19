package com.exercise.android.simplefingerpaint;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class DrawableView extends View {
    Path path = new Path();
    Paint paint = new Paint();

    public DrawableView(Context context) {
        super(context);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5.0f);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            /** COMPLETE THIS PART **/
            // reset the path
            // set the path last point to the point of touch

        } else if (event.getAction() == MotionEvent.ACTION_MOVE
                || event.getAction() == MotionEvent.ACTION_UP) {

            /** COMPLETE THIS PART **/
            // use path.rLineTo to draw a line to the current point
            // set the path last point to the point of touch

        }
        invalidate();
        return true;
    }
}
