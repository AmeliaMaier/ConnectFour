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

    public Logic()
    {
        //board [high] then [wide] or [row][column]
        this.board = new char[6][7];
        SetBoardEmpty();
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
    
    public void SetMarkers(int player1, int player2)
    {
        switch(player1)
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
        switch(player2)
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
}
