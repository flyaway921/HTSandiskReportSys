package com.sandisk.rpsys.service.report;

import java.sql.SQLException;

import com.sandisk.rpsys.dto.ReportDTO;
import com.sandisk.rpsys.entity.Report;

public interface IReportService {
	
	public boolean deleteReport(Report report);
	public void modifyReport(Report report);
	//submit the report to DB.
	public boolean submitReport(ReportDTO report) throws SQLException;
}
