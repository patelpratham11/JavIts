import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Pomodoro {
    private int pomos;
    private int hard;
    private int medium;
    private int easy;
    private String fileString;

    private final double pomoMultiplier = 0.025;
    private final double hardMultiplier = 0.075;
    private final double mediumMultiplier = 0.05;
    private final double easyMultiplier = 0.01;



    public Pomodoro(String fileName){
        this.fileString = fileName;
        try{
            File playerFile = new File(fileName);
            Scanner myReader = new Scanner(playerFile);
            String [] data = myReader.nextLine().split(",");
            this.pomos = Integer.parseInt(data[0]);
            this.hard = Integer.parseInt(data[1]);
            this.medium = Integer.parseInt(data[2]);
            this.easy = Integer.parseInt(data[3]);
            myReader.close();
        }
        catch(Exception e){
            System.out.println(fileName +" not found!");
        }
    }

    public int getPomos(){
        return this.pomos;
    }

    public int getHards(){
        return this.hard;
    }

    public int getMeds(){
        return this.medium;
    }

    public int getEasys(){
        return this.easy;
    }

    public void addPomos(int val){
        this.pomos += val;
    }

    public void addHards(int val){
        this.hard += val;
    }

    public void addMeds(int val){
        this.medium += val;
    }

    public void addEasy(int val){
        this.easy += val;
    }

    public double calculate(){
        double balance = this.pomos*pomoMultiplier + this.hard*hardMultiplier + this.medium*mediumMultiplier + this.easy*easyMultiplier;
        return (double) Math.round(balance * 100) / 100;
    }

    public void write(){
        try {
            FileWriter myWriter = new FileWriter(this.fileString);
            myWriter.write(this.pomos+","+this.hard+","+this.medium+","+this.easy);
            myWriter.close();
            System.out.println("Successfully wrote Pomos");
        } catch (Exception e) {
            System.out.println("An error occurred. Cannot write Pomos");
        }
    }

    public String toString(){
        String ret = "";
        ret += "Pomodoros: "+this.pomos+"\n";
        ret += "Hard Tasks: "+this.hard+"\n";
        ret += "Medium Tasks: "+this.medium+"\n";
        ret += "Easy Tasks: "+this.easy+"\n";
        return ret;
    }
}
