import World.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConwaysGameOfLifeTests {

    @Test
    public void worldsStartEmpty() {
        World world = new World(4, 5);
        assertTrue(world.isEmpty());
    }

    @Test
    public void canCreateWorldOfSpecifiedSize() {
        World world = new World(4, 5);
        assertEquals(4, world.getHeight());
        assertEquals(5, world.getWidth());
    }

    @Test
    public void canPlaceLiveCell_WorldIsNoLongerEmpty() {
        World world = new World(4, 5);
        world.setLiveCell(1,1);
        assertFalse(world.isEmpty());
    }

    @Test
    public void canPlaceDeadCell_WorldIsStillEmpty() {
        World world = new World(4,5);
        world.setDeadCell(1, 1);
        assertTrue(world.isEmpty());
    }

    @Test
    public void liveCellThenDeadCell_WorldIsEmpty() {
        World world = new World(4,5);
        world.setLiveCell(1, 1);
        world.setDeadCell(1, 1);
        assertTrue(world.isEmpty());
    }

    @Test
    public void liveAndDeadCellsExist_WorldIsNotEmpty() {
        World world = new World(4,5);
        world.setLiveCell(1, 1);
        world.setDeadCell(2, 2);
        assertFalse(world.isEmpty());
    }

    @Test
    public void checkCellInAliveMethodPlacedIntoCellClass() {
        World newWorld = new World(4,5);
        assertFalse(newWorld.cellAtPosition(1,1).isAlive());
    }

    @Test
    public void checkCellInAliveMethodPlacedIntoCellClass2() {
        World newWorld = new World(4,5);
        newWorld.setLiveCell(1,1);
        assertTrue(newWorld.cellAtPosition(1,1).isAlive());
    }

}