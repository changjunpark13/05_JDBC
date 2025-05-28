package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application3 {
    private static String empId= "200";
   // private static String empName= "홍길동";
    private static String empName= "' or 1=1 and emp_Id = '200";

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;


        String query = "select * from employee where emp_id='"+empId+"' and emp_name='"+empName+"'";
        System.out.println(query);

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            if(rset.next()){
                System.out.println(rset.getString("emp_name")+" 반갑수다");
            }else{
                System.out.println("정보 없음");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
