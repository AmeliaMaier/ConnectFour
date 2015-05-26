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
public enum Marker
{
    MARKER1 ('\u25D9'),
    MARKER2 ('\u2612'),
    MARKER3 ('\u2600'),
    MARKER4 ('\u24CD'),
    MARKER5 ('\u25CE');
    
    private final char marker;
    
    Marker(char marker)
    {
        this.marker = marker;
    }
    
    public char GetMarker()
    {
        return this.marker;
    }
    
    public static char[] GetOptions()
    {
        char[] options = {'\u25D9', '\u2612', '\u2600', '\u24CD', '\u25CE'};
        return options; 
    }
}
