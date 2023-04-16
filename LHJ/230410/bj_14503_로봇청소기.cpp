#include<bits/stdc++.h>
using namespace std; //0,n-1,m-1: 모두 벽, 1:벽, 2:청소한 칸 
typedef pair<int,int> pii;
#define Y first
#define X second
int n,m,board[50][50],sy,sx,d,dy[]={-1,0,1,0}, dx[]={0,1,0,-1}, cnt; 
void bfs(){
	queue<pii> q;
	//청소하지 않고 방문만 한다 
	q.push({sy,sx});
	while(!q.empty()){
		auto cur=q.front();q.pop();
		int curY=cur.Y, curX=cur.X;
		//1. 현재 칸이 아직 청소되지 않은 경우 현재 칸을 청소한다.
		if(!board[curY][curX]){
			board[curY][curX]=2;
			cnt++;	
		}
		//2. 청소되지 않는 빈칸이 있는 경우
		int flag=false;
		for(int i=1; i<=4; i++){
			int d_new=(d+3*i)%4;
			int newY=curY+dy[d_new], newX=curX+dx[d_new];
			if(!board[newY][newX]){
				flag=true;
				d=d_new;
				q.push({newY,newX});
				break;
			}
		}
		//3. 청소되지 않은 빈칸이 없는 경우 
		if(!flag){
			int d_back=(d+2)%4;
			int backY=curY+dy[d_back], backX=curX+dx[d_back];
			if(backY>=0&& backY<n&& backX>=0&& backX<m&&
				board[backY][backX]!=1){
				q.push({backY,backX});
				continue;
			}
			else return;	
		}
		
	}
}
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>n>>m;
	cin>>sy>>sx>>d;
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++) cin>>board[i][j];
	}
	bfs();
	cout<<cnt;
}
