package com.sandisk.rpsys.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.sandisk.rpsys.dao.user.UserDAOImpl;
import com.sandisk.rpsys.dto.ReportDTO;
import com.sandisk.rpsys.entity.User;
import com.sandisk.rpsys.service.report.ReportServiceBean;
import com.sandisk.rpsys.service.user.UserServiceBean;


public class ReportAction extends ActionSupport {
	
	private static Logger logger = Logger.getLogger(ReportAction.class);
	ReportDTO report;

	public void submitReport(){
		
		new ReportServiceBean().submitReport(report);
		
	}
	
	public ReportDTO getReport() {
		return report;
	}
	public void setReport(ReportDTO report) {
		this.report = report;
	}
	

}
