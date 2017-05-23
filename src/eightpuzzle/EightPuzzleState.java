package eightpuzzle;

import agent.Action;
import agent.State;
import java.util.ArrayList;
import java.util.Arrays;

public class EightPuzzleState extends State implements Cloneable {
    
    private int[][] matrix;
    
    private int colunaCarro;
    private ArrayList<Peca> pecas;

    public EightPuzzleState(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix.length];
        this.pecas = new ArrayList<Peca>();
        
        //TODO: (NOTA) Guardar as peças para poder retornar para a class EightPuzzelProblem
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                
                //TODO: (NOTA) Criar as pecas consuante o seu valor e guardar as suas posicoes/valores
                switch (matrix[i][j]) {
                    case 1:  pecas.add(new Peca(new Posicao(i, j), 1));
                             break;
                    case 2:  pecas.add(new Peca(new Posicao(i, j), 2));
                             break;
                    case 3:  pecas.add(new Peca(new Posicao(i, j), 3));
                             break;
                    case 4:  pecas.add(new Peca(new Posicao(i, j), 4));
                             break;
                    case 5:  pecas.add(new Peca(new Posicao(i, j), 5));
                             break;
                    case 6:  pecas.add(new Peca(new Posicao(i, j), 6));
                             break;
                    case 7:  pecas.add(new Peca(new Posicao(i, j), 7));
                             break;
                    case 8:  pecas.add(new Peca(new Posicao(i, j), 8));
                             break;
                    case 9:  pecas.add(new Peca(new Posicao(i, j), 9));
                             break;
                }

            }
        }
    }
    
    //NOTE: adicionei este getter para poder no isGoal verificar o estado da matrix
    public int[][] getMatrix() {
        return matrix;
    }

    public void executeAction(Action action) {
        action.execute(this);
        firePuzzleChanged(null);
    }


    //TODO: (NOTA) Que peca é que vai perguntar? estes metodos canMove
    public boolean canMoveRight() {
        return false;
    }

    public boolean canMoveLeft() {
        return false;
    }
    
    public boolean canMoveDown() {
        return false;
    }

    public boolean canMoveUp() {
        return false;
    }


    /*
     * Nos metodos move[Down|Up|Right|Left] não há validação(canMove), já foi feita na class EightPuzzelProblem no executeActions().
     * Saber que peça quer mover e actualizar na matriz
     */
    
    public void moveUp() {
        
    }

    public void moveRight() {
        
    }

    public void moveDown() {
        
    }

    public void moveLeft() {
        
    }

    public int getNumLines() {
        return matrix.length;
    }

    public int getNumColumns() {
        return matrix[0].length;
    }

    public int getTileValue(int line, int column) {
        if (!isValidPosition(line, column)) {
            throw new IndexOutOfBoundsException("Invalid position!"+ "line:"+ line+" column:"+ column + "Matrix["+matrix.length+"]["+matrix[0].length+"]");
        }
        return matrix[line][column];
    }

    //TODO: (NOTA) Atenção que peças não podem sobrepor-se
    public boolean isValidPosition(int line, int column) {
        return line >= 0 && line < matrix.length && column >= 0 && column < matrix[0].length;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EightPuzzleState)) {
            return false;
        }

        EightPuzzleState o = (EightPuzzleState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    @Override
    public Object clone() {
        return new EightPuzzleState(matrix);
    }
    //Listeners
    private transient ArrayList<EightPuzzleListener> listeners = new ArrayList<EightPuzzleListener>(3);

    public synchronized void removeListener(EightPuzzleListener l) {
        if (listeners != null && listeners.contains(l)) {
            listeners.remove(l);
        }
    }

    public synchronized void addListener(EightPuzzleListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public void firePuzzleChanged(EightPuzzleEvent pe) {
        for (EightPuzzleListener listener : listeners) {
            listener.puzzleChanged(null);
        }
    }
    
    //[Lalanda]
    public Iterable<Peca> getListaPecas() {
        return pecas;
    }
}
