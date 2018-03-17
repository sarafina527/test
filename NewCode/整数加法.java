import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String a = input.next();
            String b = input.next();
            if(a.matches("^[-+]?[0-9]+")&&a.matches("^[-+]?[0-9]+")){
                String ans = AddString(num1,num2);
                System.out.println(dp[n][sum]);
            }else{
                System.out.println("Error");
            }
            
        }
    }
    public StringBuilder AddString(String num1,String num2){
        StringBuilder ans = new StringBuilder();
        boolean neg = false;
        if(num1.charAt(0)=='-'){
            if(num2.charAt(0)=='-'){
                neg = true;
                StringBuilder sub = AddString(num1.substring(1),num2.substring(1));
                return sub.insert(0,'-').toString();
            }else{
                String sub1 = num1.substring(1);
                if(sub1.compareTo(num2)>0){
                    neg = true;
                    StringBuilder sub = minusString(sub1,num2);
                    return sub.insert(0,'-').toString();
                }else{
                    StringBuilder sub = minusString(num2,sub1);
                }
            }
        }
        if(num1.length()<num2.length()){
            StringBuilder temp = num1;
            num1 = num2;
            num2 = temp;
        }
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        sb1.reverse();sb2.reverse();
        
        int cw = 0,i;
        for(i=0;i<sb2.length();i++){
            int d1 = sb1.charAt(i)-'0';
            int d2 = sb2.charAt(i)-'0';
            int sum = d1+d2+cw;
            ans.append(sum%10);
            cw = sum/10;
        }
        for(;i<sb1.length();i++){
            int d1 = sb1.charAt(i)-'0';
            int sum = d1+cw;
            ans.append(sum%10);
            cw = sum/10;
        }
        while(cw>0){
            ans.append(cw%10);
            cw /= 10;
        }
        ans.reverse();
        return ans;
    }
    public StringBuilder minusString(StringBuilder num1,StringBuilder num2){

    }
}