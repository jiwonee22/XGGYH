package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.XMem;
import service.face.AdminMemberService;
import service.impl.AdminMemberServiceImpl;
import util.Paging;

@WebServlet("/admin/mem/search")
public class AdminMemSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminMemberService adminMemberService = new AdminMemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/mem/search [GET]");
		
		Paging paging = adminMemberService.getPaging(req);
		System.out.println("AdminMemberListController [GET] - " + paging);
		
		//전달 파라미터 searchtype, keyword를 통해서 searchMember객체를 반환
		List<XMem> searchMemList = adminMemberService.searchMemList(req, paging);
		
		System.out.println(searchMemList);
		
		req.setAttribute("searchMemList", searchMemList);
		
		req.setAttribute("paging", paging);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/mem/search.jsp").forward(req, resp);
		
		
	
	}
}
