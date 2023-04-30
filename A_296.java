import java.util.Scanner;

public class A_296 {
    public static void main(String[] args) {
        String result ="Yes";
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while(count < 2) {
            int n = sc.nextInt();
            if(n >= 1 && n <= 100) {
                while(count == 0) {
                    String s = sc.next();
                    if(s.length() == n) {
                        char[] sArr = s.toCharArray();
                        for(int i = 0; i < n; i++) {
                            if(sArr[i] != 'F' && sArr[i] != 'M') {
                                System.out.println("Only F or M can be in S");
                                count = 1;
                                break;
                            } else {
                                if(i != 0 && sArr[i] == sArr[i-1]) {
                                    result = "No";
                                    System.out.println(result);
                                    count = 1;
                                    break;
                                } else {
                                    count = 0;
                                }
                            }
                        }
                        if(count == 0 && result.equals("Yes")) {
                            System.out.println(result);
                            count = 2;
                        }
                    } else {
                        System.out.println("The length of S must be the same as N");
                    }
                }
                break;
            } else {
                System.out.println("N must be an integer which is smaller than 101 or larger than 0");
            }
        }
        sc.close();
    }
}