class Solution {
    public int[] getConcatenation(int[] nums) {
        int ans[]=new int[2*nums.length];
        int c=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            ans[i]=nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(c==2*nums.length)
            break;
            ans[c]=nums[i];
            c++;
        }
        return ans;
    }
}