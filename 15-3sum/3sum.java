class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        // Step 1: Sort to handle duplicates easily
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int target = -nums[i];
            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int complement = target - nums[j];
                if (set.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], complement, nums[j]);
                    result.add(triplet);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
    }
}