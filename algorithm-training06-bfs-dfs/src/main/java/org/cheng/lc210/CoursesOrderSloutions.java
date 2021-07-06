package org.cheng.lc210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 */
public class CoursesOrderSloutions {
    /**
     * 拓扑排序 记录课程拓扑顺序
     *
     * 先初始化图 并记录入度，入度为0的 是先决课程，根据入度为0的课程 进行BFS
     * 访问到点 入度 - 1  入度为0的时候 出队，最终出队的元素和总的课程个数一致，表示可以选所有的课程
     * 否则 还有存在入度不为0的点，表示有环
     *
     * @param numCourses 课程数
     * @param prerequisites 2个元素 课程与先决课程 [1,0] 表示1的先决课程是0
     * @return 课程拓扑顺序
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        edges = new ArrayList<>();
        inDeg = new int[n];
        // 初始化图
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
            inDeg[i] = 0;
        }
        // 给图加边和入度
        for( int[] pre : prerequisites) {
            int x = pre[1];
            int y = pre[0];
            addEdge(x,y);
        }


        return topSort(edges,inDeg);


    }

    /**
     * 给图进行拓扑排序
     * @param edges 图的出边数组
     * @param inDeg 顶点的入度
     * @return
     */
    private int[] topSort(List<List<Integer>> edges, int[] inDeg) {
        int[] orders = new int[n];
        // orders下标
        int m = 0;
        Queue<Integer> queue = new LinkedList<>();
        //零入度订点入队
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        // bfs
        while (!queue.isEmpty()) {
            int x = queue.poll();
            orders[m++] = x;
            // 遍历下一层 并将入度-1,入度为0的入队
            for(Integer y : edges.get(x)) {
                inDeg[y]--;
                if (inDeg[y] == 0) {
                    queue.offer(y);
                }
            }
        }
        if (m != n) {
            return new int[] {};
        }
        return orders;
    }

    private void addEdge(int x, int y) {
        edges.get(x).add(y);
        inDeg[y]++;
    }

    /**
     * 边数
     */
    private int n;
    /**
     * 边的入度
     */
    private int[] inDeg;
    /**
     * 出边数组 记录图
     */
    private List<List<Integer>> edges;
}
