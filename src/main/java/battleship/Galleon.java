package battleship;

/**
 * The type Galleon represents a ship with a size of 5 units.
 * It is positioned on the game board based on its bearing and initial position.
 * The Galleon has a unique shape depending on its orientation.
 *
 * Author: britoeabreu
 * Date: 2023-10-10
 * Time: 15:30
 */
public class Galleon extends Ship {

	public static final int TOP_ROW_LENGTH = 3;
	public static final int VERTICAL_PART_LENGTH = 2;
	public static final int HORIZONTAL_PART_LENGTH = 4;

	/**
	 * Instantiates a new Galleon.
	 *
	 * @param bearing The bearing of the ship (NORTH, SOUTH, EAST, or WEST).
	 * @param pos     The initial position of the ship on the game board.
	 */
	public Galleon(Compass bearing, IPosition pos) {
		super("Galeao", bearing, pos, 5);

		switch (bearing) {
			case NORTH:
				fillNorth(pos);
				break;
			case EAST:
				fillEast(pos);
				break;
			case SOUTH:
				fillSouth(pos);
				break;
			case WEST:
				fillWest(pos);
				break;
		}
	}

	/**
	 * Fills the positions of the Galleon when oriented to the NORTH.
	 *
	 * @param pos The initial position of the ship.
	 */

	private void fillNorth(IPosition pos) {
		for (int i = 0; i < TOP_ROW_LENGTH; i++) {
			getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
		}
		getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
		getPositions().add(new Position(pos.getRow() + VERTICAL_PART_LENGTH, pos.getColumn() + 1));
	}

	/**
	 * Fills the positions of the Galleon when oriented to the SOUTH.
	 *
	 * @param pos The initial position of the ship.
	 */
	private void fillSouth(IPosition pos) {
		for (int i = 0; i < VERTICAL_PART_LENGTH; i++) {
			getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
		}
		for (int j = VERTICAL_PART_LENGTH; j < 5; j++) {
			getPositions().add(new Position(pos.getRow() + VERTICAL_PART_LENGTH, pos.getColumn() + j - TOP_ROW_LENGTH));
		}
	}

	/**
	 * Fills the positions of the Galleon when oriented to the EAST.
	 *
	 * @param pos The initial position of the ship.
	 */
	private void fillEast(IPosition pos) {
		getPositions().add(new Position(pos.getRow(), pos.getColumn()));
		for (int i = 1; i < HORIZONTAL_PART_LENGTH; i++) {
			getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - TOP_ROW_LENGTH));
		}
		getPositions().add(new Position(pos.getRow() + VERTICAL_PART_LENGTH, pos.getColumn()));
	}

	/**
	 * Fills the positions of the Galleon when oriented to the WEST.
	 *
	 * @param pos The initial position of the ship.
	 */
	private void fillWest(IPosition pos) {
		getPositions().add(new Position(pos.getRow(), pos.getColumn()));
		for (int i = 1; i < HORIZONTAL_PART_LENGTH; i++) {
			getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
		}
		getPositions().add(new Position(pos.getRow() + VERTICAL_PART_LENGTH, pos.getColumn()));
	}
}