public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mth1 = (nums1.length+nums2.length-1)/2;
		int mth2 = (nums1.length+nums2.length)/2;
		double mthnum1,mthnum2;
        int p1=0,q1=nums1.length-1,p2=0,q2=nums2.length-1;
        while(p1<q1&&p2<q2){
        	int mid1 = p1+(q1-p1)/2;
    		int mid2 = p2+(q2-p2)/2;
    		if(nums1[mid1]==nums2[mid2]){
    			if(mid1+mid2<mth1){
    				p1 = mid1;
    				p2 = mid2;
    			}else{
    				q1=mid1;
    				q2=mid2;
    			}
    		}else if(nums1[mid1]>nums2[mid2]){
    			q1=mid1;
    			p2=mid2;
    		}else{
    			p1=mid1;
    			q2=mid2;
    		}
        }        
		if(p2==q2){
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			int tmp = p1;p1 = p2;p2 = tmp;
			tmp = q1;q1=q2;q2=tmp;
		}
		int part = binarySearchPos(nums2,p2,q2,nums1[p1]);
		
		
		if(mth1<part+p1)
			mthnum1 = nums2[mth1-p1];
		else if(mth1==part+p1)
			mthnum1 = nums1[p1];
		else
			mthnum1 = nums2[mth1-p1];
		if(mth2<part+p1)
			mthnum2 = nums2[mth1-p1];
		else if(mth2==part+p1)
			mthnum2 = nums1[p1];
		else
			mthnum2 = nums2[mth1-p1];

		return (mthnum1+mthnum2)/2;    	
    }
    public int binarySearchPos(int[] arr,int p,int q,int t){
    	int mid = p+(q-p)/2;
    	while(p<q){
    		if(t<arr[mid]&&(mid==p||t<arr[mid-1])){
    			return mid;
    		}else if(t<arr[mid])
    			q = mid-1;
    		else
    			p = mid+1;
    	}
    	if(t<arr[p]) return p;
    	else return q+1;
    }
}