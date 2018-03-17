class Solution {
    public int nextGreaterElement(int n) {
        int[] arr = translist(n);
        int i=1;
        if(i>=arr.length) return -1;
        for(;i<arr.length;i++){
            if(arr[i]<arr[i-1])
                break;
        }
        if(i==arr.length) return -1;
        int j = 0;
        for(;j<arr.length;j++){
            if(arr[j]>arr[i]){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                break;
            }
        }
        for(int k=0;k<i/2;k++){
            int tmp = arr[k];
            arr[k] = arr[i-k-1];
            arr[i-k-1] = tmp;
        }
        long ans = 0;
        for(i = arr.length-1;i>=0;i--){
            ans = ans*10+arr[i];
        }
        if(ans>Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
    public int bitcnt(int n){
        int ans =0;
        while(n>0){
            ans++;
            n/=10;
        }
        return ans;
    }
    public int[] translist(int n){
        int len = bitcnt(n);
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = n%10;
            n/=10;
        }
        return arr;
    }
}
