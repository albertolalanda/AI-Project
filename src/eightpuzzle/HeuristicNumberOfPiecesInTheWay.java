package eightpuzzle;

import agent.Heuristic;

public class HeuristicNumberOfPiecesInTheWay extends Heuristic<EightPuzzleProblem, EightPuzzleState> {

    public double compute(EightPuzzleState state) {
        return state.computeNumberOfPiecesInTheWay();
    }

    @Override
    public String toString() {
        return "Number of pieces in the way";
    }
}
