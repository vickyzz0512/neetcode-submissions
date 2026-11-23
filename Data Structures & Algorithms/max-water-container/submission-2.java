class Solution {
    public int maxArea(int[] heights) {

        // 解题思路： 因为 area = w * h，所以我们从最宽的地方开始看， 
        //又因为高度是取较小的那个高度， 所以当我们在两根柱子里面发现了较小的那一根就可以安全的舍弃

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
     
        while(left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            maxArea = Math.max (maxArea, width * height);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
        
    }
}
