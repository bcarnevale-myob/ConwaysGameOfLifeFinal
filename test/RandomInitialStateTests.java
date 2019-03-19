import World.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomInitialStateTests {

    @Test
    public void ifUserChoosesRandom_thereWillBeSomeAliveCells() {
        MockConwayRandom mockRandom = new MockConwayRandom(1, 2);
        World newWorld = new World(4,5, true, mockRandom);
        assertFalse(newWorld.isEmpty());
        assertEquals(3, mockRandom.getCalledTimes());
    }

    @Test
    public void ifTwoRandomWorldsCreated_theyShouldNotMatch() {
        MockConwayRandom mockRandom = new MockConwayRandom(1, 2);
        MockConwayRandom mockRandomTwo = new MockConwayRandom(1, 3);
        World newWorld = new World(4,5, true, mockRandom);
        World newWorldTwo = new World(4,5, true, mockRandomTwo);
        assertFalse(newWorld.equals(newWorldTwo));
        assertEquals(3, mockRandom.getCalledTimes());
        assertEquals(3, mockRandomTwo.getCalledTimes());
    }

    @Test
    public void ifConwayRandomProducesOneAndThree_OneLiveCellIsPlacedAtThreeThree() {
        MockConwayRandom mockRandom = new MockConwayRandom(1, 3);
        World newWorld = new World(4,5, true, mockRandom);
        assertTrue(newWorld.cellAtPosition(3,3).isAlive());
        assertEquals(3, mockRandom.getCalledTimes());
    }

    @Test
    public void ifConwayRandomProducesTwoAndThreeAndThreeAndFourAndFour_TwoLiveCellsPlaceAtThreeThreeAndFourFour() {
        MockConwayRandom mockRandom = new MockConwayRandom(2, 3, 4);
        World newWorld = new World(5,5, true, mockRandom);
        assertTrue(newWorld.cellAtPosition(3,3).isAlive());
        assertTrue(newWorld.cellAtPosition(4,4).isAlive());
        assertEquals(5, mockRandom.getCalledTimes());
    }

}
