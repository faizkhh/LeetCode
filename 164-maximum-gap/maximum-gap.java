class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0;

        int gap = (int) Math.ceil((double)(max - min) / (n - 1));
        int size = (max - min) / gap + 1;

        int[] bMin = new int[size];
        int[] bMax = new int[size];
        boolean[] used = new boolean[size];

        Arrays.fill(bMin, Integer.MAX_VALUE);
        Arrays.fill(bMax, Integer.MIN_VALUE);

        for (int num : nums) {
            int idx = (num - min) / gap;
            bMin[idx] = Math.min(bMin[idx], num);
            bMax[idx] = Math.max(bMax[idx], num);
            used[idx] = true;
        }

        int res = 0, prev = min;
        for (int i = 0; i < size; i++) {
            if (!used[i]) continue;
            res = Math.max(res, bMin[i] - prev);
            prev = bMax[i];
        }

        return res;
    }
}