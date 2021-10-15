package controller.mem;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.XShow;
import service.face.JjimService;
import service.impl.JjimServiceImpl;
import util.Paging;

@WebServlet("/mypage/myjjim")
public class JjimListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private JjimService jjimService = new JjimServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인한 회원아이디
		String memid = (String)req.getSession().getAttribute("memid");
		
		Paging paging = jjimService.getPaging(req, memid);
		
		List<XShow> showList = jjimService.getShowNoByMemId(paging, memid);
		
		req.setAttribute("showList", showList);

		req.setAttribute("paging", paging);
		
		req.setAttribute("linkUrl", "/mypage/myjjim");
		
		req.getRequestDispatcher("/WEB-INF/views/mem/mypage/myjjim.jsp").forward(req, resp);		

	}
}
