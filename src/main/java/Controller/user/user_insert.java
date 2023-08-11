package Controller.user;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dto.UserDto;
import Domain.Common.Service.UserService;
import Domain.Common.Service.UserServiceImpl;


public class user_insert implements SubController {

	private UserService service = UserServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("User_Insert execute");

		try {
			if (req.getMethod().equals("GET")) {
				req.setAttribute("msg", "");
				req.getRequestDispatcher("./join.jsp").forward(req, resp);
				return;
			}} catch (Exception e) {
				e.printStackTrace();
			}
			// 01 파라미터
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			// 주소값을 받아오는 방법
			String roadAddress = req.getParameter("sample4_roadAddress");
			String jibunAddress = req.getParameter("sample4_jibunAddress");
			String extraAddress = req.getParameter("sample4_extraAddress");
			String detailAddress = req.getParameter("sample4_detailAddress");
			String addr = roadAddress + " " + jibunAddress + " " + extraAddress + " " + detailAddress;
			String phone = req.getParameter("phone");
			System.out.println(addr);

			try {
			// 03 서비스
			UserDto dto = new UserDto();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setPhone(phone);
			dto.setAddr(addr);
			
			boolean isjoin = service.UserJoin(dto);
			//04 뷰로 이동
			if(isjoin) {
				resp.sendRedirect(req.getContextPath()+"/login.do");
				
			}else {
				req.setAttribute("msg", "회원가입 실패...");
				req.getRequestDispatcher("./join.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

