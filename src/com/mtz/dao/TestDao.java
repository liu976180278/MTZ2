/**
 * @Description: TODO
 * @date 2017��9��25�� ����10:10:07 	
 */
package com.mtz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mtz.util.DBManager;

/**
 * @author lzc
 * ���Ա��������м���������
 */
public class TestDao {
	public static void main(String[] args) throws SQLException {
		 Connection conn;
		 Statement st;
		 PreparedStatement ps;
		 ResultSet rs;
		 conn=DBManager.getConn();
		 String sql="select * from tb_mtz where id=1 for update";
		 conn.setAutoCommit(false);
		 st=conn.createStatement();
		 rs=st.executeQuery(sql);
		 
		 conn.commit();
	}
}
