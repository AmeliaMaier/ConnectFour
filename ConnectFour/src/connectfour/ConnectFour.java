/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Lia
 */
public class ConnectFour
{

    char[][] gameBoard;
    Logic logic;
    Scanner input;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ConnectFour game = new ConnectFour();
    }

    public ConnectFour()
    {
        OutputLine();
        System.out.println("\ufe34 Welcome to Connect Four \ufe34");
        OutputLine();
        do
        {
            Initialize();
            GetMarkerSelection();
            RunOneGame();

        } while (PlayAgain());
    }

    private void OutputLine()
    {
        System.out.println("\uFE4F\uFE4F\uFE4F\uFE4F\uFE4F\uFE4F\uFE4F\uFE4F"
                + "\uFE4F\uFE4F\uFE4F\uFE4F\uFE4F\uFE4F\uFE4F\uFE4F\uFE4F");
    }

    private void Initialize()
    {
        //gameboard high, then wide
        this.logic = new Logic();
        this.gameBoard = logic.GetBoard();
        this.input = new Scanner(System.in);
    }

    /**
     * Gets user to select the marker for player1 and player2 passes them to
     * Logic
     */
    private void GetMarkerSelection()
    {
        int player1 = 0;
        int player2 = 0;
        char[] markerOptions = Marker.GetOptions();
        do
        {
            System.out.printf("Please select a marker for player %s.\n",
                    (player1 == 0 ? "1" : "2"));
            for (int x = 0; x < markerOptions.length; x++)
            {
                if (player1 == x + 1)
                {
                    System.out.print((x + 1) + ".  This option is already taken by player 1.\n");
                } else
                {
                    System.out.print((x + 1) + ". " + markerOptions[x] + "\n");
                }
            }
            try
            {
                if (player1 == 0)
                {
                    player1 = input.nextInt();
                    if (player1 < 1 || player1 > 5)
                    {
                        System.out.print("Please only enter a number 1-5.\n");
                        player1 = 0;
                    }
                } else
                {
                    player2 = input.nextInt();
                    if (player2 < 1 || player2 > 5)
                    {
                        System.out.print("Please only enter a number 1-5.\n");
                        player2 = 0;
                    }
                }
            } catch (InputMismatchException e)
            {
                System.out.print("Please only enter a number 1-5.\n");
                input.nextLine();
            }
            if (player1 == player2 && player1 != 0)
            {
                System.out.print("Please choose a different marker. "
                        + "Player 1 is already using that one.");
                player2 = 0;
            }
        } while (player1 == 0 || player2 == 0);
        logic.SetMarkers(player1, player2);
    }

    private void RunOneGame()
    {
        boolean gameOver = false;
        do
        {
            GetMove();
            if (this.logic.WinCondition())
            {
                OutputLine();
                OutputLine();
                System.out.printf("Congragulations. Player %s is the winner!\n",
                        (this.logic.GetTurnCount() % 2 == 1 ? "1" : "2"));
                OutputBoard();
                gameOver = true;
            } else if (this.logic.BoardFull())
            {
                OutputLine();
                OutputLine();
                System.out.println("The board is full. This game is a draw.");
                OutputBoard();
                gameOver = true;
            }
        } while (!gameOver);
    }

    private void GetMove()
    {
        int move = -1;
        OutputLine();
        OutputBoard();
        do
        {
            try
            {
                System.out.printf("PLAYER %s\n" + "Please enter your move.\n",
                        (this.logic.GetTurnCount() % 2 == 0 ? "1" : "2"));
                do
                {
                    System.out.print("Chose a column to place your marker in.");
                    move = input.nextInt();
                    if (move < 1 || move > 7)
                    {
                        System.out.println("Please only enter a number 1-7.");
                    }
                } while (move < 1 || move > 7);
            } catch (InputMismatchException e)
            {
                System.out.println("Please only enter a number 1-7.");
                input.nextLine();
            }
            if (move > 0 && move < 8)
            {
                if (!this.logic.PlaceMarker(move))
                {
                    System.out.println("That is not a valid move.");
                    move = -1;
                }
            }
        } while (move == -1);
    }

    /**
     * prints out the playing board with grey shading for empty spots and with
     * player markers in place
     *
     * COME BACK TO MAKE LOOK BETTER
     */
    private void OutputBoard()
    {
        int arrayRow = 0;
        int arrayColumn = 0;

        for (int row = 0; row <= 13; row++)
        {
            for (int column = 0; column <= 14; column++)
            {
                if (row == 0)
                {
                    if (column == 14)
                    {
                        System.out.print(" \n");
                    } else if (column % 2 == 0)
                    {
                        System.out.print("  ");
                    } else
                    {
                        System.out.print(column / 2 + column % 2);
                    }
                } else if (row == 1)
                {
                    if (column == 0)
                    {
                        System.out.print("\u250f");
                        //upper left curve \u250f
                    } else if (column == 14)
                    {
                        System.out.print("\u2513\n");
                        //upper right curve \u2513
                    } else if (column % 2 == 1)
                    {
                        System.out.print("\u2501");
                        //straight across \u2501
                    } else
                    {
                        System.out.print("\u2533");
                        //across and down \u2533
                    }
                } else if (row == 13)
                {
                    if (column == 0)
                    {
                        System.out.print("\u2517");
                        //bottom left curve \u2517
                    } else if (column == 14)
                    {
                        System.out.print("\u251b\n");
                        //bottom right curve \u251b
                    } else if (column % 2 == 1)
                    {
                        System.out.print("\u2501");
                        //straight across \u2501
                    } else
                    {
                        System.out.print("\u253b");
                        //across and up \u253b
                    }
                } else if (row % 2 == 1)
                {
                    if (column == 0)
                    {
                        System.out.print("\u2523");
                        //up and to right \u2523
                    } else if (column == 14)
                    {
                        System.out.print("\u252b\n");
                        //up and to left \u252b
                    } else if (column % 2 == 1)
                    {
                        System.out.print("\u2501");
                        //straight across \u2501
                    } else
                    {
                        System.out.print("\u254B");
                        //cross \u254b
                    }

                } else
                {
                    if (column == 14)
                    {
                        System.out.print("\u2503\n");
                        //straight up \u2503
                    } else if (column % 2 == 0)
                    {
                        System.out.print("\u2503");
                        //straight up \u2503
                    } else
                    {
                        System.out.print(this.gameBoard[arrayRow][arrayColumn]);
                        arrayColumn++;
                    }
                }
            }
            if (arrayColumn != 0)
            {
                arrayColumn = 0;
                arrayRow++;
            }
        }
    }

    private boolean PlayAgain()
    {
        char playAgain = ' ';
        do
        {
            try
            {
                System.out.print("Do you want to play again? (Y/N)");
                playAgain = input.next().toUpperCase().charAt(0);
            } catch (InputMismatchException e)
            {
                System.out.println("Please only enter a letter.");
                input.nextLine();
            }
        } while (playAgain != 'Y' && playAgain != 'N');
        return (playAgain == 'Y');
    }
}
