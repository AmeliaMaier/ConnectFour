/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class AI
{

    private final int level;
    private AILevel levelID;
    private Marker playerMarker;
    private Marker aiMarker;

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

    public void SetMarkers(Marker player, Marker ai)
    {
        this.playerMarker = player;
        this.aiMarker = ai;
    }

    public int GetAIMove(char[][] board, int turnCount)
    {
        int move = 0;
        switch (this.level)
        {
            case 1:
                move = RandomAIMove(board);
                break;
            case 2:
                move = WinningAIMove(board, turnCount);
                if (move == 0)
                {
                    move = RandomAIMove(board);
                }
                break;
            case 3:
                move = WinningAIMove(board, turnCount);
                if (move == 0)
                {
                    move = BlockWinningPlayerMove(board, turnCount);
                }
                if (move == 0)
                {
                    move = RandomAIMove(board);
                }
                break;
            case 4:

                move = WinningAIMove(board, turnCount);
                if (move == 0)
                {
                    move = BlockWinningPlayerMove(board, turnCount);
                }
                if (move == 0)
                {
                    move = RandomNotHelpPlayerMove(board);
                }
                if (move == 0)
                {
                    move = RandomAIMove(board);
                }
                break;
        }
        return move;
    }

    private int RandomAIMove(char[][] board)
    {
        Integer[] columnArray =
        {
            0, 1, 2, 3, 4, 5, 6
        };
        Collections.shuffle(Arrays.asList(columnArray));
        for (int x = 0; x < columnArray.length; x++)
        {
            for (int row = board.length - 1; row >= 0; row--)
            {
                if (board[row][columnArray[x]] == Marker.EMPTY.GetMarker())
                {
                    return columnArray[x] + 1;
                }
            }
        }
        return 0;
    }

    private int WinningAIMove(char[][] board, int turnCount)
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
                if (board[row][column] == this.aiMarker.GetMarker())
                {
                    if (row >= 3)
                    {
                        move = CheckUp(board, row, column, this.aiMarker.GetMarker(), 4);
                        if (move != 0)
                        {
                            return move;
                        }
                        if (column <= 3)
                        {
                            move = CheckUpRight(board, row, column, this.aiMarker.GetMarker(), 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                        if (column >= 3)
                        {
                            move = CheckUpLeft(board, row, column, this.aiMarker.GetMarker(), 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                    } else
                    {
                        move = CheckDown(board, row, column, this.aiMarker.GetMarker(), 4);
                        if (move != 0)
                        {
                            return move;
                        }
                        if (column <= 3)
                        {
                            move = CheckDownRight(board, row, column, this.aiMarker.GetMarker(), 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                        if (column >= 3)
                        {
                            move = CheckDownLeft(board, row, column, this.aiMarker.GetMarker(), 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                    }
                    if (column <= 3)
                    {
                        move = CheckRight(board, row, column, this.aiMarker.GetMarker(), 4);
                        if (move != 0)
                        {
                            return move;
                        }
                    }
                    if (column >= 3)
                    {
                        move = CheckLeft(board, row, column, this.aiMarker.GetMarker(), 4);
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

    private int BlockWinningPlayerMove(char[][] board, int turnCount)
    {
        int move = 0;
        if (turnCount < 4)
        {
            return move;
        }
        for (int row = board.length - 1; row >= 0; row--)
        {
            for (int column = board[0].length - 1; column >= 0; column--)
            {
                if (board[row][column] == this.playerMarker.GetMarker())
                {
                    if (row >= 3)
                    {
                        move = CheckUp(board, row, column, this.playerMarker.GetMarker(), 4);
                        if (move != 0)
                        {
                            return move;
                        }
                        if (column <= 3)
                        {
                            move = CheckUpRight(board, row, column, this.playerMarker.GetMarker(), 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                        if (column >= 3)
                        {
                            move = CheckUpLeft(board, row, column, this.playerMarker.GetMarker(), 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                    } else
                    {
                        move = CheckDown(board, row, column, this.playerMarker.GetMarker(), 4);
                        if (move != 0)
                        {
                            return move;
                        }
                        if (column <= 3)
                        {
                            move = CheckDownRight(board, row, column, this.playerMarker.GetMarker(), 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                        if (column >= 3)
                        {
                            move = CheckDownLeft(board, row, column, this.playerMarker.GetMarker(), 4);
                            if (move != 0)
                            {
                                return move;
                            }
                        }
                    }
                    if (column <= 3)
                    {
                        move = CheckRight(board, row, column, this.playerMarker.GetMarker(), 4);
                        if (move != 0)
                        {
                            return move;
                        }
                    }
                    if (column >= 3)
                    {
                        move = CheckLeft(board, row, column, this.playerMarker.GetMarker(), 4);
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

    public int RandomNotHelpPlayerMove(char[][] board)
    {
        char[][] testBoard = new char[board.length][board[0].length];
        for (int x = 0; x < board.length; x++)
        {
            System.arraycopy(board[x], 0, testBoard[x], 0, board[x].length);
        }
        Integer[] columnArray =
        {
            0, 1, 2, 3, 4, 5, 6
        };
        Collections.shuffle(Arrays.asList(columnArray));
        for (int x = 0; x < columnArray.length; x++)
        {
            for (int row = testBoard.length - 1; row >= 0; row--)
            {
                if (testBoard[row][columnArray[x]] == Marker.EMPTY.GetMarker())
                {
                    if (row == testBoard.length - 1 || testBoard[row + 1][columnArray[x]] != Marker.EMPTY.GetMarker())
                    {
                        testBoard[row][columnArray[x]] = this.aiMarker.GetMarker();
                        if (0 == BlockWinningPlayerMove(testBoard, 10))
                        {
                            return columnArray[x] + 1;
                        } else
                        {
                            testBoard[row][columnArray[x]] = Marker.EMPTY.GetMarker();
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int CheckUp(char[][] board, int row, int column, char marker, int countNeeded)
    {
        int skipped = 0;
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row - x][column] != marker)
            {
               
                if (skipped == 0 && board[row - x][column] == Marker.EMPTY.GetMarker() && board[(row - x) + 1][column] != Marker.EMPTY.GetMarker())
                {
                    skipped = column+ 1;
                } else
                {
                    return 0;
                }
            
            }
        }
        return skipped;
    }

    public int CheckUpLeft(char[][] board, int row, int column, char marker, int countNeeded)
    {
        int skipped = 0;
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row - x][column - x] != marker)
            {
                if (skipped == 0 && board[row - x][column - x] == Marker.EMPTY.GetMarker() && board[(row - x) + 1][column - x] != Marker.EMPTY.GetMarker())
                {
                    skipped = column - x + 1;
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
                if (skipped == 0 && board[row - x][column + x] == Marker.EMPTY.GetMarker() && board[(row - x) + 1][column + x] != Marker.EMPTY.GetMarker())
                {
                    skipped = column + x + 1;
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
        int skipped = 0;
        for (int x = 1; x < countNeeded; x++)
        {
            if (board[row + x][column] != marker)
            {
                 if (skipped == 0 && board[row + x][column] == Marker.EMPTY.GetMarker() && board[(row + x) + 1][column] != Marker.EMPTY.GetMarker())
                {
                    skipped = column + 1;
                } else
                {
                    return 0;
                }
            }
        }
        return skipped;
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
