package Paiza.Java;

import java.util.Scanner;

// 친구에게 메일 보냄 -> 문자열 꾸며서
// '+'으로 이루어진 프레임에 둘러싸인 문자열 

public class c084 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        // 문자열 S(영문) -> 길이는 1 이상 100 이하
        String line = sc.nextLine();
        if(line.matches("^[a-zA-Z]*$") && line.length() >= 1 && line.length() <= 100) {
            // 출력
            String result = "";
            for(int i = 0; i < line.length()+2; i++) {
                result += "+";
            }
            // 문자열 감싼 결과
            System.out.println(result);
            System.out.println("+" + line + "+");
            System.out.println(result);
        }

    }
}