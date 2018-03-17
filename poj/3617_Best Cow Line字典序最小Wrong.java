import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            char[] seq = new char[n];
            for(int i=0;i<n;i++){
                seq[i]=input.next().charAt(0);
            }
            int head=0,tail=n-1;
            StringBuilder sb = new StringBuilder();
            while(head<=tail){
                if(seq[head]<seq[tail])
                    sb.append(seq[head++]);
                else if(seq[head]>seq[tail])
                    sb.append(seq[tail--]);
                else{
                    int i=head+1,j=tail-1;
                    while(i<j&&seq[i++]==seq[j--]);
                    if(i<j&&seq[i]<seq[j]){
                        sb.append(seq[head++]);
                    }else
                        sb.append(seq[tail--]);
                }
            }
            int s = 0;
            while(s<sb.length()){
                for(int i=s;i<s+80&&i<sb.length();i++)
                    System.out.print(sb.charAt(i));
                System.out.println("");
                s+=80;
            }
        }
    }
       
}