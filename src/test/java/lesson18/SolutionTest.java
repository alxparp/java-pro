package lesson18;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void maxProfit() {
        Solution solution = new Solution();

        Assert.assertEquals(solution.romanToInt("XXXVIII"), 38);
        Assert.assertEquals(solution.romanToInt("XLVIII"), 48);
        Assert.assertEquals(solution.romanToInt("XCIX"), 99);
        Assert.assertEquals(solution.romanToInt("CCXCIX"), 299);
        Assert.assertEquals(solution.romanToInt("DCCXCIV"), 794);
        Assert.assertEquals(solution.romanToInt("MMMCMXCIX"), 3999);

    }

}
