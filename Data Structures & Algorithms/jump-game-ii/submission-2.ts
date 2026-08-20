class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    jump(nums: number[]): number {
        const number_of_nums = nums.length;
        let jumpsArray = new Array(number_of_nums);

        for (let i = number_of_nums - 1; i >= 0; i--) {
            if (i === number_of_nums - 1) {
                jumpsArray[number_of_nums - 1] = 0;
                continue;
            }

            if (nums[i] === 0) {
                jumpsArray[i] = Number.MAX_SAFE_INTEGER;
                continue;
            }

            if (nums[i] + i >= number_of_nums - 1) {
                jumpsArray[i] = 1;
                continue;
            }

            jumpsArray[i] = this.getMin(nums, jumpsArray, i);
        }

        return jumpsArray[0];
    }

    getMin(nums: number[], jumpsArray: number[], index: number): number {
        let minJumps = Number.MAX_SAFE_INTEGER;
        for (let i = index + 1; i < index + 1 + nums[index]; i++) {
            if (minJumps > jumpsArray[i]) minJumps = jumpsArray[i];
        }
        return minJumps + 1;
    }
}
