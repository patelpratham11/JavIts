import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Player{
    private String name;
    private float xp;
    private double strength;
    private float balance;
    private String fileString;

    public Player(String fileName){
        this.fileString = fileName;
        try{
            File playerFile = new File(fileName);
            Scanner myReader = new Scanner(playerFile);
            String [] data = myReader.nextLine().split(",");
            this.name = data[0];
            this.xp = Float.parseFloat(data[1]);
            this.strength = Double.parseDouble(data[2]);
            this.balance = Float.parseFloat(data[3]);
            myReader.close();
        }
        catch(Exception e){
            System.out.println(fileName +" not found!");
        }
    }

    public String getName(){
        return this.name;
    }

    public int getLevel(){
        return (int) this.xp / 100;
    }

    public double getStrength(){
        return this.strength;
    }

    public float getBalance(){
        return this.balance;
    }

    public int addXP(float xp){
        this.xp += xp;
        return this.getLevel();
    }

    public void addStrength(double strength){
        this.strength += strength;
    }

    public void setBalance(float balance){
        this.balance = balance;
    }

    public void write(){
        try {
            FileWriter myWriter = new FileWriter(this.fileString);
            myWriter.write(this.name+","+this.xp+","+this.strength+","+this.balance);
            myWriter.close();
            System.out.println("Successfully wrote Player");
        } catch (Exception e) {
            System.out.println("An error occurred. Cannot write Player");
        }
    }

    public String toString(){
        String ret = "";
        ret += "Player Name: "+this.name+"\n";
        ret += "Hit Strength: "+this.strength+"\n";
        ret += "Level: "+this.getLevel()+"\n";
        ret += "Balance: "+this.balance+"\n";
        return ret;
    }

}