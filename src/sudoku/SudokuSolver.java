/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 *
 * @author Samaritan
 */
public class SudokuSolver {
 
    Stack<SudokuMove> moves;
    public SudokuSolver(List<SudokuMove> initialBoard)
    {
        moves = new Stack();
        ListIterator<SudokuMove> board = initialBoard.listIterator();
        while(board.hasNext())
        { 
            moves.push(board.next());
        }
    }
    
public boolean isValid()
 {
    if(moves.isEmpty())
        return true;
    
    SudokuMove last = moves.pop();
    ListIterator<SudokuMove> options = moves.listIterator();
    
    while(options.hasNext())
    {
      SudokuMove move = options.next();
      if(move.value == last.value)
      {
            if(move.group == last.group)
            {
                moves.push(last);
                return false;
            }

            else if(last.group % 3 == move.group % 3 && last.col == move.col)
            {
                moves.push(last);
                return false;
            }
            else
            {
                int start = (last.group / 3) * 3;
                int end = start + 2;
                if(start <= move.group && move.group <= end && last.row == move.row)
                {
                    moves.push(last);
                    return false;
                }                    
            }
      }
    }
    moves.push(last);
    return true;
 }

    public List<SudokuMove> getFrontier()
    {
        List<SudokuMove> frontier = new ArrayList(81);
        for(int g = 0; g < 9; g++)
        {
            for(int r = 0; r < 3; r++)
            {
                 for(int c = 0; c < 3; c++)
                 {
                    boolean filled = false;
                    ListIterator<SudokuMove> occupied = moves.listIterator();
                    while(occupied.hasNext())
                    {
                        SudokuMove next = occupied.next();
                        if(next.group == g && next.col == c && next.row == r)
                        {
                            filled = true;
                            break;
                        }
                    }

                    if(!filled)
                    {
                        for(int i = 1; i < 10 ; i++)
                        {
                            frontier.add(new SudokuMove(i,r,c,g));
                        }
                    }
                 }
            }
        }   

        return frontier;
    }

    public boolean Solved()
    {
        return moves.size() == 81; 
    }
    
    public boolean backTrack()
    {
        if(!isValid())
            return false;
        
        if(Solved())
            return true;
        
        ListIterator<SudokuMove> frontier = getFrontier().listIterator();
        while(frontier.hasNext())
        {
            SudokuMove next = frontier.next();
            moves.push(next);
            if(backTrack())
            {   
                System.out.println("Done");
                return true;
            }
            moves.pop();
        }
        return false;
    }
    
    public Stack<SudokuMove> getMoves()
    {
        return moves;
    }

    /*public boolean validTest(SudokuMove s)
    {
    moves.push(s);
    boolean valid = isValid();
    moves.pop();
    return valid;
}*/
}    

