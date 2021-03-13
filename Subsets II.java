/*


Subsets II

https://leetcode.com/problems/subsets-ii/

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10


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
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = (int)(Math.pow(2, nums.length));
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<List<Integer>> list = new ArrayList<List<Integer>>(n);
        for(int num = 0;num < n;num++){
            String t = intToBinaryString(num, nums.length);
            List<Integer> temp = new ArrayList<Integer>();
            for(int j = 0;j < t.length();j++){
                if(t.charAt(j) == '1'){
                    temp.add(nums[j]);
                }
            }
            Collections.sort(temp);
            set.add(temp);
        }
        for(List<Integer> l : set){
            list.add(l);
        }
        return list;
    }
}
