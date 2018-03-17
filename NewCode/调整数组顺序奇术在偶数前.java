public class Solution {
    public void reOrderArray(int [] array) {
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1){
                int insert = array[i],j=i;
                for(;j>0&&(array[j-1]&1)==0;j--){
                    array[j] = array[j-1];
                }
                array[j] = insert;
            }
        }
    }
}