import java.util.Scanner;

// w칸*h칸의 grit으로 된 공간
// 그릿 밖으로 나가면 탈출
// 몇 개의 칸에는 큰 기둥이 있음 -> 뚫고 지나갈 수 없음
// 기둥에 부딪히지 않고 나갈 수 있는지 판정

public class a055 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        // 그릿의 가로, 세로 길이(스페이스로 구분)
        String line = sc.nextLine();
        String[] wh = line.split("\\s");
        int h = Integer.parseInt(wh[0]);
        int w = Integer.parseInt(wh[1]);
        // H, W는 1 이상 100 이하
        if(w >= 1 && w <= 100 && h >= 1 && h <= 100) {
            char[][] s_i = new char[h][w];
            int count = 0;
            // H행의 i(1이상 H이하)번째행에는 반각기호 '#', '.', 혹은 반각기호 S 길이의 W문자열 S_i 전달
            // s_i의 J(1 이상 W 이하)번째 문자는 i행J열 그릿의 상태를 나타냄
            // '#'는 기둥, '.'는 다닐 수 있는 길, 'S'는 최초 위치
            for(int i = 0; i < h; i++) {
                line = sc.nextLine();
                if(line.length() == w) {
                    for(int j = 0; j < w; j++) {
                        if(line.charAt(j) == '#' || line.charAt(j) == '.' || line.charAt(j) == 'S') {
                            s_i[i][j] = line.charAt(j);
                            if(s_i[i][j] == 'S') {
                                count++;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                if(count > 1) {
                    break;
                }
            }
            // s_{i, j}는 '#', '.', 'S', s_{i,j} = 'S'(S는 하나만)
            if(count == 1) {
                int move = 0;
                int s_count = 0;
                int si = 0;
                int sj = 0;
                char temp = '*';
                for(int i = 0; i < h; i++) {
                    for(int j = 0; j < w; j++) {
                        if(s_i[i][j] == 'S') {
                            si = i;
                            sj = j;
                            break;
                        }
                    }
                }
                while(true) {
                    if(sj+1 < w && s_i[si][sj+1] == '.') {
                        move++;
                        sj += 1;
                        s_i[si][sj] = temp;
                    } else if(si-1 >= 0 && s_i[si-1][sj] == '.') {
                        move++;
                        si -= 1;
                        s_i[si][sj] = temp;
                    } else if(sj-1 >= 0 && s_i[si][sj-1] == '.') {
                        move++;
                        sj -= 1;
                        s_i[si][sj] = temp;
                    } else if(si+1 < h && s_i[si+1][sj] == '.') {
                        move++;
                        si += 1;
                        s_i[si][sj] = temp;
                    } else {
                        // 출력
                        // 탈촐 가능 -> YES / 불가능 -> NO
                        if(move == 0) {
                            System.out.println("NO" );
                            break;
                        } else if(sj == w-1 || sj == 0 || si == h-1 || si == 0) {
                            System.out.println("YES");
                            break;
                        } else {
                            System.out.println("NO");
                            break;
                        }
                    }
                }
            }
        }

    }
}