class Solution {
    public int lengthOfLongestSubstring(String s) {

        // hashset主要是查重
        Set<Character> windows = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 看hashset里面有没有重复的element
            while (windows.contains(c)) {
                windows.remove(s.charAt(left));
                left++;
            } 
            windows.add(c);
            maxLen = Math.max(maxLen, right - left +1);
        }
        return maxLen;
    }
}
