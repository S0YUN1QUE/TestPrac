import java.util.Scanner;

// チェス盤のどこに駒が置かれているか
// grit : 8x8
// 左から1列目のますの名前の1文字目 = a (b, c, d, ...)
// 下から1行目のますの名前の２文字目 = 1 (2, 3, 4, ...)
// ex) a1, h1, h8
// 文字＊は一つだけ、他には全部.で表す（1列に8文字の長さ）
// コマが置かれているますの名前を出力

public class B_296 {
    public static void main(String[] args) {
        char[][] grit = new char[8][8];
        int star;
        int row = 0;
        String column = "i";
        Scanner sc = new Scanner(System.in);
        while(true) {
            star = 0;
            for(int i = 0; i < 8; i++) {
                String s = sc.nextLine();
                if(s.length() != 8) {
                    System.out.println("There must be 8 letters. Try again.");
                    star = 2;
                    break;
                } else {
                    for(int j = 0; j < 8; j++) {
                        if(s.charAt(j) != '.' && s.charAt(j) != '*') {
                            System.out.println("Only '.' or '*' can be input. Try agian.");
                            star = 2;
                            break;
                        } else if(s.charAt(j) == '*') {
                            star++;
                            if(star > 1) {
                                System.out.println("You can input '*' only once. Try again");
                                break;
                            }
                        } 
                        grit[i][j] = s.charAt(j);
                        if(grit[i][j] == '*') {
                            switch(j) {
                                case 0: column = "a";
                                        break;
                                case 1: column = "b";
                                        break;
                                case 2: column = "c";
                                        break;
                                case 3: column = "d";
                                        break;
                                case 4: column = "e";
                                        break;
                                case 5: column = "f";
                                        break;
                                case 6: column = "g";
                                        break;
                                default: column = "h";
                                         break;
                            }
                            row = 8-i;
                        }
                    }
                    if(star == 2) {
                        break;
                    }
                }
            }
            if(star == 1) {
                break;
            } else if(star == 0) {
                System.out.println("You must input one '*'. Try again.");
            }
        }
        System.out.println(column + row);
        sc.close();
    }
}