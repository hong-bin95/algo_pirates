#include<bits/stdc++.h>
using namespace std;
int v,e,visited[101],cnt;
vector<int> adj_list[101];
void dfs(int v){
	cnt++;
	visited[v]=true;
	for(int u: adj_list[v]){
		if(visited[u]) continue;
		dfs(u);
	}
}
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>v>>e;
	for(int i=0,v1,v2; i<e; i++){
		cin>>v1>>v2;
		adj_list[v1].push_back(v2);
		adj_list[v2].push_back(v1);
	}
	dfs(1);
	cout<<cnt-1;
}
