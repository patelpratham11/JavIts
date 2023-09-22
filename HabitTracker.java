import java.util.Scanner;

public class HabitTracker {

    private static Player player;
    private static Boss boss;
    private static Reminders reminders; 
    private static Pomodoro pomoList;
    private static Shop shop;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        player = new Player("Resources/Player.config");
        boss = new Boss("Resources/Boss.config");
        reminders = new Reminders("Resources/Reminders.config");
        pomoList = new Pomodoro("Resources/Pomos.config");
        shop = new Shop("Resources/Shop.config");
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
        System.out.println("Please enter the following information in the following format:\n<# Pomos>;<# Hard>;<# Medium>;<# Easy>");
        input.nextLine();
        String [] data = input.nextLine().split(";");
        pomoList.addPomos(Integer.parseInt(data[0]));
        pomoList.addHards(Integer.parseInt(data[1]));
        pomoList.addMeds(Integer.parseInt(data[2]));
        pomoList.addEasy(Integer.parseInt(data[3]));

        balanceCalc(pomoList.calculate());
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
        System.out.println("Please enter the reminder's information in the following format:\n<Name>;<Difficulty>;<Neg>");
        input.nextLine();
        String [] data = input.nextLine().split(";");
        reminders.addReminder(new Reminder(data[0], Integer.parseInt(data[1]), Boolean.parseBoolean(data[2]), 0));
        System.out.println("Added successfully!");
        reminders.print();
    }
    
    public static void updateReminders(){
        reminders.print();
        double balance = 0;
        System.out.println("Which reminder would you like to update? If there are multiple, split them with ';'");
        input.nextLine();
        String [] choices = input.nextLine().split(";");
        for (String c : choices){
            int choice = Integer.parseInt(c);
            Reminder rem = reminders.getReminder(choice);
            if(rem != null){
                balance += rem.increaseStreak();
            } else{
                System.out.println("Invalid Choice!");
            }
        }

        balanceCalc(balance);
    }

    public static void shopMenu(){
        System.out.println("What would you like to do?\nEnter the number below.");
        System.out.println("_________________________________");
        System.out.printf("| %-25s | %-1s |%n", "Buy Something", 1 );
        System.out.printf("| %-25s | %-1s |%n", "Add Shop Items", 2 );
        System.out.printf("| %-25s | %-1s |%n", "Quit", 3 );
        System.out.println("_________________________________");

        int choice = input.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        switch (choice){
            case 1: 
                shop();
                shopMenu();
                break;
            case 2: 
                addShop();
                shopMenu();
                break;
            case 3: 
                return;
            case 4: 
            default:
                System.out.println("Invalid Choice!");
                shopMenu();
                break;
        }
    }

    public static void shop(){
        shop.print();
        System.out.println("What would you like to purchase?");
        int choice = input.nextInt();

       Item i = shop.getItem(choice);
        if(i.getCost() < player.getBalance()){
            player.addBalance(-1*i.getCost());
            if(i.getValue() == 1){
                boss.damage(i.getAmt());
                System.out.println("You attacked the boss by "+i.getAmt());
                System.out.println("Current boss health is "+boss.getHealth());
            } else if(i.getValue() == 2) {
                player.addStrength(i.getAmt());
                System.out.println("You gained "+i.getAmt()+" strength!");
                System.out.println("Current strength is "+player.getStrength());
            } else{
                System.out.println("You bout "+i.getName()+", Enjoy!");
            }
        } else{
            System.out.println("Sorry, insufficient funds!");
        }
    }

    public static void addShop(){
        System.out.println("Add the item in this fashion:\n<Name>;<Cost>;<Type>;<Amt>");
        input.nextLine();
        String [] data = input.nextLine().split(";");
        shop.putItem(new Item(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3])));
        System.out.println("Placed successfully!");
    }

    public static void balanceCalc(double balance){
        double damage = player.getStrength() + (balance * Math.random() *7);
        damage = (double) Math.round(damage * 100) / 100;
        boss.damage(damage);
        player.addXP((float)damage);
        player.addBalance(balance*(player.getLevel()));

        System.out.println("You damaged the boss with "+(double) Math.round(damage * 100) / 100+ " hitpoints");
        System.out.println("You also earned "+(double) Math.round(balance * 100) / 100+" coins, bringing your balance up to "+ player.getBalance());
    }

}
