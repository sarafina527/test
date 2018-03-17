import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int str = input.next();
            int n = str.length();
            int ans = 0;
            int left = n/2;
            List<String> list = new LinkedList<String>();
            StringBuilder sofar = new StringBuilder();
            generatePar(sofar,0,n,list);
            System.out.println(list);
            System.out.println(ans);
        }
    }
    public static void generatePar(StringBuilder sofar,int leftcur,int n,List<String> list){
    	if(sofar.length()==2*n){
    		list.add(sofar.toString());
    		return;
    	}
    	if(leftcur==n){
    		for(int i=sofar.length();i<2*n;i++){
    			sofar.append(')');
    		}
    		list.add(sofar.toString());
    		return;
    	}
    	if(sofar.length()==2*cur){
    		generatePar(sofar.append('('),leftcur+1,n);
    	}else{
    		generatePar(sofar.append('('),leftcur+1,n);
    		generatePar(sofar.append(')'),leftcur,n);
    	}
    }
       
}