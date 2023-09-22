import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Boss {
    private String name;
    private double health;
    private float reward;
    private String fileString;

    public Boss(String fileName){
        this.fileString = fileName;
        try{
            File playerFile = new File(fileName);
            Scanner myReader = new Scanner(playerFile);
            String [] data = myReader.nextLine().split(",");
            this.name = data[0];
            this.health = Double.parseDouble(data[1]);
            this.reward = Float.parseFloat(data[2]);
            myReader.close();
        }
        catch(Exception e){
            System.out.println(fileName +" not found!");
        }
    }

    public String getName(){
        return this.name;
    }

    public float getReward(){
        return this.reward;
    }

    public double getHealth(){
        return (double) Math.round(this.health * 100) / 100;
    }

    public void damage(double amtDamage){
        this.health -= amtDamage;
        this.health = (double) Math.round(this.health * 100) / 100;
    }

    public boolean isFinished(){
        return this.health > 0 ? false : true;
    }

    public void write(){
        try {
            FileWriter myWriter = new FileWriter(this.fileString);
            myWriter.write(this.name+","+this.health+","+this.reward);
            myWriter.close();
            System.out.println("Successfully wrote Player");
        } catch (Exception e) {
            System.out.println("An error occurred. Cannot write Player");
        }
    }

    public String toString(){
        String ret = "";
        ret += "Boss Name: "+this.name+"\n";
        ret += "Current Health: "+this.health+"\n";
        ret += "Reward: "+this.reward+"\n";
        return ret;
    }
}
