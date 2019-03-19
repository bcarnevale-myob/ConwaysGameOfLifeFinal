package World;

import java.util.Random;

public class RealConwayRandom implements ConwayRandom {

    private final Random random;

    public RealConwayRandom(Random random) {
        this.random = random;
    }

    @Override
    public int nextInt(int upperBound) {
        return this.random.nextInt(upperBound);
    }
}
