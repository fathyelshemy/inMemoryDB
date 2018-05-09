package com.mondiamedia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DBUtilities {
	
	private static Logger _log= Logger.getLogger(DBUtilities.class);
	private String url="jdbc:derby:/MondiaInMemoryDB;create=true;";
	
	Connection conn=null;
	PreparedStatement ps=null;
	public DBUtilities() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance(); 
			conn=DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		
	}
	public void executeQueries(String query) throws SQLException {
			ps=conn.prepareStatement(query);
			ps.executeUpdate();

	}
	
	public ResultSet retrieveResult(String query) throws SQLException {
		ps=conn.prepareStatement(query);
		return ps.executeQuery();
	}
	public Connection getConn() {
		return conn;
	}
	
}
