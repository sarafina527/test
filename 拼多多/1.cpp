#include<iostream>
#include<vector>
#include<map>
#include<utility>
#include<string>
#include<algorithm>
#include<cstring>
using namespace std;

struct Bear {
	int id;
	int attack;
	int hungry;	
};

bool mycompare(Bear &a, Bear &b) {
	return a.attack>b.attack;
}

int main(){


	int n, m;
	cin>>n>>m;
	vector<int> hungrys;
	int cur;
	for(int i=0; i<m; ++i) {
		cin>>cur;
		hungrys.push_back(cur);
	}
	sort(hungrys.begin(), hungrys.end()); // 糖果排序 
	
	vector<Bear> bears(n);
	int a,b;
	for(int i=0; i<n; ++i) {
		cin>>a>>b;
		bears[i].id= i;
		bears[i].attack = a;
		bears[i].hungry = b;
	}
	// 熊按饥饿排序 
	sort(bears.begin(), bears.end(), mycompare);
	
	
	bool used[m] = {0};
	for(int i=0; i<n; ++i) {
		
		for(int j=m; j>=0; --j){
			if(!used[j] && hungrys[j]<=bears[i].hungry) {
				bears[i].hungry = bears[i].hungry - hungrys[j];
				
				cout<<i<<" "<<hungrys[j]<<" "<<bears[i].hungry<<endl;
				used[j] = true;
			}	
		}
	}
	
	for(int i=0; i<n; ++i) {
		for(int j=0; j<n; ++j) {
			if(bears[j].id==i)
				cout<<bears[j].hungry<<endl;
		}
	}
	
	
	return 0;
} 
