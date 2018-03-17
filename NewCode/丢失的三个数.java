import java.util.*;

public class Main{
    static int mod = 7;
    static int n = 10000;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            boolean[] exist = new boolean[n+1];
            for(int i=0;i<9997;i++){
                int num = input.nextInt();
                 exist[num]=true;
            }
            int fir=0,sec=0,thi=0;
            for(int i=1;i<=10000;i++){
                if(exist[i]==false){
                    if(fir==0) fir=i;
                    else if(sec==0) sec = i;
                    else if(thi==0){
                        thi = i;
                        break;
                    }
                }
            }
            String com = ""+fir+sec;
            int num = Integer.parseInt(com);
            com = num%7+""+thi;
            num = Integer.parseInt(com);
            int ans = num%7;
            System.out.println(ans);
        }
    }    
}