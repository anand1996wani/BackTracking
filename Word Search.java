/*

Word Search

79. Word Search

https://leetcode.com/problems/word-search/

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Note: There will be some test cases with a board or a word larger than constraints to test if your solution is using pruning.


*/

class Solution {
    private boolean DFS(char [][]board, boolean [][] visited, int u, int v, String word, int index){
        if(u < 0 || u >= board.length || v < 0 || v >= board[0].length || visited[u][v] == true || index >= word.length() || board[u][v] != word.charAt(index)){
            return false;
        }else{
            if(board[u][v] == word.charAt(index) && index == (word.length() -  1)){
                return true;
            }
            visited[u][v] = true;
            boolean flag = DFS(board, visited, u + 1, v, word, index + 1) ||
                DFS(board, visited, u - 1, v, word, index + 1) ||
                DFS(board, visited, u, v + 1, word, index + 1) ||
                DFS(board, visited, u, v - 1, word, index + 1);
            
            visited[u][v] = false;
            return flag;
        }
    } 
    
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                visited[i][j] = false;
            }
        }
        
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(DFS(board, visited, i, j, word, 0) == true){
                    return true;
                }        
            }
        }
        
        return false;
    }
}
