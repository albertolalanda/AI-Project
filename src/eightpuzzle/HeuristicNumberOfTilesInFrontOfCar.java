package eightpuzzle;

import agent.Heuristic;

public class HeuristicNumberOfTilesInFrontOfCar extends Heuristic<EightPuzzleProblem, EightPuzzleState> {

    // Heuristica que conta o numero de tiles ocupados em todo o quadro à direita do carro 
    
    public double compute(EightPuzzleState state) {
        return state.computeNumberOfPiecesInFrontOfTheCar();
    }

    @Override
    public String toString() {
        return "Heuristic number of ocupied tiles in front of the car";
    }
}
