#include<bits/stdc++.h>
using namespace std;
vector<int> adj_list[100001];
int n,m,r, order[100001], u,v, cnt;
void dfs(int v){
	order[v]=++cnt;
	for(int u: adj_list[v]){
		if(order[u]) continue;
		dfs(u);
	}
}
int main(){
	scanf("%d %d %d",&n,&m,&r);
	for(int i=0; i<m; i++){
		scanf("%d %d", &u,&v);
		adj_list[u].push_back(v);
		adj_list[v].push_back(u);
	}
	for(int i=1; i<=n; i++) sort(adj_list[i].begin(), adj_list[i].end(), greater<int>());
	dfs(r);
	for(int i=1; i<=n; i++) printf("%d\n", order[i]);
} 
