package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;

public class Buttons implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "home/buttons";
	}

}
