package Domain.Common.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Domain.Common.Dto.MenuDto;

public interface MenuService {

	// 메뉴 조회하기
	List<MenuDto> getAllMenu(HttpServletRequest req) throws Exception;

	MenuDto getMenu(int menu_id) throws Exception;
	
	// 메뉴 등록하기
	boolean addMenu(MenuDto dto, String id) throws Exception;

	// 메뉴 수정하기
	boolean updateMenu(MenuDto dto, String id) throws Exception;

	// 메뉴 삭제하기
	boolean deleteMenu(int menu_id, String sid) throws Exception;

	
}