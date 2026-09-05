class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        while(true)//detect cycle
        {
            slow=nums[slow];
            fast=nums[fast];//fast incremented two times
            fast=nums[fast];
            if(slow==fast)//there is a cycle
            {
                fast=0;
                while(fast!=slow)
                {
                    slow=nums[slow];
                    fast=nums[fast];
                }
                return slow;
            }
        }
        
    }
}