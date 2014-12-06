package JsonClasses;
// TODO: Auto-generated Javadoc

/**
 * The Class WeatherInfo.
 */
public class WeatherInfo {
	
	/** The weather location. */
	private String weatherLocation;
	
	/** The weather. */
	private String weather;
	
	/** The temperature. */
	private String temperature;
	
	/** The overall id. */
	private String overallID = "getClientForecast";
	
	/**
	 * Gets the weather location.
	 *
	 * @return the weather location
	 */
	public String getWeatherLocation() {
		return weatherLocation;
	}
	
	/**
	 * Sets the weather location.
	 *
	 * @param weatherLocation the new weather location
	 */
	public void setWeatherLocation(String weatherLocation) {
		this.weatherLocation = weatherLocation;
	}
	
	/**
	 * Gets the weather.
	 *
	 * @return the weather
	 */
	public String getWeather() {
		return weather;
	}
	
	/**
	 * Sets the weather.
	 *
	 * @param weather the new weather
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	/**
	 * Gets the temperature.
	 *
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}
	
	/**
	 * Sets the temperature.
	 *
	 * @param temperature the new temperature
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	
}
