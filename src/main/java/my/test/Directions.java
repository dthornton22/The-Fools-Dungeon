package main.java.my.test;

public class Directions
{

	public enum Direction
	{
		UP, DOWN, LEFT, RIGHT
	}
	private Direction anyDirection;

	/**
	 * @return the anyDirection
	 */
	public Direction getAnyDirection()
	{
		return anyDirection;
	}

	/**
	 * @param anyDirection the anyDirection to set
	 */
	public void setAnyDirection(Direction anyDirection)
	{
		this.anyDirection = anyDirection;
	}

	// change from int to enum
	public void move(Direction newDirection)
	{
		int mylocation[] = new int[2];
		Map anyMap = new Map();
		// Entity.getLocation() = mylocation;
		switch (newDirection)
		{
			case RIGHT: // East (D)
				if (!anyMap.isWall(mylocation[0], (mylocation[1] + 1)))
				{
					mylocation[1] += 1;
				}
				break;
			case UP: // North (W)
				if (!anyMap.isWall((mylocation[0] - 1), mylocation[1]))
				{
					mylocation[0] += 1;
				}
				break;
			case LEFT: // West (A)
				if (!anyMap.isWall(mylocation[0], (mylocation[1] + 1)))
				{
					mylocation[1] += 1;
				}
				break;
			case DOWN: // South (S)
				if (!anyMap.isWall((mylocation[0] - 1), mylocation[1]))
				{
					mylocation[0] += 1;
				}
				break;
		}
	}

}
