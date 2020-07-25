package com.nextwin.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nextwin.board.database.Dao;
import com.nextwin.board.database.Dto;

public class ReplyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Dto dto = new Dto();
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setName(request.getParameter("name"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setGroup(Integer.parseInt(request.getParameter("group")));
		dto.setStep(Integer.parseInt(request.getParameter("step")));
		dto.setIndent(Integer.parseInt(request.getParameter("indent")));
		
		Dao dao = new Dao();
		dao.reply(dto);
	}

}
