/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightpuzzle;


class Posicao {
    //TODO: Guardar a linha e coluna
    
    //[Lalanda]
    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Posicao)) {
            return false;
        }

        Posicao that = (Posicao) other;

        // Custom equality check here.
        return (this.linha == that.linha)
            && (this.coluna == that.coluna);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.linha;
        hash = 53 * hash + this.coluna;
        return hash;
    }
}
