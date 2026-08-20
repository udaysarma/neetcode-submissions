class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            sum += nums[i];
        }

        int totalPredictedSum = numsLength * (numsLength + 1) / 2;
        return totalPredictedSum - sum;
    }
}
