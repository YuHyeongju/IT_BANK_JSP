package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/*
	 * public void init(ServletConfig config) throws ServletException {
	 * System.out.println("init 메소드 호출"); }
	 * 
	 * 
	 * public void destroy() { System.out.println("destory 메소드 호출"); }
	 */
	//굳이 오버라이딩 안해도 상관없음

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//창에 아이디 비밀번호 치고 로그인을 누르면 서버에 request요청이 온다. 
		//입력된 내용을 request에 저장한다.
		//저장할때 인코딩타입을 utf-8로 지정하여 글자가 안깨지게한다.
		String user_id = request.getParameter("user_id");
		//입력했던 아이디를 불러옴
		String user_pw = request.getParameter("user_pw");
		//입력했던 비밀번호를 불러옴
		String user_age = request.getParameter("user_age");
		//입력했던 나이를 불러옴
		
		System.out.println("아이디:" + user_id);
		System.out.println("비밀번호:" + user_pw);
		System.out.println("나이: " + user_age);
	}

}
