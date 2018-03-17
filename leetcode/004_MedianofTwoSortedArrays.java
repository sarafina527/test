public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length,len2 = nums2.length;
        if(len1==0&&len2==0) return 0.0;
        if(len1==0){
            if((len1&1)!=0)
                return nums2[len2/2];
            else
                return (nums2[len2/2-1]+nums2[len2/2])/2.0;
        }
        if(len2==0){
            if((len1&1)!=0)
                return nums1[len1/2];
            else
                return (nums1[len1/2-1]+nums1[len1/2])/2.0;
        }
        if(((len1+len2)&1)!=0){
            return findKth(nums1,0,len1-1,nums2,0,len2-1,(len1+len2)/2+1);
        }else{
            int k1 = findKth(nums1,0,len1-1,nums2,0,len2-1,(len1+len2)/2);
            int k2 = findKth(nums1,0,len1-1,nums2,0,len2-1,(len1+len2)/2+1);
            return (k1+k2)/2.0;
        }
    }
    public int findKth(int[] nums1,int p1,int q1,int[] nums2,int p2,int q2,int k){
        //System.out.println(nums1[p1]+" "+nums1[q1]+" "+nums2[p2]+" "+nums2[q2]+" "+k);
        if(p1==q1) return insertonekth(nums2,p2,q2,nums1[p1],k);
        if(p2==q2) return insertonekth(nums1,p1,q1,nums2[p2],k);
    
        int m1 = (p1+(k-1)/2)<=q1?(p1+(k-1)/2):q1;
        int m2 = (p2+(k-1)/2)<=q2?(p2+(k-1)/2):q2;
        int pivot1 = nums1[m1];
        int pivot2 = nums2[m2];
        if(pivot1<pivot2){
            return findKth(nums1,m1,q1,nums2,p2,m2,k-m1+p1);
        }else
            return findKth(nums1,p1,m1,nums2,m2,q2,k-m2+p2);        
    }
    public int insertonekth(int[] nums1,int p,int q,int num,int k){
        int index = 0-Arrays.binarySearch(nums1,p,q,num)-1;
        if(index-p==k-1) return num;
        else if(index-p<k-1) return nums1[k-2];
        else return nums1[k-1];
    }
    public int insertonekth2(int[] nums1,int p,int q,int num,int k){

        int lesscnt = 0;
        for(int i=p;i<=q;i++){
            if(nums1[i]<=num)
                lesscnt++;
            else break;
        }        
        if(lesscnt==k-1) return num;
        else if(lesscnt<k-1) return nums1[k-2];
        else return nums1[k-1];
    } 
}