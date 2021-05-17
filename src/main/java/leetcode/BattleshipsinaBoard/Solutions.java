package leetcode.BattleshipsinaBoard;

/**
 * Created by luyan on 17/3/6.
 */
public class Solutions {

    public static int countBattleships(char[][] board) {

        int res = 0;
        for (int row = 0; row < board.length; row++) {

            for (int column = 0; column < board[row].length; column++) {

                if (board[row][column] == 'X') {
                    board[row][column] = '-';
                    res++;
                    checkColumn(board, row+1, column);
                    checkRow(board, row, column+1);
                }

            }
        }
        return res;

    }

    /**
     * 纵向比较,查找每一列,row+1
     * @param board
     * @param row
     * @param column
     */
    private static void checkColumn(char[][] board, int row, int column) {
        if (row < board.length && board[row][column] == 'X') {
            board[row][column] = '-';
            checkColumn(board, row + 1, column);
        }

    }

    /**
     * 横向比较,查找每一行,column+1
     * @param board
     * @param row
     * @param column
     */
    private static void checkRow(char[][] board, int row, int column) {

        if (column < board[row].length && board[row][column] == 'X') {
            board[row][column] = '-';
            checkRow(board, row, column + 1);
        }
    }

    public static void main(String[] args) {
        char[][] board = { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' },
                { '.', '.', '.', 'X' } };
        System.out.println(countBattleships(board));
        board = new char[][] {{'X','X','X'}};
        System.out.println(countBattleships(board));
    }
}
