#include<bits/stdc++.h>
using namespace std;
int T, fibcount[41][2], n;
int main(){
	scanf("%d", &T);
	fibcount[0][0]=1;
	fibcount[1][1]=1;
	for(int i=2; i<=40; i++){
		fibcount[i][0]=fibcount[i-1][0]+fibcount[i-2][0];
		fibcount[i][1]=fibcount[i-1][1]+fibcount[i-2][1];
	}
	while(T--){
		scanf("%d", &n);
		printf("%d %d\n", fibcount[n][0], fibcount[n][1]);
	}
}
