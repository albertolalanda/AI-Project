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
    private int size;
    private ArrayList<Posicao> posicoes;
    

    public Peca(Posicao startingPos, int tipo) {
        this.tipo = tipo;
        this.posicao = startingPos;
        switch (tipo){
            case 1:
                size=1;
                break;
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
        
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public boolean canMoveTo(Posicao pos){
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

    public Posicao getPosicao() {
        return posicao;
    }
    
    
}
