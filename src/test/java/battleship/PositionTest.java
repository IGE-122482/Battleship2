package battleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@DisplayName("Testes da classe Position")
public class PositionTest {
	private Position position;

	@BeforeEach
	void setUp() {
		position = new Position(2, 3);
	}

	@AfterEach
	void tearDown() {
		position = null;
	}

	@Test
	@DisplayName("Construtor com int cria posição corretamente")
	void constructor() {
		Position pos = new Position(1, 1);
		assertNotNull(pos);
		assertEquals(1, pos.getRow());
		assertEquals(1, pos.getColumn());
		assertFalse(pos.isOccupied());
		assertFalse(pos.isHit());
	}

	@Test
	@DisplayName("Construtor com char cria posição corretamente")
	void constructorChar() {
		Position pos = new Position('C', 4);
		assertEquals(2, pos.getRow());
		assertEquals(3, pos.getColumn());
	}

	@Test
	@DisplayName("Construtor com char minúsculo funciona")
	void constructorCharLowercase() {
		Position pos = new Position('c', 4);
		assertEquals(2, pos.getRow());
	}

	@Test
	@DisplayName("randomPosition gera posição válida")
	void randomPosition() {
		Position pos = Position.randomPosition();
		assertNotNull(pos);
		assertTrue(pos.isInside());
	}

	@Test
	@DisplayName("getRow retorna a linha correta")
	void getRow() {
		assertEquals(2, position.getRow());
	}

	@Test
	@DisplayName("getColumn retorna a coluna correta")
	void getColumn() {
		assertEquals(3, position.getColumn());
	}

	@Test
	@DisplayName("getClassicRow retorna letra correta")
	void getClassicRow() {
		assertEquals('C', position.getClassicRow());
	}

	@Test
	@DisplayName("getClassicColumn retorna coluna +1")
	void getClassicColumn() {
		assertEquals(4, position.getClassicColumn());
	}

	@Test
	@DisplayName("Posição (0,0) é válida")
	void isValid1() {
		position = new Position(0, 0);
		assertTrue(position.isInside());
	}

	@Test
	@DisplayName("Posição com linha negativa é inválida")
	void isValid2() {
		position = new Position(-1, 5);
		assertFalse(position.isInside());
	}

	@Test
	@DisplayName("Posição com coluna negativa é inválida")
	void isValid3() {
		position = new Position(5, -1);
		assertFalse(position.isInside());
	}

	@Test
	@DisplayName("Posição com linha >= BOARD_SIZE é inválida")
	void isValid4() {
		position = new Position(Game.BOARD_SIZE, 5);
		assertFalse(position.isInside());
	}

	@Test
	@DisplayName("Posição com coluna >= BOARD_SIZE é inválida")
	void isValid5() {
		position = new Position(5, Game.BOARD_SIZE);
		assertFalse(position.isInside());
	}

	@Test
	@DisplayName("Posição adjacente horizontal")
	void isAdjacentTo1() {
		Position other = new Position(2, 4);
		assertTrue(position.isAdjacentTo(other));
	}

	@Test
	@DisplayName("Posição adjacente vertical")
	void isAdjacentTo2() {
		Position other = new Position(3, 3);
		assertTrue(position.isAdjacentTo(other));
	}

	@Test
	@DisplayName("Posição adjacente diagonal")
	void isAdjacentTo3() {
		Position other = new Position(3, 4);
		assertTrue(position.isAdjacentTo(other));
	}

	@Test
	@DisplayName("Posição não adjacente")
	void isAdjacentTo4() {
		Position other = new Position(4, 5);
		assertFalse(position.isAdjacentTo(other));
	}

	@Test
	@DisplayName("adjacentPositions retorna 8 vizinhos no meio do tabuleiro")
	void adjacentPositions() {
		List<IPosition> adjacents = position.adjacentPositions();
		assertEquals(8, adjacents.size());
	}

	@Test
	@DisplayName("adjacentPositions em canto retorna menos vizinhos")
	void adjacentPositionsCorner() {
		Position corner = new Position(0, 0);
		List<IPosition> adjacents = corner.adjacentPositions();
		assertTrue(adjacents.size() < 8);
	}

	@Test
	@DisplayName("isOccupied após occupy()")
	void isOccupied() {
		assertFalse(position.isOccupied());
		position.occupy();
		assertTrue(position.isOccupied());
	}

	@Test
	@DisplayName("isHit após shoot()")
	void isHit() {
		assertFalse(position.isHit());
		position.shoot();
		assertTrue(position.isHit());
	}

	@Test
	@DisplayName("Posições iguais são equals")
	void equals1() {
		Position same = new Position(2, 3);
		assertTrue(position.equals(same));
	}

	@Test
	@DisplayName("Position não equals a null")
	void equals2() {
		assertFalse(position.equals(null));
	}

	@Test
	@DisplayName("Position não equals a objeto de outro tipo")
	void equals3() {
		Object other = new Object();
		assertFalse(position.equals(other));
	}

	@Test
	@DisplayName("Posições com linha igual mas coluna diferente não são equals")
	void equals4() {
		Position other = new Position(2, 4);
		assertFalse(position.equals(other));
	}

	@Test
	@DisplayName("Uma posição é equals a si própria")
	void equals5() {
		assertTrue(position.equals(position));
	}

	@Test
	@DisplayName("hashCode consistente para posições iguais")
	void hashCodeConsistency() {
		Position same = new Position(2, 3);
		assertEquals(position.hashCode(), same.hashCode());
	}

	@Test
	@DisplayName("toString retorna formato C4")
	void toStringFormat() {
		assertEquals("C4", position.toString());
	}
}