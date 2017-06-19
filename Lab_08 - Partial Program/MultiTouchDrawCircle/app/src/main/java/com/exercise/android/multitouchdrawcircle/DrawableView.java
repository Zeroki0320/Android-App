package com.exercise.android.multitouchdrawcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

public class DrawableView extends View {
    Paint paint = new Paint();
    int gCenterX, gCenterY, gRadius;

    public DrawableView(Context context) {
        super(context);
        paint.setAntiAlias(true);
        paint.setColor( 0xff00ffff );
        paint.setStyle( Paint.Style.STROKE );
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        /** COMPLETE THIS PART **/
        // Draw a circle with center (gCenterX, gCenterY) and radius ‘gRadius’.


        // Extension: Draw a set of concentric circles.
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int pointerCount = event.getPointerCount();  // no. of touch points

        switch( event.getAction() )
        {
            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_POINTER_DOWN:
                if( pointerCount == 2 )  // Multi-touch
                {
                    /** COMPLETE THIS PART **/
                    // Get the co-ordinates of the points of touch
                    // Find the center (mid-point of the points of touch)
                    // Find the radius of the circle (Hint: use the Pythagoras' theorem,
                    // and use Math.sqrt to find the square root)
                }

                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }
}
