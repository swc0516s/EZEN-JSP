/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.76
 * Generated at: 2022-04-20 08:49:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.BoardBean;
import java.util.Vector;
import model.BoardDAO;

public final class BoardList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.BoardDAO");
    _jspx_imports_classes.add("java.util.Vector");
    _jspx_imports_classes.add("model.BoardBean");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div align=\"center\">\r\n");
      out.write("		<h2>전체 게시글 보기</h2>\r\n");
      out.write("		");

		// 화면에 보여질 게시글의 개수를 지정
		int pageSize=10;
		
		// 현재 카운터를 클릭한 번호값을 읽어 옴
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null){
			pageNum="1";
		}
		
		int count = 0; // 전체 글의 개수 저장
		int number= 0 ; // 페이지 넘버링
		
		int currentPage = Integer.parseInt(pageNum);
		BoardDAO bdao = new BoardDAO();
		count = bdao.getAllCount();
		
		//현재 페이지에 보여 줄 시작 번호를 설정 ==> 데이터 베이스에서 불러올 시작 번호
		int startRow= (currentPage-1) * pageSize + 1; // 1 11 21 31
		int endRow= currentPage * pageSize; // 10 20 30 40 
		
		// 최신글 10개를 기준으로 게시글을 리턴 받아주는 메서드 호출
		Vector<BoardBean> vec = bdao.getAllBoard(startRow, endRow);
		
		// 테이블에 표시할 번호 지정
           number = count - (currentPage - 1) * pageSize;
		
		
      out.write("\r\n");
      out.write("		<table width=\"700\" border=\"1\" bgcolor=\"skyblue\">\r\n");
      out.write("			<tr height=\"40\">\r\n");
      out.write("				<td align=\"right\" colspan=\"5\"><input type=\"button\" value=\"글쓰기\"\r\n");
      out.write("					onclick=\"location.href='BoardWriteForm.jsp'\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr height=\"40\">\r\n");
      out.write("				<td width=\"50\" align=\"center\">번호</td>\r\n");
      out.write("				<td width=\"320\" align=\"center\">제목</td>\r\n");
      out.write("				<td width=\"100\" align=\"center\">작성자</td>\r\n");
      out.write("				<td width=\"150\" align=\"center\">작성일</td>\r\n");
      out.write("				<td width=\"80\" align=\"center\">조회수</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			");

			for(int i=0; i<vec.size(); i++){
				//벡터에 저장되어 있는 빈클래스를 하나씩 추출
				BoardBean bean= vec.get(i);
			
      out.write("\r\n");
      out.write("			<tr height=\"40\">\r\n");
      out.write("				<td width=\"50\" align=\"center\">");
      out.print(number-- );
      out.write("</td>\r\n");
      out.write("				<td width=\"320\" align=\"left\"><a\r\n");
      out.write("					href=\"BoardInfo.jsp?num=");
      out.print(bean.getNum());
      out.write("\"\r\n");
      out.write("					style=\"text-decoration: none\">\r\n");
      out.write("					");

						if(bean.getRe_step() > 1){
							for(int j=0;j<(bean.getRe_step()-1)*5;j++){
					
      out.write("\r\n");
      out.write("					&nbsp;\r\n");
      out.write("					");

							}
					
      out.write("\r\n");
      out.write("					\r\n");
      out.write("					");

						}
					
      out.print(bean.getSubject() );
      out.write("</a></td>\r\n");
      out.write("			<td width=\"100\" align=\"center\">");
      out.print(bean.getWriter());
      out.write("</td>\r\n");
      out.write("			<td width=\"150\" align=\"center\">");
      out.print(bean.getReg_date());
      out.write("</td>\r\n");
      out.write("			<td width=\"80\" align=\"center\">");
      out.print(bean.getReadcount());
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			");

			}
			
      out.write("\r\n");
      out.write("		</table>\r\n");
      out.write("		<br><br>\r\n");
      out.write("		");

			if(count>0){
			int pageCount=count/pageSize+(count%pageSize == 0? 0:1);
			int startPage= 1;
			
			if(currentPage%10 != 0){
				startPage=(currentPage/10)*10+1;
			}else{
				startPage=(currentPage/10-1)*10+1;
			}
			
			int pageBlock=10;
			int endPage=startPage+pageBlock-1;
			
			if(endPage > pageCount)
				endPage=pageCount;
			
			if(startPage >10 ){
		
      out.write("\r\n");
      out.write("		<a href=\"BoardList.jsp?pageNum=");
      out.print(startPage - 10);
      out.write("\">[이전]</a>\r\n");
      out.write("		");

			}
			for(int i=startPage;i<=endPage;i++){
		
      out.write("\r\n");
      out.write("		<a href=\"BoardList.jsp?pageNum=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(i );
      out.write("]</a>\r\n");
      out.write("		");

		}
		if(endPage < pageCount){
		
      out.write("\r\n");
      out.write("		<a href=\"BoardList.jsp?pageNum=");
      out.print(startPage + 10);
      out.write("\">[다음]</a>\r\n");
      out.write("		");

		}
	}
		
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
