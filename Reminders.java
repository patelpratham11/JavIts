// import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reminders {
    private ArrayList<Reminder> remindersList;
    private String fileString;

    public Reminders(String fileName){
        this.remindersList = new ArrayList<>();
        this.fileString = fileName;
        try{
            File playerFile = new File(fileName);
            Scanner myReader = new Scanner(playerFile);
            while(myReader.hasNext()){
                String [] data = myReader.nextLine().split(",");
                remindersList.add(new Reminder(data[0], Integer.parseInt(data[1]), Boolean.parseBoolean(data[2]), Integer.parseInt(data[3])));
            }
            myReader.close();
        }
        catch(Exception e){
            System.out.println(fileName +" not found!");
        }
    }

    public Reminder getReminder(int id){
        return this.remindersList.get(id);
    }

    public void addReminder(Reminder reminder){
        this.remindersList.add(reminder);
    }

    public void write(){
       try {
            FileWriter myWriter = new FileWriter(this.fileString);
            for( Reminder r : remindersList){
                myWriter.write(r.toString());
            }
            myWriter.close();
            System.out.println("Successfully wrote Reminders");
        } catch (Exception e) {
            System.out.println("An error occurred. Cannot write Reminders");
        } 
    }

    public void print(){
        System.out.println("_________________________________________________________________");
        System.out.printf("| %-15s | %-15s | %-12s | %-10s |%n", "NAME", "DIFFICULTY", "ISNEGATIVE", "STREAK");
        for(Reminder r : remindersList){
            System.out.printf("| %-15s | %-15s | %-12s | %-10s |%n", r.getReminder(), r.getDifficulty(), r.getNegative(), r.getStreak());
        }
        System.out.println("_________________________________________________________________");
    }

    
}
