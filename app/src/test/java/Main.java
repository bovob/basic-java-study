import java.util.Scanner;
import org.apache.poi.ss.formula.atp.Switch;

public class Main {

    public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);

       int rank;

       rank = scan.nextInt();

        switch(rank) {
            case 100 :
            case 90: System.out.println("A");
                break;
            case 80 : System.out.println("B");
                break;
            case 70 : System.out.println("B");
                break;

        }
    }

}
