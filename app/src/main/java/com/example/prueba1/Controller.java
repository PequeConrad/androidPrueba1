package com.example.prueba1;

import android.content.Intent;
import android.widget.Button;

public class Controller {

    private int[][] matrix;
    int turno;
    int rondas;

    public Controller(){

        initMatrix();
        this.turno = 1;
        this.rondas = 0;

    }

    private void initMatrix(){

        this.matrix = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.matrix[i][j] = 0;
            }
        }
    }

    public void processAction(Button btn, MainActivity activity){
        String id = btn.getText().toString();
        if(!validAction(id)) return;
        switch (id){
            case "0":
                this.matrix[0][0] = turno;
                break;
            case "1":
                this.matrix[0][1] = turno;
                break;
            case "2":
                this.matrix[0][2] = turno;
                break;
            case "3":
                this.matrix[1][0] = turno;
                break;
            case "4":
                this.matrix[1][1] = turno;
                break;
            case "5":
                this.matrix[1][2] = turno;
                break;
            case "6":
                this.matrix[2][0] = turno;
                break;
            case "7":
                this.matrix[2][1] = turno;
                break;
            case "8":
                this.matrix[2][2] = turno;
                break;
        }
        if(turno == 1){
            activity.showAction("X", btn);
        }else{
            activity.showAction("O", btn);
        }

        turno = (turno == 1 ? 2 : 1);
        rondas++;
    }

    private boolean validAction(String id){
        switch (id){
            case "0":
                return this.matrix[0][0] == 0;
            case "1":
                return this.matrix[0][1] == 0;
            case "2":
                return this.matrix[0][2] == 0;
            case "3":
                return this.matrix[1][0] == 0;
            case "4":
                return this.matrix[1][1] == 0;
            case "5":
                return this.matrix[1][2] == 0;
            case "6":
                return this.matrix[2][0] == 0;
            case "7":
                return this.matrix[2][1] == 0;
            case "8":
                return this.matrix[2][2] == 0;
        }
        return false;

    }

    public String checkFinish(){

        String message = "CONTINUE";

        if((this.matrix[0][0] == this.matrix[0][1] && this.matrix[0][0] == this.matrix[0][2] && this.matrix[0][0] == 1) ||
                (this.matrix[1][0] == this.matrix[1][1] && this.matrix[1][0] == this.matrix[1][2] && this.matrix[1][0] == 1) ||
                (this.matrix[2][0] == this.matrix[2][1] && this.matrix[2][0] == this.matrix[2][2] && this.matrix[2][0] == 1) ||
                (this.matrix[0][0] == this.matrix[1][0] && this.matrix[0][0] == this.matrix[2][0] && this.matrix[0][0] == 1) ||
                (this.matrix[0][1] == this.matrix[1][1] && this.matrix[0][1] == this.matrix[2][1] && this.matrix[0][1] == 1) ||
                (this.matrix[0][2] == this.matrix[1][2] && this.matrix[0][2] == this.matrix[2][2] && this.matrix[0][2] == 1) ||
                (this.matrix[0][0] == this.matrix[1][1] && this.matrix[0][0] == this.matrix[2][2] && this.matrix[0][0] == 1) ||
                (this.matrix[0][2] == this.matrix[1][1] && this.matrix[0][2] == this.matrix[2][0] && this.matrix[0][2] == 1)){

            message = "GANADOR: Jugador 1 (X)";

        }else if((this.matrix[0][0] == this.matrix[0][1] && this.matrix[0][0] == this.matrix[0][2] && this.matrix[0][0] == 2) ||
                (this.matrix[1][0] == this.matrix[1][1] && this.matrix[1][0] == this.matrix[1][2] && this.matrix[1][0] == 2) ||
                (this.matrix[2][0] == this.matrix[2][1] && this.matrix[2][0] == this.matrix[2][2] && this.matrix[2][0] == 2) ||
                (this.matrix[0][0] == this.matrix[1][0] && this.matrix[0][0] == this.matrix[2][0] && this.matrix[0][0] == 2) ||
                (this.matrix[0][1] == this.matrix[1][1] && this.matrix[0][1] == this.matrix[2][1] && this.matrix[0][1] == 2) ||
                (this.matrix[0][2] == this.matrix[1][2] && this.matrix[0][2] == this.matrix[2][2] && this.matrix[0][2] == 2) ||
                (this.matrix[0][0] == this.matrix[1][1] && this.matrix[0][0] == this.matrix[2][2] && this.matrix[0][0] == 2) ||
                (this.matrix[0][2] == this.matrix[1][1] && this.matrix[0][2] == this.matrix[2][0] && this.matrix[0][2] == 2)){

            message = "GANADOR: Jugador 2 (O)";

        }else if(rondas == 9){

            message = "EMPATE!!";

        }

        return message;

    }
}
