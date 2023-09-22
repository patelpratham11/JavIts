import java.io.File;
import java.util.Scanner;

public class Pomodoro {
    private int pomos;
    private int hard;
    private int medium;
    private int easy;
    private String fileString;

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
}
