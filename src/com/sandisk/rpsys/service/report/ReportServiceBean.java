package com.sandisk.rpsys.service.report;

import java.sql.SQLException;

import com.sandisk.rpsys.dao.report.IReportDAO;
import com.sandisk.rpsys.dao.report.ReportDAOImpl;
import com.sandisk.rpsys.dao.user.UserDAOImpl;
import com.sandisk.rpsys.dto.ReportDTO;
import com.sandisk.rpsys.entity.Report;

public class ReportServiceBean implements IReportService {

	public boolean deleteReport(Report report) {
		// TODO Auto-generated method stub
		return false;
	}

	public void modifyReport(Report report) {
		// TODO Auto-generated method stub
		
	}

	public boolean submitReport(ReportDTO report) {
		IReportDAO reportDAO = new ReportDAOImpl();
		boolean success = false;
		int authorId;
		try {
			authorId = new UserDAOImpl().getByName(report.getAuthorname()).getUserId();
			Report r = new Report();
			r.setAuthorId(authorId);
			r.setContent(report.getContent());
			success = reportDAO.insert(r);
			return success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

}
