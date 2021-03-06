package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.XAdmin;
import service.face.AdminService;
import service.impl.AdminServiceImpl;

@WebServlet("/admin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminService adminService = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("###TEST### AdminLoginController doGet()"); 

		req.getRequestDispatcher("/WEB-INF/views/admin/main.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("###TEST### AdminLoginController doPost()"); 
		
		XAdmin admin = adminService.getLoginAdmin(req);
		System.out.println("###TEST### admin : " + admin);
		System.out.println(req.getParameter("adminid"));
		HttpSession session = req.getSession();
		
		if(adminService.loginAdmin(admin)) {
			session.setAttribute("adminlogin", true);
			session.setAttribute("adminid", adminService.getAdmin(admin).getAdminId());
			session.setAttribute("adminname", adminService.getAdmin(admin).getAdminName());
			session.setAttribute("adminauthority", adminService.getAdmin(admin).getAdminAuthority());
		} else {
			session.setAttribute("loginfail", true);
		}
		req.getRequestDispatcher("/WEB-INF/views/admin/main.jsp").forward(req, resp);
	}

}