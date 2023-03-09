import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main_2407_조합 {

    static String[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new String[101][101];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(comb(N, M));
    }

    static String comb(int n, int r) {
        if(n < 0 || r < 0) return "0";
        if(dp[n][r] != "0" && dp[n][r] != null) return dp[n][r];
        if(n == r || r == 0) return dp[n][r] = "1";
        BigInteger a = new BigInteger(comb(n - 1, r - 1));
        BigInteger b = new BigInteger(comb(n - 1, r));
        return dp[n][r] = a.add(b).toString();
    }
}