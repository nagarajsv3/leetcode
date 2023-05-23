package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.array.validsudoku;

public class ValidSudokuMain {

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        isValidSudoku(board);
    }

    private static boolean isValidSudoku(char[][] array) {
        boolean isValidSudoku = false;

        //Iterate Over Column
        for(int j=0;j<=8;j++){

            //Iterate Over Row
            for(int i=0;i<=8;i++){

                char item = array[i][j];

                if(!duplicatedInCurrentRow(item, i, j, array)){
                    if(!duplicatedInCurrentColumn(item, i, j, array)){
                        if(!duplicatedInSubBox(item, i, j, array)){
                            isValidSudoku = true;
                        }
                    }
                }
            }

        }

        return isValidSudoku;

    }

    private static boolean duplicatedInSubBox(char item, int rowPos, int colPos, char[][] array) {
        return false;
    }

    private static boolean duplicatedInCurrentColumn(char item, int rowPos, int colPos, char[][] array) {
        return false;
    }

    private static boolean duplicatedInCurrentRow(char item, int rowPos, int colPos, char[][] array) {
        boolean duplicated = true;

        for(int i=0;i<rowPos;i++){
            if(item == array[i][colPos]){
                System.out.print("Item "+item+"is duplicated");
                return duplicated;
            }
        }

        for(int i=rowPos+1;i<=8;i++){
            if(item == array[i][colPos]){
                System.out.print("Item "+item+"is duplicated");
                return duplicated;
            }
        }

        duplicated=false;

        return duplicated;
    }


}
