/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightpuzzle;

import agent.Heuristic;

/**
 *
 * @author lalanda
 */
public class HeuristicTileDistanceAndNumberOfPiecesInTheWay extends Heuristic<EightPuzzleProblem, EightPuzzleState> {
    
    // Heuristica que conta a distancia do carro à porta e o numero de peças no caminho

    public double compute(EightPuzzleState state){
        return state.computeTileDistance() + state.computeNumberOfPiecesInTheWay();       
    }
    
    @Override
    public String toString(){
        return "Heuristic tiles distance to final position + number of pieces in the way";
    }
}