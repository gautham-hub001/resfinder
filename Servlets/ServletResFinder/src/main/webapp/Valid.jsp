<%@page import="java.sql.*"%>
<%@ page language="java" %>
@WebServlet("/getLogin")
<html>
<head>
<%! 
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public void jspInit(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resfinderdb","root","root");
		}catch(Exception e ){
		}
		}
%>
</head>
<body>
<%
String email = "";
String pass = "";
try{
	String sid = request.getSession().getId();
	session.setAttribute("sid",sid);
	email = request.getParameter("email");
	pass = request.getParameter("pass");
	String sql1 ="select user_id, author, uname from login where email=? and pass=?";
	pstmt = con.prepareStatement(sql1);
	pstmt.setString(1,email.trim());
	pstmt.setString(2,pass.trim());
	rs = pstmt.executeQuery();
	String uname ="";
	String author = "";
	if(rs.next()){
		uname = rs.getString("uname");
		author = rs.getString("author");
		String uid = rs.getString("user_id");
		
		session.setAttribute("uname",uname);	
		session.setAttribute("uid",uid);				
		session.setAttribute("author",author);
		session.setAttribute("error","N");			//User defined error name and value
		
		if(rs.getString("author").equalsIgnoreCase("admin")){
			response.sendRedirect("adminhome.jsp");	
		}else if(rs.getString("author").equalsIgnoreCase("user")){
			response.sendRedirect("userhome.jsp");					
		}
	}else{
			session.setAttribute("error","Y");       //User defined error name and value
			response.sendRedirect("Home.jsp");					
	}
}
catch(Exception e){
	e.printStackTrace();
	session.setAttribute("error","Y");
	response.sendRedirect("Home.jsp");						
}

%>
</body>
</html>
