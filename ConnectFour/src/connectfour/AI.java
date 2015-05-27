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
    private AILevel levelID;

    public AI(int level)
    {
        this.level = level;
        switch (level)
        {
            case 1:
                levelID = AILevel.Level1;
                break;
            case 2:
                levelID = AILevel.Level2;
                break;
            case 3:
                levelID = AILevel.Level3;
                break;
        }
    }

    public int GetAIMove(char[][] board, char markerAI, char markerPlayer, int turnCount)
    {
        int move = 0;
        switch (level)
        {
            case 1:
                move = LevelOneMove();
                break;
            case 2:
                move = LevelTwoMove(board, markerAI, turnCount);
                if (move == 0)
                {
                    move = LevelOneMove();
                }
                break;
            case 3:
                move = LevelTwoMove(board, markerAI, turnCount);
                if (move == 0)
                {
                    move = LevelTwoMove(board, markerPlayer, turnCount);
                }
                if (move == 0)
                {
                    move = LevelOneMove();
                }
                break;
        }
        return move;
    }

    private int LevelOneMove()
    {
        Random random = new Random();
        return (random.nextInt(6) + 1);
    }

    private int LevelTwoMove(char[][] board, char marker, int turnCount)
    {
        //AI checks if possible to win this turn, otherwise Level 1 
        if(turnCount <6)
        {
            return 0;
        }
        for (int row = board.length - 1; row >= 0; row--)
        {
            for (int column = board[0].length - 1; column >= 0; column--)
            {
                System.out.println("row: " + row + "  column: " + column);
                if (board[row][column] == Marker.EMPTY.GetMarker())
                {
                    if (row >= 3)
                    {
                        if (CheckUp(board, row, column, marker, 4))
                        {
                            return column;
                        }
                        if (column <= 3)
                        {
                            if (CheckUpRight(board, row, column, marker, 4))
                            {
                                return column;
                            }
                        }
                        if (column >= 3)
                        {
                            if (CheckUpLeft(board, row, column, marker, 4))
                            {
                                return column;
                            }
                        }
                    } else
                    {
                        if (CheckDown(board, row, column, marker, 4))
                        {
                            return column;
                        }
                        if (column <= 3)
                        {
                            if (CheckDownRight(board, row, column, marker, 4))
                            {
                                return column;
                            }
                        }
                        if (column >= 3)
                        {
                            if (CheckDownLeft(board, row, column, marker, 4))
                            {
                                return column;
                            }
                        }
                    }
                    if (column <= 3)
                    {
                        if (CheckRight(board, row, column, marker, 4))
                        {
                            return column;
                        }
                    }
                    if (column >= 3)
                    {
                        if (CheckLeft(board, row, column, marker, 4))
                        {
                            return column;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public boolean CheckUp(char[][] board, int row, int column, char marker, int countNeeded)
    {
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row - x][column] != marker)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckUpLeft(char[][] board, int row, int column, char marker, int countNeeded)
    {
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row - x][column - x] != marker)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckUpRight(char[][] board, int row, int column, char marker, int countNeeded)
    {
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row - x][column + x] != marker)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckDown(char[][] board, int row, int column, char marker, int countNeeded)
    {
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row + x][column] != marker)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckDownLeft(char[][] board, int row, int column, char marker, int countNeeded)
    {
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row + x][column - x] != marker)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckDownRight(char[][] board, int row, int column, char marker, int countNeeded)
    {
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row + x][column + x] != marker)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckLeft(char[][] board, int row, int column, char marker, int countNeeded)
    {
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row][column - x] != marker)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckRight(char[][] board, int row, int column, char marker, int countNeeded)
    {
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row][column + x] != marker)
            {
                return false;
            }
        }
        return true;
    }
    
    public String GetDifficultyLevel()
    {
        return levelID.GetLevel();
    }

}
