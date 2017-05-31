package eightpuzzle;

import agent.Action;
import agent.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

    //TODO: (NOTA) Este objeto é chamado pelos algoritmos de procura enquant estiverem á procura da solução
    //os algoritmos vão sempre verificando o isGoal() e se não encontrarem continuam para o executeActions()
    
public class EightPuzzleProblem extends Problem<EightPuzzleState> {
    
    public EightPuzzleProblem(EightPuzzleState initialState ){ //, List<Action> actions) {
        //Criar lista das pecas
        super(initialState, new ArrayList<Action>());
    }
    //DONE: (NOTA) Basta verificar se a coluna do carro é igual á ultima coluna da matriz (state.getPosDoCarro()?)
    @Override
    public boolean isGoal(EightPuzzleState state) {
        return state.getColunaCarro() == state.getNumColumns()-1;
    }

    
    //TODO: NOTE: Este metodo é chamado por todos os algoritmos de procura para criar um novo estado (Nó)
    //Neste tipo de problema todas as peças mexem-se e para 2 sentidos (Horizontal[LEFT|RIGHT] ou Vertical[UP|DOWN])
    //(Para cada Peça)
    //   Se [accao sobre o estado for válida]
    //        nova Accao
    //(Para cada Accao)
    //   a.execute(sucessor)
    @Override
    public List<EightPuzzleState> executeActions(EightPuzzleState state) {
        List<EightPuzzleState> successors = new LinkedList<EightPuzzleState>();
        Action a;
        actions.clear();
        //falta código..
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
                if( a2.isValid(state) ){ //Este if pode ficar no loop das peças para não preencher a lista actions com movimentos inválidos(menos iterações)
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
    public double computePathCost(List<Action> path) {//so para otimizacao não é genérico...
        return path.size();
    }

    
}
