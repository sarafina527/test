public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[output.length-1] = 1;
        for(int i=output.length-2;i>=0;i--){
        	output[i] = output[i+1]*nums[i+1];//store the product of elems behind ith
        }
        int pre = 1;
        for(int i=0;i<output.length;i++){
        	output[i] = pre*output[i];
        	pre *= nums[i];
        }
        return output;
    }
}