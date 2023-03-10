package algo_0309;
import java.util.*;
import java.io.*;
public class Main_10974_이정현 {
    static int N;
    static int[] tmp;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(in.readLine());

        tmp = new int[N];
        v= new boolean[N+1];
        perm(0);
        System.out.println(sb);
    }

    static void perm(int depth){
        if(depth==N){
            for(int i=0;i<N;i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            if(!v[i]){
                v[i]=true;
                tmp[depth]=i;
                perm(depth+1);
                v[i]=false;
            }
        }
    }
}
