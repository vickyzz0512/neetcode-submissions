class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        // Step1: 统计每个数字出现的次数
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        // Step2: 用list里面的keys 去result里面找value再sort得到排好的keys
        List<Integer> keys = new ArrayList<>(count.keySet());
        keys.sort((a,b) -> count.get(b) - count.get(a));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keys.get(i);
        }

        return result;
    }
}
