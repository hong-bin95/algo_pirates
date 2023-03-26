#include<bits/stdc++.h>
using namespace std;
int arr[100000],n,x,ret;
int main(){
	ios::sync_with_stdio(false), cin.tie(0);
	cin>>n;
	for(int i=0; i<n; i++) cin>>arr[i];
	sort(arr,arr+n);
	cin>>x;
	int i1=0, i2=n-1;
	while(i1<i2){
		int sum=arr[i1]+arr[i2];
		if(sum==x){
			ret++;
			i2--;
			i1++;
		}
		else if(sum<x) i1++;
		else i2--; 
	}
	cout<<ret;
}
