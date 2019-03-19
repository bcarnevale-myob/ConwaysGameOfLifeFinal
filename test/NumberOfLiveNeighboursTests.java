import World.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberOfLiveNeighboursTests {

    @Test
    public void aCellWithAllDeadNeighbours_shouldReturnZeroLiveNeighbours() {
        World world = new World(4, 5);
        // given a cell location, return all eight neighbours
        assertEquals(0, world.numberOfLiveNeighbours(1,1));
    }

    @Test
    public void aCellCanCalculateHowManyLiveNeighbours() {
        World world = new World(4, 5);
        world.setLiveCell(1,1);
        world.setLiveCell(0, 0);
        world.setLiveCell(0,1);
        assertEquals(2, world.numberOfLiveNeighbours(1,1));
    }

    @Test
    public void aCellCanCalculateHowManyLiveNeighbours_ReturnOneLiveNeighbour() {
        World world = new World(4, 5);
        world.setLiveCell(1,1);
        world.setLiveCell(0, 0);
        world.setLiveCell(0,3);
        assertEquals(1, world.numberOfLiveNeighbours(1,1));
    }

    @Test
    public void aCellCanCalculateHowManyLiveNeighbours_ReturnsEightLiveNeighbours() {
        World world = new World(4, 5);
        world.setLiveCell(1,1);
        world.setLiveCell(0, 0);
        world.setLiveCell(0,1);
        world.setLiveCell(0, 2);
        world.setLiveCell(1,0);
        world.setLiveCell(1, 2);
        world.setLiveCell(2,0);
        world.setLiveCell(2, 1);
        world.setLiveCell(2,2);
        assertEquals(8, world.numberOfLiveNeighbours(1,1));
    }

    @Test
    public void aCellCanCalculateHowManyLiveNeighbours_ReturnThreeLiveNeighbours_withFarLiveCells() {
        World world = new World(4, 5);

        world.setLiveCell(1,1);
        world.setLiveCell(0, 0);
        world.setLiveCell(0,2);
        world.setLiveCell(0,1);
        world.setLiveCell(0, 4);
        world.setLiveCell(3,1);
        world.setLiveCell(3, 4);
        assertEquals(3, world.numberOfLiveNeighbours(1,1));
    }

    @Test
    public void aCellWhichisOnTheEdgeCountsLiveNeighboursCorrectly_TopMiddle() {
        World world = new World(4, 5);
        world.setLiveCell(1,0);
        world.setLiveCell(1, 4);
        assertEquals(1, world.numberOfLiveNeighbours(1,0));
    }

    @Test
    public void aCellWhichisOnTheEdgeCountsLiveNeighboursCorrectly_TopMiddle_withWrappedAndCloseLiveNeighbours() {
        World world = new World(4, 5);
        world.setLiveCell(1,0);
        world.setLiveCell(1, 4);
        world.setLiveCell(1, 1);
        assertEquals(2, world.numberOfLiveNeighbours(1,0));
    }

    @Test
    public void aCellWhichisOnTheEdgeCountsLiveNeighboursCorrectly_MiddleRight() {
        World world = new World(4, 5);
        world.setLiveCell(3, 1);
        world.setLiveCell(0, 1);
        world.setLiveCell(2, 1);
        assertEquals(2, world.numberOfLiveNeighbours(3,1));
    }

    @Test
    public void aCellWhichisOnTheEdgeCountsLiveNeighboursCorrectly_BottomRightCorner() {
        World world = new World(4, 5);
        world.setLiveCell(3, 4);
        world.setLiveCell(0, 0);
        world.setLiveCell(3, 3);
        assertEquals(2, world.numberOfLiveNeighbours(3,4));
    }

    @Test
    public void aCellWhichIsInTheCorner_hasEightLiveNeighbours() {
        World world = new World(4, 5);
        world.setLiveCell(0, 0);
        world.setLiveCell(0,1);
        world.setLiveCell(1, 0);
        world.setLiveCell(1,1);
        world.setLiveCell(3,4);
        world.setLiveCell(3, 1);
        world.setLiveCell(3,0);
        world.setLiveCell(1, 4);
        world.setLiveCell(0, 4);
        assertEquals(8, world.numberOfLiveNeighbours(0,0));
    }

}
