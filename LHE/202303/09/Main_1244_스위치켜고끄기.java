import java.io.*;
import java.util.*;

public class Main_1244_스위치켜고끄기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int numOfSwitch = Integer.parseInt(br.readLine());
        int[] switchStatus = new int[numOfSwitch + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= numOfSwitch; i++)
            switchStatus[i] = Integer.parseInt(st.nextToken());

        int numOfPerson = Integer.parseInt(br.readLine());
        for(int i = 0; i < numOfPerson; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int pick = Integer.parseInt(st.nextToken());

            if(gender == 1) {
                for(int j = pick; j <= numOfSwitch; j++) {
                    if (j % pick == 0) switchStatus[j] = switchStatus[j] == 1 ? 0 : 1;
                }
            } else {
                if(pick == 1 || pick == numOfSwitch) {
                    switchStatus[pick] = switchStatus[pick] == 1 ? 0 : 1;
                } else {
                    for(int j = 0; j < numOfSwitch; j++) {
                        if(pick - j >= 1 && pick + j <= numOfSwitch) {
                            if(switchStatus[pick - j] != switchStatus[pick + j]) break;
                            switchStatus[pick - j] = switchStatus[pick + j] = switchStatus[pick - j] == 1 ? 0 : 1;
                        } else break;
                    }
                }
            }
        }

        for(int i = 1; i <= numOfSwitch; i++) {
            sb.append(switchStatus[i]).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
