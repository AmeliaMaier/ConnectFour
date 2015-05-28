/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lia
 */
public class AIIT
{
    
    public AIIT()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of GetAIMove method, of class AI.
     */
    @Test
    public void testGetAIMove()
    {
        System.out.println("GetAIMove");
        char[][] board = null;
        char markerAI = ' ';
        char markerPlayer = ' ';
        int turnCount = 0;
        AI instance = null;
        int expResult = 0;
        int result = instance.GetAIMove(board, markerAI, markerPlayer, turnCount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckUp method, of class AI.
     */
    @Test
    public void testCheckUp()
    {
        System.out.println("CheckUp");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        boolean expResult = false;
        boolean result = instance.CheckUp(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckUpLeft method, of class AI.
     */
    @Test
    public void testCheckUpLeft()
    {
        System.out.println("CheckUpLeft");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        boolean expResult = false;
        boolean result = instance.CheckUpLeft(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckUpRight method, of class AI.
     */
    @Test
    public void testCheckUpRight()
    {
        System.out.println("CheckUpRight");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        boolean expResult = false;
        boolean result = instance.CheckUpRight(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckDown method, of class AI.
     */
    @Test
    public void testCheckDown()
    {
        System.out.println("CheckDown");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        boolean expResult = false;
        boolean result = instance.CheckDown(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckDownLeft method, of class AI.
     */
    @Test
    public void testCheckDownLeft()
    {
        System.out.println("CheckDownLeft");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        boolean expResult = false;
        boolean result = instance.CheckDownLeft(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckDownRight method, of class AI.
     */
    @Test
    public void testCheckDownRight()
    {
        System.out.println("CheckDownRight");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        boolean expResult = false;
        boolean result = instance.CheckDownRight(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckLeft method, of class AI.
     */
    @Test
    public void testCheckLeft()
    {
        System.out.println("CheckLeft");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        boolean expResult = false;
        boolean result = instance.CheckLeft(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckRight method, of class AI.
     */
    @Test
    public void testCheckRight()
    {
        System.out.println("CheckRight");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        boolean expResult = false;
        boolean result = instance.CheckRight(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetDifficultyLevel method, of class AI.
     */
    @Test
    public void testGetDifficultyLevel()
    {
        System.out.println("GetDifficultyLevel");
        AI instance = null;
        String expResult = "";
        String result = instance.GetDifficultyLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckUpLeftSkip method, of class AI.
     */
    @Test
    public void testCheckUpLeftSkip()
    {
        System.out.println("CheckUpLeftSkip");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        int expResult = 0;
        int result = instance.CheckUpLeftSkip(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckUpRightSkip method, of class AI.
     */
    @Test
    public void testCheckUpRightSkip()
    {
        System.out.println("CheckUpRightSkip");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        int expResult = 0;
        int result = instance.CheckUpRightSkip(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckDownLeftSkip method, of class AI.
     */
    @Test
    public void testCheckDownLeftSkip()
    {
        System.out.println("CheckDownLeftSkip");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        int expResult = 0;
        int result = instance.CheckDownLeftSkip(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckDownRightSkip method, of class AI.
     */
    @Test
    public void testCheckDownRightSkip()
    {
        System.out.println("CheckDownRightSkip");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        int expResult = 0;
        int result = instance.CheckDownRightSkip(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckLeftSkip method, of class AI.
     */
    @Test
    public void testCheckLeftSkip()
    {
        System.out.println("CheckLeftSkip");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        int expResult = 0;
        int result = instance.CheckLeftSkip(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckRightSkip method, of class AI.
     */
    @Test
    public void testCheckRightSkip()
    {
        System.out.println("CheckRightSkip");
        char[][] board = null;
        int row = 0;
        int column = 0;
        char marker = ' ';
        int countNeeded = 0;
        AI instance = null;
        int expResult = 0;
        int result = instance.CheckRightSkip(board, row, column, marker, countNeeded);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
