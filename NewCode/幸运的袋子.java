//求重复元素的子集，在取自己的过程中若已经不符合限制sum>=prod则剪枝
//由于有多想相同数字，排序，每次选择包不包含当前元素时需要满足3个条件
//1.没有前一个位置
//2.前一个位置与当前不相同
//3.前一个位置相同但在子集里
//不包含都可以
import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        while(input.hasNext()){
            int n = input.nextInt();
            int[] a= new int[n];
            for(int i=0;i<n;i++)
                a[i] = input.nextInt();
            Arrays.sort(a);
            int ans = subset(0,0,1,a,false);
            System.out.println(ans);
        }
    }
    public static int subset(int isofar,int sum,int prod,int[] a,boolean pretaken){
        if(isofar==a.length&&sum>prod) return 1;//找到一个子集
        else if(isofar==a.length) return 0;
        if(sum<prod&&!(sum==0&&prod==1)) return 0;//剪枝，由于是排序过的，如果当前就已经超出限制，往后找肯定也是超出限制
        int ans = 0;
        if(isofar==0||a[isofar]!=a[isofar-1]||pretaken)//用于去除相同数字的重复单独选取
            ans += subset(isofar+1,sum+a[isofar],prod*a[isofar],a,true);
        ans += subset(isofar+1,sum,prod,a,false);
        //System.out.println(isofar+" "+sum+" "+prod+" "+ans);
        return ans;
    }
}