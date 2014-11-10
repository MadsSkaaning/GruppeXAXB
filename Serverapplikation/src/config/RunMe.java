package config;
public class RunMe {

	public static void main (String [] args){
		
		Configurations cf = new Configurations();
		
			System.out.println("IP Address is " + cf.getHost());
			System.out.println("Weather longitude is: " + cf.getWeather_lon());
			System.out.println("Weather lat is: " + cf.getWeather_lat());
			System.out.println("Weather is set to display: " + cf.getWeather_future_in_days() + " days from today");
			System.out.println("PASS: " + cf.getPassword());
			System.out.println("" + cf.getFfcryptkey());
			System.out.println();
			
	}
}
