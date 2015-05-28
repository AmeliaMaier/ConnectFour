/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.Random;

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
            case 4:
                levelID = AILevel.Level4;
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
            case 4:
                //same as 3 except won't set player1 up for win
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
        int move = 0;
        if (turnCount < 6)
        {
            return move;
        }
        for (int row = board.length - 1; row >= 0; row--)
        {
            for (int column = board[0].length - 1; column >= 0; column--)
            {
                if (board[row][column] == marker)
                {
                    if (row >= 3)
                    {
                        move = CheckUp(board, row, column, marker, 4);
                        if (move != 0)
                        {
                            return move;
                        }
                        if (column <= 3)
                        {
                            move = CheckUpRight(board, row, column, marker, 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                        if (column >= 3)
                        {
                            move = CheckUpLeft(board, row, column, marker, 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                    } else
                    {
                        move = CheckDown(board, row, column, marker, 4);
                        if (move != 0)
                        {
                            return move;
                        }
                        if (column <= 3)
                        {
                            move = CheckDownRight(board, row, column, marker, 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                        if (column >= 3)
                        {
                            move = CheckDownLeft(board, row, column, marker, 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                    }
                    if (column <= 3)
                    {
                        move = CheckRight(board, row, column, marker, 4);
                        if (move != 0)
                        {
                            return move;
                        }
                    }
                    if (column >= 3)
                    {
                        move = CheckLeft(board, row, column, marker, 4);
                        if (move != 0)
                        {
                            return move;
                        }
                    }
                }
            }
        }
        return move;
    }

    public int CheckUp(char[][] board, int row, int column, char marker, int countNeeded)
    {
        for (int x = 1; x < countNeeded - 1; x++)
        {
            if (board[row - x][column] != marker)
            {
                return 0;
            }
        }
        return column + 1;
    }

    public int CheckUpLeft(char[][] board, int row, int column, char marker, int countNeeded)
    {
        int skipped = 0;
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row - x][column - x] != marker)
            {
                if (skipped == 0 && board[row - x][column - x] == Marker.EMPTY.GetMarker())
                {
                    if (board[(row - x) + 1][column - x] != Marker.EMPTY.GetMarker())
                    {
                        skipped = column - x + 1;
                    } else
                    {
                        return 0;
                    }
                } else
                {
                    return 0;
                }
            }
        }
        return skipped;
    }

    public int CheckUpRight(char[][] board, int row, int column, char marker, int countNeeded)
    {
        int skipped = 0;
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row - x][column + x] != marker)
            {
                if (skipped == 0 && board[row - x][column + x] == Marker.EMPTY.GetMarker())
                {
                    if (board[(row - x) + 1][column + x] != Marker.EMPTY.GetMarker())
                    {
                        skipped = column + x + 1;
                    } else
                    {
                        return 0;
                    }
                } else
                {
                    return 0;
                }
            }
        }
        return skipped;
    }

    public int CheckDown(char[][] board, int row, int column, char marker, int countNeeded)
    {
        for (int x = 1; x < countNeeded - 1; x++)
        {
            if (board[row + x][column] != marker)
            {
                return 0;
            }
        }
        return column + 1;
    }

    public int CheckDownLeft(char[][] board, int row, int column, char marker, int countNeeded)
    {
        int skipped = 0;
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row + x][column - x] != marker)
            {
                if (skipped == 0 && board[row + x][column - x] == Marker.EMPTY.GetMarker())
                {
                    if ((row + x) == 5 || board[(row + x) + 1][column - x] != Marker.EMPTY.GetMarker())
                    {
                        skipped = column - x + 1;
                    } else
                    {
                        return 0;
                    }
                } else
                {
                    return 0;
                }
            }
        }
        return skipped;
    }

    public int CheckDownRight(char[][] board, int row, int column, char marker, int countNeeded)
    {
        int skipped = 0;
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row + x][column + x] != marker)
            {
                if (skipped == 0 && board[row + x][column + x] == Marker.EMPTY.GetMarker())
                {
                    if ((row + x) == 5 || board[(row + x) + 1][column + x] != Marker.EMPTY.GetMarker())
                    {
                        skipped = column + x + 1;
                    } else
                    {
                        return 0;
                    }
                } else
                {
                    return 0;
                }
            }
        }
        return skipped;
    }

    public int CheckLeft(char[][] board, int row, int column, char marker, int countNeeded)
    {
        int skipped = 0;
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row][column - x] != marker)
            {
                if (skipped == 0 && board[row][column - x] == Marker.EMPTY.GetMarker())
                {
                    if (row == 5 || board[row + 1][column - x] != Marker.EMPTY.GetMarker())
                    {
                        skipped = column - x + 1;
                    } else
                    {
                        return 0;
                    }
                } else
                {
                    return 0;
                }
            }
        }
        return skipped;
    }

    public int CheckRight(char[][] board, int row, int column, char marker, int countNeeded)
    {
        int skipped = 0;
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row][column + x] != marker)
            {
                if (skipped == 0 && board[row][column + x] == Marker.EMPTY.GetMarker())
                {
                    if (row == 5 || board[row + 1][column + x] != Marker.EMPTY.GetMarker())
                    {
                        skipped = column + x + 1;
                    } else
                    {
                        return 0;
                    }
                } else
                {
                    return 0;
                }
            }
        }
        return skipped;
    }

    public String GetDifficultyLevel()
    {
        return levelID.GetLevel();
    }

}
