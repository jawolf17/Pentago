/**
 * A class to pass along specific actions for the AI to take. Initialized to values
 * that can never happen to indicate no action to be taken
 */
package util;

public class Maneuver {
	public int row=-1;
	public int column=-1;
	public char quad = 'z';
	public boolean dir;
}
