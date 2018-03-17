public class Solution {
	class Rect{
		int left=0;
		int right=0;
		int top=0;
		int bottom=0;	
		int area=0;
		Rect(int l,int b,int r,int t){
		    if(l<=r&&b<=t){
		        left = l;
    			right = r;
    			top = t;
    			bottom = b;
		    }
		    area = (right - left)*(top - bottom);
		    System.out.println(area);
		}
		Rect overlap(Rect rect){
			int l = this.left>rect.left?this.left:rect.left;
			int r = this.right<rect.right?this.right:rect.right;
			int t = this.top<rect.top?this.top:rect.top;
			int b = this.bottom>rect.bottom?this.bottom:rect.bottom;
			if(l<=r&&t>=b)
				return new Rect(l,b,r,t);
			else
				return new Rect(0,0,0,0);
		}
	}
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	Rect rect1 = new Rect(A,B,C,D);
    	Rect rect2 = new Rect(E,F,G,H);
    	Rect cross = rect1.overlap(rect2);
    	return rect1.area+rect2.area - cross.area;
    }    
}