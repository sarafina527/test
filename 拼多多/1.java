import java.util.*;
public class Main { 
    static class Bear{
        int id;
        int attack;
        int hungry;
        public Bear(int i,int a,int h){
            id = i;
            attack = a;
            hungry = h;
        }
    }   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            int[] hungrys = new int[m];
            for(int i=0;i<m;i++){
                hungrys[i] = (input.nextInt());
            }
            Collections.sort(hungrys);
            Bear[] bears = new Bear[n];
            for(int i=0;i<n;i++){
                int a = input.nextInt();
                int h = input.nextInt();
                bears[i] = new Bear(i,a,h);
            }
            Arrays.sort(bears,new Comparator<Bear>(){
                public int compare(Bear b1,Bear b2){
                    return b2.attack-b1.attack;
                }
            });
            boolean used[] = new boolean[m];
            for(int i=0;i<n;i++){
                for(j=m-1;j>=0;j--){
                    if(!used[j]&&hungrys[j]<=bears[i].hungry){
                        bears[i].hungry = bears[i].hungry- hungrys[j];
                        System.out.println(i+" "+hungrys[j]+" "+bears[i].hungry);
                        used[j] = true;
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(bears[j].id==i)
                        System.out.println(bears[j].hungry);
                }
            }
        }
    }
       
}