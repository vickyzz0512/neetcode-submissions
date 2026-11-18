class Solution {
    public boolean hasDuplicate(int[] nums) {

        // nest loop time complexity is O(n * n)
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if(nums[i] == num[j]) {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        // using hashset is O(n)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
        
    }
}