package Paiza.Java;

import java.util.*;

public class a066 {
    public static void main(String[] args) {
        // N개의 일, A_i일~B_i일까지 걸림
        // 최대 며칠까지 연속 출근?
        // 예) 일1은 1일~4일, 2는 5~7일 -> 1일~7일(총 7일)
        
        // 입력
        Scanner sc = new Scanner(System.in);
        // 일의 수 N (1 이상 10000 이하)
        String line = sc.nextLine();
        int n = Integer.parseInt(line);
        if(n >= 1 && n <= 10000) {
            // 일 i가 시작되는 일 A_i, 끝나는 B_i (I는 1이상 N 이하 / A_i, B_i는 1 이상 100000 이하)
            String[] abArr = new String[2];
            int[] A_i = new int[n];
            int[] B_i = new int[n];
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                line = sc.nextLine();
                abArr = line.split("\\s");
                if(Integer.parseInt(abArr[0]) >= 1 && Integer.parseInt(abArr[1]) >= 1 && Integer.parseInt(abArr[0]) <= 100000 && Integer.parseInt(abArr[1]) <= 100000) {
                    A_i[i] = Integer.parseInt(abArr[0]);
                    B_i[i] = Integer.parseInt(abArr[1]);
                    for(int j = A_i[i]; j <= B_i[i]; j++) {
                        temp.add(j);
                    }
                } else {
                    break;
                }
            }
            // 출력
            // 최대 연속출근일
            Set<Integer> resultSet = new HashSet<Integer>(temp);
            temp = new ArrayList<Integer>(resultSet);
            Collections.sort(temp);
            int count = 0;
            int maxCount = 0;
            for(int i = 0; i < temp.size(); i++) {
                count++;
                if(i != temp.size()-1 && temp.get(i) + 1 != temp.get(i+1)) {
                    if(count > maxCount) {
                        maxCount = count;
                    }
                    count = 0;
                } else if(i == temp.size()-1 && temp.get(i)-1 != temp.get(i-1)) {
                    count--;
                }
            }
            if(count == temp.size()) {
                System.out.println(temp.size());
            } else if(maxCount > count) {
                System.out.println(maxCount);
            } else {
                System.out.println(count);
            }
        }
    }
}
