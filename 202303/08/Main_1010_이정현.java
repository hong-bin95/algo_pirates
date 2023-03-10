package algo_0308;

import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class Main_1010_이정현 {
    static int M, N;
    static int[][] dp=new int[31][31];
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T= Integer.parseInt(in.readLine());
        for(int tc=0;tc<T;tc++) {
            StringTokenizer st= new StringTokenizer(in.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());

            BigInteger n1 = BigInteger.ONE;
            BigInteger n2 = BigInteger.ONE;

            for(int i=0;i<N;i++){
                n1=n1.multiply(new BigInteger(String.valueOf(M-i)));
                n2=n2.multiply(new BigInteger(String.valueOf(i+1)));
            }

            BigInteger answer= n1.divide(n2);
            System.out.println(answer);


        }



    }


}
