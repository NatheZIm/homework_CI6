package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // <kieu bien > tenbien
//        int a = 1;
//        int b = 2;
//        float c = (float)a / (float)b ;
//        System.out.println(c);
//        String s = "Hello ";
//        String s1 = "Mathafaka";
//        String s3 = s + s1;
//        System.out.println(s3);
//

        // IF - ELSE
//        int a = 2;
//        boolean result = true; // !result = false
//        if (a == 3){
//            System.out.println("YO !!");
//        }
//        else
//        {
//            System.out.println("Not cool man ! ");
//        }
//        int a = 4 ;
//        switch(a){
//            case 1 :
//                System.out.println("This is case 1 ");
//                break;
//            case 2:
//                System.out.println("This is case 2 ");
//                break;
//            case 3:
//                System.out.println("This is case 3 ");
//                break;
//            default: // ko co case thoa man thi in ra dong` nay`
//                System.out.println("This is none case ");
//                break;
//        }

        // LOOP
//        int a = 1;
//        while(a < 0 ){
//            System.out.println(a);
//            a++;
//        }
//        do {
//
//            System.out.println(a);
//            a++;
//        }
//        while(a<0);
        //ARRAY
//        int[] array = new int[10]; // khai báo mảng
//        int [] list = {1,2,3,4,5,6,7,8,9,10}; // khai báo mảng cố định
//        List<String> another_list = new ArrayList<>();
//        another_list.add("a");
//        another_list.add("b");
//        another_list.add("c");
//        another_list.add(2,"d");
//        String s = another_list.get(0);
//        for (int i = 0 ; i < another_list.size() ; i++){
//            System.out.println(another_list.get(i));
//        }
//        for (int i = 0 ; i < array.length ; i++){   // cho giá trị vào mảng
//            array[i] = i;
//        }
//        for (int element : array){  // trả lại giá trị
//            System.out.println(element);
//        }

        // NHẬP VÀO TỪ BÀN PHÍM
//        Scanner n = new Scanner(System.in);
//        int a = n.nextInt();
//        double b = n.nextDouble();
//        String s = n.next();
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(s);

        String[][] board = {{"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"}};
//        ArrayList<Point> positions = new ArrayList<>();
//        for(int i = 0 ; i < board.length ; i++){
//            for(int j = 0 ; j < board[i].length ; j++){
//                positions.add(Point j,i);
//            }
//        }
        int p_x = 2;
        int p_y = 3;


        while (true) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[p_x][p_y] = "P";
                }
            }

                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }

                System.out.println("Nhap w,a,s,d de di chuyen :");
                Scanner scanner = new Scanner(System.in);
                String key = scanner.next();

                switch (key) {
                    case "w":
                        if (p_x == 0) {
                            p_x = 3 ;
                            board[p_x][p_y] = "P";
                            board[0][p_y] = "*";
                        } else {
                            p_x = p_x - 1;
                            board[p_x][p_y] = "P";
                            board[p_x + 1][p_y] = "*";
                        }
                        break;

                    case "d":
                        if (p_y == board.length - 1 ) {
                            p_y = 0 ;
                            board[p_x][p_y] = "P";
                            board[p_x][board.length - 1 ] = "*";
                        } else {
                            p_y = p_y + 1;
                            board[p_x][p_y] = "P";
                            board[p_x][p_y - 1 ] = "*";
                        }
                        break;

                    case "s":
                        if (p_x == board.length - 1 ) {
                            p_x = 0 ;
                            board[p_x][p_y] = "P";
                            board[board.length - 1][p_y] = "*";
                        } else {
                            p_x = p_x + 1;
                            board[p_x][p_y] = "P";
                            board[p_x - 1][p_y] = "*";
                        }
                        break;

                    case "a":
                        if (p_y == 0 ) {
                            p_y = 3;
                            board[p_x][p_y] = "P";
                            board[p_x][0] = "*";
                        } else {
                            p_y = p_y - 1;
                            board[p_x][p_y] = "P";
                            board[p_x][p_y + 1] = "*";
                        }
                        break;
                }
            }
        }
    }




