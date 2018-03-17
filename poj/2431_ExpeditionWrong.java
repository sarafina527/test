import java.util.*;
public class Main {  
    static class fuelStation{
        int pos;
        int fuel;
        fuelStation(int p,int f){pos=p;fuel=f;}
    }  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);       
        int n = input.nextInt();
        fuelStation[] fs = new fuelStation[n+1];
        int[] dist = new int[n+1];
        int[] fuel = new int[n+1];
        for(int i=0;i<n;i++){
            fs[i] = new fuelStation(input.nextInt(),input.nextInt());
        }
        int L = input.nextInt(),P=input.nextInt();
        fs[n] = new fuelStation(0,0);
        Arrays.sort(fs,new Comparator<fuelStation>(){
            public int compare(fuelStation f1,fuelStation f2){
                return f2.pos-f1.pos;
            }
        });
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(n+1,Collections.reverseOrder());
        int sd=0,ans = 0;
        for(int i=0;i<=n;i++){
            int nextsd = L-fs[i].pos;
            int d = nextsd-sd;
            if(P < d){
                if(heap.isEmpty()){
                    System.out.println(-1);
                    return;
                }
                P += heap.poll();
                ans++;
            }
            P -= d;
            sd = nextsd;
            heap.offer(fs[i].fuel);            
        }
        System.out.println(ans);        
    }
       
}