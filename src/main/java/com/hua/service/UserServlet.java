package com.hua.service;

import com.hua.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/user/login")
public class UserServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean success = false;
        //获取用户名和密码是否正确
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //连接数据库验证密码


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="yujun";
            String url="jdbc:mysql://localhost:3306/mvc?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
            Connection conn= DriverManager.getConnection(url,user,pass);
            String sql="select * from t_user where username=? and password=?";
            //编译sql
            PreparedStatement ps=conn.prepareStatement(sql);
            //给站位符传值
            ps.setString(1,username);
            ps.setString(2,password);
            //执行sql
             ResultSet rs=ps.executeQuery();
            if (rs.next()){
                //登录成功
                success=true;
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

        }

        //登录成功/失败
        if (success){
            //成功
            response.sendRedirect(request.getContextPath()+"/succeed.jsp");
        }else {
            //失败
            response.sendRedirect( request.getContextPath()+"/error.jsp");
        }

    }
}
