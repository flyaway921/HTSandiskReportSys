package com.sandisk.rpsys.dao.report;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.sandisk.rpsys.entity.Report;
import com.sandisk.rpsys.entity.User;

public class ReportDAOImplTest {
	@Test
	public void TestInsert() throws SQLException{
		Report report = new Report();
		report.setAuthorId(12);
		report.setContent("aaaaacontent");
		report.setDate(new Date());
		new ReportDAOImpl().insert(report);
	}
	
	@Test
	public void TestUpdate() throws SQLException{
		Report report = new Report();
		report.setAuthorId(12);
		report.setContent("aaaaacosafdasdfsafffntent");
		report.setDate(new Date());
		new ReportDAOImpl().updateById(1,report);
	}
	
	@Test
	public void TestGetById() throws SQLException{
		
		Report result = new ReportDAOImpl().getById(3);
		System.out.println(result.toString());
	}
	
	@Test
	public void TestDeleteById() throws SQLException{
		
		System.out.println(new ReportDAOImpl().deleteById(5));
	}
	
	@Test
	public void TestgetAll() throws SQLException{
		
		System.out.println(new ReportDAOImpl().getAll());
	}

}
