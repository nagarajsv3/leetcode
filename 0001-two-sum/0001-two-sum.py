class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        num_ind_map = {}

        for index,num in enumerate(nums):
            if (target - num) in num_ind_map:
                return [index, num_ind_map[target - num]]
            else:
                num_ind_map[num] = index
                 


        