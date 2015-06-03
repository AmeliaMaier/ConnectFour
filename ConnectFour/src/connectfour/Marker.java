/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Lia
 */
public enum Marker
{
    MARKER1 ('\u25D9'),
    MARKER2 ('\u2612'),
    MARKER3 ('\u2600'),
    MARKER4 ('\u24CD'),
    MARKER5 ('\u25CE'),
    EMPTY ('\u2591');
    
    private final char marker;
    
    Marker(char marker)
    {
        this.marker = marker;
    }
    
    public char GetMarker()
    {
        return this.marker;
    }
    
    public static String[] GetOptions()
    {
        String[] options = {"\u25D9", "\u2612", "\u2600", "\u24CD", "\u25CE"};
        return options; 
    }
    
    public static String[] GetOptions(int remove)
    {
        String[] options = {"\u25D9", "\u2612", "\u2600", "\u24CD", "\u25CE"};
        List<String> list = new ArrayList<>(Arrays.asList(options));
        list.remove(remove);
        options = list.toArray(new String[0]);        
        return options; 
    }
}
