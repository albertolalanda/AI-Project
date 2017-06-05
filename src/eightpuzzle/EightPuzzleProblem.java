package eightpuzzle;

import agent.Action;
import agent.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
    
public class EightPuzzleProblem extends Problem<EightPuzzleState> {
    
    public EightPuzzleProblem(EightPuzzleState initialState ){ 
        super(initialState, new ArrayList<Action>());
    }
    @Override
    public boolean isGoal(EightPuzzleState state) {
        return state.getColunaCarro() == state.getNumColumns()-1;
    }

    
    
    @Override
    public List<EightPuzzleState> executeActions(EightPuzzleState state) {
        List<EightPuzzleState> successors = new LinkedList<EightPuzzleState>();
        Action a;
        actions.clear();
        for(Peca peca: state.getListaPecas()){
            if (peca.getTipo() == 1 || peca.getTipo() % 2 == 0){
                a = new ActionRight();
                a.setPeca(peca);
                actions.add(a);
                a = new ActionLeft();
                a.setPeca(peca);
                actions.add(a);
            } else{
                a = new ActionUp();
                a.setPeca(peca);
                actions.add(a);
                a = new ActionDown();
                a.setPeca(peca);
                actions.add(a);
            }
        }

            for (Action a2 : actions) {
                if( a2.isValid(state) ){ 
                    EightPuzzleState sucessor = (EightPuzzleState) state.clone();
                    //System.out.println(a2.getPeca().getLinha()+"-"+a2.getPeca().getColuna()+a2);
                    //System.out.println("a"+sucessor);
                    a2.execute(sucessor);
                    //System.out.println("d"+sucessor);
                    successors.add(sucessor);
                }
            }
        return successors;
    }

    @Override
    public double computePathCost(List<Action> path) {
        return path.size();
    }

    
}
