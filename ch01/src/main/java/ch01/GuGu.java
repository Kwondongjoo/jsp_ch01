package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gugudan
 */
//@WebServlet("/GuGu")   // url 역할!
public class GuGu extends HttpServlet {   // 단지 class일 뿐
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuGu() {
        super();
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int num = Integer.parseInt(request.getParameter("num"));
      
      response.setContentType("text/html;charset=utf-8");
      
      PrintWriter out = response.getWriter();
      out.print("<html><body>");
      out.print("<h1>구구단 " + num + "단</h1>");
   
      for(int i=1 ; i<=9 ; i++) {
         out.printf("%d * %d = %d<br>", num, i, (num*i));
      }
      
      out.print("</body></html>");
      out.close();
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
	   
	   doGet(request, response);
   }
}