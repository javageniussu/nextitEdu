package kr.or.nextit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name="GuguDan" , urlPatterns={"/guguDan.test"})
public class GuGuDanServlet extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String flag = req.getParameter("flag");
		PrintWriter out = resp.getWriter();
		out.println( ("left".equals(flag) ? "<tr style=\"text-align : center;\">": "") );
		for( int dan =1; dan <10; dan++) {
			if("left".equals(flag)) {out.println(" <td>"); }  
			else {out.println("<tr style=\"text-align : center;\">\" \n <td>");}
			for(int i =1 ; i< 10; i++) {
				out.printf(" %d * %d = %d <br> \n", dan,i,(dan * i));
			}
				out.println("left".equals(flag) ? "</td> \n" : "</td> \n<tr> \n");
			}
		out.println("<title>구구단</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>구구단 출력 </h1>");
		out.println("</body>");
		out.println("<script>");
		out.println("function gugudan() {");
		out.println("for(var i=1; i <= 9 ; i++) {");   
		out.println("  document.write(i) ");
		out.println("  <br> ");
		out.println("	for(var j=1; j <= 9 ; j++) {");
		out.println("	   document.write( i * j)");
		out.println("	}					");
		out.println("		} 				");
		out.println("			} 				");
		out.println("gugudan();");		
		out.println("param : " + req.getParameter("test"));
		out.println("</script>");
		out.println("</html>");
		
		
		//super.service(arg0, arg1);
	}
}
