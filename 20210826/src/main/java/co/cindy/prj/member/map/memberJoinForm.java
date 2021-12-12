package co.cindy.prj.member.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;

public class memberJoinForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		
		return "member/memberJoinForm";
	}

}
