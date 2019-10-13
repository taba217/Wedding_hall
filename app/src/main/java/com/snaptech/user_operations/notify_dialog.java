package com.snaptech.user_operations;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Gallery;
import android.widget.ViewFlipper;


import com.snaptech.R;


public class notify_dialog extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private float lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_dialog);

       // CustomGallery c=new CustomGallery(this);
        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
    }

    public boolean onTouchEvent(MotionEvent touchevent)
    {
        switch (touchevent.getAction())
        {
            // when user first touches the screen to swap
            case MotionEvent.ACTION_DOWN:
            {
                lastX = touchevent.getX();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                float currentX = touchevent.getX();

                // if left to right swipe on screen
                if (lastX < currentX)
                {
                    // If no more View/Child to flip
                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    // set the required Animation type to ViewFlipper
                    // The Next screen will come in form Left and current Screen will go OUT from Right
//                    viewFlipper.setInAnimation(this, R.anim.in_from_left);
//                    viewFlipper.setOutAnimation(this, R.anim.out_to_right);
                    // Show the next Screen
                    viewFlipper.showNext();
                }

                // if right to left swipe on screen
                if (lastX > currentX)
                {
                    if (viewFlipper.getDisplayedChild() == 1)
                        break;
                    // set the required Animation type to ViewFlipper
                    // The Next screen will come in form Right and current Screen will go OUT from Left
                    viewFlipper.setInAnimation(this, R.anim.in_from_right);
                   // viewFlipper.setOutAnimation(this, R.anim.out_to_left);
                    // Show The Previous Screen
                    viewFlipper.showPrevious();
                }
                break;
            }
        }
        return false;
    }

}

class CustomGallery extends Gallery {

    private Handler handler;

    public CustomGallery(Context context) {
        super(context);
        handler = new Handler();
        postDelayedScrollNext();
    }

    public CustomGallery(Context context, AttributeSet attrs) {
        super(context, attrs);
        handler = new Handler();
        postDelayedScrollNext();
    }
    public CustomGallery(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        handler = new Handler();
        postDelayedScrollNext();
    }

    protected void postDelayedScrollNext() {
        handler.postDelayed(new Runnable() {
            public void run() {
                postDelayedScrollNext();
                Log.d("CustomGallery", "dpad RIGHT");
                onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
            }
        }, 1000);
    }

    protected boolean isScrollingLeft(MotionEvent e1, MotionEvent e2) {
        return e2.getX() > e1.getX();
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int kEvent;
        if (isScrollingLeft(e1, e2)) {
            Log.d("CustomGallery", "fling LEFT");
            kEvent = KeyEvent.KEYCODE_DPAD_LEFT;
        } else {
            Log.d("CustomGallery", "fling LEFT");
            kEvent = KeyEvent.KEYCODE_DPAD_RIGHT;
        }
        onKeyDown(kEvent, null);
        return true;
    }
}

