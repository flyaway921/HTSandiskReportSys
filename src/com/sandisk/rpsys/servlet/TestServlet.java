package com.sandisk.rpsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<HTML>");
        out.println("      <HEAD>");
        out.println("    　　<TITLE>A Servlet</TITLE>");
        out.println("    　　<meta http-equiv=\"content-type\" " + "content=\"text/html; charset=utf-8\">");
        out.println("　　 </HEAD>");
        out.println("       <BODY>");
        out.println("             Hello AnnotationServlet.");
        out.println("     </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
	}

}
