package model.QueryBuild;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Model;

import org.apache.commons.lang.StringEscapeUtils;
/**
 * The Class Execute.
 */
public class Execute extends Model {

	/** The select. */
	private final String SELECT = "SELECT ";

	/** The from. */
	private final String FROM = " FROM ";

	/** The where. */
	private final String WHERE = " WHERE ";

	/** The insertinto. */
	private final String INSERTINTO = "INSERT INTO ";

	/** The update. */
	private final String UPDATE = "UPDATE ";

	/** The values. */
	private final String VALUES = " VALUES ";

	/** The query builder. */
	private QueryBuilder queryBuilder;

	/** The where. */
	private Where where;

	/** The values. */
	private Values values;

	/** The get all. */
	private boolean getAll = false;

	/**
	 * Gets the query builder.
	 *
	 * @return the query builder
	 */
	protected QueryBuilder getQueryBuilder() {
		return queryBuilder;
	}

	/**
	 * Gets the where.
	 *
	 * @return the where
	 */
	protected Where getWhere() {
		return where;
	}

	/**
	 * Gets the values.
	 *
	 * @return the values
	 */
	protected Values getValues() {
		return values;
	}

	/**
	 * Checks if is gets the all.
	 *
	 * @return true, if is gets the all
	 */
	protected boolean isGetAll() {
		return getAll;
	}

	/**
	 * Instantiates a new execute.
	 *
	 * @param queryBuilder the query builder
	 * @param getAll the get all
	 */
	public Execute(QueryBuilder queryBuilder, boolean getAll) {
		this.queryBuilder = queryBuilder;
		this.getAll = getAll;
	}

	/**
	 * Instantiates a new execute.
	 *
	 * @param queryBuilder the query builder
	 * @param where the where
	 */
	public Execute(QueryBuilder queryBuilder, Where where) {
		this.queryBuilder = queryBuilder;
		this.where = where;
	}

	/**
	 * Instantiates a new execute.
	 *
	 * @param queryBuilder the query builder
	 * @param values the values
	 */
	public Execute(QueryBuilder queryBuilder, Values values) {
		this.queryBuilder = queryBuilder;
		this.values = values;
	}

	/**
	 * Execute SQL and returns ResultSet.
	 *
	 * @return ResultSet
	 * @throws SQLException the SQL exception
	 */
	public ResultSet ExecuteQuery() throws SQLException {
		String sql = "";
		if (isGetAll()) {
			sql = SELECT + getQueryBuilder().getSelectValue() + FROM + getQueryBuilder().getTableName() + ";";
			try {
				getConnection(false);
				getConn();
				String cleanSql = StringEscapeUtils.escapeSql(sql);
				sqlStatement = getConn().prepareStatement(cleanSql);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			sql = SELECT + getQueryBuilder().getSelectValue() +
					FROM + getQueryBuilder().getTableName() +
					WHERE + getWhere().getWhereKey() + " " + getWhere().getWhereOperator() + " ?;";
			try {
				getConnection(false);
				getConn();
				String cleanSql = StringEscapeUtils.escapeSql(sql);
				sqlStatement = getConn().prepareStatement(cleanSql);
				sqlStatement.setString(1, getWhere().getWhereValue());

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sqlStatement.executeQuery();
	}


	/**
	 * Execute SQL Query. <strong>OBS nothing returns.</strong>
	 *
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean Execute() throws SQLException {
		String sql = "";

		if (getQueryBuilder().isSoftDelete()) {
			sql = UPDATE + getQueryBuilder().getTableName() + " SET active = 0" +
					WHERE + getWhere().getWhereKey() + " " + getWhere().getWhereOperator() + " " + getWhere().getWhereValue() + ";  ";
			try {
				getConnection(false);
				getConn();
				String cleanSql = StringEscapeUtils.escapeSql(sql);
				sqlStatement = getConn().prepareStatement(cleanSql);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if(getQueryBuilder().isUpdate()) {
			sql = UPDATE + getQueryBuilder().getTableName() + " SET " + getQueryBuilder().getFields() + "" + WHERE + getWhere().getWhereKey() + " " + getWhere().getWhereOperator() + " ?;";
			try {
				getConnection(false);
				getConn();

				sqlStatement = getConn().prepareStatement(sql);
				sqlStatement.setString(1, getWhere().getWhereValue());

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(sql);

			sql = INSERTINTO + getQueryBuilder().getTableName() + " (" + getQueryBuilder().getFields() + ")" + VALUES + "(";
			StringBuilder sb = new StringBuilder();
			for (String n : getValues().getValues()) {
				if (sb.length() > 0) sb.append(',');
				sb.append(" ?");
			}
			sql += sb.toString();
			sql += " );";
			try {
				getConnection(false);
				getConn();
				String cleanSql = StringEscapeUtils.escapeSql(sql);
				sqlStatement = getConn().prepareStatement(cleanSql);
				int x = 0;
				for (int i = 0; i < getValues().getValues().length; i++) {
					x = i;
					sqlStatement.setString(x+1, getValues().getValues()[i]);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sqlStatement.toString());
		return sqlStatement.execute();
	}


}
