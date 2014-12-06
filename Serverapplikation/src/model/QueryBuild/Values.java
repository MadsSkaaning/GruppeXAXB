package model.QueryBuild;


// TODO: Auto-generated Javadoc
/**
 * The Class Values.
 */
public class Values {

	/** The query builder. */
	private QueryBuilder queryBuilder;
	
	/** The values. */
	private String[] values;

	/**
	 * Sets the values.
	 *
	 * @param values the new values
	 */
	private void setValues(String[] values){
		this.values = values;
	}
	
	/**
	 * Gets the values.
	 *
	 * @return the values
	 */
	protected String[] getValues(){
		return values;
	}

	/**
	 * Gets the query builder.
	 *
	 * @return the query builder
	 */
	protected QueryBuilder getQueryBuilder(){
		return this.queryBuilder;
	}

	/**
	 * Instantiates a new values.
	 *
	 * @param queryBuilder the query builder
	 */
	public Values(QueryBuilder queryBuilder){
		this.queryBuilder = queryBuilder;
	}
	
	/**
	 * Instantiates a new values.
	 */
	private Values(){

	}

	/**
	 * Values.
	 *
	 * @param values the values
	 * @return the execute
	 */
	public Execute values(String[] values){
		Values v = new Values();
		v.setValues(values);
		return new Execute(getQueryBuilder(), v);
	}

}
