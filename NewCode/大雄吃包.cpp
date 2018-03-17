#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
	int n,m;
	cin>>n>>m;
	int cur[n];
	int d[n];
	int left = 0;
	for(int i=0;i<n;i++){
		cin>>cur[i];		
		cin>>d[i];
		if(cur[i]>0)
			left++;
	}
	while(left>=m&&left>0){
		int fi=-1,si=-1;
		int max = 0,sec=0;
		left = 0;
		//find the two most delicious 
		for(int i=0;i<n;i++){
			if(cur[i]>max||cur[i]==max&&cur[i]>0&&d[i]>d[fi]){
				sec = max;
				si = fi;
				max = cur[i];
				fi = i;
			}else if(cur[i]>sec||cur[i]==sec&&cur[i]>0&&d[i]>d[si]){
				sec = cur[i];
				si = i;
			}				
		}
		//eat
		if(fi>=0)
			cur[fi] = -1;
		if(si>=0)
			cur[si]=-1;
		//decrease
		for(int i=0;i<n;i++){
			if(cur[i]>0){
				cur[i] -= d[i];
				if(cur[i]<0) cur[i] = 0;
			}
			if(cur[i]>0)//check
				left++;
		}
	}
	for(int i=0;i<n;i++)
		cout<<cur[i]<<endl;
	return 0;
}