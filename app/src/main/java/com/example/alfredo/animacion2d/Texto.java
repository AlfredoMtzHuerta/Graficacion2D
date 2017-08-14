package com.example.alfredo.animacion2d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Texto extends AppCompatActivity {

    private int corx, cory;
    private Lienzo fondo;
    private Random ColorRed, ColorBlue, ColorGreen, ColorFondoRed, ColorFondoBlue, ColorFondoGreen, tamanio;
    private String texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);

        corx = 100;
        cory = 100;
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.Layout5);

        fondo = new Lienzo(this);
        fondo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                corx = (int) event.getX();
                cory = (int) event.getY();

                fondo.invalidate();
                return true;
            }
        });
        layout1.addView(fondo);
        ColorRed = new Random();
        ColorBlue = new Random();
        ColorGreen = new Random();
        ColorFondoRed = new Random();
        ColorFondoBlue = new Random();
        ColorFondoGreen = new Random();
        tamanio = new Random();
    }

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(ColorFondoRed.nextInt(), ColorFondoGreen.nextInt(), ColorFondoBlue.nextInt());
            Paint pincel1 = new Paint();
            pincel1.setARGB(255, ColorRed.nextInt(), ColorGreen.nextInt(), ColorBlue.nextInt());
            pincel1.setStrokeWidth(4);
            pincel1.setStyle(Paint.Style.STROKE);
            pincel1.setTextSize(corx);
            texto = getIntent().getStringExtra("texto");
            canvas.drawText(texto, corx, cory, pincel1);

        }
    }

    public void Regresar(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
