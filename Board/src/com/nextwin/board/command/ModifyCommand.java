package com.nextwin.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nextwin.board.database.Dao;
import com.nextwin.board.database.Dto;

public class ModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Dto dto = new Dto();
		
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		Dao dao = new Dao();
		dao.modify(dto);
	}

}
