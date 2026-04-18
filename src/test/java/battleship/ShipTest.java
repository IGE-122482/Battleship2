package battleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Ship")
class ShipTest {

    private Ship ship;
    private Position pos;

    @BeforeEach
    void setUp() {
        pos = new Position(3, 3);
        ship = new Barge(Compass.NORTH, pos);
    }

    @AfterEach
    void tearDown() {
        ship = null;
    }

    @Test
    @DisplayName("Categoria do barco está correta")
    void testGetCategory() {
        assertEquals("Barca", ship.getCategory());
    }

    @Test
    @DisplayName("Posição inicial está correta")
    void testGetPosition() {
        assertEquals(pos, ship.getPosition());
    }

    @Test
    @DisplayName("Orientação está correta")
    void testGetBearing() {
        assertEquals(Compass.NORTH, ship.getBearing());
    }

    @Test
    @DisplayName("Tamanho da barca é 1")
    void testGetSize() {
        assertEquals(1, ship.getSize());
    }

    @Test
    @DisplayName("Barco está a flutuar inicialmente")
    void testStillFloating() {
        assertTrue(ship.stillFloating());
    }

    @Test
    @DisplayName("Barco afunda após ser atingido")
    void testSink() {
        ship.sink();
        assertFalse(ship.stillFloating());
    }

    @Test
    @DisplayName("Barco ocupa a posição inicial")
    void testOccupies() {
        assertTrue(ship.occupies(pos));
    }

    @Test
    @DisplayName("Barco não ocupa posição diferente")
    void testNotOccupies() {
        assertFalse(ship.occupies(new Position(9, 9)));
    }

    @Test
    @DisplayName("Posição mais acima está correta")
    void testGetTopMostPos() {
        assertEquals(3, ship.getTopMostPos());
    }

    @Test
    @DisplayName("Posição mais abaixo está correta")
    void testGetBottomMostPos() {
        assertEquals(3, ship.getBottomMostPos());
    }

    @Test
    @DisplayName("Posição mais à esquerda está correta")
    void testGetLeftMostPos() {
        assertEquals(3, ship.getLeftMostPos());
    }

    @Test
    @DisplayName("Posição mais à direita está correta")
    void testGetRightMostPos() {
        assertEquals(3, ship.getRightMostPos());
    }

    @Test
    @DisplayName("Shoot atinge a posição correta")
    void testShoot() {
        ship.shoot(pos);
        assertFalse(ship.stillFloating());
    }

    @Test
    @DisplayName("Shoot em posição errada não afunda o barco")
    void testShootWrongPosition() {
        ship.shoot(new Position(9, 9));
        assertTrue(ship.stillFloating());
    }

    @Test
    @DisplayName("tooCloseTo posição adjacente retorna true")
    void testTooCloseToPosition() {
        Position adjacent = new Position(3, 4);
        assertTrue(ship.tooCloseTo(adjacent));
    }

    @Test
    @DisplayName("tooCloseTo barco próximo retorna true")
    void testTooCloseToShip() {
        Ship other = new Barge(Compass.NORTH, new Position(3, 4));
        assertTrue(ship.tooCloseTo(other));
    }

    @Test
    @DisplayName("tooCloseTo barco distante retorna false")
    void testNotTooCloseToShip() {
        Ship other = new Barge(Compass.NORTH, new Position(9, 9));
        assertFalse(ship.tooCloseTo(other));
    }

    @Test
    @DisplayName("buildShip cria uma Barca corretamente")
    void testBuildShipBarca() {
        Ship s = Ship.buildShip("barca", Compass.NORTH, new Position(1, 1));
        assertNotNull(s);
        assertEquals("Barca", s.getCategory());
    }

    @Test
    @DisplayName("buildShip cria Caravela corretamente")
    void testBuildShipCaravela() {
        Ship s = Ship.buildShip("caravela", Compass.NORTH, new Position(1, 1));
        assertNotNull(s);
    }

    @Test
    @DisplayName("buildShip cria Nau corretamente")
    void testBuildShipNau() {
        Ship s = Ship.buildShip("nau", Compass.NORTH, new Position(1, 1));
        assertNotNull(s);
    }

    @Test
    @DisplayName("buildShip cria Fragata corretamente")
    void testBuildShipFragata() {
        Ship s = Ship.buildShip("fragata", Compass.NORTH, new Position(1, 1));
        assertNotNull(s);
    }

    @Test
    @DisplayName("buildShip cria Galeao corretamente")
    void testBuildShipGaleao() {
        Ship s = Ship.buildShip("galeao", Compass.NORTH, new Position(1, 1));
        assertNotNull(s);
    }

    @Test
    @DisplayName("buildShip com tipo inválido retorna null")
    void testBuildShipInvalid() {
        Ship s = Ship.buildShip("invalido", Compass.NORTH, new Position(1, 1));
        assertNull(s);
    }

    @Test
    @DisplayName("toString retorna formato correto")
    void testToString() {
        assertNotNull(ship.toString());
        assertTrue(ship.toString().contains("Barca"));
    }

    @Test
    @DisplayName("getPositions não está vazio")
    void testGetPositions() {
        assertFalse(ship.getPositions().isEmpty());
    }

    @Test
    @DisplayName("getAdjacentPositions retorna posições adjacentes")
    void testGetAdjacentPositions() {
        assertFalse(ship.getAdjacentPositions().isEmpty());
    }

    @Test
    @DisplayName("getTopMostPos com Galleon orientado a NORTH")
    void testGetTopMostPosMultiSize() {
        Ship galleon = new Galleon(Compass.NORTH, new Position(5, 5));
        assertEquals(5, galleon.getTopMostPos());
    }

    @Test
    @DisplayName("getBottomMostPos com Galleon orientado a NORTH")
    void testGetBottomMostPosMultiSize() {
        Ship galleon = new Galleon(Compass.NORTH, new Position(3, 3));
        assertEquals(5, galleon.getBottomMostPos());
    }

    @Test
    @DisplayName("getLeftMostPos com Galleon orientado a EAST")
    void testGetLeftMostPosMultiSize() {
        Ship galleon = new Galleon(Compass.EAST, new Position(5, 5));
        assertTrue(galleon.getLeftMostPos() < 5);
    }

    @Test
    @DisplayName("getRightMostPos com Fragata orientada a EAST")
    void testGetRightMostPosMultiSize() {
        Ship frigate = new Frigate(Compass.EAST, new Position(5, 5));
        assertEquals(8, frigate.getRightMostPos());
    }
}