/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.xov2;

/**
 *
 * @author informatics
 */
public class XOv2 {

     public static char[][] table = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    public static char turn = 'X';
    public static Scanner sc = new Scanner(System.in);
    public static int row;
    public static int col;
    public static int count = 0;

    public static void main(String[] args) {
        printWelcome();
        while (true) {
            showTable();
            showTurn();
            intpuRowCol();
            if (isfinish()) {
                showTable();
                showPlayerWin();
                break;
            }
            turn = switchTurn(turn);
        }
    }

    public static void printWelcome() {
        System.out.println("Welcome to my XO Game");
    }

    public static void showTable() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(table[r][c] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void showTurn() {
        System.out.println("Turn " + turn);
    }

    public static char switchTurn(char turn) {
        if (turn == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    public static void intpuRowCol() {
        System.out.print("please enter(row,col) : ");
        row = sc.nextInt() - 1;
        col = sc.nextInt() - 1;
        table[row][col] = turn;
        count++;
    }

    public static boolean isfinish() {
        if (checkWin()) {
            return true;
        }
        if (checkDraw()) {
            return true;
        }
        return false;
    }

    public static boolean checkWin() {
        if (checkRow(table, turn, row)) {
            return true;
        }
        if (checkCol()) {
            return true;
        }
        if (checkX()) {
            return true;
        }
        return false;
    }

    public static boolean checkRow(char[][] table, char turn, int row) {
        if (table[row][0] == turn && table[row][1] == turn && table[row][2] == turn) {
            return true;
        }
        return false;
    }

    public static boolean checkCol() {
        if (table[0][col] == turn && table[1][col] == turn && table[2][col] == turn) {
            return true;
        }
        return false;
    }

    public static boolean checkX() {
        if (table[0][2] == turn && table[1][1] == turn && table[2][0] == turn) {
            return true;
        }
        if (table[2][2] == turn && table[1][1] == turn && table[0][0] == turn) {
            return true;
        }
        return false;
    }

    public static boolean checkDraw() {
        if (count == 9) {
            return true;
        }
        return false;
    }

    public static void showPlayerWin() {
        if (checkDraw()) {
            System.out.println("Draw !!!");
        }
        if (checkWin()) {
            System.out.println(turn + " Win!!!");
        }
    }
}
