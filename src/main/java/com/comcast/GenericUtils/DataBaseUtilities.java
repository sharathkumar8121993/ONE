package com.comcast.GenericUtils;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtilities {
    Connection conn = null;
    ResultSet result = null;

    /**
     * this method will establish connection with the database
     *
     * @throws SQLException
     */

    public void connectToDB() throws SQLException {
        Driver driverRef;
        try {
            driverRef = new Driver();
            DriverManager.registerDriver(driverRef);
            conn = DriverManager.getConnection(IConstantsAndPath.dbUrl, IConstantsAndPath.dbUserName, IConstantsAndPath.dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void closeDB() throws SQLException{
        conn.close();
    }

    /**
     *This method helps to verify data in database
     * @param query
     * @param columnIndex
     * @param expData
     * @return
     */

    public String executeQueryAndGetData(String query, int columnIndex, String expData) throws SQLException {
        boolean flag = false;
        result = conn.createStatement().executeQuery(query);
        while (result.next()) {
            if (result.getString(columnIndex).equalsIgnoreCase(expData)) {
                flag = true;
                break;

            }
        }
        if (flag){
            System.out.println(expData+"data verified in database");
        }
        else {
            System.out.println(expData+"data not verified");
        }
        return expData;


    }
}