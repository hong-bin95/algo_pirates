package algo_0309;

import java.io.*;
import java.util.*;
public class Main_25501_이정현 {
    static int call;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(in.readLine());

        for(int tc=0;tc<T;tc++){
            String s= in.readLine();
            call=0;
            int isPalindrome =recursion(s,0,s.length()-1);
            System.out.println(isPalindrome+" "+call);
        }
    }

    static int recursion(String s,int l, int r){
        call++;
        if(l>=r) return 1;
        else if(s.charAt(l)!=s.charAt(r)) return 0;
        else return recursion(s,l+1,r-1);
    }
}
