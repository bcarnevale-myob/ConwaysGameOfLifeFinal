package World;

public class World {

    private final Cell[][] world;

    public World(int height, int width) {
        this.world = new Cell[height][width];
        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                world[x][y] = new DeadCell();
            }
        }
    }

    public World(int height, int width, boolean initialiseRandom, ConwayRandom randomInstance) {
        this(height, width);
        if(initialiseRandom) {
            this.randomInitialState(randomInstance);
        }
    }

    public int numberOfLiveNeighbours(int x, int y) {
        int numberOfLiveNeighbours = 0;
        int neighbourRow;
        int neighbourCol;
        for(int row = x - 1; row <= x+1; row++) {
            neighbourRow = calculateWrapPosition(row, this.getHeight());
            for(int col = y - 1; col <= y+1; col++) {
                neighbourCol = calculateWrapPosition(col, this.getWidth());
                if (!world[neighbourRow][neighbourCol].equals(world[x][y])) {
                    if (world[neighbourRow][neighbourCol].isAlive()) {
                        numberOfLiveNeighbours++;
                    }
                }
            }
        }
        return numberOfLiveNeighbours;
    }

    public static int calculateWrapPosition(int neighbourPosition, int maxLength) {
        int wrappedValue;
        if(neighbourPosition == -1) {
            wrappedValue = maxLength - 1;
        } else if (neighbourPosition == maxLength) {
            wrappedValue = 0;
        } else {
            wrappedValue = neighbourPosition;
        }
        return wrappedValue;
    }

    public boolean isEmpty() {
        boolean isDead = true;
        for(int x = 0; x < this.getHeight(); x++) {
            for(int y = 0; y < this.getWidth(); y++) {
                if(world[x][y].isAlive()) {
                    isDead = false;
                }
            }
        }
        return isDead;
    }

    public int getHeight() {
        return this.world.length;
    }

    public int getWidth() {
        return this.world[0].length;
    }

    public void setLiveCell(int x, int y) {
        this.world[x][y] = new AliveCell();
    }

    public void setDeadCell(int x, int y) {
        this.world[x][y] = new DeadCell();
    }

    public boolean nextStateAlive(int x, int y) {
        boolean nextStateAlive = false;
        if (this.world[x][y].isAlive() && ((this.numberOfLiveNeighbours(x, y) == 2) || (this.numberOfLiveNeighbours(x,y) == 3))) {
            nextStateAlive = true;
        } else if (!this.world[x][y].isAlive() && (this.numberOfLiveNeighbours(x,y) == 3)) {
            nextStateAlive = true;
        }
        return nextStateAlive;
    }

    // probably do no need worldsMatch method as it is the same as .equals
    public static boolean worldsMatch(World worldOne, World worldTwo) {
        return worldOne.equals(worldTwo);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof World)) {
            return false;
        }
        if((((World) obj).getHeight() != this.getHeight()) || (((World) obj).getWidth() != this.getWidth())) {
            return false;
        }
        for(int x = 0; x < this.getHeight(); x++) {
            for(int y = 0; y < this.getWidth(); y++) {
                if (this.world[x][y].isAlive() != ((World) obj).world[x][y].isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    public World evolve() {
        World nextWorld = new World(this.getHeight(), this.getWidth());
        for(int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                if (this.nextStateAlive(x, y)) {
                    nextWorld.setLiveCell(x,y);
                } else {
                    nextWorld.setDeadCell(x, y);
                }
            }
        }
        return nextWorld;
    }

    public String toString() {
        String result = "";

        for (int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                result = result + this.world[x][y].toString();
            }
            result = result + "\n";
        }
        return result;
    }

    public void randomInitialState(ConwayRandom randomInstance) {
        int row;
        int col;

        int numberOfLiveCellsToPlace = randomInstance.nextInt(this.getHeight() * this.getWidth());

        for(int cell = 1; cell <= numberOfLiveCellsToPlace; cell++){
            row = randomInstance.nextInt(this.getHeight());
            col = randomInstance.nextInt(this.getWidth());
            this.setLiveCell(row, col);
        }
    }

    public Cell cellAtPosition(int x, int y) {
        return this.world[x][y];
    }
}
