public class Solution {

    public int change(int amount, int[] coins) {//beibao
        int n = coins.length;
        int[] d = new int[amount+1];
        for(int i=0;i<d.length;i++)
            d[i] = -1;
        d[0] = 1;
        changeRecur(amount,coins,d);
        System.out.println(Arrays.toString(d));
        return d[amount];
    }
    public int changeRecur(int amount,int[] coins,int[] d){
        if(d[amount]!=-1) return d[amount];
        int curd = 0;
        for(int i=0;i<coins.length;i++){
            if(amount>=coins[i])
                curd+=changeRecur(amount-coins[i],coins,d);
        }
        d[amount] = curd;
        return d[amount];
    }
}