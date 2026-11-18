class Solution {
    public boolean isAnagram(String s, String t) {

        // 先判断 s和t的长度是否一样， 如果不一样肯定不是anagram
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);

    }
}
