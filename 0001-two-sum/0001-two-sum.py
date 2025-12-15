class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for index, num in enumerate(nums):
            if (target-num) in seen:
                return [index, seen.get(target-num)] 
            seen[num] = index
        return [-1, -1]
        
        #TC - O(N)
        #SC - O(N)
        