#include<bits/stdc++.h>
using namespace std;
int n,m,r,u,v,dist[100001], cnt;
vector<int> adj_list[100001];
void bfs(){
	queue<int> q;
	dist[r]=++cnt;
	q.push(r);
	while(!q.empty()){
		int v=q.front();q.pop();
		for(int u: adj_list[v]){
			if(dist[u]) continue;
			dist[u]=++cnt;
			q.push(u);
		}
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
	bfs();
	for(int i=1; i<=n; i++) printf("%d\n", dist[i]);
}
