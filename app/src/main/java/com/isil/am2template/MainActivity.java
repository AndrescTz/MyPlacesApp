package com.isil.am2template;

import android.animation.Animator;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();
        app();
    }

    private void app() {
    }

    private void showMessage(){
    }

    private void rippleEffect() {

        /*int cx = (imageViewIsil.getLeft() + imageViewIsil.getRight()) / 2;
        int cy = (imageViewIsil.getTop() + imageViewIsil.getBottom()) / 2;

        int finalRadius = Math.max(constraintLayoutContainer.getWidth()/2, constraintLayoutContainer.getHeight()/2);

        Animator anim =
                null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(constraintLayoutContainer, cx, cy, 0, finalRadius);
            anim.setDuration(2000);
            anim.start();
        }*/
    }

    private void ui() {

    }
}
