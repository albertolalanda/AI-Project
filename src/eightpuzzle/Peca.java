/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightpuzzle;

import agent.Action;
import java.util.Arrays;
import java.util.LinkedList;
/**
 *
 * @author Pedro
 */
public class Peca {
    private Posicao posicao;
    private int tipo;
    

    //TODO: (Peca) criar a peca preciso da sua posicao da quantidade de blocos que tem e o seu valor
    public Peca(Posicao startingPos, int tipo) {
        //TODO: (PECA) Pecas horizontais sao pares Verticais sao impares! guarda a direcao delas para saber que accoes podem executar
        this.tipo = tipo;
        this.posicao = startingPos;
        
        // Guardar as posicoes ou só a cabeça da peca?
        
    }

    
    public boolean canMoveTo(Posicao pos){
        return false;
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
