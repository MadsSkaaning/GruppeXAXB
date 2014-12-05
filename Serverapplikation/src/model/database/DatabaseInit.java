package model.database;

import model.Model;
import model.QueryBuild.QueryBuilder;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DatabaseInit extends Model {

    //Test main method
    public static void main(String[] args) {
        try {
			new DatabaseInit().go();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void go() throws SQLException, IOException {

//        String[] keys = {"firstKey", "secondKey"};
//        QueryBuilder qb = new QueryBuilder();
//        resultSet = qb.selectFrom("users").all().ExecuteQuery();
//        resultSet = qb.selectFrom(keys, "events").where("id", "=", "123").ExecuteQuery();
//
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("email"));
//        }
//        resultSet.close();

        if (doesDatabaseExist()) {
            System.out.print("Database environment does exist");
        } else {
            System.out.print("Database environment does NOT exist");
            readfromSqlFile("src/SQLFiles/createDBscript.sql");
        }

    }
}
