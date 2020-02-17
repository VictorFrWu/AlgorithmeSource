package DesignPattern.Observer;

public interface WeatherObserver {
	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObserver();
}
