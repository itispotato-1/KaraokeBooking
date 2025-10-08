package store;

public class toppings {

    private String top;
    private double cost;

    public toppings(String top,Double cost){
            this.top = top ;
            this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
    
    public String getTop() {
        return top;
    }
}
