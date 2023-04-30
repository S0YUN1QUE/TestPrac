import java.util.Scanner;

public class d242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if(x >= 0 && x <= 5000000) {
            int y = sc.nextInt();
            if(y >= 0 && x <= 5000000) {
                int z = sc.nextInt();
                if(z >= 0 && z <= 5000000 && z <= x+y) {
                    System.out.println(x+y-z);
                }
            }
        }
    }
}
