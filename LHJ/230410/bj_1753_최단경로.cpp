#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> pii;
#define DIST first
#define V second
#define INF 987654321
vector<pii> adj_list[20001];
int v,e,k,dist[20001];
void dijkstra(){
	priority_queue<pii,vector<pii>,greater<pii>> pq;
	fill_n(dist, v+1, INF); 
	dist[k]=0;
	pq.push({dist[k], k});
	while(!pq.empty()){
		auto cur=pq.top();pq.pop();
		if(dist[cur.V]<cur.DIST) continue;
		for(auto edge: adj_list[cur.V]){
			int nxtV=edge.V, nxtdist=dist[cur.V]+edge.DIST;
			if(nxtdist<dist[nxtV]){
				dist[nxtV]=nxtdist;
				pq.push({dist[nxtV], nxtV});
			}
		}
	}
}
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>v>>e>>k;
	for(int i=0,a,b,w; i<e; i++){
		cin>>a>>b>>w;
		adj_list[a].push_back({w,b});
	}
	dijkstra();
	for(int i=1; i<=v; i++){
		if(dist[i]==INF) cout<<"INF\n";
		else cout<<dist[i]<<'\n';
	}
}
