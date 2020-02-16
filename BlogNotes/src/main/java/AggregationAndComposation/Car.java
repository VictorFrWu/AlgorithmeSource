package AggregationAndComposation;

public final class Car {
	// private Engine engine; //aggregation
	private final Engine engine;

	public Car(Engine engine) {
		super();
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}

//	public void setEngine(Engine engine) {
//		this.engine = engine;
//	}

	// car start moving by starting engine
	public void move() {

		// if(engine != null)
		{
			engine.work();
			System.out.println("Car is moving ");
		}
	}
}

