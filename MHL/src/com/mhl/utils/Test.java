package com.mhl.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        System.out.println("输入一个整数");
        int i = Utility.readInt();
        System.out.println(i);


        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
    }
}
