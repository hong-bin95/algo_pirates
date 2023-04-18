import java.util.*;
import java.io.*;

public class Main_bj11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int k = K;

        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i = N-1; i >= 0 ; i--){
            if(k >= arr[i]){
                count += k / arr[i];
//                System.out.println("k / arr[i] : " + k / arr[i]);
                k -= (k / arr[i]) * arr[i];
            }

            if(k == 0){
                break;
            }
        }

        System.out.println(count);

    }
}