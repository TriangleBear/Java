import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class CustomDie{
    public static int n;
    public static String[] nF;
    public static void customFace(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter how many Faces: ");
        n=sc.nextInt();
        nF = new String[n];
        for (int i =0;i<n;i++){
            System.out.print("Enter the Face "+(i+1)+": ");
            nF[i]=sc.next();
        }
        System.out.println("You entered this Faces:");
        for (int i=0;i<n;i++){
            System.out.println("Face "+(i+1)+": "+nF[i]);
        }
        System.out.println();
        Die_Runner.main(null);
    }
    public static void addFace(){
        Scanner sc=new Scanner(System.in);
        if(nF!=null){
            System.out.println("Current Die Faces: "+Arrays.toString(nF));
            int sizenF = nF.length;
            String newFace = sc.next();
            String[] newList = new String[sizenF+1];
            System.arraycopy(nF, 0, newList, 0, nF.length);
            newList[newList.length-1]=newFace;
            nF = newList;
            System.out.println("New Die Face: " + Arrays.toString(nF));
            System.out.println();
        }else{
            System.out.println("The Die has Empty Faces");
        }
        Die_Runner.main(null);
    }
    public static void removeFace(){
        Scanner sc=new Scanner(System.in);
        if(nF!=null){
            System.out.println("Current Die Faces");
            System.out.println(Arrays.toString(nF));
            ArrayList<String> str = new ArrayList<>(List.of(nF));
            System.out.print("What face do you want to remove(n): ");
            int pos=sc.nextInt();
            if((pos > str.size())||(pos<1)){
                System.out.println("Out of Bounce");
                removeFace();
            }else{
                str.remove(pos-1);
                System.out.println("New Faces: \n"+str);
                System.out.println();
            }
        }else{
            System.out.println("The Die has Empty Faces");
        }
        Die_Runner.main(null);
    }
}
