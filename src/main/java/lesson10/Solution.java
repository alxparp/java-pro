package lesson10;

import java.util.*;

class Solution {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int dif = 0;

        for (int price : prices) {
            min = Math.min(price, min);
            dif = Math.max(price - min, dif);
        }
        return dif;
    }

    public int maxProfit2(int[] prices) {

        Set<Integer> maxValues = new HashSet<>(List.of(0));
        for (int i = 0; i < prices.length - 1; i++) {
            int current = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                if (temp > current) current = temp;
            }
            maxValues.add(current);
        }

        return Collections.max(maxValues);

    }

    public ListNode reverseList(ListNode head) {
        List<Integer> tempList = new ArrayList<>();
        ListNode nodeTail = null;
        ListNode nodeHead = null;
        while (head != null) {
            tempList.add(head.val);
            head = head.next;
        }
        for (int i = tempList.size()-1; i >= 0; i--) {
            if (nodeTail == null) {
                nodeTail = new ListNode(tempList.get(i));
                nodeHead = nodeTail;
            } else {
                nodeTail.next = new ListNode(tempList.get(i));
                nodeTail = nodeTail.next;
            }
        }
        return nodeHead;
    }
}
