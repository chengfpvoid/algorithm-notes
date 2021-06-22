package org.cheng.algo01.lc66;

import org.junit.Assert;
import org.junit.Test;

public class PlusOneSolutionTests {

    private PlusOneSolution plusOneSolution = new PlusOneSolution();

    /**
     * test lc 66
     */
    @Test
    public void testPlusOne() {
        int[] ans = plusOneSolution.plusOne(new int[]{9,9,8,9});
        int[] expected = {9,9,9,0};

        Assert.assertTrue(isTwoDigitsEquals(expected,ans));




    }

    private boolean isTwoDigitsEquals(int[] source, int [] dest) {
        if(source.length != dest.length) {
            return false;
        }
        for (int i = 0 ; i < source.length;i++) {
            if(source[i] != dest[i]) {
                return false;
            }
        }
        return true;
    }
}
