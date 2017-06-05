package agent;

import eightpuzzle.Peca;


public abstract class Action <S extends State>{
    private double cost; 
    protected Peca peca;
    
    public Action(double cost){
        this.cost = cost;
    }

    public abstract void execute(S State);


    public abstract boolean isValid(S State);

    public double getCost(){
        return cost;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}