import java.util.*;

public class bj_10973_이전순열 {
	static String[][] combination;
	static String calc(int n,int r) {
		if(combination[n][r]!=null) return combination[n][r];
		if(r==0 || n==r) return combination[n][r]="1";
		return combination[n][r] =add(calc(n-1,r-1), calc(n-1,r));
	}
	static String add(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry=0;
		if(num1.length()<num2.length()) {
			String tmp=num1;
			num1=num2;
			num2=tmp;
		}
		int long_length=num1.length();
		int short_length=num2.length();
		for(int i=1; i<=long_length; i++) {
			int digit1=digit(num1,i);
			int digit2=i>short_length? 0:digit(num2,i);
			int half_add=digit1+digit2+carry;
			carry=half_add/10;
			half_add%=10;
			sb.append(half_add);
		}
		if(carry>0) sb.append(carry);
		return sb.reverse().toString();
	}
	static int digit(String num, int idx) {
		return num.charAt(num.length()-idx)-'0';
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		combination = new String[n+1][m+1];
		System.out.println(calc(n,m));
	}

}
