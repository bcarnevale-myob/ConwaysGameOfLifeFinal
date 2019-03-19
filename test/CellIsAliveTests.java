import World.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellIsAliveTests {


    @Test
    public void checkCellAtLocation_isItAlive() {
        World world = new World(4, 5);
        world.setLiveCell(1,1);
        assertTrue(world.cellAtPosition(1,1).isAlive());
    }

    @Test
    public void checkCellAtLocation_isItDead() {
        World world = new World(4, 5);
        world.setDeadCell(1,1);
        assertFalse(world.cellAtPosition(1,1).isAlive());
    }

    @Test
    public void canSetAliveCells_allOtherCellsShouldBeDead() {
        World world = new World(2, 2);
        world.setLiveCell(0,0);
        world.setLiveCell(0,1);
        assertFalse(world.cellAtPosition(1,0).isAlive());
        assertFalse(world.cellAtPosition(1,1).isAlive());
    }

}
