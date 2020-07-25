package com.nextwin.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nextwin.board.database.Dao;
import com.nextwin.board.database.Dto;

public class ReplyViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Dao dao = new Dao();
		Dto dto = dao.getReplyView(id);
		
		request.setAttribute("reply_view", dto);
	}

}
