public class Solution {
    public int magicalString(int n) {
        if(n<2) return n>=0?n:0;
    	int ans=1,groups=0;
        int[] mstr = new int[n+1];//store the sequence
        mstr[0] = 1;mstr[1] = 2;//init seq

        for(int nthg=1;nthg<n;nthg++){//group index,accord to gindex to fill the seqence
        	groups+=mstr[nthg-1];
        	int cnt = mstr[nthg];
        	int next = mstr[groups-1]==1?2:1;//switch the state every group

        	if(next==1){//count the ones
        		ans+=cnt;
        	}
        	
        	if(cnt==1){//当第n个组的个数
        		mstr[groups] = next;
        		if(groups==n-1){
        			break;
        		}
        	}else{
        		mstr[groups] = next;
        		mstr[groups+1] = next;
        		if(groups==n-1){
        			if(next==1)
        				ans--;
        			break;
        		}else if(groups+1==n-1)
        			break;
        	}
        }
        return ans;
    }
}