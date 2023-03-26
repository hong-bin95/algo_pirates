#include<queue>
#include<iostream>
#include<utility>
using namespace std;
typedef pair<int,int> pii;
#define IDX first
#define NUM second
int n, ret[1000], pizza;
queue<pii> q;
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>n;
	for(int i=0; i<n; i++){
		cin>>pizza;
		q.push({i,pizza});
	}
	int time=1;
	while(!q.empty()){
		auto& cur=q.front();q.pop();
		if(cur.NUM==1) ret[cur.IDX]=time;
		else q.push({cur.IDX, cur.NUM-1});
		time++;
	}
	for(int i=0; i<n; i++) cout<<ret[i]<<' ';
}
