#include<bits/stdc++.h>
using namespace std;
typedef tuple<int,int,int> tiii;
queue<tiii> q;
int n,m,board[1000][1000], cnt, dy[]={1,-1,0,0}, dx[]={0,0,1,-1};
int bfs(){
	if(cnt==0) return 0;
	while(!q.empty()){
		int curY,curX,curDay;
		tie(curY,curX,curDay)=q.front();q.pop();
		for(int i=0; i<4; i++){
			int nxtY=curY+dy[i], nxtX=curX+dx[i];
			if(nxtY<0 || nxtY>=n || nxtX<0 || nxtX>=m || board[nxtY][nxtX]!=0) continue;
			board[nxtY][nxtX]=1;
			if(--cnt==0) return curDay+1;
			q.push({nxtY,nxtX,curDay+1});
		}
	}
	return -1;
}
int main(){
	scanf("%d %d", &m,&n);
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			scanf("%d", &board[i][j]);
			if(board[i][j]==1) q.push({i,j,0});
			else if(board[i][j]==0) cnt++;
		}
	}
	printf("%d", bfs());
} 
