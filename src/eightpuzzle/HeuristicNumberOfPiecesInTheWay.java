package eightpuzzle;

import agent.Heuristic;

public class HeuristicNumberOfPiecesInTheWay extends Heuristic<EightPuzzleProblem, EightPuzzleState> {

    // Heuristica que conta o numero de peças que estão no caminho do carro
    
    public double compute(EightPuzzleState state) {
        return state.computeNumberOfPiecesInTheWay();
    }

    @Override
    public String toString() {
        return "Heuristic number of pieces in the way";
    }
}
