/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.Random;

/**
 * Level 1 = AI works randomly Level 2 = AI checks if possible to win this turn,
 * otherwise Level 1 Level 3 = Level 2, otherwise blocks player 1 if possible
 * for player 1 to win next turn, otherwise Level 1 Level 4 = Level 3, but makes
 * sure not setting player 1 up to win with piece placement Level 5 and up =
 * need more research
 */
public class AI
{

    private final int level;
    private char[][] board;

    public AI(int level)
    {
        this.level = level;
    }

    public int GetAIMove(char[][] board, char marker, int turnCount)
    {
        this.board = board;
        int move = -1;
        switch (level)
        {
            case 1:
                move = LevelOneMove();
                break;
            case 2:
                move = LevelTwoMove(marker, turnCount);
                break;
        }
        return move;
    }

    private int LevelOneMove()
    {
        Random random = new Random();
        return (random.nextInt(5) + 1);
    }

    private int LevelTwoMove(char marker, int turnCount)
    {
        int move = -1;
        //AI checks if possible to win this turn, otherwise Level 1 
        for (int row = this.board.length - 1; row > 0; row++)
        {
            for (int column = 0; column < this.board[0].length; column++)
            {
                if (this.board[row][column] == Marker.EMPTY.GetMarker())
                {
                    if (WinCondition(turnCount, marker, row, column))
                    {
                        return column;
                    }
                }
            }
        }
        return move;
    }

    public boolean WinCondition(int turnCount, char marker, int row, int column)
    {
        if (turnCount <= 6)
        {
            return false;
        }

        if (row >= 3)
        {
            if (CheckUp(row, column, marker))
            {
                return true;
            }
            if (column <= 3)
            {
                if (CheckUpRight(row, column, marker))
                {
                    return true;
                }
            }
            if (column >= 3)
            {
                if (CheckUpLeft(row, column, marker))
                {
                    return true;
                }
            }
        } else
        {
            if (CheckDown(row, column, marker))
            {
                return true;
            }
            if (column <= 3)
            {
                if (CheckDownRight(row, column, marker))
                {
                    return true;
                }
            }
            if (column >= 3)
            {
                if (CheckDownLeft(row, column, marker))
                {
                    return true;
                }
            }
        }
        if (column <= 3)
        {
            if (CheckRight(row, column, marker))
            {
                return true;
            }
        }
        if (column >= 3)
        {
            if (CheckLeft(row, column, marker))
            {
                return true;
            }
        }
        return false;
    }

    public boolean CheckUp(int row, int column, char possibleWinner)
    {
        for (int x = 1; x < 4; x++)
        {
            if (this.board[row - x][column] != possibleWinner)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckUpLeft(int row, int column, char possibleWinner)
    {
        for (int x = 1; x < 4; x++)
        {
            if (this.board[row - x][column - x] != possibleWinner)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckUpRight(int row, int column, char possibleWinner)
    {
        for (int x = 1; x < 4; x++)
        {
            if (this.board[row - x][column + x] != possibleWinner)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckDown(int row, int column, char possibleWinner)
    {
        for (int x = 1; x < 4; x++)
        {
            if (this.board[row + x][column] != possibleWinner)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckDownLeft(int row, int column, char possibleWinner)
    {
        for (int x = 1; x < 4; x++)
        {
            if (this.board[row + x][column - x] != possibleWinner)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckDownRight(int row, int column, char possibleWinner)
    {
        for (int x = 1; x < 4; x++)
        {
            if (this.board[row + x][column + x] != possibleWinner)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckLeft(int row, int column, char possibleWinner)
    {
        for (int x = 1; x < 4; x++)
        {
            if (this.board[row][column - x] != possibleWinner)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckRight(int row, int column, char possibleWinner)
    {
        for (int x = 1; x < 4; x++)
        {
            if (this.board[row][column + x] != possibleWinner)
            {
                return false;
            }
        }
        return true;
    }

}
