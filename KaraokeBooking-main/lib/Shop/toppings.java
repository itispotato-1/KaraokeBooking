package lib.Shop;

public class toppings {

    private String top;
    private double cost;

    private void checkRep(){
        if(top.isBlank()|| top == null){
            throw new RuntimeException("RI violated: topping is Blank or null");
        }
        if(cost < 0){
            throw new RuntimeException("RI violated: id must be cost >= 0");
        }
    }

    public toppings(String top,Double cost){
            this.top = top ;
            this.cost = cost;
            checkRep();
    }

    public double getCost() {
        return cost;
    }
    
    public String getTop() {
        return top;
    }
}
