package algo_0308;

import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class Main_2407_이정현 {
    static int n, m;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        cnt=0;
        //depth, start
//        comb(0,0);

        BigInteger n1=BigInteger.ONE;
        BigInteger n2=BigInteger.ONE;


        //nCr = n! / (n-r)! * r!
        for(int i=0;i<m;i++){
            //Strig.valueOf() => (int, dobule, boolean) 등의 자료형을 String객체로 만든다.
            n1=n1.multiply(new BigInteger(String.valueOf(n-i)));
            n2=n2.multiply(new BigInteger(String.valueOf(i+1)));
        }

        //n1 => n에서 n-m까지의 곱 (분모)
        //n2 => m에서 1까지의 곱   (분자)


        BigInteger answer =n1.divide(n2);

        System.out.println(answer);
//        System.out.println(cnt);
    }

//    static void comb(int depth, int start){
//        if(depth==m){
//            cnt++;
//            return;
//        }
//
//        for(int i=start;i<n;i++){
//            comb(depth+1, i+1);
//        }
//
//
//    }

}
