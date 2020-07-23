package com.nextwin.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nextwin.board.database.Dao;
import com.nextwin.board.database.Dto;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Dao dao = new Dao();
		ArrayList<Dto> dtos = dao.getList();
		request.setAttribute("list", dtos);
	}

}
