<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div align="center">
		<h3>HappyHouse Community</h3>
      	<c:if test="${empty userinfo}">
			<a href="${root}/user/register">회원가입</a><br />
	      	<a href="${root}/user/login">로그인</a><br />
      	</c:if>
      	<c:if test="${!empty userinfo}">
			<strong>${userinfo.userName}</strong> (${userinfo.userId})님 안녕하세요.<br />
	      	<a href="${root}/user/logout">로그아웃</a><br />
	      	<c:if test="${userinfo.userId eq 'admin'}">
	      		<a href="${root}/user/list">회원목록</a><br />
	      	</c:if>
      	</c:if>
      	<a href="${root}/notice/list?pg=1&key=&word=">공지사항</a><br />
      	  <a href="${root}/">메인으로</a><br />
	</div>
  </body>
</html>
