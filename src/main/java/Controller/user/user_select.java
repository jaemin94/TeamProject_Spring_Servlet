package Controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Common.Dto.UserDto;
import Domain.Common.Service.UserService;
import Domain.Common.Service.UserServiceImpl;

public class user_select implements SubController{

	
	private UserService service = UserServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 1 파라미터 추출(생략)
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");


		
		// 2 입력값 검증(생략)
		if (id == null) {
			System.out.println("[ERROR] Data Validation Check Error!");
			
		}
		// 3 서비스 실행(서비스모듈작업 이후 처리)

		UserDto mdto = null;

		
		try {
			mdto = service.userSearchOne(id);
			req.setAttribute("userDto", mdto);
			req.getRequestDispatcher("/test_user_select.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
