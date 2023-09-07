import java.util.Scanner;
public class MobilePhone_Constructors {
    public static final Scanner sc = new Scanner(System.in);
    public static float load;//default: 0, cannot be negative.
    public static char network;//default: 's', possible options = ['s', 't', 'g']
    public final static float ratePerText = 1;//value is always 1
    public final static float ratePerCall = 2;//depends on network ('s' - 3, 't' - 5, 'g' - 7)

    public static void checkBalance() {
        System.out.println("Balance: " + load);
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
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 5*ratePerCall;
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 7*ratePerCall;
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
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 5;
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 7*ratePerCall;
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
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 5*ratePerCall;
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= 7;
                }
            }
        }
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
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText+1;
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText+1;
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
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText;
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText+1;
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
                }
            }
            if(network == 't'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText+1;
                }
            }
            if(network == 'g'){
                if(load == 0){
                    System.out.println("No load or Not Enough Load");
                }else{
                    load -= ratePerText;
                }
            }
        }
    }// deducts text cost from balance, if different networks, cost is doubled
    public static void reload() {
        System.out.println("How much you want to reload? ");
        float reload =sc.nextFloat();
        load = reload + load;
    }//increases the balance of the account
    public static void main(String[] args) {
        System.out.println("""
                What do you want to do?
                1) Check Balance
                2) Call
                3) Text
                4) Reload""");
        System.out.print("1-4: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> checkBalance();
            case 2 -> call();
            case 3 -> text();
            case 4 -> reload();
        }
    } //main method
}
