import World.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorldEvolveTests {

    @Test
    public void ifWorldsAreInTheSameState_worldsMatchReturnTrue_allDeadCells() {
        World oldWorld = new World(4,5);
        World newWorld = new World(4,5);
        assertTrue(World.worldsMatch(oldWorld, newWorld));
    }

    @Test
    public void ifWorldsAreInTheSameState_worldsMatchReturnTrue_liveCellsMatch() {
        World oldWorld = new World(4, 5);
        World newWorld = new World(4, 5);
        oldWorld.setLiveCell(1, 1);
        oldWorld.setLiveCell(1, 3);
        newWorld.setLiveCell(1, 1);
        newWorld.setLiveCell(1, 3);
        assertTrue(World.worldsMatch(oldWorld, newWorld));
    }

    @Test
    public void ifWorldsAreInDifferentStates_worldsMatchReturnFalse() {
        World oldWorld = new World(4, 5);
        World newWorld = new World(4, 5);
        oldWorld.setLiveCell(1, 1);
        oldWorld.setLiveCell(1, 3);
        newWorld.setLiveCell(2, 1);
        newWorld.setLiveCell(1, 3);
        assertFalse(World.worldsMatch(oldWorld, newWorld));
    }

    @Test
    public void ifWorldsAreInDifferentStates_worldsMatchReturnFalse_multipleSimilarCells() {
        World oldWorld = new World(4, 5);
        World newWorld = new World(4, 5);
        oldWorld.setLiveCell(1, 1);
        oldWorld.setLiveCell(1, 3);
        oldWorld.setLiveCell(2, 0);
        oldWorld.setLiveCell(3, 3);
        newWorld.setLiveCell(1, 1);
        newWorld.setLiveCell(1, 3);
        newWorld.setLiveCell(2, 0);
        newWorld.setLiveCell(3, 1);
        assertFalse(World.worldsMatch(oldWorld, newWorld));
    }

    @Test
    public void ifThereAreOnlyTwoLiveCellsAndTheyAreNextToEachOther_theyBothDieInTheNextStateAndTheWorldEnds() {
        World oldWorld = new World(4, 5);
        oldWorld.setLiveCell(1,1);
        oldWorld.setLiveCell(1,2);
        World newWorld = oldWorld.evolve();
        assertTrue(newWorld.isEmpty());
    }

    @Test
    public void ifThreeAdjacentCellsAreAlive_theyAllRemainAlivePlusAnotherAdjacentCellComesToLife() {
        World oldWorld = new World(4, 4);
        oldWorld.setLiveCell(1,1);
        oldWorld.setLiveCell(1,2);
        oldWorld.setLiveCell(2,1);
        World newWorld = oldWorld.evolve();
        assertTrue(newWorld.cellAtPosition(2,2).isAlive());
    }

    @Test
    public void ifACellHasWrappedNeighbours_doesTheEvolveMethodStillFollow() {
        World oldWorld = new World(4, 5);
        oldWorld.setLiveCell(0,0);
        oldWorld.setLiveCell(2,3);
        oldWorld.setLiveCell(2,4);
        oldWorld.setLiveCell(3,4);
        World newWorld = oldWorld.evolve();
        assertFalse(newWorld.cellAtPosition(0,0).isAlive());
    }

}
