package World;

public class DeadCell implements Cell {

    public String toString() {
        return ".";
    }

    @Override
    public Boolean isAlive() {
        return false;
    }
}
