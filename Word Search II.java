/*

Word Search II

212. Word Search II

https://leetcode.com/problems/word-search-ii/

Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

*/

class Solution {
    private boolean DFS(char[][] board, boolean[][] visited, int u, int v, String word, int index){
        if(u < 0 || u >= board.length || v < 0 || v >= board[0].length || visited[u][v] == true || index >= word.length() || board[u][v] != word.charAt(index)){
            return false;
        }else{
            if(board[u][v] == word.charAt(index) && (index == (word.length() - 1))){
                return true;
            }else{
                visited[u][v] = true;
                boolean flag = DFS(board, visited, u + 1, v, word, index + 1) ||
                    DFS(board, visited, u - 1, v, word, index + 1) ||
                    DFS(board, visited, u, v + 1, word, index + 1) ||
                    DFS(board, visited, u, v - 1, word, index + 1);
                
                visited[u][v] = false;
                return flag;
            }
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new LinkedList<String>();
        for(int i = 0;i < words.length;i++){
            
            boolean visited[][] = new boolean[board.length][board[0].length];
            for(int j = 0;j < board.length;j++){
                for(int k = 0;k < board[0].length;k++){
                    visited[j][k] = false;
                }
            }
            boolean word_flag = false;
            for(int j = 0;j < board.length;j++){
                for(int k = 0;k < board[0].length;k++){
                    if(DFS(board, visited, j, k, words[i], 0) == true){
                        list.add(words[i]);
                        word_flag = true;
                        break;
                    }
                }
                if(word_flag)
                    break;
            }
        }
        return list;
    }
}

