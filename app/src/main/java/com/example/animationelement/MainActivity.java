package com.example.animationelement;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable doggy;
    private ImageView imagen;
    private boolean isAnimating = true; // Variable para controlar el estado de la animación

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = (ImageView) findViewById(R.id.imagenPerrito);
        imagen.setBackgroundResource(R.drawable.animacion_doggy);
        doggy = (AnimationDrawable) imagen.getBackground();
        doggy.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (isAnimating) {
                doggy.stop();
                isAnimating = false;
            } else {
                imagen.setBackgroundResource(R.drawable.animacion_doggy);
                doggy = (AnimationDrawable) imagen.getBackground();
                doggy.start();
                isAnimating = true;
            }
        }
        return super.onTouchEvent(event);
    }
}
