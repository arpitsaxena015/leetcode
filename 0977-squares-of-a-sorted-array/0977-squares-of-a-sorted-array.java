class Solution {
    public int[] sortedSquares(int[] nums) {
        int a = nums.length;

        // Step 1: square every element
        for (int i = 0; i < a; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // Step 2: selection sort
        for (int j = 0; j < a - 1; j++) {
            for (int k = j + 1; k < a; k++) {
                if (nums[j] > nums[k]) {
                    int temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                }
            }
        }

        return nums;
    }
}