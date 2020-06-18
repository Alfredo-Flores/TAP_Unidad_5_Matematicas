package com.example.tapunidad5matematicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button  button_1, button_2, button_3;
    FloatingActionButton button_info;
    TextView textView_1, textView_2, textView_op;

    int valor_1, valor_2, res;
    String operador;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_info = findViewById(R.id.button_info);

        textView_1 = findViewById(R.id.textView_1);
        textView_2 = findViewById(R.id.textView_2);
        textView_op = findViewById(R.id.textView_op);

        this.shuffle();

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences puntuacion = getSharedPreferences("puntuacion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = puntuacion.edit();
                editor = puntuacion.edit();

                if (button_1.getText().equals(String.valueOf(res))) {
                    editor.putString("acertados", String.valueOf(Integer.parseInt(puntuacion.getString("acertados", "0"))+ 1));
                    editor.putString("intentos", String.valueOf(Integer.parseInt(puntuacion.getString("intentos", "0"))+ 1));
                    editor.commit();

                    Context context = getApplicationContext();
                    CharSequence text = "Correcto! +10";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    editor.putString("intentos", String.valueOf(Integer.parseInt(puntuacion.getString("intentos", "0")) + 1));
                    editor.commit();

                    Context context = getApplicationContext();
                    CharSequence text = "Buen intento, pero era otro!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                shuffle();
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences puntuacion = getSharedPreferences("puntuacion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = puntuacion.edit();
                editor = puntuacion.edit();

                if (button_2.getText().equals(String.valueOf(res))) {
                    editor.putString("acertados", String.valueOf(Integer.parseInt(puntuacion.getString("acertados", "0"))+ 1));
                    editor.putString("intentos", String.valueOf(Integer.parseInt(puntuacion.getString("intentos", "0"))+ 1));
                    editor.commit();

                    Context context = getApplicationContext();
                    CharSequence text = "Correcto! +10";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    editor.putString("intentos", String.valueOf(Integer.parseInt(puntuacion.getString("intentos", "0"))+ 1));
                    editor.commit();

                    Context context = getApplicationContext();
                    CharSequence text = "Buen intento, pero era otro!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                shuffle();
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences puntuacion = getSharedPreferences("puntuacion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = puntuacion.edit();
                editor = puntuacion.edit();

                if (button_3.getText().equals(String.valueOf(res))) {
                    editor.putString("acertados", String.valueOf(Integer.parseInt(puntuacion.getString("acertados", "0"))+ 1));
                    editor.putString("intentos", String.valueOf(Integer.parseInt(puntuacion.getString("intentos", "0"))+ 1));
                    editor.commit();

                    Context context = getApplicationContext();
                    CharSequence text = "Correcto! +10";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                } else {
                    editor.putString("intentos", String.valueOf(Integer.parseInt(puntuacion.getString("intentos", "0"))+ 1));
                    editor.commit();

                    Context context = getApplicationContext();
                    CharSequence text = "Buen intento, pero era otro!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                shuffle();
            }
        });

        button_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences puntuacion =  getSharedPreferences("puntuacion", Context.MODE_PRIVATE);

                String mensaje = "Acertados: " + puntuacion.getString("acertados", "0") + "\n" +
                        "Puntos: " + String.valueOf(Integer.parseInt(puntuacion.getString("acertados", "0")) * 10) + "\n" +
                        "Intentos: " + puntuacion.getString("intentos", "0") + "\n";

                PuntuacionDialog dialog =  new PuntuacionDialog(mensaje);
                dialog.show(getSupportFragmentManager(), "Puntuacion");
            }
        });
    }

    public String randomOperator() {
        int op = r.nextInt(4 - 1) + 1;

        switch (op) {
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "*";
        }

        return null;
    }

    public int getResult (int v1, int v2, String op) {
        switch (op) {
            case "+":
                return v1 + v2;
            case "-":
                return v1 - v2;
            case "*":
                return v1 * v2;
        }
        return 0;
    }

    public void shuffle () {
        valor_1 = r.nextInt(45 - 10) + 10;
        valor_2 = r.nextInt(45 - 10) + 10;

        operador = randomOperator();
        res = getResult(valor_1, valor_2, operador);

        textView_1.setText(String.valueOf(valor_1));
        textView_2.setText(String.valueOf(valor_2));
        textView_op.setText(String.valueOf(operador));

        switch (r.nextInt(4 - 1) + 1) {
            case 1:
                button_1.setText(String.valueOf(res));
                button_2.setText(String.valueOf(res + r.nextInt(8 - 3) + 3));
                button_3.setText(String.valueOf(res - r.nextInt(8 - 3) + 3));
                break;
            case 2:
                button_1.setText(String.valueOf(res - r.nextInt(8 - 3) + 3));
                button_2.setText(String.valueOf(res));
                button_3.setText(String.valueOf(res + r.nextInt(8 - 3) + 3));
                break;
            case 3:
                button_1.setText(String.valueOf(res + r.nextInt(8 - 3) + 3));
                button_2.setText(String.valueOf(res - r.nextInt(8 - 3) + 3));
                button_3.setText(String.valueOf(res));
                break;
        }
    }
}