#include<bits/stdc++.h>
using namespace std;
int n, num[8], used[9];
void bt(int k){
	if(k==n){
		for(int i=0; i<n; i++) cout<<num[i]<<' ';
		cout<<'\n';
		return;
	}
	for(int i=1; i<=n; i++){
		if(used[i]) continue;
		used[i]=true;
		num[k]=i;
		bt(k+1);
		used[i]=false;
	}
	
}
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>n;
	bt(0);
}
