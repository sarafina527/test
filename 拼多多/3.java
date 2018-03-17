import java.util.*;
public class Main {    
    static class Good{
        int id;
        int hot;
        int amount;
        public Good(int i,int h,int a){
            id = i;hot=h;amount=a;
        }
    }
    static class Activity{
        int startTime;
        int endTime;
        int goodsId;
        int limitQuantity;
        public Activity(int s,int e,int d,int q){
            startTime = s;endTime=e;goodsId =d;limitQuantity=q;
        }
    }
    static List<Activity> acis = new LinkedList<Activity>();
    static Set<Good> ina = new HashSet<Good>();
    static Map<Integer,Good> goodsmap = new HashMap<Integer,Good>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            
            for(int i=0;i<n;i++){
                int i,h,a;
                i = input.nextInt();
                h = input.nextInt();
                a = input.nextInt();
                goodsmap.put(i,new Good(i,h,a));
            }
            for(int i=0;i<m;i++){
                int t = input.nextInt();
                String type = input.next();
                if(type.equals("add")){
                    int s = input.nextInt();
                    int e = input.nextInt();
                    int id = input.nextInt();
                    int q = input.nextInt();
                    int ans = addActivity(s,e,id,q);
                }else if(type.equals("buy")){
                    int aid = input.nextInt();
                    int q = input.nextInt();
                    int ans = buyGoods(aid,q);
                }else{
                    List<Integer> ans = getActivity()
                }
                System.out.println(ans);
            }
            
        }
    }
    public static int addActivity(int startTime,int endTime,int goodsId,int limitQuantity){
        if(ina.contains(goodsId)||goodsmap.get(goodsId).amount<limitQuantity)
            return -1;
        else
        {
            acis.add(new Activity(startTime,endTime,goodsId,limitQuantity));
            return acis.size()-1;
        }
    }
    public static int buyGoods(int activityId,int quantity){
        if(quantity>acis[activityId].limitQuantity)
            return -1;
        else{
            acis[activityId].limitQuantity-=quantity;
            return 0;
        }
    }
    public static List<Activity> getActivity(){
        return acis;
    }
       
}