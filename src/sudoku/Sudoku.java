/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ListIterator;
import java.util.Stack;


/**
 *
 * @author Samaritan
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
         //TODO code application logic here
       Stack<SudokuMove> board = new Stack();
       //board.push(new SudokuMove(2,0,0,0));
       board.push(new SudokuMove(9,0,1,0));
       board.push(new SudokuMove(6,0,2,0));
       //board.push(new SudokuMove(5,1,0,0));
       board.push(new SudokuMove(8,1,1,0));
       //board.push(new SudokuMove(4,1,2,0));
       board.push(new SudokuMove(7,2,0,0));
       //board.push(new SudokuMove(1,2,1,0));
       board.push(new SudokuMove(3,2,2,0));
       board.push(new SudokuMove(3,0,0,1));
       //board.push(new SudokuMove(1,0,1,1));
       board.push(new SudokuMove(8,0,2,1));
       board.push(new SudokuMove(9,1,0,1));
       //board.push(new SudokuMove(7,1,1,1));
       board.push(new SudokuMove(2,1,2,1)); 
       board.push(new SudokuMove(6,2,0,1));
       //board.push(new SudokuMove(4,2,1,1));
       board.push(new SudokuMove(5,2,2,1));       
       //board.push(new SudokuMove(5,0,0,2));
       board.push(new SudokuMove(7,0,1,2));
       //board.push(new SudokuMove(4,0,2,2));
       board.push(new SudokuMove(6,1,0,2));
       board.push(new SudokuMove(1,1,1,2));
       board.push(new SudokuMove(3,1,2,2));
       //board.push(new SudokuMove(2,2,0,2));
       board.push(new SudokuMove(8,2,1,2));
       board.push(new SudokuMove(9,2,2,2));
       //board.push(new SudokuMove(6,0,0,3));
       board.push(new SudokuMove(2,0,1,3));
       board.push(new SudokuMove(5,0,2,3));
       //board.push(new SudokuMove(9,1,0,3));
       board.push(new SudokuMove(3,1,1,3));
       //board.push(new SudokuMove(1,1,2,3));
       board.push(new SudokuMove(4,2,0,3));
       board.push(new SudokuMove(7,2,1,3));
       //board.push(new SudokuMove(8,2,2,3));
       board.push(new SudokuMove(8,0,0,4));
       //board.push(new SudokuMove(9,0,1,4));
       board.push(new SudokuMove(7,0,2,4));
       //board.push(new SudokuMove(4,1,0,4));
       board.push(new SudokuMove(2,1,1,4));
       //board.push(new SudokuMove(6,1,2,4));
       board.push(new SudokuMove(5,2,0,4));
       //board.push(new SudokuMove(3,2,1,4));
       board.push(new SudokuMove(1,2,2,4));
       board.push(new SudokuMove(3,0,0,5));
       //board.push(new SudokuMove(4,0,1,5));
       board.push(new SudokuMove(1,0,2,5));
       board.push(new SudokuMove(8,1,0,5));
       //board.push(new SudokuMove(5,1,1,5));       
       board.push(new SudokuMove(7,1,2,5));
       //board.push(new SudokuMove(9,2,0,5));
       board.push(new SudokuMove(2,2,1,5));
       //board.push(new SudokuMove(6,2,2,5));
       board.push(new SudokuMove(1,0,0,6));
       board.push(new SudokuMove(6,0,1,6));
       //board.push(new SudokuMove(7,0,2,6));
       //board.push(new SudokuMove(8,1,0,6));
       board.push(new SudokuMove(5,1,1,6));
       //board.push(new SudokuMove(9,1,2,6));
       board.push(new SudokuMove(3,2,0,6));
       //board.push(new SudokuMove(4,2,1,6));
       board.push(new SudokuMove(2,2,2,6));
       board.push(new SudokuMove(2,0,0,7));
       //board.push(new SudokuMove(5,0,1,7));
       //board.push(new SudokuMove(3,0,2,7));
       board.push(new SudokuMove(7,1,0,7));
       //board.push(new SudokuMove(6,1,1,7));
       board.push(new SudokuMove(4,1,2,7));
       board.push(new SudokuMove(1,2,0,7));
       //board.push(new SudokuMove(8,2,1,7));
       //board.push(new SudokuMove(9,2,2,7));
       board.push(new SudokuMove(4,0,0,8));
       //board.push(new SudokuMove(9,0,1,8));
       board.push(new SudokuMove(8,0,2,8));
       board.push(new SudokuMove(1,1,0,8));
       //board.push(new SudokuMove(3,1,1,8));
       //board.push(new SudokuMove(2,1,2,8));
       board.push(new SudokuMove(7,2,0,8));
       //board.push(new SudokuMove(6,2,1,8));
       board.push(new SudokuMove(5,2,2,8));
       
       
       
       
       SudokuSolver s = new SudokuSolver(board);
       
        if(s.backTrack())
            printStack( s);
        else
            System.out.println("No solution exists");
       
      
}
    public static int[][][] createBoard(SudokuSolver s)
    {
        ListIterator<SudokuMove> sm = s.getMoves().listIterator();
        int[][][] board = new int[9][3][3];
        while(sm.hasNext())
        {
            SudokuMove m = sm.next();
            board[m.group][m.row][m.col] = m.value;
        }
        
        return board;
    }
    
    public static void printBoard(int[][][] board)
    {
        for(int r = 0; r < 3; r++)
        {
            for(int g = r; g < 9; g++)
            {
                for(int c = 0; c < 3; c++)
                    System.out.println(board[g][r][c]+" ");
            }
            
        }
    }
    
    public static void printStack(SudokuSolver s)
    {
        ListIterator<SudokuMove> sm = s.getMoves().listIterator();
        while(sm.hasNext())
        {
            SudokuMove m = sm.next();
            System.out.println("["+m.group+"]["+m.row+"]["+m.col+"] = "+m.value);
        }
    }
}
