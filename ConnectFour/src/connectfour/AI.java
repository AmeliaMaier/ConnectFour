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
                    move = LevelTwoMoveSkip(board, markerAI, turnCount);
                }
                if (move == 0)
                {
                    move = LevelOneMove();
                }
                break;
            case 3:
                move = LevelTwoMove(board, markerAI, turnCount);
                if (move == 0)
                {
                    move = LevelTwoMoveSkip(board, markerAI, turnCount);
                }
                if (move == 0)
                {
                    move = LevelTwoMove(board, markerPlayer, turnCount);
                }
                if (move == 0)
                {
                    move = LevelTwoMoveSkip(board, markerPlayer, turnCount);
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
        int move = 0;
        if (turnCount < 6)
        {
            return move;
        }
        for (int row = board.length - 1; row >= 0; row--)
        {
            for (int column = board[0].length - 1; column >= 0; column--)
            {
                if (row == 5 || board[row + 1][column] != Marker.EMPTY.GetMarker())
                {
                    if (board[row][column] == Marker.EMPTY.GetMarker())
                    {
                        if (row >= 3)
                        {
                            if (CheckUp(board, row, column, marker, 4))
                            {
                                return column + 1;
                            }
                            if (column <= 3)
                            {
                                if (CheckUpRight(board, row, column, marker, 4))
                                {
                                    return column + 1;
                                }
                            }
                            if (column >= 3)
                            {
                                if (CheckUpLeft(board, row, column, marker, 4))
                                {
                                    return column + 1;
                                }
                            }
                        } else
                        {
                            if (CheckDown(board, row, column, marker, 4))
                            {
                                return column + 1;
                            }
                            if (column <= 3)
                            {
                                if (CheckDownRight(board, row, column, marker, 4))
                                {
                                    return column + 1;
                                }
                            }
                            if (column >= 3)
                            {
                                if (CheckDownLeft(board, row, column, marker, 4))
                                {
                                    return column + 1;
                                }
                            }
                        }
                        if (column <= 3)
                        {
                            if (CheckRight(board, row, column, marker, 4))
                            {
                                return column + 1;
                            }
                        }
                        if (column >= 3)
                        {
                            if (CheckLeft(board, row, column, marker, 4))
                            {
                                return column + 1;
                            }
                        }
                    }
                }
            }
        }
        return move;
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

    private int LevelTwoMoveSkip(char[][] board, char marker, int turnCount)
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
                        if (column <= 3)
                        {
                            move = CheckUpRightSkip(board, row, column, marker, 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                        if (column >= 3)
                        {
                            move = CheckUpLeftSkip(board, row, column, marker, 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                    } else
                    {
                        if (column <= 3)
                        {
                            move = CheckDownRightSkip(board, row, column, marker, 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                        if (column >= 3)
                        {
                            move = CheckDownLeftSkip(board, row, column, marker, 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                    }
                    if (column <= 3)
                    {
                        move = CheckRightSkip(board, row, column, marker, 4);
                        if (move != 0)
                        {
                            return move;
                        }
                    }
                    if (column >= 3)
                    {
                        move = CheckLeftSkip(board, row, column, marker, 4);
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

    public int CheckUpLeftSkip(char[][] board, int row, int column, char marker, int countNeeded)
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

    public int CheckUpRightSkip(char[][] board, int row, int column, char marker, int countNeeded)
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

    public int CheckDownLeftSkip(char[][] board, int row, int column, char marker, int countNeeded)
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

    public int CheckDownRightSkip(char[][] board, int row, int column, char marker, int countNeeded)
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

    public int CheckLeftSkip(char[][] board, int row, int column, char marker, int countNeeded)
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

    public int CheckRightSkip(char[][] board, int row, int column, char marker, int countNeeded)
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
}
