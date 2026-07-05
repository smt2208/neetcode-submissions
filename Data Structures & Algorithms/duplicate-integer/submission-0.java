class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer>freq=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        for(int value:freq.values())
        {
            if(value>1)
            return true;
        }
        return false;
    }
}