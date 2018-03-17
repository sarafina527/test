import java.util.*;
public class Main { 
    static Map<Character,Integer> cnt = new HashMap<Character,Integer>();
    //static String[] digits = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        List<Integer> nums = new ArrayList<Integer>();
        while(cases-->0){
            cnt.clear();
            int[] dcnt = new int[10];
            String tel = input.next();
            for(int i=0;i<tel.length();i++){
                char c = tel.charAt(i);
                if(cnt.containsKey(c))
                    cnt.put(c,cnt.get(c)+1);
                else
                    cnt.put(c,1);
            }
            dcnt[0+2] = cnt.containsKey('Z')?cnt.get('Z'):0;
            dcnt[2+2] = cnt.containsKey('W')?cnt.get('W'):0;
            dcnt[4+2] = cnt.containsKey('U')?cnt.get('U'):0;
            dcnt[6+2] = cnt.containsKey('X')?cnt.get('X'):0;
            dcnt[8+2-10] = cnt.containsKey('G')?cnt.get('G'):0;
            dcnt[1+2] = cnt.containsKey('O')?cnt.get('O')-dcnt[0+2]-dcnt[2+2]-dcnt[4+2]:0;
            dcnt[3+2] = cnt.containsKey('H')?cnt.get('H')-dcnt[8+2-10]:0;
            dcnt[7+2] = cnt.containsKey('S')?cnt.get('S')-dcnt[6+2]:0;
            dcnt[5+2] = cnt.containsKey('V')?cnt.get('V')-dcnt[7+2]:0;
            dcnt[9+2-10] = cnt.containsKey('I')?cnt.get('I')-dcnt[5+2]-dcnt[6+2]-dcnt[8+2-10]:0;
            for(int i=0;i<10;i++){
                for(int j=0;j<dcnt[i];j++)
                    System.out.print(i);
            }
            System.out.println();
        }
    }
}