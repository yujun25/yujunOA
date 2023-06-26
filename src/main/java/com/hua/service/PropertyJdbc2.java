package com.hua.service;
import com.hua.utils.DBUtil;

import java.sql.*;

public class PropertyJdbc2 {
    public static void main(String[] args) {
        //1.加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String username="root";
            String password="yujun";
            String url="jdbc:mysql://localhost:3306/mvc?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
            Connection conn= DriverManager.getConnection(url,username,password);
            //3.获取SQL执行对象
            Statement st = conn.createStatement();

            String sql="select * from t_user where userid=1";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("====================================");
                System.out.println("id: " + rs.getInt("userid"));
                System.out.println("name: " + rs.getString("username"));
                System.out.println("password: " + rs.getString("password"));


            }

            rs.close();
            st.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

        }

    }
}