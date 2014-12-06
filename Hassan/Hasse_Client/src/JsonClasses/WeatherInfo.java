package JsonClasses;
public class WeatherInfo {
	//Alle JSON klasser indenholder getters og setters for, hvad de består af hver især
	private String weatherLocation;
	private String weather;
	private String temperature;
	private String overallID = "getClientForecast";
	
	public String getWeatherLocation() {
		return weatherLocation;
	}
	public void setWeatherLocation(String weatherLocation) {
		this.weatherLocation = weatherLocation;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	
}
