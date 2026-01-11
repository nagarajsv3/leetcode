class Solution(object):
    def twosum_brute(self, numbers, target):
        arr_len = len(numbers)
        for i in range(arr_len):
            for j in range(i+1, arr_len):
                if (numbers[i] + numbers[j] == target):
                    return [i+1, j+1]

    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        #return self.twosum_brute(numbers, target)
        
        i = 0
        j = len(numbers)-1
        while(i < j):
            if (numbers[i] + numbers[j] == target):
                return [i+1, j+1]
            elif (numbers[i] + numbers[j] < target):
                i = i+1
            elif (numbers[i] + numbers[j] > target):
                j = j-1
        
        #TC O(n)
        #SC O(1)
            


        