/*


78. Subsets

https://leetcode.com/problems/subsets/


Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.




*/


class Solution {
    
    private String intToBinaryString(int i, int length){
        int q = -1,r = -1;
        int index = 0;
        char array[] = new char[length];
        int d = i;
        while(q != 0){
            q = d / 2;
            r = d % 2;
            if(r == 0){
                array[index++] = '0';
            }else{
                array[index++] = '1';
            }
            d = q;
        }
        while(index < length){
            array[index++] = '0';    
        }
        String s = new String(array);
        return s;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        int n = (int)(Math.pow(2, nums.length));
        List<List<Integer>> list = new ArrayList<List<Integer>>(n);
        for(int num = 0;num < n;num++){
            String t = intToBinaryString(num, nums.length);
            List<Integer> temp = new ArrayList<Integer>();
            for(int j = 0;j < t.length();j++){
                if(t.charAt(j) == '1'){
                    temp.add(nums[j]);
                }
            }
            list.add(temp);
        }
        return list;
    }
}
