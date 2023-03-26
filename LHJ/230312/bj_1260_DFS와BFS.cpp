#include<bits/stdc++.h>
using namespace std;
vector<int> adj_list[1001];
int n,m,v, visited[1001];
void dfs(int u){
	printf("%d ", u);visited[u]=true;
	for(int w: adj_list[u]){
		if(visited[w]) continue;
		dfs(w);
	}
}
void bfs(){
	queue<int> q;
	printf("%d ", v);visited[v]=true;
	q.push(v);
	while(!q.empty()){
		int u=q.front();q.pop();
		for(int w: adj_list[u]){
			if(visited[w]) continue;
			printf("%d ", w);visited[w]=true;
			q.push(w);
		}
	}
}
int main(){
	scanf("%d %d %d",&n,&m,&v);
	int v1,v2;
	for(int i=0; i<m; i++){
		scanf("%d %d", &v1,&v2);
		adj_list[v1].push_back(v2);
		adj_list[v2].push_back(v1);
	}
	for(int i=1; i<=n; i++) sort(adj_list[i].begin(), adj_list[i].end());
	dfs(v);printf("\n");memset(visited,0x00,sizeof(visited));
	bfs();
} 
