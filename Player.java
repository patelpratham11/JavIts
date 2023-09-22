import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Player{
    private String name;
    private double xp;
    private double strength;
    private double balance;
    private String fileString;

    public Player(String fileName){
        this.fileString = fileName;
        try{
            File playerFile = new File(fileName);
            Scanner myReader = new Scanner(playerFile);
            String [] data = myReader.nextLine().split(",");
            this.name = data[0];
            this.xp = Double.parseDouble(data[1]);
            this.strength = Double.parseDouble(data[2]);
            this.balance = Double.parseDouble(data[3]);
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
        return ((int) (this.xp / 100)+1);
    }

    public double getStrength(){
        return (double) Math.round(this.strength * 100) / 100;
    }

    public double getBalance(){
        return (double) Math.round(this.balance * 100) / 100;
    }

    public int addXP(float xp){
        int old = this.getLevel();
        this.xp += xp;
        if (this.getLevel() > old){
            System.out.println("You leveled up!");
            this.strength += Math.random()*2;
            System.out.println("Your Strength is now "+this.strength);
        }
        return this.getLevel();
    }

    public void addStrength(double strength){
        this.strength += strength;
        this.strength = (double) Math.round(this.strength * 100) / 100;
    }

    public void addBalance(double balance){
        System.out.println(this.balance);
        this.balance += balance;
        System.out.println(balance);
        System.out.println(this.balance);
        this.balance = (double) Math.round(this.balance * 100) / 100;
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