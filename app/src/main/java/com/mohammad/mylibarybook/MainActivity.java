package com.mohammad.mylibarybook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout container;
    private boolean flip = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container=findViewById(R.id.container);
        findViewById(R.id.coverImageView).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                animateCover();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void animateCover() {
        ConstraintSet constraintSet=new ConstraintSet();
        if (flip){
            constraintSet.clone(this,R.layout.activity_main_big_cover);

        }else {
            constraintSet.clone(this,R.layout.activity_main);

        }
        flip = !flip;
        TransitionManager.beginDelayedTransition(container);
        constraintSet.applyTo(container);
    }
}