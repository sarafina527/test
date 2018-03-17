public class Solution {
    public int RectCover(int target) {
		if(target<=2) return target;
        int f_2 = 1,f_1=2;
        for(int i=3;i<=target;i++){
            int cur = f_2+f_1;
            f_2 = f_1;
            f_1 = cur;
        }
        return f_1; 
    }
}