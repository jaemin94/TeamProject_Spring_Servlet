package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.MemberDto;

@Mapper
public interface MemberMapper{


	@Select("select * from tbl_member")
	public List<MemberDto> selectAll();

	@Select("select * from tbl_member where username = #{username}")
	public MemberDto select(@Param("username") String username);
	
	@Insert("insert into tbl_member values(#{username},#{password},#{name},#{adr_addr},#{role})")
	public int insert(MemberDto dto);
	
	@Update("update tbl_member set password=#{password}, name =#{name},adr_addr=#{adr_addr} where username = #{username}")
	public int update(MemberDto dto);

	@Delete("delete from tbl_member where username = #{username}")
	public int delete(String username);

}
