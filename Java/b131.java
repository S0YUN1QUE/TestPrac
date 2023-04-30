package Paiza.Java;
import java.util.*;

public class b131 {
    public static void main(String[] args) {
        // 전철 N개 노선, m개 역
        // i번째(1<=i<=n) 노선의 J번째(1<=j<=m) 역까지 이동하면 a{i, j}엔
        // k번째(1<=k<=j) 역에서 j번째 역까지 a{i, j}와 a{i, k}의 차액만큼(j에서 k까지도 동일)
        // 지정된 루트로 전철을 사용해 목적지까지 갈 때 얼마 나오는지
        // 스타트 지점은 1번째 노선의 1번째 역, 현지점은 j번째 역 -> 0엔으로 이동 불가
        // 목적지가 i번째 노선 역이면 i번째 노선 이용
        // 같은 역 번호에서는 환승(0엔)

        // 입력
        // 1행은 노선 수 n, 역 수 m이 반각 스페이스를 사이에 두고 입력
        // 1+i행은 i번째 노선에 대해 1번째 역에서 J번째 역까지 이동하는 데 얼마나 걸리는지 표시(A_{i, j} -> 반각 스페이스로 끊기
        // 1+n+1행은 골까지 경유하는 모든 역 수 x
        // 2+N+i행은 i번째로 경유하는 모든 역 수 R_i, S_i -> 현지점부터 R_i번째 노선의 S_i번째 역까지
        // 총 2+N+x행 최종행에 개행 한번

        // n, m, A_{i, j}는 1 이상 100이하
        // A_{i, j}는 A_{i, j+1} 이하
        // x는 1 이상 n*m-1 이하
        // R_k는 1 이상 n 이하
        // S_k는 1이상 M 이하
        // K는 1 이상 x 이하

        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            if(line.length() < 3 || line.length() > 7) {
                break;
            } else {
                String[] nm = line.split("\\s");
                int n = Integer.parseInt(nm[0]);
                int m = Integer.parseInt(nm[1]);
                if(n >= 1 && n <= 100 && m >= 1 && m <= 100) {
                    int[][] A_ = new int[n][m];
                    for(int i = 0; i < n; i++) {
                        line = sc.nextLine();
                        nm = line.split("\\s");
                        if(nm.length != m) {
                            break;
                        } else {
                            for (int j = 0; j < m; j++) {
                                A_[i][j] = Integer.parseInt(nm[j]);
                            }
                        }
                    }
                    line = sc.nextLine();
                    int x = Integer.parseInt(line);
                    if(x >= 1 && x <= (n*m-1)) {
                        int[] R_ = new int[x];
                        int[] S_ = new int[x];
                        for (int i = 0; i < x; i++) {
                            line = sc.nextLine();
                            nm = line.split("\\s");
                            if(line.length() < 3 || line.length() > 7) {
                                break;
                            } else {
                                R_[i] = Integer.parseInt(nm[0]);
                                S_[i] = Integer.parseInt(nm[1]);
                                if(R_[i] < 1 || R_[i] > n || S_[i] < 1 || S_[i] > m) {
                                    break;
                                }
                            }
                        }

                        int result = 0;
                        for(int i = 0; i < x; i++) {
                            if(i == 0) {
                                result += A_[R_[i]-1][S_[i]-1];
                                System.out.println(result);
                            } else if(S_[i] == S_[i-1]) {
                                result += 0;
                                System.out.println(result);
                            } else if(S_[i] < S_[i-1]) {
                                result += (A_[R_[i]-1][S_[i-1]-1] - A_[R_[i]-1][S_[i]-1]);
                                System.out.println(result);
                            } else {
                                result += (A_[R_[i]-1][S_[i]-1] - A_[R_[i]-1][S_[i-1]-1]);
                                System.out.println(result);
                            }
                        }
                        System.out.println(result);
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}