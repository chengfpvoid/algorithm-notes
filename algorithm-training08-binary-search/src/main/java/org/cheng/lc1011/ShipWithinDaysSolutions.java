package org.cheng.lc1011;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 */
public class ShipWithinDaysSolutions {
    /**
     * 要得到>= 某数的 最小值，
     * 这里如果要求1天送达，则最低运载能力为重量之和，要求每天可以承载1件货物，则最低运载能力为最大货物的重量
     * 此题采用二分查找 + 判定 二分区间是 [max(weights),sum(weights)]
     * 先判定 最低运载能力为t的时候 能否在d天送达
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (isValid(weights,days,mid)) {
                //满足条件 继续往小的地方找
                r = mid;

            } else {
                l = mid + 1;
            }
        }
        return l;



    }

    /**
     * 运载能力为t时 d天内能否完成
     * @param weights
     * @param d
     * @param t
     * @return
     */
    private boolean isValid(int[] weights, int d, int t) {
        // 需要的天数
        int days = 1;
        // 每天运送的包裹总重量
        int totalWeight = 0;

        for(int i = 0; i < weights.length; i++) {
            totalWeight += weights[i];
            if (totalWeight > t) {
                //超过了当天的运载能力 ，到下一天，重新统计重量
                days++;
                totalWeight = weights[i];
            }
            if(days > d) {
                // 超过了指定的天数限制 返回false
                return false;
            }
        }
        return true;
    }
}
