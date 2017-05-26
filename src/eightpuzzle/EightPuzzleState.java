package eightpuzzle;

import agent.Action;
import agent.State;
import java.util.ArrayList;
import java.util.Arrays;

public class EightPuzzleState extends State implements Cloneable {
    
    private int[][] matrix;
    
    private int colunaCarro;  //Mas a linha do carro é sempre a mesma a coluna é que muda...
    private ArrayList<Peca> pecas;
    private ArrayList<Posicao> notStartingPos;
    private boolean found=false;

    public EightPuzzleState(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix.length];
        this.pecas = new ArrayList<Peca>();
        this.notStartingPos = new ArrayList<Posicao>();
        notStartingPos.add(new Posicao(-1,-1));
        //TODO: (NOTA) Guardar as peças para poder retornar para a class EightPuzzelProblem
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                
                //DONE: (NOTA) Criar as pecas consuante o seu valor e guardar as suas posicoes/valores
                switch (matrix[i][j]) {
                    case 1:  pecas.add(new Peca(new Posicao(i, j), 1));
                             colunaCarro =  j;
                             break;
                    case 2:  pecas.add(new Peca(new Posicao(i, j), 2));
                             break;
                    case 3:  pecas.add(new Peca(new Posicao(i, j), 3));
                             break;
                    case 4:  for(int k = 0; k < notStartingPos.size(); k++){
                                if(notStartingPos.get(k).equals(new Posicao(i,j))){
                                    System.out.println("Found a 4");
                                    found=true;
                                }
                             }
                             if(!found){
                                pecas.add(new Peca(new Posicao(i, j), 4));
                                notStartingPos.add(new Posicao(i, j+1));
                             }
                             found=false;
                             break;
                    case 5:  for(int k = 0; k < notStartingPos.size(); k++){
                                if(notStartingPos.get(k).equals(new Posicao(i,j))){
                                    System.out.println("Found a 5");
                                    found=true;
                                }
                             }
                             if(!found){
                                pecas.add(new Peca(new Posicao(i, j), 5));
                                notStartingPos.add(new Posicao(i+1, j));
                             }
                             found=false;
                             break;
                    case 6:  for(int k = 0; k < notStartingPos.size(); k++){
                                if(notStartingPos.get(k).equals(new Posicao(i,j))){
                                    System.out.println("Found a 6");
                                    found=true;
                                }
                             }
                             if(!found){
                                pecas.add(new Peca(new Posicao(i, j), 6));
                                notStartingPos.add(new Posicao(i, j+1));
                                notStartingPos.add(new Posicao(i, j+2));
                             }
                             found=false;
                             break;
                    case 7:  for(int k = 0; k < notStartingPos.size(); k++){
                                if(notStartingPos.get(k).equals(new Posicao(i,j))){
                                    System.out.println("Found a 7");
                                    found=true;
                                }
                             }
                             if(!found){
                                pecas.add(new Peca(new Posicao(i, j), 7));
                                notStartingPos.add(new Posicao(i+1, j));
                                notStartingPos.add(new Posicao(i+2, j));
                             }
                             found=false;
                             break;
                    case 8:  for(int k = 0; k < notStartingPos.size(); k++){
                                if(notStartingPos.get(k).equals(new Posicao(i,j))){
                                    System.out.println("Found a 8");
                                    found=true;
                                }
                             }
                             if(!found){
                                pecas.add(new Peca(new Posicao(i, j), 8));
                                notStartingPos.add(new Posicao(i, j+1));
                                notStartingPos.add(new Posicao(i, j+2));
                                notStartingPos.add(new Posicao(i, j+3));
                             }
                             found=false;
                             break;
                    case 9:  for(int k = 0; k < notStartingPos.size(); k++){
                                if(notStartingPos.get(k).equals(new Posicao(i,j))){
                                    System.out.println("Found a 9");
                                    found=true;
                                }
                             }
                             if(!found){
                                pecas.add(new Peca(new Posicao(i, j), 9));
                                notStartingPos.add(new Posicao(i+1, j));
                                notStartingPos.add(new Posicao(i+2, j));
                                notStartingPos.add(new Posicao(i+3, j));
                             }
                             found=false;
                             break;
                }

            }
        }
        //System.out.println(pecas);
        for(Posicao p:notStartingPos){
            System.out.println(p.getLinha() + "," + p.getColuna());
        }
        
    }

    public int getColunaCarro() {
        return colunaCarro;
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
    public boolean canMoveRight(Peca peca) {
        switch (peca.getTipo()) {
            case 1:  isValidPosition(peca.getLinha(), peca.getColuna() +1);
                     break;
            case 2:  isValidPosition(peca.getLinha(), peca.getColuna() +1);
                   break; 
            case 4:  if(isValidPosition(peca.getLinha(), peca.getColuna() +1) && isValidPosition(peca.getLinha(), peca.getColuna() +2)){return true;}
                   break;
            case 6:  if(isValidPosition(peca.getLinha(), peca.getColuna() +1) && isValidPosition(peca.getLinha(), peca.getColuna() +2) && isValidPosition(peca.getLinha(), peca.getColuna() +3)){return true;}
                   break;
            case 8:  if(isValidPosition(peca.getLinha(), peca.getColuna() +1) && isValidPosition(peca.getLinha(), peca.getColuna() +2) && isValidPosition(peca.getLinha(), peca.getColuna() +3) && isValidPosition(peca.getLinha(), peca.getColuna() +4)){return true;}
                   break;
            default: return false;
        }
        return false;
    }

    public boolean canMoveLeft(Peca peca) {
        switch (peca.getTipo()) {
            case 1:  isValidPosition(peca.getLinha(), peca.getColuna() -1);
                     break;
            case 2:  isValidPosition(peca.getLinha(), peca.getColuna() -1);
                   break; 
            case 4:  if(isValidPosition(peca.getLinha(), peca.getColuna() -1) && isValidPosition(peca.getLinha(), peca.getColuna())){return true;}
                   break;
            case 6:  if(isValidPosition(peca.getLinha(), peca.getColuna() -1) && isValidPosition(peca.getLinha(), peca.getColuna()) && isValidPosition(peca.getLinha(), peca.getColuna() +1)){return true;}
                   break;
            case 8:  if(isValidPosition(peca.getLinha(), peca.getColuna() -1) && isValidPosition(peca.getLinha(), peca.getColuna()) && isValidPosition(peca.getLinha(), peca.getColuna() +1) && isValidPosition(peca.getLinha(), peca.getColuna() +2)){return true;}
                   break;
            default: return false;
        }
        return false;
    }
    
    public boolean canMoveDown(Peca peca) {
        switch (peca.getTipo()) {
            case 3:  isValidPosition(peca.getLinha()-1, peca.getColuna());
                   break; 
            case 5:  if(isValidPosition(peca.getLinha()-1, peca.getColuna()) && isValidPosition(peca.getLinha()-2, peca.getColuna())){return true;}
                   break;
            case 7:  if(isValidPosition(peca.getLinha()-1, peca.getColuna()) && isValidPosition(peca.getLinha()-2, peca.getColuna()) && isValidPosition(peca.getLinha()-3, peca.getColuna())){return true;}
                   break;
            case 9:  if(isValidPosition(peca.getLinha()-1, peca.getColuna()) && isValidPosition(peca.getLinha()-2, peca.getColuna()) && isValidPosition(peca.getLinha()-3, peca.getColuna()) && isValidPosition(peca.getLinha()-4, peca.getColuna())){return true;}
                   break;
            default: return false;
        }
        return false;
    }

    public boolean canMoveUp(Peca peca) {
        switch (peca.getTipo()) {
            case 3:  isValidPosition(peca.getLinha()+1, peca.getColuna());
                   break; 
            case 5:  if(isValidPosition(peca.getLinha()+1, peca.getColuna()) && isValidPosition(peca.getLinha(), peca.getColuna())){return true;}
                   break;
            case 7:  if(isValidPosition(peca.getLinha()+1, peca.getColuna()) && isValidPosition(peca.getLinha(), peca.getColuna()) && isValidPosition(peca.getLinha()-1, peca.getColuna())){return true;}
                   break;
            case 9:  if(isValidPosition(peca.getLinha()+1, peca.getColuna()) && isValidPosition(peca.getLinha(), peca.getColuna()) && isValidPosition(peca.getLinha()-1, peca.getColuna()) && isValidPosition(peca.getLinha()-2, peca.getColuna())){return true;}
                   break;
            default: return false;
        }
        return false;
    }

    /*
     * Nos metodos move[Down|Up|Right|Left] não há validação(canMove), já foi feita na class EightPuzzelProblem no executeActions().
     * Saber que peça quer mover e actualizar na matriz
     */
    
    // modificar a peca na matriz e atualizar na lista de pecas
    public void moveUp(Peca peca) {
        
        matrix[peca.getLinha()][peca.getColuna()] = 0;
        peca.setPosicao(new Posicao(peca.getLinha()+1, peca.getColuna()));
    }

    public void moveRight(Peca peca) {
        
    }

    public void moveDown(Peca peca) {
        
    }

    public void moveLeft(Peca peca) {
        
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
