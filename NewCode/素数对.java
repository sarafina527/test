import java.util.*;
public class Main { 
    static Set<Integer>  primes = new TreeSet<Integer>();
    static{
        boolean isp[] = new boolean[1001];
        Arrays.fill(isp,true);
        for(int i=2;i<=1000;i++){
            if(isp[i]){
                primes.add(i);
                for(int j=2*i;j<=1000;j+=i)
                    isp[j] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int ans = 0;
            for(int p:primes){
                if(p>n/2) break;
                if(primes.contains(n-p))
                    ans++;
            }
            System.out.println(ans);
        }
    }
       
}