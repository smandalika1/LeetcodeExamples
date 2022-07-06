public class BuySellStock {
    public static void main(String args[]){
        BuySellStock bs=new BuySellStock();
        int[] prices=new int[]{2,4,1};
        System.out.println(bs.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else if(prices[i]-minPrice>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
    public int maxProfitincorrect(int[] prices) {

        int min=prices[0];
        int max=prices[prices.length-1];

        int minpos=0;
        int maxpos=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
                minpos=i;
            }
            if(prices[i]>max){
                max=prices[i];
                maxpos=i;
            }
        }
        System.out.println("min--"+min+"--minpos--"+minpos);
        System.out.println("max--"+max+"--maxpos--"+maxpos);
        if(minpos<maxpos){
            return max-min;
        }else{
            //find next min
            minpos=0;
            min=prices[0];
            for(int i=0;i<maxpos;i++){
                if(prices[i]<min){
                    min=prices[i];
                    minpos=i;
                }
            }
            System.out.println("min--"+min+"--minpos--"+minpos);
            System.out.println("max--"+max+"--maxpos--"+maxpos);
            return max-min;
        }

    }
    public int maxProfitOld(int[] prices) {
        int len=prices.length;
        int profit=0;
        for(int i=0;i<len;i++){
            int j=i+1;
            System.out.println("i--"+prices[i]);
            for(;j<=len-1;j++){

                System.out.println("j--"+prices[j]);
                if(prices[j]-prices[i]>0 && (prices[j]-prices[i])>profit){
                    profit=prices[j]-prices[i];
                    //System.out.println("profit--"+profit);

                }
            }
        }
        return profit;
    }
}
