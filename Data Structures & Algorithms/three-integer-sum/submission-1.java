class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // step1：sort array 从小到大
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 如果第一个数都大于0了，之后每一个数都大于0
            if (nums[i] > 0) {
                break;
            }
            // i 跳过重复的数字
            if(i > 0 && nums[i] == nums[i - 1]) {
               continue; 
            }
            int l = i + 1;
            int r = nums.length - 1; 
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if(sum < 0) {
                    l++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // l跳过重复的数字
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    // r跳过重复的数字
                    while(l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
        return result;    
    }
}
