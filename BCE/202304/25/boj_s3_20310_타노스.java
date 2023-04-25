package a20230424;

import java.io.*;

public class boj_s3_20310_타노스 {

	static int zero, one, len;
	static int[] S;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		len = str.length();
		S = new int[len];
		for (int i = 0; i < len; i++) {
			S[i] = str.charAt(i)-'0';
			if(S[i] == 0) {
				zero++;
			}
		}
		one = len-zero;
		br.close();
		makeHalf();
		System.out.println(makeString());
	}
	
	public static void makeHalf() {
		int cnt = 0;
		zero /= 2;
		for (int i = len-1; i > 0; i--) { // 0은 오른쪽부터 삭제
			if(cnt == zero) {
				break;
			}
			if(S[i] == 0) {
				cnt++;
				S[i] = -1;
			}
		}
		cnt = 0;
		one /= 2;
		for (int i = 0; i < len; i++) { // 1은 왼쪽부터 삭제
			if(cnt == one) {
				break;
			}
			if(S[i] == 1) {
				cnt++;
				S[i] = -1;
			}
		}
	}
	
	public static String makeString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if(S[i] != -1) {
				sb.append(S[i]);
			}
		}
		return sb.toString();
	}

}