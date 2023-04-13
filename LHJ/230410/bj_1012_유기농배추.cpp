#include<bits/stdc++.h>
using namespace std;
int T,m,n,k,x,y,board[50][50], dy[]={1,0,-1,0}, dx[]={0,1,0,-1};
void dfs(int y,int x){
	board[y][x]=0;
	for(int i=0; i<4; i++){
		int newY=y+dy[i], newX=x+dx[i];
		if(newY>=0&& newY<n&& newX>=0&& newX<m&& board[newY][newX]) dfs(newY,newX);
	}
}
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>T;
	while(T--){
		int ret=0;
		memset(board, 0x00, sizeof(board));
		cin>>m>>n>>k;
		for(int i=0,x,y; i<k; i++){
			cin>>x>>y;
			board[y][x]=1;
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(board[i][j]){
					ret++;
					dfs(i,j);	
				}
			}
		}
		cout<<ret<<'\n';
	}
}
