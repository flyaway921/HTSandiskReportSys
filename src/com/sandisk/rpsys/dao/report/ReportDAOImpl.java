package com.sandisk.rpsys.dao.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sandisk.rpsys.entity.Report;
import com.sandisk.rpsys.entity.User;
import com.sandisk.rpsys.jdbc.util.DBUtil;

public class ReportDAOImpl implements IReportDAO {

	/**
	 * insert a report record to table report
	 * 
	 * @param report
	 * @throws SQLException
	 */
	public boolean insert(Report report) throws SQLException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into report (id,author_id,content) values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, null);
			pstmt.setInt(2, report.getAuthorId());
			pstmt.setString(3, report.getContent());
			int n = pstmt.executeUpdate();
			if(n == 1){
				System.out.println(n+" record inserted");
				return true;
			}else
				return false;

		} catch (SQLException e) {
			System.out.println("error at insert report");
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return false;
	}

	/**
	 * delete a report from the table report by id
	 * 
	 * @param id
	 *            report id
	 * @throws SQLException
	 */
	public boolean deleteById(int id) throws SQLException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from report where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			int n = pstmt.executeUpdate();
			if(n == 1){
				System.out.println(n+" record deleted");
				return true;
			}else
				return false;

		} catch (SQLException e) {
			System.out.println("error at delete report");
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return false;
	}

	/**
	 * update a report by id
	 * 
	 * @param id
	 * @param report
	 * @throws SQLException
	 */
	public boolean updateById(int id, Report report) throws SQLException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update report set author_id = ?, content = ? where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, report.getAuthorId());
			pstmt.setString(2, report.getContent());
			pstmt.setInt(3, id);
			int n = pstmt.executeUpdate();
			if(n == 1){
				System.out.println(n+" record updated");
				return true;
			}else
				return false;

		} catch (SQLException e) {
			System.out.println("error at update report");
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return false;
	}

	/**
	 * get a report by id
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Report getById(int id) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from report where id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			Report result = new Report();
			result.setAuthorId(rs.getInt("author_id"));
			result.setContent(rs.getString("content"));
			result.setDate(null);
			return result;

		} catch (SQLException e) {
			System.out.println("error at read report");
			e.printStackTrace();
		} finally {
			rs.close();
			conn.close();
		}
		return null;
	}

	@Override
	public ArrayList<Report> getAll() throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from report";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Report> result = new ArrayList<Report>();
			while(rs.next()){
				Report report = new Report();
				report.setAuthorId(rs.getInt("author_id"));
				report.setContent(rs.getString("content"));
				report.setId(rs.getInt("id"));
				result.add(report);
			}
			return result;

		} catch (SQLException e) {
			System.out.println("error at read report");
			e.printStackTrace();
		} finally {
			rs.close();
			conn.close();
		}
		return null;
	}
}
