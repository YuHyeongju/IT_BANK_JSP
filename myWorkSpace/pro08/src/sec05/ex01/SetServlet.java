package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cset")
public class SetServlet extends HttpServlet {
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		// servletContext객체를 가져옴
		
		List member = new ArrayList();		
		member.add("이순신");
		member.add(30);
		context.setAttribute("member",member);
		//servletContext객체에 데이터를 바인딩
		out.print("<html><body>");
		out.print("이순신과 30 설정");
		out.print("</body></html>");
		
		
	}

}
