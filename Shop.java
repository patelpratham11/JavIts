import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shop {
    private ArrayList<Item> shop;
    private String fileString;

    public Shop(String fileName){
       this.fileString = fileName;
       shop = new ArrayList<>();
        try{
            File playerFile = new File(fileName);
            Scanner myReader = new Scanner(playerFile);
            while(myReader.hasNext()){
                String [] data = myReader.nextLine().split(",");
                Item temp = new Item(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                this.putItem(temp);
            }
            myReader.close();
        }
        catch(Exception e){
            System.out.println(fileName +" not found!");
        }
    }

    public Item getItem(int id){
        return shop.get(id-1);
    }

    public void putItem(Item itemInfo){
        shop.add(itemInfo);;
    }

    public void write(){
        try {
            FileWriter myWriter = new FileWriter(this.fileString);
            for( Item r :  this.shop){
                myWriter.write(r.toString());
            }
            myWriter.close();
            System.out.println("Successfully wrote Shop");
        } catch (Exception e) {
            System.out.println("An error occurred. Cannot write Shop");
        } 
    }

    public void print(){
        System.out.println("__________________________________________________________________________");
        System.out.printf("| %-6s | %-35s | %-5s | %-8s | %-10s |%n", "INDEX ","NAME", "COST", "ATTACK?", "AMOUNT");
        int i = 1;
        for(Item r : shop){
            String version = "";
            switch (r.getValue()){
                case 1: 
                    version = "Attack";
                    break;
                case 2: 
                    version = "Strength";
                    break;
                case 3: 
                    version = "Reward";
                    break;
            }
            System.out.printf("| %-6s | %-35s | %-5s | %-8s | %-10s |%n", i, r.getName(), r.getCost(), version, r.getAmt());
            i += 1; 
        }
        System.out.println("__________________________________________________________________________");
    }
}
