import World.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextStateTests {

    @Test
    public void ifCellIsAliveAndTwoNeighboursAreAlive_thatCellStaysAlive() {
        World world = new World(4,5);
        world.setLiveCell(1,1);
        world.setLiveCell(0,0);
        world.setLiveCell(1,0);
        assertTrue(world.nextStateAlive(1,1));
    }

    @Test
    public void ifCellIsAliveAndThreeNeighboursAreAlive_thatCellStaysAlive() {
        World world = new World(4,5);
        world.setLiveCell(1,1);
        world.setLiveCell(0,0);
        world.setLiveCell(1,0);
        world.setLiveCell(2,0);
        assertTrue(world.nextStateAlive(1,1));
    }

    @Test
    public void ifCellIsAliveAndOneNeighboursAreAlive_thatCellDies() {
        World world = new World(4,5);
        world.setLiveCell(1,1);
        world.setLiveCell(0,0);
        assertFalse(world.nextStateAlive(1,1));
    }

    @Test
    public void ifCellIsAliveAndFourNeighboursAreAlive_thatCellDies() {
        World world = new World(4,5);
        world.setLiveCell(1,1);
        world.setLiveCell(0,0);
        world.setLiveCell(1,0);
        world.setLiveCell(2,0);
        world.setLiveCell(0,1);
        assertFalse(world.nextStateAlive(1,1));
    }

    @Test
    public void ifCellIsDeadAndThreeNeighboursAreAlive_thatCellBecomesAlive() {
        World world = new World(4,5);
        world.setDeadCell(1,1);
        world.setLiveCell(0,0);
        world.setLiveCell(1,0);
        world.setLiveCell(2,0);
        assertTrue(world.nextStateAlive(1,1));
    }

    @Test
    public void ifCellIsDeadAndTwoNeighboursAreAlive_thatCellStaysDead() {
        World world = new World(4,5);
        world.setDeadCell(1,1);
        world.setLiveCell(0,0);
        world.setLiveCell(1,0);
        assertFalse(world.nextStateAlive(1,1));
    }

    @Test
    public void ifCellIsDeadAndFourNeighboursAreAlive_thatCellStaysDead() {
        World world = new World(4,5);
        world.setDeadCell(1,1);
        world.setLiveCell(0,0);
        world.setLiveCell(1,0);
        world.setLiveCell(0,1);
        world.setLiveCell(0,2);
        assertFalse(world.nextStateAlive(1,1));
    }

}
