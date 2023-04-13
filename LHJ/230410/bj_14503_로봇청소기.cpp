#include<bits/stdc++.h>
using namespace std; //0,n-1,m-1: ��� ��, 1:��, 2:û���� ĭ 
typedef pair<int,int> pii;
#define Y first
#define X second
int n,m,board[50][50],sy,sx,d,dy[]={-1,0,1,0}, dx[]={0,1,0,-1}, cnt; 
void bfs(){
	queue<pii> q;
	//û������ �ʰ� �湮�� �Ѵ� 
	q.push({sy,sx});
	while(!q.empty()){
		auto cur=q.front();q.pop();
		int curY=cur.Y, curX=cur.X;
		//1. ���� ĭ�� ���� û�ҵ��� ���� ��� ���� ĭ�� û���Ѵ�.
		if(!board[curY][curX]){
			board[curY][curX]=2;
			cnt++;	
		}
		//2. û�ҵ��� �ʴ� ��ĭ�� �ִ� ���
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
		//3. û�ҵ��� ���� ��ĭ�� ���� ��� 
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
