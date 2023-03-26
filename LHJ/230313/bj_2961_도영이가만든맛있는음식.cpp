#include<bits/stdc++.h>
using namespace std;
int n,s[10],b[10], check, ret=1000000000;//재료: 0~n-1, 비트: 1<<0 ~ 1<<n-1  
void bt(int k){ //k번째 비트 구경하기 
	if(k==n){
		if(!check) return;
		int svalue=1,bvalue=0;
		for(int i=0; i<n; i++){
			if(check&(1<<i)){
				svalue*=s[i];
				bvalue+=b[i];
			}
		}
		ret=min(ret,abs(svalue-bvalue));
		return;
	}
	bt(k+1);
	check|=(1<<k);
	bt(k+1);
	check&=~(1<<k);
}
int main(){
	scanf("%d", &n);
	for(int i=0; i<n; i++) scanf("%d %d", &s[i], &b[i]);
	bt(0);
	printf("%d", ret);
}
