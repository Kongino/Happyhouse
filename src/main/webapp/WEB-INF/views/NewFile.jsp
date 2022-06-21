<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method='get' action='search'>

	<input type='hidden' name='action' value='list'/>
	<select name='key'>
		<option value='all'>----선택하세요----</option>
		<option value='Dongname'>동이름</option>
		<option value='Aptname'>아파트이름</option>
	</select>
	<input type='text' name='word' />
	<input type='submit' value='검색'/>

</form>

		<c:if test="${!empty apts}">    
		<c:forEach var="apt" items="${apts}">
            <table class="table table-active text-left">
            	<thead>
            		<tr>
            		<td>아파트이름</td>
            		<td>거래금액</td>
            		<td>거래일</td>
            		<td>면적</td>
            		<td>법정동</td>
            		
            		</tr>
            	
            	</thead>
            
                <tbody>
          			<tr>
          				<td>${apt.getAptName() }</td>
          				<td>${apt.getDealAmount() }</td>
          				<td>${apt.getDealYear() }.${apt.getDealMonth() }.${apt.getDealDay() }</td>
          				<td>${apt.getArea() }</td>
          				<td>${apt.getDongName() }</td>
          			
          			</tr>
          
          	
                </tbody>
            </table>
		</c:forEach>

	</c:if>  


</body>
</html>