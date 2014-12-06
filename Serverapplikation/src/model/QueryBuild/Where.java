package model.QueryBuild;

// TODO: Auto-generated Javadoc
/**
 * The Class Where.
 */
public class Where {

	/** The qb. */
	private QueryBuilder qb;
	
	/** The where key. */
	private String whereKey;
	
	/** The where operator. */
	private String whereOperator;
	
	/** The where value. */
	private String whereValue;

	/**
	 * Gets the where key.
	 *
	 * @return the where key
	 */
	protected String getWhereKey() {
		return whereKey;
	}

	/**
	 * Sets the where key.
	 *
	 * @param whereKey the new where key
	 */
	private void setWhereKey(String whereKey) {
		this.whereKey = whereKey;
	}

	/**
	 * Gets the where operator.
	 *
	 * @return the where operator
	 */
	protected String getWhereOperator() {
		return whereOperator;
	}

	/**
	 * Sets the where operator.
	 *
	 * @param whereOperator the new where operator
	 */
	private void setWhereOperator(String whereOperator) {
		this.whereOperator = whereOperator;
	}

	/**
	 * Gets the where value.
	 *
	 * @return the where value
	 */
	protected String getWhereValue() {
		return whereValue;
	}

	/**
	 * Sets the where value.
	 *
	 * @param whereValue the new where value
	 */
	private void setWhereValue(String whereValue) {
		this.whereValue = whereValue;
	}
	
	/**
	 * Gets the query builder.
	 *
	 * @return the query builder
	 */
	protected QueryBuilder getQueryBuilder(){
		return qb;
	}

	/**
	 * Instantiates a new where.
	 *
	 * @param queryBuilder the query builder
	 */
	public Where(QueryBuilder queryBuilder){
		qb = queryBuilder;
	}
	
	/**
	 * Instantiates a new where.
	 */
	private Where(){

	}

	/**
	 * Select all columns from table in DB (SELECT * ...)
	 *
	 * @return the execute
	 */
	 public Execute all(){
		 return new Execute(getQueryBuilder(), true);
	 }


	 /**
 	 * WHERE key operate value, ex. WHERE id = 5
 	 *
 	 * @param key the key
 	 * @param operator the operator
 	 * @param value the value
 	 * @return the execute
 	 */
	 public Execute where(String key, String operator, String value){

		 Where where = new Where();
		 where.setWhereKey(key);
		 where.setWhereOperator(operator);
		 where.setWhereValue(value);

		 return new Execute(getQueryBuilder(), where);
		 //System.out.print("SELECT " + getSelectParameters() + " FROM " + getTableName() + " WHERE " + getWherekey() + " = " + getWherePlaceholders());

	 }

}