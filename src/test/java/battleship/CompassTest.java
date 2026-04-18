package battleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Compass")
public class CompassTest {

	private Compass compass;

	@BeforeEach
	void setUp() {
		compass = Compass.NORTH;
	}

	@AfterEach
	void tearDown() {
		compass = null;
	}

	@Test
	@DisplayName("Compass não é null")
	void constructor() {
		assertNotNull(compass);
	}

	@Test
	@DisplayName("getDirection retorna o caractere correto para cada direção")
	void getDirection() {
		assertEquals('n', Compass.NORTH.getDirection());
		assertEquals('s', Compass.SOUTH.getDirection());
		assertEquals('e', Compass.EAST.getDirection());
		assertEquals('o', Compass.WEST.getDirection());
	}

	@Test
	@DisplayName("toString retorna o caractere como string")
	void toStringTest() {
		assertEquals("n", Compass.NORTH.toString());
		assertEquals("s", Compass.SOUTH.toString());
		assertEquals("e", Compass.EAST.toString());
		assertEquals("o", Compass.WEST.toString());
	}

	@Test
	@DisplayName("charToCompass converte cada caractere válido corretamente")
	void charToCompass1() {
		assertEquals(Compass.NORTH, Compass.charToCompass('n'));
		assertEquals(Compass.SOUTH, Compass.charToCompass('s'));
		assertEquals(Compass.EAST, Compass.charToCompass('e'));
		assertEquals(Compass.WEST, Compass.charToCompass('o'));
	}

	@Test
	@DisplayName("charToCompass com caractere inválido retorna null")
	void charToCompass2() {
		assertNull(Compass.charToCompass('x'));
	}

	@Test
	@DisplayName("charToCompass com caractere nulo retorna null")
	void charToCompass3() {
		assertNull(Compass.charToCompass('\0'));
	}

	@Test
	@DisplayName("randomBearing retorna uma direção válida")
	void testRandomBearing() {
		Compass bearing = Compass.randomBearing();
		assertNotNull(bearing);
		assertTrue(bearing == Compass.NORTH || bearing == Compass.SOUTH ||
				bearing == Compass.EAST || bearing == Compass.WEST);
	}
}