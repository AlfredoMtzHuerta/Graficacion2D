package com.example.alfredo.animacion2d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Random;

public class Todos extends AppCompatActivity {

    private int corx, cory;
    private Lienzo fondo;
    private Random ColorRed, ColorBlue, ColorGreen, ColorFondoRed, ColorFondoBlue, ColorFondoGreen,anchoLinea, y1, fit;
    private String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        corx = 100;
        cory = 100;
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.Layout7);
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
        anchoLinea = new Random();
        y1 = new Random();
        fit = new Random();


    }
    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(ColorFondoRed.nextInt(), ColorFondoGreen.nextInt(), ColorFondoBlue.nextInt());
            Paint pincel1 = new Paint();
            Paint pincel2 = new Paint();
            Paint pincel3 = new Paint();
            Paint pincel4 = new Paint();
            Paint pincel5 = new Paint();
            texto = getIntent().getStringExtra("texto");
            pincel1.setARGB(255, ColorRed.nextInt(), ColorGreen.nextInt(), ColorBlue.nextInt());
            pincel1.setStrokeWidth(4);
            pincel1.setStyle(Paint.Style.STROKE);

            pincel2.setARGB(255, ColorRed.nextInt(), ColorGreen.nextInt(), ColorBlue.nextInt());
            pincel2.setStrokeWidth(4);
            pincel2.setStyle(Paint.Style.STROKE);

            pincel3.setARGB(255, ColorRed.nextInt(), ColorGreen.nextInt(), ColorBlue.nextInt());
            pincel3.setStrokeWidth(4);
            pincel3.setStyle(Paint.Style.STROKE);

            pincel4.setARGB(255, ColorRed.nextInt(), ColorGreen.nextInt(), ColorBlue.nextInt());
            pincel4.setStrokeWidth(4);
            pincel4.setStyle(Paint.Style.STROKE);

            pincel5.setARGB(255, ColorRed.nextInt(), ColorGreen.nextInt(), ColorBlue.nextInt());
            pincel5.setStrokeWidth(4);
            pincel5.setStyle(Paint.Style.STROKE);

            canvas.drawOval(corx, fit.nextFloat(),cory,80, pincel1);
            canvas.drawCircle(corx, cory, 30, pincel2);
            canvas.drawRect(corx, 40, cory, 70, pincel3);
            pincel5.setTextSize(corx);
            canvas.drawLine(corx, cory, anchoLinea.nextFloat(), y1.nextFloat(), pincel4);
            canvas.drawText(texto, corx, cory, pincel5);
        }
    }

    public void Regresar(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
