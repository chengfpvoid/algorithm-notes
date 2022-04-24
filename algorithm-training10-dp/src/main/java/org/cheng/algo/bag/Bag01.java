package org.cheng.algo.bag;

public class Bag01 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        testWeightBagProblem(weight, value, bagWeight);
        testWeightBagProblem02(weight,value,bagWeight);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int wlen = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen][bagSize + 1];
        // 初始化 i 有 i-1 而来 首先dp[0][j] 需要初始化
        for (int j = 0; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        // 递推 遍历的顺序 i范围 0  到  物品个数 - 1
        // 遍历顺序来自左上，对调下也是没问题的
        for (int i = 1; i < wlen; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    // 第i个物品放不进去
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j - weight[i]] + value[i]);
                }
            }
        }

        //打印dp数组
        for (int i = 0; i < wlen; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void testWeightBagProblem02(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                System.out.println("i:" + i + "重量" + weight[i]  +"价值：" + value[i]   + "包的容量j:" + j  + "dp[j]:" +  dp[j]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }
}
