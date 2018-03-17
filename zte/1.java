import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int y = input.nextInt();
            int k = input.nextInt();
            int[] white = new int[3];
            int[] black = new int[2];
            white[0]=black[0]=k;
            for(int i=1;i<=y;i++){
                for(int j=2;j>0;j--){
                    white[j]=white[j-1];
                }
                white[0] = white[2]*3+white[1]*2;
                for(int j=1;j>0;j--){
                    black[j]=black[j-1];
                }
                black[0]=black[1]*3;
            }
            int whitecnt = 0,bcnt = 0;;
            for(int i=0;i<3;i++)
                whitecnt+=white[i];
            for(int i=0;i<2;i++)
                bcnt+=black[i];
            System.out.println(Math.abs(whitecnt-bcnt));
        }
    }
       
}