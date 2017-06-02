package eightpuzzle;

import agent.Heuristic;

public class HeuristicNull extends Heuristic<EightPuzzleProblem, EightPuzzleState> {

    public double compute(EightPuzzleState state) {
        return 0.0;
    }

    @Override
    public String toString() {
        return "No Heuristic";
    }
}
