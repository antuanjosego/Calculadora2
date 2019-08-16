package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    boolean op1_empty = true;
    boolean op2_empty = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calcular = (Button)findViewById(R.id.button);
        calcular.setEnabled(false);

        final EditText op1 = (EditText)findViewById(R.id.editText);
        final EditText op2 = (EditText)findViewById(R.id.editText2);
        final EditText results = (EditText)findViewById(R.id.editText3);
        final Spinner opciones = (Spinner)findViewById(R.id.spinner);

        final String[] datos = new String[] {"Sumar", "Multiplicar"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);

        final Spinner Opciones = (Spinner)findViewById(R.id.spinner);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Opciones.setAdapter(adaptador);

        op1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (op1.getText().length() > 0)
                {
                    op1_empty = false;
                }
                else
                {
                    op1_empty = true;
                }
                if (!op1_empty && !op2_empty)
                {
                    calcular.setEnabled(true);
                }
                else
                {
                    calcular.setEnabled(false);
                }

            }
        });

        op2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(op2.getText().length() > 0)
                {
                    op2_empty = false;
                }
                else
                {
                    op2_empty = true;
                }

                if(!op1_empty && !op2_empty)
                {
                    calcular.setEnabled(true);
                }
                else
                {
                    calcular.setEnabled(false);
                }

            }
        });

        calcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Integer a, b;
                a = new Integer(op1.getText().toString());
                b = new Integer(op2.getText().toString());

                if(opciones.getSelectedItem().equals("Sumar"))
                {
                    results.setText(String.valueOf(suma(a,b)));
                }
                else if(opciones.getSelectedItem().equals("Multiplicar"))
                {
                    results.setText(String.valueOf(multiplicacion(a,b)));
                }
                else
                {
                    results.setText("Error en la aplicación");
                }
            }
        });

    }

    public int suma (int a, int b)
    {
        int res = a + b;
        return res;
    }

    public int multiplicacion (int a, int b)
    {
        int res = a * b;
        return res;
    }

}
