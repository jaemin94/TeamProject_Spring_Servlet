package Controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Common.Service.UserService;
import Domain.Common.Service.UserServiceImpl;


public class user_delete implements SubController {

	private UserService service = UserServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
			// 1 파라미터 추출
					HttpSession session = req.getSession();
					String id = (String) session.getAttribute("id");
					String sid = (String) req.getAttribute("sid");

					// 2 입력값 검증
					if (id == null) {
						System.out.println("[ERROR] Data Validation Check Error!");
						
					}
					// 3 서비스 실행

					Boolean rValue = false;
					try {
						rValue = service.UserDelete(id, sid);
						req.getRequestDispatcher("/test_check_delete.jsp").forward(req, resp);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		
	}
	
}

