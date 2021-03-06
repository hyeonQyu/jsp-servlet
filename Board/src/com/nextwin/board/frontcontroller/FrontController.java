package com.nextwin.board.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nextwin.board.command.Command;
import com.nextwin.board.command.ContentCommand;
import com.nextwin.board.command.DeleteCommand;
import com.nextwin.board.command.ListCommand;
import com.nextwin.board.command.ModifyCommand;
import com.nextwin.board.command.ReplyCommand;
import com.nextwin.board.command.ReplyViewCommand;
import com.nextwin.board.command.WriteCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String com = uri.substring(path.length());
		
		if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		} else if(com.equals("/write.do")) {
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/list.do")) {
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if(com.equals("/content_view.do")) {
			command = new ContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if(com.equals("/modify.do")) {
			command = new ModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/delete.do")) {
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/reply_view.do")) {
			command = new ReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} else if(com.equals("/reply.do")) {
			command = new ReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
