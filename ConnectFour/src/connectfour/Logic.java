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
    private String[] markerOptions;

    public Logic()
    {
        //board [high] then [wide] or [row][column]
        this.board = new char[6][7];
        SetBoardEmpty();
        turnCount = 0;
    }

    private void SetBoardEmpty()
    {
        for (char[] board1 : this.board)
        {
            for (int y = 0; y < this.board[0].length; y++)
            {
                board1[y] = Marker.EMPTY.GetMarker();
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

    public String [] SetMarkerOptions(String[] markerOptions)
    {
        this.markerOptions = markerOptions;
        return markerOptions;
    }

    public void SetMarkerPlayer1(int player1)
    {
        switch (this.markerOptions[player1].charAt(0))
        {
            case '\u25D9':
                this.player1 = Marker.MARKER1;
                break;
            case '\u2612':
                this.player1 = Marker.MARKER2;
                break;
            case '\u2600':
                this.player1 = Marker.MARKER3;
                break;
            case '\u24CD':
                this.player1 = Marker.MARKER4;
                break;
            case '\u25CE':
                this.player1 = Marker.MARKER5;
                break;
        }
    }

    public void SetMarkerPlayer2(int player2)
    {
        switch (this.markerOptions[player2].charAt(0))
        {
            case '\u25D9':
                this.player2 = Marker.MARKER1;
                break;
            case '\u2612':
                this.player2 = Marker.MARKER2;
                break;
            case '\u2600':
                this.player2 = Marker.MARKER3;
                break;
            case '\u24CD':
                this.player2 = Marker.MARKER4;
                break;
            case '\u25CE':
                this.player2 = Marker.MARKER5;
                break;
        }
    }

    public String [] GetAIOptions()
    {
        String[] options = {"Yes","No"};
        return options;
    }
    public char GetPlayer1()
    {
        return player1.GetMarker();
    }

    public char GetPlayer2()
    {
        return player2.GetMarker();
    }

    public int GetAIMove(AI ai)
    {
        ai.SetMarkers(player1, player2);
        return ai.GetAIMove(this.board, this.turnCount);
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
            if (this.board[row][move - 1] == Marker.EMPTY.GetMarker())
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
     *
     * @return
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
