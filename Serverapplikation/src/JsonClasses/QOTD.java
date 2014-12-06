package JsonClasses;

// TODO: Auto-generated Javadoc
/**
 * The Class QOTD.
 */
public class QOTD {

	/** The quote. */
	private String quote;
	
	/** The author. */
	private String author;
	
	/** The topic. */
	private String topic;
	
	/** The overall id. */
	private String overallID ="getQuote";
	
	/**
	 * Instantiates a new qotd.
	 *
	 * @param quote the quote
	 * @param author the author
	 * @param topic the topic
	 */
	public QOTD(String quote, String author, String topic) {
		super();
		this.quote = quote;
		this.author = author;
		this.topic = topic;
	}
	
	/**
	 * Gets the quote.
	 *
	 * @return the quote
	 */
	public String getQuote() {
		return quote;
	}
	
	/**
	 * Sets the quote.
	 *
	 * @param quote the new quote
	 */
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Gets the topic.
	 *
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}
	
	/**
	 * Sets the topic.
	 *
	 * @param topic the new topic
	 */
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

