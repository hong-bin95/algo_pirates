#include<iostream>
using namespace std;
int n,m,N[10000], ret;
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>n>>m;
	for(int i=0; i<n; i++) cin>>N[i];
	for(int i1=0, i2=1, sum=N[0];i2<=n;){
		if(sum==m) ret++;
		if(sum<=m) sum+=N[i2++];
		else if(sum>m) sum-=N[i1++];
		
	}
	cout<<ret;
}
