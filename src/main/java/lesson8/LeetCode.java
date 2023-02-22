package lesson8;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {

    public boolean isPalindrome(String phrase) {
        phrase = phrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int phraseLength = phrase.length();
        int halfPhraseLength = (int)Math.floor(phraseLength >> 1);

        for (int i=0; i<halfPhraseLength; i++) {
            if (phrase.charAt(i) != phrase.charAt(phraseLength-i-1))
                return false;
        }

        return true;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length > distNums.size();
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target && j != i) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

}
