package com.exercise.android.movingicon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class MainActivity extends ActionBarActivity {

    class Panel extends ???? implements SurfaceHolder.Callback {
        private DrawingThread drawingThread;
        private Bitmap icon;
        int xPos = 100, yPos = 100;
        int panelWidth, panelHeight;
        int iconWidth, iconHeight;
        boolean moveDown = true, moveRight = true;

        public Panel(Context context) {
            super(context);
            getHolder().addCallback(this);
            drawingThread = new DrawingThread(getHolder(), this);
            icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            iconWidth = icon.getWidth();
            iconHeight = icon.getHeight();
        }

        @Override
        public void ????(Canvas canvas) {
            // COMPLETE THIS PART
            // The xPos and yPos are modified according to the moving direction.
            // The moving direction is changed when a border is reached.
       	
            canvas.drawColor(Color.DKGRAY);
            canvas.drawBitmap(icon, xPos, yPos, null);
        }

        public void onSizeChanged(int w, int h, int oldW, int oldH) {
            panelWidth = w;
            panelHeight = h;
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            // TODO Auto-generated method stub
        }

        public void surfaceCreated(SurfaceHolder holder) {
            drawingThread.setRunning(true);
            drawingThread.start();
        }

        public void ????(SurfaceHolder holder) {
            // we have to tell thread to shut down & wait for it to finish, or else
            boolean retry = true;
            drawingThread.setRunning(false);
            while (retry) {
                try {
                    drawingThread.join();
                    retry = false;
                } catch (InterruptedException e) {
                    // try it again and again...
                }
            }
        }
    }

    class DrawingThread extends Thread {
        private SurfaceHolder msurfaceHolder;
        private Panel mpanel;
        private boolean mrun = false;

        public DrawingThread(SurfaceHolder surfaceHolder, Panel panel) {
            msurfaceHolder = surfaceHolder;
            mpanel = panel;
        }

        public void setRunning(boolean run) {
            mrun = run;
        }

        @Override
        public void run() {
            Canvas c;
            while (mrun) {
                c = null;
                try {
                    c = msurfaceHolder.lockCanvas(null);
                    synchronized (msurfaceHolder) {
                        mpanel.onDraw(c);
                    }
                    sleep(10);
                } catch (InterruptedException e) {

                } finally {
                    // do this in a finally so that if an exception is thrown
                    // during the above, we don't leave the Surface in an
                    // inconsistent state
                    if (c != null) {
                        msurfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Panel(this));
    }

    @Override
    public void onStop() {
        super.onStop();
        super.finish();
    }
}
