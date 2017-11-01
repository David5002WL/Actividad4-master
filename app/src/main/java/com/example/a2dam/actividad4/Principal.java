package com.example.a2dam.actividad4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //RATING ESTRELLAS
        RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
        TextView estrellas = (TextView) findViewById(R.id.textView3);
        puntuacion(rating, estrellas);


        //TEXTO CON CLICK LARGO
        TextView clickLargo = (TextView) findViewById(R.id.textView2);

        clickLargo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "¡Muchas Gracias!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        //CAMBIO DE COLOR AL LAYOUT
        Button cambiocolor = (Button) findViewById(R.id.button);
        final LinearLayout segundo = (LinearLayout) findViewById(R.id.LinearLayout);

        cambiocolor.setOnClickListener(new View.OnClickListener() {
            boolean color = true;
            Button cambiocolor = (Button) findViewById(R.id.button);
            @Override
            public void onClick(View v) {

                if(color)
                {
                    segundo.setBackgroundColor(Color.RED);
                    cambiocolor.setText("FONDO BLANCO");
                    color = false;
                }
                else
                {
                    segundo.setBackgroundColor(Color.WHITE);
                    cambiocolor.setText("FONDO ROJO");
                    color = true;
                }

            }
        });

    }

    public void onClick(View v){

        //MENSAJE OCULTO
        if(v.getId() == R.id.checkBox) {
            CheckBox mostrar = (CheckBox) findViewById(R.id.checkBox);
            TextView oculto = (TextView) findViewById(R.id.textView);
            if (mostrar.isChecked() == true) {
                oculto.setVisibility(View.VISIBLE);
            } else {
                oculto.setVisibility(View.GONE);
            }
        }


        //CAMBIO DE COLOR DE LETRAS
        Button cambiocolor2 = (Button) findViewById(R.id.button2);

        if(v.getId() == R.id.button2 && cambiocolor2.getCurrentTextColor() == Color.BLACK){
            cambiocolor2.setTextColor(Color.RED);
            cambiocolor2.setText("LETRAS NEGRAS");
        }else{
            cambiocolor2.setTextColor(Color.BLACK);
            cambiocolor2.setText("LETRAS ROJAS");
        }


    }

    //RATING ESTRELLAS
    private void puntuacion(RatingBar rating, final TextView puntuacion){
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            public void onRatingChanged(RatingBar ratingBar, float value, boolean b){
                puntuacion.setText("["+value+"/5]");
            }
        });
    }

}
