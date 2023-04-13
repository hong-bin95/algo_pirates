#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> pii;
#define DIST first
#define X second
#define INF 987654321
int n,k, dist[100001];
void bfs(){
	queue<pii> q;
	fill_n(dist, 100001, INF);
	dist[n]=0; 
	q.push({0,n});
	while(!q.empty()){
		auto cur=q.front();q.pop();
		int curX=cur.X, curdist=cur.DIST;
		if(curX==k) return;
		if(curX*2<=100000){ //*2를 먼저 넣으면 큐에 들어간 순서가 시간순이 되어서 pq를안쓸수있다.
			dist[curX*2]=curdist;
			q.push({curdist, curX*2});
		}
		if(curX-1>=0&& curdist+1<dist[curX-1]){
			dist[curX-1]=curdist+1;
			q.push({curdist+1, curX-1});
		}
		if(curX+1<=100000&& curdist+1<dist[curX+1]){
			dist[curX+1]=curdist+1;
			q.push({curdist+1, curX+1});
		}
	}
}
int main(){
	scanf("%d %d", &n,&k);
	bfs();
	printf("%d", dist[k]);
} 
