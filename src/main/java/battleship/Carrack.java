package battleship;

import java.util.List;

/**
 * The type Carrack represents a ship with a size of 3 units.
 * It is positioned on the game board based on its bearing and initial position.
 *
 * Author: britoeabreu
 * Date: 2023-10-10
 * Time: 15:30
 */
public class Carrack extends Ship {

	/**
	 * Instantiates a new Carrack.
	 *
	 * @param bearing The bearing of the ship (NORTH, SOUTH, EAST, or WEST).
	 * @param pos     The initial position of the ship on the game board.
	 */
	public Carrack(Compass bearing, IPosition pos) {
		super("Nau", bearing, pos, 3);

		switch (bearing) {
			case SOUTH:
				for (int rowOffset = 0; rowOffset < this.getSize(); rowOffset++)
					getPositions().add(new Position(pos.getRow() + rowOffset, pos.getColumn()));
				break;
			case NORTH:
				for (int rowOffset = 0; rowOffset < this.getSize(); rowOffset++)
					getPositions().add(new Position(pos.getRow() + rowOffset, pos.getColumn()));
				break;
			case EAST:
				for (int colOffsset = 0; colOffsset < this.getSize(); colOffsset++)
					getPositions().add(new Position(pos.getRow(), pos.getColumn() + colOffsset));
				break;
			case WEST:
				for (int colOffset = 0; colOffset < this.getSize(); colOffset++)
					getPositions().add(new Position(pos.getRow(), pos.getColumn() + colOffset));
				break;
		}
	}
}