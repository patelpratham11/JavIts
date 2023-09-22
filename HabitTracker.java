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
        menu();
    }

    private static void menu(){
        System.out.println("What would you like to do?\nEnter the number below.");
        System.out.printf("| %-15s | %-1s |%n", "View Player", 1 );
        System.out.printf("| %-15s | %-1s |%n", "View Boss", 2 );
        System.out.printf("| %-15s | %-1s |%n", "Add Pomodoros", 3 );
        System.out.printf("| %-15s | %-1s |%n", "Go to Reminders", 4 );
        System.out.printf("| %-15s | %-1s |%n", "Go to Shop", 5 );
        System.out.printf("| %-15s | %-1s |%n", "Quit", 6 );

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
                //player
                break;
            case 4: 
                //player
                break;
            case 5: 
                //player
                break;
            case 6: 
                player.write();
                boss.write();
                reminders.write();
                pomoList.write();
                break;
            
        }

    }
}
