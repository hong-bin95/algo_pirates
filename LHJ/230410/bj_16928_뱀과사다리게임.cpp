#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> pii;
#define V second
#define DIST first
#define INF 987654321 
int n,m,mv[101], dist[101];
void dijkstra(){
	priority_queue<pii, vector<pii>, greater<pii>> pq;
	fill_n(dist, 101, INF);
	dist[1]=0;
	pq.push({0,1});
	while(!pq.empty()){
		auto cur = pq.top();pq.pop();
		if(cur.V==100) break;
		if(mv[cur.V]){
			int nxtV=mv[cur.V], nxtdist=cur.DIST;
			if(nxtdist<dist[nxtV]){
				dist[nxtV]=nxtdist;
				pq.push({nxtdist, nxtV});	
			}
		}else{
			for(int i=1; i<=6; i++){
				int nxtV=cur.V+i, nxtdist=cur.DIST+1;
				if(nxtV>100 || dist[nxtV]<=nxtdist) continue;
				dist[nxtV]=nxtdist;
				pq.push({nxtdist, nxtV});
			}
		}
	}
}
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>n>>m;
	for(int i=0,x,y; i<n+m; i++){
		cin>>x>>y;
		mv[x]=y;
	}
	dijkstra();
	cout<<dist[100];
}
