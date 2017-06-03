package eightpuzzle;

import agent.Heuristic;

public class HeuristicSizeOfObjectsInTheWay extends Heuristic<EightPuzzleProblem, EightPuzzleState> {
    
    // Heuristica que conta o tamanho dos objectos que se encontram no caminho do carro
    
    public double compute(EightPuzzleState state) {
        return state.computeSizeOfObjectsOnPath();
    }

    @Override
    public String toString() {
        return "Heuristic size of Objects in the way";
    }
}
