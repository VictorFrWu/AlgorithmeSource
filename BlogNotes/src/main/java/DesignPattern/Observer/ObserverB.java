package DesignPattern.Observer;

public class ObserverB implements Observer {

	WeatherStation ws;

	public ObserverB(WeatherStation ws) {
		this.ws = ws;
	}

	@Override
	public void update() {
		if (ws.getDampness() > 20) {
			System.out.println("air condition");
		}

	}

}
