package paiza;

import java.util.ArrayList;

// 놀이동산 관람차 가동상태 확인 프로그램 구현
// 관람차 -> N개의 곤돌라(1~N번) -> i번에는 A_i명 탑승 가능
// 반시계방향
// M개 그룹이 관람차 대기 -> 선두부터 i번째 그룹은 B_i명 있음
// - 선두그룹부터 순서대로 탑승
// - 그룹 전원이 현재 곤돌라에 탑승 가능하면 전원 탑승
// - 그룹 전원이 탑승 불가능하면 가능한 사람만 탑승, 남은 사람은 다음
// - 곤돌라는 순서대로 탑승
// - 다른 그룹이 함께 타는 경우 없음
// - 곤돌라는 한 바퀴 돌면 돌아옴, 돌아오면 모두 하차
// 개장 시점에는 1부터 대기

import java.util.Scanner;

public class b108 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        // 곤돌라 수 n, 그룹 수 m(스페이스로 구분) (1 이상 30 이하)
        String line = sc.nextLine();
        String[] nm = line.split("\\s");
        boolean aBool = true;
        if(nm.length == 2) {
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            if(n >= 1 && m >= 1 && n <= 30 && m <= 30) {
                // i번째 곤돌라에 승차 가능한 인원 A_i (1 이상 n 이하)
                int a = 0;
                int[] A_i = new int[n];
                for(int i = 0; i < n; i++) {
                    a = sc.nextInt();
                    if(a < 0 || a > 100) {
                        aBool = false;
                        break;
                    } else {
                        A_i[i] = a;
                    }
                }
                if(aBool == true) {
                    // i번째 그룹 인원수 B_i (1 이상 m 이하)
                    int b = 0; 
                    int[] B_i = new int[m];
                    for(int i = 0; i < m; i++) {
                        b = sc.nextInt();
                        if(b < 0 || b > 100) {
                            break;
                        } else {
                            B_i[i] = b;
                        }
                    }
                    // 출력
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    int nCount = 0;
                    int mCount = 0;
                    while(mCount < m) {
                        if(nCount >= n) {
                            nCount -= n;
                        }
                        if(A_i[nCount] < B_i[mCount]) {
                            int temp = B_i[mCount];
                            while(temp > 0) {
                                if(A_i[nCount] > temp) {
                                    result.add(temp);
                                    temp = 0;
                                } else {
                                    result.add(A_i[nCount]);
                                    temp -= A_i[nCount];
                                }
                                nCount++;
                                if(nCount >= n) {
                                    nCount -= n;
                                }
                            }
                            mCount++;
                        } else {
                            result.add(B_i[mCount]);
                            nCount++;
                            mCount++;
                        }
                    }
                    // 각 곤돌라에 탄 인원 수 총합
                    int[] resultArr = new int[n];
                    if(result.size() <= n) {
                        for(int i = 0; i < result.size(); i++) {
                            resultArr[i] = result.get(i);
                        }
                    }
                    for(int i = 0; i < result.size()/n; i++) {
                        for(int j = 0; j < n; j++) {
                                resultArr[j] += result.get((n*i)+j);
                            }
                            if(i == ((result.size()/n)-1) && (result.size()%n) != 0) {
                                for(int k = 0; k < result.size()%n; k++) {
                                    resultArr[k] += result.get((result.size())-((result.size()%n)-k));
                                }
                            }
                    }
                    for(int i = 0; i < resultArr.length; i++) {
                        System.out.println(resultArr[i]);
                    }
                }
            }
        }
    }
}

// [4, 5, 4, 5, 
// 2, 1, 4, 1, 
// 4, 3, 1, 2, 
// 1]

// 9 -> 4, 2, 3
// 3 -> 2, / 1
// 5 -> 2, 3
// 7 -> 2, / 4, 1
// 1 -> 1
// 3 -> 2, / 1