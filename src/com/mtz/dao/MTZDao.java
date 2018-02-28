package com.mtz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mtz.po.MTZ;
import com.mtz.util.DBManager;

public class MTZDao {
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	public  Boolean addMtz(MTZ mtz){
		Boolean b=false;
		try {
			conn=DBManager.getConn();
			String sql="insert into tb_mtz(time,grade,state)values(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, mtz.getTime());
			ps.setInt(2, mtz.getGrade());
			ps.setString(3, mtz.getState());
			int i=ps.executeUpdate();
			if(i>0){
				 b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, ps, rs);
		}
		return b;
		
	}
	
	public List<MTZ> findAll(){
		List<MTZ> mtzs =new ArrayList<MTZ>(); 
		try {
			conn=DBManager.getConn();
			String sql="select * from tb_mtz";
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String time=rs.getString("time");
				int grade=rs.getInt("grade");
				String state=null;
				if(rs.getString("state").equals("0")){
					 state="游戏成功";
				}else {
					 state="游戏失败";
				}
				MTZ mtz = new MTZ(id, time, grade, state);
				mtzs.add(mtz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, st, rs);
		}
		return mtzs;
	}
	
}
