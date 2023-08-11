package Controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Common.Dto.UserDto;
import Domain.Common.Service.UserService;
import Domain.Common.Service.UserServiceImpl;

public class user_select_all implements SubController {

	private UserService service = UserServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		
		HttpSession session = req.getSession();
		String role= (String) session.getAttribute("role");
		
		// 2 입력값 검증(생략)

		// 3 서비스 실행(서비스모듈작업 이후 처리)
		List<UserDto> list = null;
		try {
			list =  service.userSearch(role);
			req.setAttribute("userList", list);
			req.getRequestDispatcher("/test_user_selectAll.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
