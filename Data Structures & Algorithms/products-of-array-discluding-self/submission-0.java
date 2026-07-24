public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1, zeroCount = 0;
        for (int num : nums) {
            if (num != 0) {
                prod *= num;//first calculating the prod of non zero numbers
            } else {
                zeroCount++; //now calculating the zero count
            }
        }

        if (zeroCount > 1) {
            return new int[nums.length];//if zero count >1 then all prod zero returning an array with filled zero
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                res[i] = (nums[i] == 0) ? prod : 0;//only the element which is zero will have the product
            } else {
                res[i] = prod / nums[i];//non zeroes just divide total prod with the current element.
            }
        }
        return res;
    }
}