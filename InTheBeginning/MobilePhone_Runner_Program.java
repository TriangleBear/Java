/*
* Assignment 1.3 Runner Program
* Assignment Group 11
* Kurt Jayson Zacarias
* Christian Cardinoza
* Joshua Dichoso
* */
import java.util.Scanner;
@SuppressWarnings("ALL")
public class MobilePhone_Runner_Program {
    public static final Scanner sc = new Scanner(System.in);
    public static float load;//default: 0, cannot be negative.
    public static char network;//default: 's', possible options = ['s', 't', 'g']
    public final static float ratePerText = 1;//value is always 1
    public final static float ratePerCall = 2;//depends on network ('s' - 3, 't' - 5, 'g' - 7)

    public static float checkBal(){
        return checkBalance();
    }//returns how much balance is left
    private static float checkBalance() {
        System.out.println("Balance: "+load);
        main(null);
        return 0;
    }//returns how much balance is left
    public static void call() {
        System.out.print("What network are you using?: ");
        network = sc.next().charAt(0);
        if(network == 's'){
            System.out.print("What network you want to call to?");
            network = sc.next().charAt(0);
            if(network == 's'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 3;
                    main(null);
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 5*ratePerCall;
                    main(null);
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 7*ratePerCall;
                    main(null);
                }
            }
        }else if(network == 't'){
            System.out.print("What network you want to call to?");
            network = sc.next().charAt(0);
            if(network == 's'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 3*ratePerCall;
                    main(null);
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 5;
                    main(null);
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 7*ratePerCall;
                    main(null);
                }
            }
        }else if(network == 'g'){
            System.out.print("What network you want to call to?");
            network = sc.next().charAt(0);
            if(network == 's'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 3*ratePerCall;
                    main(null);
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 5*ratePerCall;
                    main(null);
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 7;
                    main(null);
                }
            }
        }else{
            main(null);
        }
        main(null);
    }//deducts text cost from balance, if different networks, cost is doubled
    public static void text(){
        System.out.print("What network are you using?: ");
        network = sc.next().charAt(0);
        if(network == 's'){
            System.out.print("What network you want to call to?");
            network = sc.next().charAt(0);
            if(network == 's'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText;
                    main(null);
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText+1;
                    main(null);
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText+1;
                    main(null);
                }
            }
        }else if(network == 't'){
            System.out.print("What network you want to call to?");
            network = sc.next().charAt(0);
            if(network == 's'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText+1;
                    main(null);
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText;
                    main(null);
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText+1;
                    main(null);
                }
            }
        }else if(network == 'g'){
            System.out.print("What network you want to call to?");
            network = sc.next().charAt(0);
            if(network == 's'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText+1;
                    main(null);
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText+1;
                    main(null);
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText;
                    main(null);
                }
            }
        }else{
            main(null);
        }
        main(null);
    }// deducts text cost from balance, if different networks, cost is doubled
    public static void reload() {
        System.out.println("How much you want to reload? ");
        float reload =sc.nextFloat();
        load = reload + load;
        main(null);
    }//increases the balance of the account
    public static void quit(){
        System.out.println("Are you sure? y/n");
        char usure = sc.next().charAt(0);
        if(usure == 'n'){
            main(null);
        }else if(usure == 'y'){
            System.exit(0);
        }else{
            quit();
        }
    }//Exits the Program
    public static void main(String[] args) {//main method
        System.out.println("""
                What do you want to do?
                1) Check Balance
                2) Call
                3) Text
                4) Reload
                5) Quit""");
        System.out.print("1-5: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> System.out.println("Balance: " + checkBal());
            case 2 -> call();
            case 3 -> text();
            case 4 -> reload();
            case 5 -> quit();
        }
    } //main method
}
