package JsonClasses;

public class QOTD {

	private String quote;
	private String author;
	private String topic;
	private String overallID ="getQuote";
	
	public QOTD(String quote, String author, String topic) {
		super();
		this.quote = quote;
		this.author = author;
		this.topic = topic;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	/**
	 * Gets the overall id.
	 *
	 * @return the overall id
	 */
	public String getOverallID() {
		return overallID;
	}
	
	/**
	 * Sets the overall id.
	 *
	 * @param overallID the new overall id
	 */
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	
}

