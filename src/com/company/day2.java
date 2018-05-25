package com.company;

public class day2 {
    public static void main(String[] args) {
        String[][] board = {{"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"}};
        // Hàm
        /// <kieu tra ve > [ten ham] (tham so )
        int a = 2;
        int b = 5;
        int c = add(a,b);
        System.out.println(c);
    }
    static void printMap (String[][]board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    static int add(int x , int y){
        return x + y ;
    }
}
