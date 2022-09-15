package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */                                  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//목표 : 1부터 누적값 전달
		int num = Integer.parseInt(request.getParameter("num"));
		String loc = request.getParameter("loc");
		System.out.println("Add3 num -> " + num); //
		int sum= 0;
		for(int i = 1; i<=num; i++) {
			sum += i;
		}
		
		
		request.setCharacterEncoding("utf-8");//post 방식 일때 꼭 써야되는 메서드
		response.setContentType("text/html;charset=utf-8");//웹 실행시 글씨가 깨져서 나옴으로, 이과정이 꼭 필요함
		//공식 --> 사용자 browser에 보여주는 객체
		PrintWriter out = response.getWriter();//화면으로 출력해주는 자바패키지클래스
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 합계</h1>" , num);//num - > 사용자가 직접 입력하는 값
		out.printf("<h4>LOC --> %s</h4>" , loc);//loc -> 사용자가 직접 입력하는 값
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//한글이 안깨지게 해주는 엔코딩
		System.out.println("doPost 시작 ");

		doGet(request, response);
	}

}
