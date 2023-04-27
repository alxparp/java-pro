package lesson18;

class Solution {
    public int romanToInt(String s) {

        String[] romNums = new String[] {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] arabNums = new int[] {1, 4, 5, 9};

        int result = 0;
        for (int i = s.length()-1, romInd = 0, arabInd = 0; i>=0; ) {
            int romNumLen = romNums[romInd].length()-1;
            if (i-romNumLen >= 0 && s.substring(i-romNumLen,i+1).equals(romNums[romInd])) {
                result += arabNums[arabInd%arabNums.length]*Math.pow(10, romInd/4);
                i -= (romNumLen+1);
                if (romNumLen==0) continue;
            }
            romInd++; arabInd++;
        }
        return result;
    }
}
