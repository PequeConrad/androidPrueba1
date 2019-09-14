package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnArriba, btnAbajo, btnIzquierda, btnDerecha, btnCentro;
    Button btnArribaIzquierda, btnArribaDerecha, btnAbajoDerecha, btnAbajoIzquierda;

    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instanceViewElements();
        addListeners();
        controller = new Controller();


    }

    private void instanceViewElements(){

        btnAbajo = findViewById(R.id.btnAbajo);
        btnAbajoDerecha = findViewById(R.id.btnAbajoDerecha);
        btnArribaDerecha = findViewById(R.id.btnArribaDerecha);
        btnDerecha = findViewById(R.id.btnDerecha);
        btnCentro = findViewById(R.id.btnCentro);
        btnArriba = findViewById(R.id.btnArriba);
        btnAbajoIzquierda = findViewById(R.id.btnAbajoIzquierda);
        btnArribaIzquierda = findViewById(R.id.btnArribaIzquierda);
        btnIzquierda = findViewById(R.id.btnIzquierda);

    }

    private void addListeners(){
        addBtnOnclikListener(btnArriba);
        addBtnOnclikListener(btnAbajo);
        addBtnOnclikListener(btnIzquierda);
        addBtnOnclikListener(btnDerecha);
        addBtnOnclikListener(btnCentro);
        addBtnOnclikListener(btnArribaIzquierda);
        addBtnOnclikListener(btnArribaDerecha);
        addBtnOnclikListener(btnAbajoDerecha);
        addBtnOnclikListener(btnAbajoIzquierda);
    }

    private void addBtnOnclikListener(final Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.processAction(btn, MainActivity.this);
                String message = controller.checkFinish();
                if(!message.equals("CONTINUE")){
                    Intent pantallaFinal = new Intent(MainActivity.this, Main2Activity.class);
                    pantallaFinal.putExtra("Info", message);
                    startActivity(pantallaFinal);
                    finish();
                }

            }
        });
    }

    public void showAction(String action, Button btn){

        if(action.equals("X")){
            btn.setBackgroundResource(R.drawable.cruz);
        }else if(action.equals("O")){
            btn.setBackgroundResource(R.drawable.circulo);
        }

    }

}
