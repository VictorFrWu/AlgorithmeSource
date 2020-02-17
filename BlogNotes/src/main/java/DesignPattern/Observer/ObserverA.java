package DesignPattern.Observer;

public class ObserverA implements Observer {

	WeatherStation ws;

	public ObserverA(WeatherStation ws) {
		this.ws = ws;
	}

	@Override
	public void update() {
		if (ws.getTemperature() < 0) {
			System.out.println("doudoune");
		}

	}

}
