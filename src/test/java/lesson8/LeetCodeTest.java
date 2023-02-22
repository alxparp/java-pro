package lesson8;

import org.junit.Assert;
import org.junit.Test;

public class LeetCodeTest {

    private final LeetCode leetCode = new LeetCode();

    @Test
    public void isPalindromeTest() {
        boolean actual1 = leetCode.isPalindrome("A man, a plan, a canal: Panama");
        boolean actual2 = leetCode.isPalindrome("race a car");
        boolean actual3 = leetCode.isPalindrome(" ");
        boolean actual4 = leetCode.isPalindrome("");

        Assert.assertTrue(actual1);
        Assert.assertFalse(actual2);
        Assert.assertTrue(actual3);
        Assert.assertTrue(actual4);
    }

    @Test
    public void containsDuplicateTest() {
        boolean actual1 = leetCode.containsDuplicate(new int[] {1,2,3,1});
        boolean actual2 = leetCode.containsDuplicate(new int[] {1,2,3,4});
        boolean actual3 = leetCode.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2});

        Assert.assertTrue(actual1);
        Assert.assertFalse(actual2);
        Assert.assertTrue(actual3);
    }

    @Test
    public void twoSum() {
        int[] actual1 = leetCode.twoSum(new int[] {2,7,11,15}, 9);
        int[] actual2 = leetCode.twoSum(new int[] {3,2,4}, 6);
        int[] actual3 = leetCode.twoSum(new int[] {3,3}, 6);


        int[] expected1 = new int[]{0,1};
        int[] expected2 = new int[]{1,2};
        int[] expected3 = new int[]{0,1};


        Assert.assertArrayEquals(expected1, actual1);
        Assert.assertArrayEquals(expected2, actual2);
        Assert.assertArrayEquals(expected3, actual3);
    }

}
