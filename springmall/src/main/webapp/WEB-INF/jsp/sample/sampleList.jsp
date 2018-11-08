<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sampleList</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<H1>SampleList</H1>
	<table class="table" border="1">
		<thead>
			<tr>
				<td>SAMPLE NO</td>
				<td>SAMPLE ID</td>
				<td>SAMPLE PW</td>
				<td>DELETE</td>
				<td>UPDATE</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sample" items="${sampleList}">
				<tr>
					<td>${sample.sampleNo}</td>
					<td>${sample.sampleId}</td>
					<td>${sample.samplePw}</td>
					<td><a href="/sample/removeSample?sampleNo=${sample.sampleNo}">DELETE</a></td>
					<td><a href="/sample/modifySample?sampleNo=${sample.sampleNo}">UPDATE</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tr>
			<td><c:if test="${currentPage >9}">
					<a href="/sample/sampleList?currentPage=${currentPage -10}"><button>＜＜Previous
						</button></a>
				</c:if> <c:if test="${currentPage < totalCount-10}">
					<a href="/sample/sampleList?currentPage=${currentPage +10}"><button
							type="button" style="float: right;">Next＞＞</button></a>
				</c:if></td>
		<tr>
			<a href="<%=request.getContextPath()%>/sample/addSample"><button
					type="button">Sign Up</button></a>
		</tr>
	</table>
</body>
</html>
