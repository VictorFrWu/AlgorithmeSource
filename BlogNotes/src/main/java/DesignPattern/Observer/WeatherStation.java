package DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherObserver {

	List<Observer> obs = new ArrayList<Observer>();
	int temperature = 0;
	int dampness = 1;

	public int getDampness() {
		return dampness;
	}

	public void setDampness(int dampness) {
		this.dampness = dampness;
		notifyObserver();
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
		notifyObserver();
	}

	@Override
	public void registerObserver(Observer o) {
		obs.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		obs.remove(o);
	}

	@Override
	public void notifyObserver() {
		for (Observer o : obs) {
			o.update();
		}
	}

}
