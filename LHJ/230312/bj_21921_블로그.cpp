#include<bits/stdc++.h>
int n,x,blog[250000], max_sum, cnt;
int main(){
	scanf("%d %d", &n,&x);
	for(int i=0; i<n; i++) scanf("%d", &blog[i]);
	int sum=0;
	for(int i=0; i<x; i++) sum+=blog[i];
	max_sum=sum, cnt=1;
	for(int i=x; i<n; i++){
		sum+=blog[i];
		sum-=blog[i-x];
		if(sum==max_sum) cnt++;
		else if(sum>max_sum){
			max_sum=sum;
			cnt=1;
		}
	}
	if(max_sum==0) printf("SAD");
	else{
		printf("%d\n%d", max_sum, cnt);
	}
	
}
