package model.QueryBuild;


// TODO: Auto-generated Javadoc
/**
 * The Class QueryBuilder.
 */
public class QueryBuilder {

	/** The select value. */
	private String selectValue;

	/** The table name. */
	private String tableName;

	/** The fields. */
	private String fields;

	/** The soft delete. */
	private boolean softDelete;

	/** The is update. */
	private boolean isUpdate;

	/**
	 * Sets the soft delete.
	 *
	 * @param b the new soft delete
	 */
	protected void setSoftDelete(boolean b){
		this.softDelete = b;
	}

	/**
	 * Checks if is soft delete.
	 *
	 * @return true, if is soft delete
	 */
	protected boolean isSoftDelete(){
		return softDelete;
	}

	/**
	 * Checks if is update.
	 *
	 * @return true, if is update
	 */
	protected boolean isUpdate() {
		return isUpdate;
	}

	/**
	 * Sets the update.
	 *
	 * @param isUpdate the new update
	 */
	protected void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	/**
	 * Sets the select value.
	 *
	 * @param selectValue the new select value
	 */
	protected void setSelectValue(String selectValue) {
		this.selectValue = selectValue;
	}

	/**
	 * Gets the select value.
	 *
	 * @return the select value
	 */
	protected String getSelectValue(){
		return selectValue;
	}

	/**
	 * Gets the table name.
	 *
	 * @return the table name
	 */
	protected String getTableName() {
		return tableName;
	}

	/**
	 * Sets the table name.
	 *
	 * @param tableName the new table name
	 */
	protected void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	protected String getFields(){
		return fields;
	}

	/**
	 * Sets the fields.
	 *
	 * @param fields the new fields
	 */
	protected void setFields(String fields){
		this.fields = fields;
	}

	/**
	 * SELECT values FROM tablename.
	 *
	 * @param values String[]
	 * @param tableName String
	 * @return the where
	 */
	public Where selectFrom(String[] values, String tableName) {

		QueryBuilder queryBuilder = new QueryBuilder();

		StringBuilder sb = new StringBuilder();
		for (String n : values) {
			if (sb.length() > 0) sb.append(',');
			sb.append(n);
		}
		queryBuilder.setSelectValue(sb.toString());
		queryBuilder.setTableName(tableName);

		return new Where(queryBuilder);
	}

	/**
	 * SELECT * FROM tableName.
	 *
	 * @param tableName the table name
	 * @return the where
	 */
	public Where selectFrom(String tableName) {

		QueryBuilder queryBuilder = new QueryBuilder();

		queryBuilder.setSelectValue("*");
		queryBuilder.setTableName(tableName);
		return new Where(queryBuilder);
	}

	/**
	 * INSERT INTO tableName fields.
	 *
	 * @param tableName the table name
	 * @param fields the fields
	 * @return the values
	 */
	public Values insertInto(String tableName, String[] fields){

		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.setTableName(tableName);

		StringBuilder sb = new StringBuilder();
		for (String n : fields) {
			if (sb.length() > 0) {
				sb.append(',');
			}
			sb.append(n);
		}
		queryBuilder.setFields(sb.toString());
		return new Values(queryBuilder);

	}

	/**
	 * UPDATE tableName SET ([fields,values], [fields, value] ...)
	 *
	 * @param tableName the table name
	 * @param fields the fields
	 * @param values the values
	 * @return the where
	 */
	public Where update(String tableName, String[] fields, String[] values) {
		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.setTableName(tableName);

		String setQuery = "";
		for (int i = 0; i < fields.length; i++) {
			if(i != (fields.length-1)) {
				setQuery += fields[i] + "='" + values[i] + "',";
			} else {
				setQuery += fields[i] + "='" + values[i] + "'";
			}
		}
		queryBuilder.setFields(setQuery);
		queryBuilder.setUpdate(true);

		return new Where(queryBuilder);
	}

	/**
	 * Soft delete method. UPDATE tableName
	 *
	 * @param tableName the table name
	 * @return the where
	 */
	public Where deleteFrom(String tableName){
		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.setTableName(tableName);
		queryBuilder.setSoftDelete(true);
		return new Where(queryBuilder);
	}




}





