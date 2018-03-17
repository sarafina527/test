import java.util.*;
public class Main {
    static class dec{
        public int a;
        public int b;
        public dec(int aa,int bb){ a=aa;b=bb;};
        public boolean equals(Object o){
            dec oo = (dec)o;
            return this.a==oo.a&&this.b==oo.b;
        }
        public int hashCode(){
            return a*101+b;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int w = input.nextInt();
            int x = input.nextInt();
            int y = input.nextInt();
            int z = input.nextInt();
            int min = w/z;
            int max = x/y;
            Set<dec> exist = new HashSet<dec>();
            for(int a=w;a<=x;a++){
                for(int b=y;b<=z;b++){
                    int g = a>b?gcd(a,b):gcd(b,a);
                    dec tmp = new dec(a/g,b/g);
                    if(!exist.contains(tmp))
                        exist.add(tmp);
                }
            }
            System.out.println(exist.size());
        }
    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}