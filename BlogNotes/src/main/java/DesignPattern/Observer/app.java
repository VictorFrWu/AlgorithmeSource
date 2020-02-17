package DesignPattern.Observer;

public class app {
	public static void main(String[] args) {
		WeatherStation ws = new WeatherStation();

		ObserverA a = new ObserverA(ws);
		ObserverB b = new ObserverB(ws);

		ws.registerObserver(a);
		ws.registerObserver(b);

		ws.setTemperature(-1);
		ws.setDampness(111);
		
	}

}
