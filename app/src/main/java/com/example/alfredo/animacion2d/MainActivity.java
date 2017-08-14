package com.example.alfredo.animacion2d;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private EditText texto;
    private Button btnEnviar, btnSiguiente, btnTodo;
    private CheckBox cbCirculo, cbLinea, cbOvalo, cbRectangulo, cbTexto;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        texto = (EditText) findViewById(R.id.edTexto);
         texto.setVisibility(View.INVISIBLE);

         btnEnviar = (Button) findViewById(R.id.btnEnviar);

         btnSiguiente = (Button) findViewById(R.id.btSiguiente);
         btnSiguiente.setVisibility(View.INVISIBLE);

        btnTodo = (Button) findViewById(R.id.btnTodos);
         btnTodo.setVisibility(View.INVISIBLE);

         cbCirculo = (CheckBox) findViewById(R.id.cbCirculo);
         cbLinea = (CheckBox) findViewById(R.id.cbLinea);
         cbOvalo = (CheckBox) findViewById(R.id.cbOvalo);
         cbRectangulo = (CheckBox) findViewById(R.id.cbRectangulo);
         cbTexto = (CheckBox) findViewById(R.id.cbTexto);


    }

    public void IrFigura(View view) {
        if (cbCirculo.isChecked() && cbOvalo.isChecked() && cbLinea.isChecked() && cbRectangulo.isChecked() && cbTexto.isChecked()) {
            texto.setVisibility(View.VISIBLE);
            btnEnviar.setVisibility(View.INVISIBLE);
            btnTodo.setVisibility(View.VISIBLE);
        } else if (cbCirculo.isChecked()) {
            Intent i1 = new Intent(this, Circulo.class);
            startActivity(i1);
        } else if (cbLinea.isChecked()) {
            Intent i = new Intent(this, Linea.class);
            startActivity(i);
        } else if (cbOvalo.isChecked()) {
            Intent i2 = new Intent(this, Ovalo.class);
            startActivity(i2);
        } else if (cbRectangulo.isChecked()) {
            Intent i = new Intent(this, Rectangulo.class);
            startActivity(i);
        } else if (cbTexto.isChecked()) {
            texto.setVisibility(View.VISIBLE);
            btnEnviar.setVisibility(View.INVISIBLE);
            btnSiguiente.setVisibility(View.VISIBLE);
        } else {

        }
    }

    public void EnviarTexto(View v)
    {
        Intent i4 = new Intent(this, Texto.class);
        i4.putExtra("texto", texto.getText().toString());
        startActivity(i4);
    }

    public void EnviarTodo(View v)
    {
        Intent i = new Intent(this, Todos.class);
        i.putExtra("texto", texto.getText().toString());
        startActivity(i);
    }

}