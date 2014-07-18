package com.sandisk.rpsys.dao.report;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sandisk.rpsys.entity.Report;

public interface IReportDAO {
	
	public boolean insert(Report report) throws SQLException;
	
	public boolean deleteById(int id) throws SQLException;
	
	public boolean updateById(int id,Report report) throws SQLException;
	
	public Report getById(int id) throws SQLException;
	
	public ArrayList<Report> getAll() throws SQLException;
	
}
