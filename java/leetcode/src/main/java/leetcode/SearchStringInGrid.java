package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SearchStringInGrid {

    private boolean exist(char[][] board, char[] word, int cStartIndex,  int row,int column, List<Integer> blockedRow, List<Integer> blockedColumn) {
        if (column < 0 || row < 0 || row >= board.length || column >= board[row].length) {
            return false;
        }

        for (int i = 0; i < blockedRow.size(); i++) {
            if (row == blockedRow.get(i) && column == blockedColumn.get(i)) {
                return false;
            }
        }

        if (board[row][column] == word[cStartIndex]) {

            if (cStartIndex == word.length-1){
                return true;
            }

            blockedRow.add(row);
            blockedColumn.add(column);
            if (
                    exist(board, word, cStartIndex+1, row - 1, column, blockedRow, blockedColumn) ||
                            exist(board, word, cStartIndex+1, row, column + 1, blockedRow, blockedColumn)
                            ||
                            exist(board, word, cStartIndex+1, row + 1, column, blockedRow, blockedColumn)
                            ||
                            exist(board, word, cStartIndex+1, row, column - 1, blockedRow, blockedColumn)) {
                return true;
            }

        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == wordArray[0]) {
                    if (1 == wordArray.length){
                        return true;
                    }

                    List<Integer> blockedRow = new ArrayList<>();
                    List<Integer> blockedColumn = new ArrayList<>();
                    blockedRow.add(row);
                    blockedColumn.add(column);

                    if (
                            exist(board, wordArray, 1, row - 1, column, new ArrayList(blockedRow), new ArrayList(blockedColumn))
                                    ||
                                    exist(board, wordArray, 1, row, column + 1, new ArrayList(blockedRow), new ArrayList(blockedColumn))
                                    ||
                                    exist(board, wordArray, 1, row + 1, column, new ArrayList(blockedRow), new ArrayList(blockedColumn))
                                    ||
                                    exist(board, wordArray, 1, row, column - 1, new ArrayList(blockedRow), new ArrayList(blockedColumn))
                    ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

