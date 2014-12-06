package model.Forecast;

// TODO: Auto-generated Javadoc
/**
 * Created by danielfranch on 16/10/14.
 * Constructor til ForecastModel Arraylist
 */
public class Forecast {

	/** The date. */
	private String date;

	/** The celsius. */
	private String celsius;

	/** The desc. */
	private String desc;

	// Funktion som setter dato, grader og beskrivelse til Forecast objektet
	/**
	 * Instantiates a new forecast.
	 *
	 * @param date the date
	 * @param celsius the celsius
	 * @param desc the desc
	 */
	public Forecast(String date, String celsius, String desc) {
		this.date = date;
		this.celsius = celsius;
		this.desc = desc;
	}

	// Settere og gettere for Forecast klassen
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the celsius.
	 *
	 * @return the celsius
	 */
	public String getCelsius() {
		return celsius;
	}

	/**
	 * Sets the celsius.
	 *
	 * @param celsius the new celsius
	 */
	public void setCelsius(String celsius) {
		this.celsius = celsius;
	}

	/**
	 * Gets the desc.
	 *
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the desc.
	 *
	 * @param desc the new desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	// Returnere vejrudsigten som en json tekststreng
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Forecast{" +
				"date='" + date + '\'' +
				", celsius='" + celsius + '\'' +
				", desc='" + desc + '\'' +
				'}';
	}
}
