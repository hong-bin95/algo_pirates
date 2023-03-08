#include<bits/stdc++.h>
using namespace std;
int n,m,combination[31][31];
int calc(int n,int r){
	if(combination[n][r]>0) return combination[n][r];
	if(r==0 || n==r) return combination[n][r]=1;
	return combination[n][r] =calc(n-1,r-1)+calc(n-1,r);
}
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	int T;
	cin>>T;
	while(T--){
		cin>>n>>m;
		cout<<calc(m,n)<<'\n';
	}
}
