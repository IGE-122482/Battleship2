package battleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DisplayName("Testes da classe Fleet")
public class FleetTest {

	private Fleet fleet;

	@BeforeEach
	void setUp() {
		fleet = new Fleet();
	}

	@AfterEach
	void tearDown() {
		fleet = null;
	}

	@Test
	@DisplayName("Construtor cria frota vazia")
	void testConstructor() {
		assertNotNull(fleet);
		assertTrue(fleet.getShips().isEmpty());
	}

	@Test
	@DisplayName("addShip adiciona barco válido")
	void testAddShip1() {
		IShip ship = new Barge(Compass.NORTH, new Position(1, 1));
		assertTrue(fleet.addShip(ship));
		assertEquals(1, fleet.getShips().size());
	}

	@Test
	@DisplayName("addShip não adiciona barco fora do tabuleiro")
	void testAddShip3() {
		IShip shipOutside = new Barge(Compass.NORTH, new Position(99, 99));
		assertFalse(fleet.addShip(shipOutside));
	}

	@Test
	@DisplayName("addShip não adiciona barco em colisão")
	void testAddShip4() {
		IShip ship1 = new Barge(Compass.NORTH, new Position(1, 1));
		IShip ship2 = new Barge(Compass.NORTH, new Position(1, 1));
		fleet.addShip(ship1);
		assertFalse(fleet.addShip(ship2));
	}

	@Test
	@DisplayName("getShips retorna lista correta")
	void testGetShips() {
		assertTrue(fleet.getShips().isEmpty());
		IShip ship = new Barge(Compass.NORTH, new Position(1, 1));
		fleet.addShip(ship);
		assertEquals(1, fleet.getShips().size());
		assertEquals(ship, fleet.getShips().get(0));
	}

	@Test
	@DisplayName("getShipsLike retorna barcos da categoria")
	void testGetShipsLike() {
		IShip ship1 = new Barge(Compass.NORTH, new Position(1, 1));
		IShip ship2 = new Caravel(Compass.NORTH, new Position(4, 1));
		fleet.addShip(ship1);
		fleet.addShip(ship2);

		List<IShip> barges = fleet.getShipsLike("Barca");
		assertEquals(1, barges.size());
		assertEquals(ship1, barges.get(0));
	}

	@Test
	@DisplayName("getShipsLike com categoria inexistente retorna vazio")
	void testGetShipsLikeEmpty() {
		IShip ship = new Barge(Compass.NORTH, new Position(1, 1));
		fleet.addShip(ship);
		List<IShip> result = fleet.getShipsLike("Galeao");
		assertTrue(result.isEmpty());
	}

	@Test
	@DisplayName("getFloatingShips retorna barcos a flutuar")
	void testGetFloatingShips() {
		IShip ship1 = new Barge(Compass.NORTH, new Position(1, 1));
		IShip ship2 = new Caravel(Compass.NORTH, new Position(4, 4));
		fleet.addShip(ship1);
		fleet.addShip(ship2);

		List<IShip> floatingShips = fleet.getFloatingShips();
		assertEquals(2, floatingShips.size());

		ship1.getPositions().get(0).shoot();
		floatingShips = fleet.getFloatingShips();
		assertEquals(1, floatingShips.size());
		assertEquals(ship2, floatingShips.get(0));
	}

	@Test
	@DisplayName("getSunkShips retorna barcos afundados")
	void testGetSunkShips() {
		IShip ship1 = new Barge(Compass.NORTH, new Position(1, 1));
		IShip ship2 = new Barge(Compass.NORTH, new Position(5, 5));
		fleet.addShip(ship1);
		fleet.addShip(ship2);

		assertEquals(0, fleet.getSunkShips().size());

		ship1.sink();
		assertEquals(1, fleet.getSunkShips().size());
	}

	@Test
	@DisplayName("shipAt retorna barco na posição")
	void testShipAt() {
		IShip ship = new Barge(Compass.NORTH, new Position(1, 1));
		fleet.addShip(ship);

		assertEquals(ship, fleet.shipAt(new Position(1, 1)));
		assertNull(fleet.shipAt(new Position(7, 7)));
	}

	@Test
	@DisplayName("createRandom cria frota completa")
	void testCreateRandom() {
		IFleet randomFleet = Fleet.createRandom();
		assertNotNull(randomFleet);
		assertEquals(11, randomFleet.getShips().size());
	}

	@Test
	@DisplayName("printStatus não lança exceções")
	void testPrintStatus() {
		IShip ship = new Barge(Compass.NORTH, new Position(1, 1));
		fleet.addShip(ship);
		assertDoesNotThrow(fleet::printStatus);
	}

	@Test
	@DisplayName("printShips não lança exceções")
	void testPrintShips() {
		IShip ship = new Barge(Compass.NORTH, new Position(1, 1));
		fleet.addShip(ship);
		assertDoesNotThrow(() -> fleet.printShips(fleet.getShips()));
	}

	@Test
	@DisplayName("printAllShips não lança exceções")
	void testPrintAllShips() {
		IShip ship = new Barge(Compass.NORTH, new Position(1, 1));
		fleet.addShip(ship);
		assertDoesNotThrow(fleet::printAllShips);
	}

	@Test
	@DisplayName("printFloatingShips não lança exceções")
	void testPrintFloatingShips() {
		IShip ship = new Barge(Compass.NORTH, new Position(1, 1));
		fleet.addShip(ship);
		assertDoesNotThrow(fleet::printFloatingShips);
	}

	@Test
	@DisplayName("printShipsByCategory não lança exceções")
	void testPrintShipsByCategory() {
		IShip ship = new Barge(Compass.NORTH, new Position(1, 1));
		fleet.addShip(ship);
		assertDoesNotThrow(() -> fleet.printShipsByCategory("Barca"));
	}
}