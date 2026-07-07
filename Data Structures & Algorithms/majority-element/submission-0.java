class Solution {
    public int majorityElement(int[] nums) {
        int length=nums.length;
        HashMap<Integer,Integer>freq=new HashMap<>();
        for(int i=0;i<length;i++)
        {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            if(freq.get(nums[i])>length/2)
            return nums[i];
        }
        return 0;
    }
}