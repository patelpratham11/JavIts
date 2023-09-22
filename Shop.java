import java.util.HashMap;

public class Shop {
    private HashMap<String, Integer> shop;

    public Shop(){
        // read in information
    }

    public Integer getItem(String item){
        return shop.get(item);
    }

    public void putItem(String item, int cost){
        shop.put(item, cost);
        this.write();
    }

    private void write(){
        // 
    }
}
