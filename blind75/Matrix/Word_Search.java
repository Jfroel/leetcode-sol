// Time: O(n*m*4^len)
// space: O(len), no more visited 2d array but still have stack frames

// in place
class Solution {
  public boolean exist(char[][] board, String word) {
      int n = board.length;
      int m = board[0].length;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (dfs(board, word, 0, i, j)) {
            return true;
          }
        }
      }
      return false;
  }
  private boolean dfs(char[][] board, String word, int index, int i, int j) {
    // check if off board
    if (i < 0 || i >= board.length) return false;
    if (j < 0 || j >= board[0].length) return false;
    // have we already used this tile
    if (board[i][j] == '*') return false;

    // check the word
    char original = board[i][j];
    if (index == word.length()-1 && word.charAt(index) == original) return true;
    if (word.charAt(index) != original) return false;

    // check neighbors
    board[i][j] = '*';
    boolean found = false;
    if (dfs(board, word, index+1, i+1, j)) {
      found = true;
    } else if (dfs(board, word, index+1, i-1, j)) {
      found = true;
    } else if (dfs(board, word, index+1, i, j+1)) {
      found = true;
    } else if (dfs(board, word, index+1, i, j-1)) {
      found = true;
    } 
    board[i][j] = original;
    return found;
  }
}