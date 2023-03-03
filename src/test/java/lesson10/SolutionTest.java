package lesson10;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void maxProfit() {
        Solution solution = new Solution();

        int[][] data = new int[][] {
                {solution.maxProfit(new int[] {4,2,7,1}), 5},
                {solution.maxProfit(new int[] {8,9,1,2,5,3}), 4},
                {solution.maxProfit(new int[] {7,1,5,3,6,4}), 5},
                {solution.maxProfit(new int[] {7,6,4,3,1}), 0},
                {solution.maxProfit(new int[] {}), 0},
                {solution.maxProfit(new int[] {7,1,5,2,3,6,8,4}), 7},
                {solution.maxProfit(new int[] {7,2,9,5,3,6,8,4,11}), 9}
        };

        for (int[] datum : data) {
            Assert.assertEquals(datum[1], datum[0]);
        }
    }

    @Test
    public void reverseListTest() {
        Solution solution = new Solution();

        ListNode tail = null;
        ListNode head = null;
        int[] expected = new int[10];
        int[] actual = new int[10];

        for (int i = 0; i < expected.length; i++) {
            if (tail == null) {
                tail = new ListNode(i);
                head = tail;
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
            expected[i] = expected.length - i - 1;
        }

        ListNode reverse = solution.reverseList(head);

        int i = 0;
        while ((reverse != null)) {
            actual[i++] = reverse.val;
            reverse = reverse.next;
        }


        Assert.assertArrayEquals(expected, actual);
    }

}
