package Paiza.Java;

import java.util.Scanner;

// 자기 웹사이트에서 선물 이벤트 기획
// 선물 -> A, B 두 종류
// 당첨 조건 -> 정수 X 배수번째 응모자는 A, 정수 Y 배수번째 응모자는 B
// 응모자 수 입력하면 당첨 정보 출력

public class c097 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        // N X Y (스페이스로 구분)
        String line = sc.nextLine();
        String[] nxy = line.split("\\s");
        int n = Integer.parseInt(nxy[0]);
        int x = Integer.parseInt(nxy[1]);
        int y = Integer.parseInt(nxy[2]);
        // N은 1 이상 1000 이하
        if(n >= 1 && n <= 1000) {
            // X, Y는 1 이상 N 이하
            if(x >= 1 && x <= n && y >= 1 && y <= n) {
                // 출력
                String result = "";
                // N행 -> 순서대로 당첨정보 출력
                for(int i = 1; i <= n; i++) {
                    // 둘다 당첨 -> AB, A만 당첨 -> A, B만 당첨 -> B, 둘다 아니면 N
                    if(x > y) {
                        if(i < y) {
                            result = "N";
                        } else if(x%y == 0) {
                            if(i <= y && i % y == 0) {
                                result = "B";
                            } else if(i > y && i % x == 0) {
                                result = "AB";
                            } else {
                                result = "N";
                            }
                        } else {
                            if(i % (x*y) == 0) {
                                result = "AB";
                            } else if(i % y == 0) {
                                result = "B";
                            } else if(i % x == 0) {
                                result = "A";
                            } else {
                                result = "N";
                            }
                        }
                    } else {
                        if(i < x) {
                            result = "N";
                        } else if(x == y) {
                            if(i % x == 0) {
                                result = "AB";
                            } else {
                                result = "N";
                            }
                        } else if(y%x == 0) {
                            if(i <= x && i % x == 0) {
                                result = "A";
                            } else if(i > x && i % y == 0) {
                                result = "AB";
                            } else {
                                result = "N";
                            }
                        } else {
                            if(i % (x*y) == 0) {
                                result = "AB";
                            } else if(i % y == 0) {
                                result = "B";
                            } else if(i % x == 0) {
                                result = "A";
                            } else {
                                result = "N";
                            }
                        }
                    }
                    System.out.println(result);
                    result = "";
                }
            }
        } 
        
    }
}
