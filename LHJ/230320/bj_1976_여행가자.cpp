#include<bits/stdc++.h>
using namespace std;
int p[1001],n,m;
int find(int a){
	if(a==p[a]) return a;
	return p[a]=find(p[a]);
}
int unionfun(int a,int b){
	a=find(a),b=find(b);
	if(a==b) return false;
	else{
		p[a]=find(b);
		return true;
	}
}
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>n;
	for(int i=1; i<=n; i++) p[i]=i;
	cin>>m;
	for(int i=1; i<=n; i++){
		for(int j=1; j<=n; j++){
			int conn;
			cin>>conn;
			if(conn) unionfun(i,j);
		}
	}
	int a;
	string ret="YES";
	cin>>a;
	for(int i=1; i<m; i++){
		int b;
		cin>>b;
		if(unionfun(a,b)) ret="NO";
	}
	cout<<ret;
}

