package eightpuzzle;

import agent.Heuristic;

public class HeuristicTileDistance extends Heuristic<EightPuzzleProblem, EightPuzzleState>{
    
    // Heuristica que conta a distancia do carro à porta

    public double compute(EightPuzzleState state){
        return state.computeTileDistance();       
    }
    
    @Override
    public String toString(){
        return "Heuristic tiles distance to final position";
    }
}