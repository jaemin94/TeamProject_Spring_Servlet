package Controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dto.UserDto;
import Domain.Common.Service.UserService;
import Domain.Common.Service.UserServiceImpl;

public class user_update implements SubController {

	private UserService service = UserServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 1 파라미터 추출
					String id = (String) req.getParameter("id");
					String pw = (String) req.getParameter("pw");
					String name = (String) req.getParameter("username");
					String adr_addr = (String) req.getParameter("adr_addr");
					String phone = (String) req.getParameter("phone");
					String role = (String) req.getParameter("role");
					String sid = (String) req.getParameter("sid");
					// 2 입력값 검증
					if (id == null || pw == null || name == null || role == null) {
						System.out.println("[ERROR] Data Validation Check Error!");
						
					}
					// 3 서비스 실행
					UserDto dto = new UserDto(id, pw, name, adr_addr,phone, role);
					System.out.println("Dto : " + dto);

					Boolean rValue = false;
					try {
						rValue = service.UserUpdate(dto, sid);
						req.setAttribute("userDto", dto);
						req.getRequestDispatcher("/test_check_update.jsp").forward(req, resp);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		
	}
	
}
