package leetcode.WordSearch;

/**
 * Created by luyan on 17/4/25.
 */
public class Solutions {

    private boolean isExists = false;

    public static void main(String[] args) {

        Solutions solution = new Solutions();
        System.out.println(solution.exist(new char[][] { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));
        solution = new Solutions();
        System.out.println(solution.exist(new char[][] { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
        solution = new Solutions();
        System.out.println(solution.exist(new char[][] { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));

    }

    private boolean isSimilar(String currentWord, String word) {
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(char[][] board, String currentWord, String word, int x, int y,
            boolean[][] isVisited) {
        if (isExists) {
            return;
        }
        if (!isSimilar(currentWord, word)) {
            return;
        } else {
            if (currentWord.equals(word)) {
                isExists = true;
                return;
            } else {
                if (x < 0 || x > board.length || y < 0 || y > board[0].length) {
                    return;
                }
                if (x + 1 < board.length && isVisited[x + 1][y] == false) {
                    isVisited[x + 1][y] = true;
                    dfs(board, currentWord + board[x + 1][y], word, x + 1, y, isVisited);
                    isVisited[x + 1][y] = false;

                }
                if (x - 1 >= 0 && isVisited[x - 1][y] == false) {
                    isVisited[x - 1][y] = true;
                    dfs(board, currentWord + board[x - 1][y], word, x - 1, y, isVisited);
                    isVisited[x - 1][y] = false;
                }
                if (y - 1 >= 0 && isVisited[x][y - 1] == false) {
                    isVisited[x][y - 1] = true;
                    dfs(board, currentWord + board[x][y - 1], word, x, y - 1, isVisited);
                    isVisited[x][y - 1] = false;
                }
                if (y + 1 < board[x].length && isVisited[x][y + 1] == false) {
                    isVisited[x][y + 1] = true;
                    dfs(board, currentWord + board[x][y + 1], word, x, y + 1, isVisited);
                    isVisited[x][y + 1] = false;
                }
            }
        }
    }

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        boolean[][] isVisited = new boolean[board.length][];

        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = new boolean[board[0].length];
        }
        for (int x = 0; x < isVisited.length; x++) {
            for (int y = 0; y < isVisited[x].length; y++) {
                isVisited[x][y] = false;
            }
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {

            }
        }
        if (board.length > 0 && board[0].length > 0) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    String currentWord = "" + board[x][y];
                    isVisited[x][y] = true;
                    dfs(board, currentWord, word, x, y, isVisited);
                    isVisited[x][y] = false;
                }
            }

        }
        return isExists;
    }
}
