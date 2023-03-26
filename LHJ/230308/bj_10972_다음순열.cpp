#include<bits/stdc++.h>
using namespace std;
int n,num[10000];
bool next_permutation(){
	for(int i=n-2; i>=0; i--){
		if(num[i]<num[i+1]){
			int max_idx=n; //num[i]보다 큰 가장 작은 수 
			while(num[--max_idx]<num[i]);
			
			int tmp=num[i];
			num[i]=num[max_idx];
			num[max_idx]=tmp; 
			sort(num+i+1,num+n);
			return true;
		}
	}
	return false;
}
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>n;
	for(int i=0; i<n; i++) cin>>num[i];
	bool ret=next_permutation();
	if(ret){
		for(int i=0; i<n; i++) cout<<num[i]<<' ';
	}
	else cout<<-1;
}
