/*

Permutations of a given string

https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1#

Given a string S. The task is to print all permutations of a given string.

Example 1:

Input: ABC
Output:
ABC ACB BAC BCA CAB CBA
Explanation:
Given string ABC has permutations in 6 
forms as ABC, ACB, BAC, BCA, CAB and CBA .
Example 2:

Input: ABSG
Output:
ABGS ABSG AGBS AGSB ASBG ASGB BAGS 
BASG BGAS BGSA BSAG BSGA GABS GASB 
GBAS GBSA GSAB GSBA SABG SAGB SBAG 
SBGA SGAB SGBA
Explanation:
Given string ABSG has 24 permutations.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function find_permutaion() which takes the string S as input parameter and returns a vector of string in lexicographical order.

 

Expected Time Complexity: O(n! * n)

Expected Space Complexity: O(n)

 

Constraints:
1 <= length of string <= 5


*/


class Solution {
    List<String> list;
    
    public Solution(){
        list = new LinkedList<String>();
    }
    
    private String swap(String S, int i, int j){
        char[] array = S.toCharArray();
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        String t = new String(array);
        return t;
    }
    
    private void find_p(String S, int counter){
        if(counter < (S.length() - 1)){
            int i = counter;
            for(int j = i;j < S.length();j++){
                String temp = swap(S, i, j);
                find_p(temp, counter + 1);
            }
        }else{
            this.list.add(S);
        }
    }
    
    public List<String> find_permutation(String S) {
        // Code here
        find_p(S, 0);
        Collections.sort(this.list);
        return this.list;
    }
}
