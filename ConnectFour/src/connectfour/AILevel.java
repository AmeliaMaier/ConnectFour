/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author Lia
 */
public enum AILevel
{
    Level1 ("Random Moves"),
    Level2 ("Easy"),
    Level3 ("Medium");
    private final String level;
    
    AILevel(String level)
    {
        this.level = level;
    }
    
    public String GetLevel()
    {
        return this.level;
    }
    
    public static String[] GetOptions()
    {
        String[] levelOptions = {"Random Moves", "Easy", "Medium"};
        return levelOptions;
    }
}
