class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            // 跳过左边的非字母数字字符 （isLetterOrDigit）用来判断一个char是不是字母或者数字
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            //跳过右边的非字母数字字符
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            // 忽略大小写
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
}
