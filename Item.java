public class Item {
    private int cost;
    private int value;
    private String name;
    private int amt;

    public Item(String name, int cost, int value, int amt){
        this.cost = cost;
        this.value = value;
        this.name = name;
        this.amt = amt;
    }

    public int getCost(){
        return this.cost;
    }

    public int getValue(){
        return this.value;
    }

    public String getName(){
        return this.name;
    }

    public int getAmt(){
        return this.amt;
    }

    public String toString(){
        return this.name+","+this.cost+","+this.value+","+this.amt;
    }
}
