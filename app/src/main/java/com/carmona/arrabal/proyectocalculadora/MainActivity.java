package com.carmona.arrabal.proyectocalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    /**
     * @date 09/11/2017.
     * @author RafaelCarmonaArrabal.
     * @param savedInstanceState
     */

    //vars.
            //Todos los botones.
    Button boton7, boton8, boton9, boton4, boton5, boton6, boton1, boton2, boton3, boton0, botonSumar, botonRestar, botonDividir, botonMult,
            botonIgual, botonCambiarSigno, botonReiniciarTodo, botonReiniciarEmpty;
            //textView.
    TextView tvTotal, tvEmpty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //asignamos variables.
        //botones.
        boton9 = (Button) findViewById(R.id.boton9);
        boton8 = (Button) findViewById(R.id.boton8);
        boton7 = (Button) findViewById(R.id.boton7);
        boton6 = (Button) findViewById(R.id.boton6);
        boton5 = (Button) findViewById(R.id.boton5);
        boton4 = (Button) findViewById(R.id.boton4);
        boton3 = (Button) findViewById(R.id.boton3);
        boton2 = (Button) findViewById(R.id.boton2);
        boton1 = (Button) findViewById(R.id.boton1);
        boton0 = (Button) findViewById(R.id.boton0);
        botonSumar = (Button) findViewById(R.id.botonSumar);
        botonRestar = (Button) findViewById(R.id.botonRestar);
        botonMult = (Button) findViewById(R.id.botonMultiplicar);
        botonDividir = (Button) findViewById(R.id.botonDividir);
        botonIgual = (Button) findViewById(R.id.botonIgual);
        botonCambiarSigno = (Button) findViewById(R.id.botonCambiarSigno);
        botonReiniciarTodo = (Button) findViewById(R.id.botonResetearTotal);
        botonReiniciarEmpty = (Button) findViewById(R.id.botonResetearEmpty);
        //TextView.
        tvTotal = (TextView) findViewById(R.id.tvCalculoTotal);
        tvEmpty = (TextView) findViewById(R.id.tvCalculoEmpty);
        //acciones botones.
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                annadeNumero(view, 1);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                annadeNumero(view,2);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                annadeNumero(view, 3);
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                annadeNumero(view, 4);
            }
        });
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                annadeNumero(view, 5);
            }
        });
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                annadeNumero(view, 6);
            }
        });
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                annadeNumero(view, 7);
            }
        });
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                annadeNumero(view, 8);
            }
        });
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                annadeNumero(view, 9);
            }
        });
        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                annadeNumero(view, 0);
            }
        });

        //Sumar, restar, multiplicar y dividir.
        botonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                operacion(view, "+");
            }
        });
        botonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                operacion(view, "-");
            }
        });

        botonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                operacion(view, "×");
            }
        });

        botonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                operacion(view, "÷");
            }
        });

        botonReiniciarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                reiniciaTotal(view);
            }
        });

        botonReiniciarEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                reiniciaEmpty(view);
            }
        });

        botonCambiarSigno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                cambiaSigno(view);
            }
        });

        botonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamada a la funcion
                igual(view);
            }
        });
    }

    //Funcion en la que cambiamos el tvEmpty.
    public void annadeNumero(View view, int numero){
        try{
            if(tvEmpty.getText().toString().length() <= 8){
                if(Integer.parseInt(tvEmpty.getText().toString())==0){
                    tvEmpty.setText(Integer.toString(numero));
                }else{
                    tvEmpty.setText(tvEmpty.getText()+Integer.toString(numero));
                }
            }else{
                return;
            }
        }catch(Exception e){
            return;
        }
    }

    //pone el simbolo de la operación que se va a ejecutar.
    public void operacion(View view, String simbOperacion){

        if(tvTotal.length()==1) {
            tvTotal.setText(tvEmpty.getText());
        }else{
            if(Integer.parseInt(tvEmpty.getText().toString())!=0){
                return;
            }
        }
        //primero tenemos que comprobar si el campo tv total tiene un símbolo.
        String simbolo = tvTotal.getText().toString().substring(tvTotal.getText().toString().length()-1, tvTotal.getText().toString().length());
        //patrones de la expresion regular.
        Pattern patron = Pattern.compile("[\\+\\-\\±\\×\\÷]");
        Matcher matchPatron = patron.matcher(simbolo);
        if(matchPatron.matches()){
            tvTotal.setText(tvTotal.getText().toString().substring(0,tvTotal.getText().toString().length()-1)+simbOperacion);
            Log.d("REGEX","ENTRAS EN TRUE");
        }else{
            tvTotal.setText(tvTotal.getText().toString()+simbOperacion);
            Log.d("REGEX","ENTRAS EN FALSE");
        }
        //ponemos a 0 el contador
        tvEmpty.setText("0");
        //ponemos los botones de calculo a 0.
    }

    //reiniciar el contador de empty a 0.
    public void reiniciaEmpty(View view){
        tvEmpty.setText("0");
    }
    //Reinicia tanto el total como el empty a 0.
    public void reiniciaTotal(View view){
        tvTotal.setText("0");
        tvEmpty.setText("0");
    }

    //Cambia el signo de lo que se encuentra en el tvEmpty.
    public void cambiaSigno(View view){
        //primero recogemos la cadena para comprobar que no sea 0.
        if(Integer.parseInt(tvEmpty.getText().toString())!=0){
            if(Integer.parseInt(tvEmpty.getText().toString())<0){
                //si es menor de 0 le quitamos el símbolo de delante del número.
                tvEmpty.setText(tvEmpty.getText().toString().replace("-",""));
            }else{
                //si es mayor a 0 quiere decir que no tiene simbolo, se lo podemos poner al principio.
                tvEmpty.setText("-"+tvEmpty.getText().toString());
            }
        }else{
            return;
        }
    }

    //Muestra el resultado.
    public void igual(View view){
        //primero sacamos el simbolo de operacion.
        String simbolo = tvTotal.getText().toString().substring(tvTotal.getText().toString().length()-1,tvTotal.getText().toString().length());
      try{
          int resultado;
          switch(simbolo){
              case "+":
                  resultado = Integer.parseInt(tvTotal.getText().toString().substring(0, tvTotal.getText().toString().length()-1))+Integer.parseInt(tvEmpty.getText().toString());
                  break;
              case "-":
                  resultado = Integer.parseInt(tvTotal.getText().toString().substring(0, tvTotal.getText().toString().length()-1))-Integer.parseInt(tvEmpty.getText().toString());
                  break;
              case "×":
                  resultado = Integer.parseInt(tvTotal.getText().toString().substring(0, tvTotal.getText().toString().length()-1))*Integer.parseInt(tvEmpty.getText().toString());
                  break;
              case "÷":
                  resultado = Integer.parseInt(tvTotal.getText().toString().substring(0, tvTotal.getText().toString().length()-1))/Integer.parseInt(tvEmpty.getText().toString());
                  break;
              default:
                  resultado = Integer.parseInt(tvEmpty.getText().toString());
                  break;
          }
          tvTotal.setText("0");
          tvEmpty.setText(resultado+"");
      }catch (Exception e){
          tvEmpty.setText("0");
      }
    }
}
