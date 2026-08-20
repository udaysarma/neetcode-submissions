class Solution {
    public int missingNumber(int[] nums) {
        int numsLength = nums.length;
        int predictedSum = numsLength * (numsLength + 1) / 2;
        for (int i = 0; i < numsLength; i++) {
            predictedSum -= nums[i];
        }

        return predictedSum;
    }
}
