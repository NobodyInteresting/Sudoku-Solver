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
public class SudokuMove {
    public int value;
    public int row;
    public int col;
    public int group;
    
    public SudokuMove(int v, int r, int c, int g)
    {
        value = v;
        row = r;
        col = c;
        group = g;
        
    }
    
    public void loadBoard(Stack<SudokuMove> moves, int board[][][])
    {
        ListIterator<SudokuMove> reserve = moves.listIterator();
        while(reserve.hasNext())
        {
            SudokuMove next = reserve.next();
            board[next.group][next.row][next.col] = next.value;
        }
    }
    
    public void print()
    {
        System.out.println("value: " + value + " row: " + row + " column: " + col + " group: " + group);
    }
    
}

