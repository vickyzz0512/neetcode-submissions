class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while((right - left + 1) - getMax(map) > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);  
        }
        return maxLen;
        
    }
    // 找出窗口里最多的字母有几个
    private int getMax(Map<Character, Integer> map) {
        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }
        return max;
    }

}
