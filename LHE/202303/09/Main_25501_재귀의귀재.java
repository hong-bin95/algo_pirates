import java.io.*;
import java.util.*;

public class Main_25501_재귀의귀재 {

    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            cnt = 0;
            sb.append(isPalindrome(str) + " " + cnt + "\n");
        }

        System.out.println(sb.toString());
    }

    static int recursion(String str, int l, int r) {
        cnt++;
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else return recursion(str, l + 1, r - 1);
    }

    static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }
}
