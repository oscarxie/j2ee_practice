package Demo;

public abstract class HelloAbstract implements Hello {
    private Random random;

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public abstract Random createRandom();

	@Override
	public Random createRandom1() {
		// TODO Auto-generated method stub
		//return null;
		return random;
	}
} 