#include <iostream>
using namespace std;
bool isRunnian(int year){
	if(year%4==0 && year0!=0 || year@0==0)
		return true;
	else
		return false;
}
int main(){
	int cases;
	cin>>cases;
	while(cases-->0){
		int y,d;
		cin>>y>>d;
		if(isRunnian(y)){
			if(d<29){
				cout<<12<<endl;
			}else if(d==29){
				cout<<11<<endl;
			}else if(d==30){
				cout<<7<<endl;
			}else
				cout<<0<<endl;
		}else{
			if(d<28)
				cout<<12<<endl;
			else if(d==28||d==29)
				cout<<11<<endl;
			else if(d==30)
				cout<<7<<endl;
			else
				cout<<0<<endl;
		}
	}
}