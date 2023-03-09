import java.io.*;
import java.util.*;

public class Main_10974_모든순열 {
    static int[] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }

        do {
            for(int i = 0; i < N; i++) {
                sb.append(numbers[i] + " ");
            }
            sb.append("\n");
        } while(np(numbers));

        System.out.println(sb.toString());
    }

    static boolean np(int[] numbers) {
        int N = numbers.length;
        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i]) --i;
        if(i == 0) return false;
        int j = N - 1;
        while (numbers[i - 1] >= numbers[j]) --j;
        swap(numbers, i - 1, j);
        int k = N - 1;
        while(i < k) swap(numbers, i++, k--);
        return true;
    }

    static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
