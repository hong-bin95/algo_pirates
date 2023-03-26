#include<bits/stdc++.h>
using namespace std;
int n,t[17],p[17], dp[17];
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>n;
	for(int i=1; i<=n; i++) cin>>t[i]>>p[i];
	int local_max=0;
	for(int i=1; i<=n; i++){
		local_max=max(local_max, dp[i]);
		if(i+t[i]<=n+1)	dp[i+t[i]]=max(dp[i+t[i]], local_max+p[i]);
	}
	cout<<*max_element(dp+1, dp+n+2);
}
