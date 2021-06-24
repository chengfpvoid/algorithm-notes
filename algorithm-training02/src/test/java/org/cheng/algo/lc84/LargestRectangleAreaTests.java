package org.cheng.algo.lc84;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleAreaTests {

    @Test
    public void testLargestRectangleArea() {
        LargestRectangleAreaSolution solution = new LargestRectangleAreaSolution();
        int ans = solution.largestRectangleArea(new int[] {1,5,5,6,5,4});
        Assert.assertEquals(20,ans);

    }
}
