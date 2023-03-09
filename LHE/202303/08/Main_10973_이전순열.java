import java.io.*;
import java.util.*;

public class Main_10973_이전순열 {
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        boolean boolAns = revNP(input);

        if(boolAns == false)
            System.out.println(-1);
        else {
            for(int i = 0; i < N; i++) {
                System.out.print(input[i] + " ");
            }
        }
    }

    static boolean revNP(int[] numbers) {
        int N = numbers.length;
        int i = N - 1;
        while (i > 0 && numbers[i - 1] <= numbers[i]) --i;
        if(i == 0) return false;
        int j = N - 1;
        while (numbers[i - 1] <= numbers[j]) --j;
        swap(numbers, i - 1, j);
        int k = N - 1;
        while (i < k) swap(numbers, i++, k--);
        return true;
    }

    static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}

