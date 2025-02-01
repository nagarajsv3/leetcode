class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        val_idx_dict = {}
        for i in range(len(nums)):
            if val_idx_dict.get(target - nums[i]) is not None:
                return [i, val_idx_dict.get(target - nums[i])]
            val_idx_dict[nums[i]] = i