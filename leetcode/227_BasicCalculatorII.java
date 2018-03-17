public class Solution {
    public int calculate(String s) {
        String[] nums = s.split("(\\+|-|\\*|/)");
        String[] ops = s.split("\\w*\\d+\\w*");
        ArrayList<Integer> oprands = new ArrayList<Integer>();
        List<String> opts = new ArrayList<String>();
        for(int i=0;i<nums.length;i++){
            oprands.add(Integer.parseInt(nums[i].trim()));
        }
        for(int i=0;i<ops.length;i++){
            if(ops[i].trim().matches("(\\+|-|\\*|/)"))
                opts.add(ops[i]);
        }
        boolean premd = true;
        int conscnt = 0;
        for(int i = 0;i<opts.size();i++){
            if(premd&&!opts.get(i).contains("*")&&!opts.get(i).contains("/")){
                premd = false;
                conscnt = 0;                
            }else{
                if(opts.get(i).contains("*")||opts.get(i).contains("/")){//连续乘除，需要设置最先的oprands
                    int a = oprands.get(i);
                    int b = oprands.get(i+1);
                    int ans = 0;
                    if(opts.get(i).contains("*")) ans = a*b;
                    else ans = a/b;
                    oprands.set(i+1,ans);
                    oprands.set(i-conscnt,ans);//set the first
                    premd = true;
                    conscnt++;
                }
            }           
        }
        //System.out.println(oprands);
        boolean flag = true;
        int ans=oprands.size()>0?oprands.get(0):0;
        for(int i=0;i<opts.size();i++){
            if(opts.get(i).contains("+")||opts.get(i).contains("-")){
                if(flag){
                    ans = oprands.get(i);
                    flag = false;
                }
                int b = oprands.get(i+1);
                if(opts.get(i).contains("+")) ans+=b;
                else ans-=b;
                //System.out.println(i+" "+ans);
            }
            
        }
        return ans;
    }
}