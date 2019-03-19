package World;

public class AliveCell implements Cell {

    public String toString() {
        return "x";
    }

    @Override
    public Boolean isAlive() {
        return true;
    }
}
