import java.util.Random;
import java.util.Scanner;
public class UnfairDie extends CustomDie {
    public static int rn;
    public static void Equal_CD(){
        if(CustomDie.nF != null){
            int rnd = new Random().nextInt(CustomDie.nF.length);
            System.out.println("Unfair Die roll: "+nF[rnd]);
        }else{
            System.out.println("The Die has Empty Faces");
        }
        System.out.println();
        System.out.println();
        Die_Runner.main(null);
    }
    public static void Custom_CD(){
        Scanner sc = new Scanner(System.in);
        if((CustomDie.nF != null)){
            System.out.println("Enter Probability for all faces: ");
            rn = sc.nextInt();
            int rnd = new Random(rn).nextInt(CustomDie.nF.length);
            System.out.println("Unfair Die roll: "+nF[rnd]);
            System.out.println();
        }else{
            System.out.println("The Die has Empty Faces");
            System.out.println();
            Die_Runner.main(null);
        }
        System.out.println();
        Die_Runner.main(null);
    }
}