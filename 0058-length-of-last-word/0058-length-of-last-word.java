class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] splitarr = s.split(" ");
        return splitarr[splitarr.length-1].length();
    }
}