package org.cheng.algo.avl.acwing136;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 给定一个长度为 n 的序列 A，A 中的数各不相同。
 *
 * 对于 A 中的每一个数 Ai，求：
 *
 * min1≤j<i|Ai−Aj|
 * 以及令上式取到最小值的 j（记为 Pi）。若最小值点不唯一，则选择使 Aj 较小的那个。
 *
 * 输入格式
 * 第一行输入整数 n，代表序列长度。
 *
 * 第二行输入 n 个整数A1…An,代表序列的具体数值，数值之间用空格隔开。
 *
 * 输出格式
 * 输出共 n−1 行，每行输出两个整数，数值之间用空格隔开。
 *
 * 分别表示当 i 取 2∼n 时，对应的 min1≤j<i|Ai−Aj| 和 Pi 的值。
 *
 * 数据范围
 * n≤105,|Ai|≤109
 * 输入样例：
 * 3
 * 1 5 3
 * 输出样例：
 * 4 1
 * 2 1
 */
public class FindAdjacentValue {
    /**
     * 求绝对值的最小值 和下标
     */
    public static void printAdjacentValueAndIndex(int[] a, int n) {
        TreeSet<Integer> orderSet = new TreeSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        orderSet.add(a[0]);
        // 值 和对应的下标 (下标从1开始)
        map.put(a[0],1);
        // i 从 2~n开始
        for (int i = 2; i <= n; i++) {
            int index = 0;
            // 找小于Ai的最大值 暂时作为候选项的值 以及拿到对应的下标
            int ans = 0;
            Integer lower = orderSet.lower(a[i-1]);
            if(lower != null) {
                index = map.get(lower);
                ans = a[i-1] - lower;
            }
            // 找到大于Ai的最小值，和前面取得的值比较，选与Ai相比绝对值更小的，如果两者相等，取aj更小的那个
            Integer higher = orderSet.higher(a[i-1]);
            if (higher != null) {
                if (index == 0) {
                    // 前面没拿到下标，直接拿此处的下标
                    index = map.get(higher);
                    ans = higher;

                } else {
                    // 和前面的值 分别对Ai差值绝对值比较
                    int x = a[i - 1] - lower;
                    int y = higher - a[i - 1];
                    if ( x <= y) {
                        // 值较小，且 |Ai - Aj| 较小
                        index = map.get(lower);
                        ans = x;

                    } else {
                        index = map.get(higher);
                        ans = y;
                    }
                }
            }
            System.out.println(ans + " " + index);

        }

    }

    public static void main(String[] args) {
        int[] a = {1,5,3};
        int n = 3;
        printAdjacentValueAndIndex(a,n);

    }
}
