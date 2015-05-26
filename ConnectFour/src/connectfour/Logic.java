/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 * check for win check for full board check if move valid place marker for each
 * move
 */
public class Logic
{

    private char[][] board;
    private Marker player1;
    private Marker player2;
    private int turnCount;

    public Logic()
    {
        //board [high] then [wide] or [row][column]
        this.board = new char[6][7];
        SetBoardEmpty();
        turnCount = 0;
    }

    public void SetBoardEmpty()
    {
        for (int x = 0; x < this.board.length; x++)
        {
            for (int y = 0; y < this.board[0].length; y++)
            {
                board[x][y] = '\u2591';
            }
        }
    }

    public char[][] GetBoard()
    {
        return this.board;
    }

    public int GetTurnCount()
    {
        return this.turnCount;
    }

    public void SetMarkers(int player1, int player2)
    {
        switch (player1)
        {
            case 1:
                this.player1 = Marker.MARKER1;
                break;
            case 2:
                this.player1 = Marker.MARKER2;
                break;
            case 3:
                this.player1 = Marker.MARKER3;
                break;
            case 4:
                this.player1 = Marker.MARKER4;
                break;
            case 5:
                this.player1 = Marker.MARKER5;
                break;
        }
        switch (player2)
        {
            case 1:
                this.player2 = Marker.MARKER1;
                break;
            case 2:
                this.player2 = Marker.MARKER2;
                break;
            case 3:
                this.player2 = Marker.MARKER3;
                break;
            case 4:
                this.player2 = Marker.MARKER4;
                break;
            case 5:
                this.player2 = Marker.MARKER5;
                break;
        }
    }

    public char GetPlayer1()
    {
        return player1.GetMarker();
    }

    public char GetPlayer2()
    {
        return player2.GetMarker();
    }

    public boolean PlaceMarker(int move)
    {
        char marker;
        if (turnCount % 2 == 0)
        {
            marker = player1.GetMarker();
        } else
        {
            marker = player2.GetMarker();
        }

        for (int row = this.board.length - 1; row >= 0; row--)
        {
            if (this.board[row][move - 1] == '\u2591')
            {
                this.board[row][move - 1] = marker;
                turnCount++;
                return true;
            }
        }
        return false;
    }

    /**
     * returns true if the turn count is greater than or equal to 42 because
     * only 42 markers can fit on the board
     *
     * otherwise returns false because there are still open spaces
     */
    public boolean BoardFull()
    {
        return turnCount >= 42;
    }

    /**
     * checks if the current player has completed a set of 4 returns true if
     * they have returns false automatically until turn 7 because it is
     * impossible to win before this
     *
     * @return
     */
    public boolean WinCondition()
    {
        char possibleWinner;
        if (turnCount <= 6)
        {
            return false;
        }
        if (turnCount % 2 == 1)
        {
            possibleWinner = player1.GetMarker();
        } else
        {
            possibleWinner = player2.GetMarker();
        }
        for (int row = this.board.length - 1; row >= 0; row--)
        {
            for (int column = this.board[0].length - 1; column >= 0; column--)
            {
                if (this.board[row][column] == possibleWinner)
                {
                    if (row >= 3)
                    {
                        if (CheckUp(row, column, possibleWinner))
                        {
                            return true;
                        }
                        if (column <= 3)
                        {
                            if (CheckUpRight(row, column, possibleWinner))
                            {
                                return true;
                            }
                        }
                        if (column >= 3)
                        {
                            if (CheckUpLeft(row, column, possibleWinner))
                            {
                                return true;
                            }
                        }
                    } else
                    {
                        if (CheckDown(row, column, possibleWinner))
                        {
                            return true;
                        }
                        if (column <= 3)
                        {
                            if (CheckDownRight(row, column, possibleWinner))
                            {
                                return true;
                            }
                        }
                        if (column >= 3)
                        {
                            if (CheckDownLeft(row, column, possibleWinner))
                            {
                                return true;
                            }
                        }
                    }
                    if (column <= 3)
                    {
                        if (CheckRight(row, column, possibleWinner))
                        {
                            return true;
                        }
                    }
                    if (column >= 3)
                    {
                        if (CheckLeft(row, column, possibleWinner))
                        {
                            return true;
                        }
                    }
                }
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
