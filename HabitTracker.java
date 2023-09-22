import java.util.Scanner;

public class HabitTracker {

    private static Player player;
    private static Boss boss;
    private static Reminders reminders; 
    private static Pomodoro pomoList;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        player = new Player("Resources/Player.config");
        boss = new Boss("Resources/Boss.config");
        reminders = new Reminders("Resources/Reminders.config");
        pomoList = new Pomodoro("Resources/Pomos.config");
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        menu();
    }

    private static void menu(){
        System.out.println("What would you like to do?\nEnter the number below.");
        System.out.println("_______________________");
        System.out.printf("| %-15s | %-1s |%n", "View Player", 1 );
        System.out.printf("| %-15s | %-1s |%n", "View Boss", 2 );
        System.out.printf("| %-15s | %-1s |%n", "Add Pomodoros", 3 );
        System.out.printf("| %-15s | %-1s |%n", "Go to Reminders", 4 );
        System.out.printf("| %-15s | %-1s |%n", "Go to Shop", 5 );
        System.out.printf("| %-15s | %-1s |%n", "Quit", 6 );
        System.out.println("_______________________");

        int choice = input.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        switch (choice){
            case 1: 
                System.out.println(player.toString());
                menu();
                break;
            case 2: 
                System.out.println(boss.toString());
                menu();
                break;
            case 3: 
                addPomodoros();
                menu();
                break;
            case 4: 
                remindersMenu();
                menu();
                break;
            case 5: 
                shopMenu();
                menu();
                break;
            case 6: 
                player.write();
                boss.write();
                reminders.write();
                pomoList.write();
                break;
            
        }

    }

    public static void addPomodoros(){
        
    }

    public static void remindersMenu(){
        System.out.println("What would you like to do?\nEnter the number below.");
        System.out.println("_________________________________");
        System.out.printf("| %-25s | %-1s |%n", "View Reminders", 1 );
        System.out.printf("| %-25s | %-1s |%n", "Update Reminders", 2 );
        System.out.printf("| %-25s | %-1s |%n", "Add New Reminders", 3 );
        System.out.printf("| %-25s | %-1s |%n", "Quit", 4 );
        System.out.println("_________________________________");

        int choice = input.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        switch (choice){
            case 1: 
                reminders.print();
                remindersMenu();
                break;
            case 2: 
                updateReminders();
                remindersMenu();
                break;
            case 3: 
                addNewReminder();
                remindersMenu();
                break;
            case 4: 
                return;
            default:
                System.out.println("Invalid Choice!");
                remindersMenu();
                break;
        }
    }

    public static void addNewReminder(){
        System.out.println("Please enter the reminder's information in the following format:\n<Name>:<Difficulty>:<Neg>");
        input.nextLine();
        String [] data = input.nextLine().split(":");
        reminders.addReminder(new Reminder(data[0], Integer.parseInt(data[1]), Boolean.parseBoolean(data[2]), 0));
        System.out.println("Added successfully!");
        reminders.print();
    }
    public static void updateReminders(){
        reminders.print();
        System.out.println("Which reminder would you like to update? If there are multiple, split them with ';'");
        input.nextLine();
        String [] choices = input.nextLine().split(";");
        for (String c : choices){
            int choice = Integer.parseInt(c);
            Reminder rem = reminders.getReminder(choice);
            if(rem != null){
                rem.increaseStreak();
            } else{
                System.out.println("Invalid Choice!");
            }
        }
        
    }

    public static void shopMenu(){
        
    }

}
