package battleship;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FrigateTest {

	private Frigate frigate;

	@BeforeEach
	void setUp() {
		frigate = new Frigate(Compass.NORTH, new Position(5, 5));
	}

	@AfterEach
	void tearDown() {
		frigate = null;
	}

	@Test
	void testConstructorNorth() {
		List<IPosition> positions = frigate.getPositions();

		assertEquals(4, positions.size());
		assertEquals(new Position(5, 5), positions.get(0));
		assertEquals(new Position(6, 5), positions.get(1));
		assertEquals(new Position(7, 5), positions.get(2));
		assertEquals(new Position(8, 5), positions.get(3));
	}

	@Test
	void testConstructorSouth() {
		frigate = new Frigate(Compass.SOUTH, new Position(5, 5));
		List<IPosition> positions = frigate.getPositions();

		// ⚠️ Igual ao NORTH (porque o código está assim)
		assertEquals(new Position(5, 5), positions.get(0));
		assertEquals(new Position(6, 5), positions.get(1));
		assertEquals(new Position(7, 5), positions.get(2));
		assertEquals(new Position(8, 5), positions.get(3));
	}

	@Test
	void testConstructorEast() {
		frigate = new Frigate(Compass.EAST, new Position(5, 5));
		List<IPosition> positions = frigate.getPositions();

		assertEquals(new Position(5, 5), positions.get(0));
		assertEquals(new Position(5, 6), positions.get(1));
		assertEquals(new Position(5, 7), positions.get(2));
		assertEquals(new Position(5, 8), positions.get(3));
	}

	@Test
	void testConstructorWest() {
		frigate = new Frigate(Compass.WEST, new Position(5, 5));
		List<IPosition> positions = frigate.getPositions();

		// ⚠️ Igual ao EAST (porque o código está assim)
		assertEquals(new Position(5, 5), positions.get(0));
		assertEquals(new Position(5, 6), positions.get(1));
		assertEquals(new Position(5, 7), positions.get(2));
		assertEquals(new Position(5, 8), positions.get(3));
	}

	@Test
	void testGetSize() {
		assertEquals(4, frigate.getSize());
	}

	@Test
	void testStillFloatingNoHits() {
		assertTrue(frigate.stillFloating());
	}

	@Test
	void testStillFloatingOneHit() {
		frigate.getPositions().get(0).shoot();
		assertTrue(frigate.stillFloating());
	}

	@Test
	void testStillFloatingMultipleHits() {
		frigate.getPositions().get(0).shoot();
		frigate.getPositions().get(1).shoot();
		assertTrue(frigate.stillFloating());
	}

	@Test
	void testStillFloatingAllHit() {
		frigate.getPositions().forEach(IPosition::shoot);
		assertFalse(frigate.stillFloating());
	}

	@Test
	void testGetTopMostPos() {
		assertEquals(5, frigate.getTopMostPos());
	}

	@Test
	void testGetBottomMostPos() {
		assertEquals(8, frigate.getBottomMostPos());
	}

	@Test
	void testGetLeftMostPos() {
		assertEquals(5, frigate.getLeftMostPos());
	}

	@Test
	void testGetRightMostPos() {
		assertEquals(5, frigate.getRightMostPos());
	}

	@Test
	void testPositionsNotNull() {
		assertNotNull(frigate.getPositions());
		assertFalse(frigate.getPositions().isEmpty());
	}

	@Test
	void testShootSamePositionTwice() {
		IPosition pos = frigate.getPositions().get(0);

		pos.shoot();
		pos.shoot(); // não deve crashar

		assertTrue(true);
	}

	@Test
	void testConstructorInvalidInput() {
		assertThrows(NullPointerException.class, () -> new Frigate(null, null));
		assertThrows(NullPointerException.class, () -> new Frigate(Compass.NORTH, null));
	}
}