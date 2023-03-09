import java.io.*;
import java.util.*;

public class Main_25176_청정수열 {

    static int N;
    static int[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = new int[N];

        for(int i = 1; i <= N; i++) {
            input[i - 1] = i;
        }

        int answer = 0;

        do {
            answer++;
        } while (np(input));

        System.out.println(answer);
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
        while (i < k) swap(numbers, i++, k--);
        return true;
    }

    static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
