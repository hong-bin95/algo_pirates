#include<bits/stdc++.h>
using namespace std;
int n,m,r,u,v,dist[100001], cnt;
vector<int> adj_list[100001];
void dfs(int v){
	dist[v]=++cnt;
	for(int u: adj_list[v]){
		if(dist[u]) continue;
		dfs(u);
	}
}
int main(){
	scanf("%d %d %d", &n,&m,&r);
	for(int i=0; i<m; i++){
		scanf("%d %d", &u,&v);
		adj_list[u].push_back(v);
		adj_list[v].push_back(u);
	}
	for(int i=1; i<=n; i++) sort(adj_list[i].begin(), adj_list[i].end());
	dfs(r);
	for(int i=1; i<=n; i++) printf("%d\n", dist[i]);
}
