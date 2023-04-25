package me.songjy.generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Domain {
    public static void main(String[] args) {
        //声明数据库连接对象
        Connection conn = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //初始化数据库连接,获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/information_schema?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                    "root",
                    "123456");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from information_schema.COLUMNS");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("COLUMN_NAME"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获得数据库连接出错");
        }
    }
}
