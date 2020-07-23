package com.nextwin.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nextwin.board.database.Dao;
import com.nextwin.board.database.Dto;

public class ContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Dao dao = new Dao();
		Dto dto = dao.getContentView(id);
		
		request.setAttribute("content_view", dto);
	}

}
