public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double[] circen = new double[2];
        circen[0] = (p1[0]+p2[0]+p3[0]+p4[0])/4.0;
        circen[1] = (p1[1]+p2[1]+p3[1]+p4[1])/4.0;
        //System.out.println(circen[0]+" "+circen[1]);
        double d1 = (circen[0]-p1[0])*(circen[0]-p1[0])+(circen[1]-p1[1])*(circen[1]-p1[1]);
        double d2 = (circen[0]-p2[0])*(circen[0]-p2[0])+(circen[1]-p2[1])*(circen[1]-p2[1]);
        double d3 = (circen[0]-p3[0])*(circen[0]-p3[0])+(circen[1]-p3[1])*(circen[1]-p3[1]);
        double d4 = (circen[0]-p4[0])*(circen[0]-p4[0])+(circen[1]-p4[1])*(circen[1]-p4[1]);
        return true;
    }
}