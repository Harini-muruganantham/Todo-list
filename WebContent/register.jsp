<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
        <div class="container">

            <h2>User Register Form</h2>
            <div class="col-md-6 col-md-offset-3">
                <div class="alert alert-success center" role="alert">
                    <p>${NOTIFICATION}</p>
                </div>

                <form action="<%=request.getContextPath()%>/register" method="post">

                    <div class="form-group">
                        <label for="name">Name:</label> <input type="text" class="form-control" id="name" placeholder="Name" name="Name" required>
                    </div>

                    <div class="form-group">
                    <label for="gender">Choose Gender:</label><br>
                       <input type="radio" id="male" name="gender" value="male">
                         <label for="male">Male</label><br>
                       <input type="radio" id="female" name="gender" value="female">
                         <label for="female">Female</label><br>
                       <input type="radio" id="other" name="gender" value="other">
                         <label for="other">Other</label>
                    </div>

                    <div class="form-group">
                        <label for="email">Email:</label> <input type="email" class="form-control" id="email" placeholder="Email" name="email" required>
                    </div>

                    <div class="form-group">
                        <label for="name">Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                    </div>
                    
                    <div class="form-group">
                    <label for="country">Choose country:</label>
                     <select id="country" name="country">
                     
                     <%
                        try {
                        	Class.forName("com.mysql.cj.jdbc.Driver");
                        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/demo?useSSL=false","root","harini");
                        	Statement st = con.createStatement();
                        	String query = "select * from countries";
                        	ResultSet rs = st.executeQuery(query);
                        	while(rs.next()) {
      
                     %>
                     <option><%=rs.getString("country")%></option>
                          <%
                      }
                        } catch (Exception e){
                    	  out.print(e.getMessage()); 
                       }
                 %>    
                     
                     
                     </select>
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>

                </form>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>