package com.ohgiraffers.section02.prepared;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;
//JDBC에서 slelct문 생성할 때 사용하는 메소드
//Statmenet 객체일 경우 : executeQuery(쿼리문)
//PreparedStatement객체일경우 => executeQuery();
public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();
/*PreparedStatement 객체 타입: PreparedStatement 타입이면서 Statement 타입이기도함
* => 상속구조이기 때문에 다형성 적용가능
* (close)pstmt => close(Statement stmt = new PreparedStatement 타입) */
        PreparedStatement pstmt = null;

        ResultSet rset = null; //

        try {
            pstmt = con.prepareStatement("SELECT menu_Name, menu_price FROM tbl_menu");
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.printf("%S %d \n", rset.getString("menu_Name"),
                        rset.getInt("menu_price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
            close(con);
        }

    }
}
