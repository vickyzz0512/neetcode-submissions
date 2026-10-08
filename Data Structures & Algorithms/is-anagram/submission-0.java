class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        if (s.length() != t.length()) 
            return false; 
    
        for (char c : charArrayS) {
            countS.put(c, countS.getOrDefault(c, 0) + 1);
        }

        for (char c : charArrayT) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        return countS.equals(countT);

    }
}
