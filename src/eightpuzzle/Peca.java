/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightpuzzle;

import agent.Action;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Peca {
    private Posicao posicao;
    private int tipo;
    // Added:
    private int size;
    private boolean horizontal;
    private ArrayList<Posicao> posicoes;
    

    //TODO: (Peca) criar a peca preciso da sua posicao da quantidade de blocos que tem e o seu valor
    public Peca(Posicao startingPos, int tipo) {
        //TODO: (PECA) Pecas horizontais sao pares Verticais sao impares! guarda a direcao delas para saber que accoes podem executar
        this.tipo = tipo;
        this.posicao = startingPos;
        if((tipo%2)==0){
            horizontal=true;
        } else {
            horizontal=false;
        }
        switch (tipo){
            case 2:
                size=1;
                break;
            case 3:
                size=1;
                break;
            case 4:
                size=2;
                break;
            case 5:
                size=2;
                break;
            case 6:
                size=3;
                break;
            case 7:
                size=3;
                break;
            case 8:
                size=4;
                break;
            case 9:
                size=4;
                break;
        }
        
        // Guardar as posicoes ou só a cabeça da peca?
        
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public boolean canMoveTo(Posicao pos){ //TODO: Probably
        return true;
    }

    public int getLinha() {
        return posicao.getLinha();
    }
    
    public int getColuna() {
        return posicao.getColuna();
    }

    private void moveTo(Posicao pos) {
        this.posicao = pos;
    }
    
    public int getTipo() {
        return tipo;
    }
}
