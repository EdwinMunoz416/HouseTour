/*
 * Step 5: before you start exploring you need DIRECTION... enum
 * represents a group of constants, which can help us navigate in game and better readability
 */
package move;

public enum Direction {
	NORTH,
	SOUTH,
	EAST,
	WEST;
	// instead of return -1 we can write .NOEXIT for less confusion
	public static final int NOEXIT = -1;
}
