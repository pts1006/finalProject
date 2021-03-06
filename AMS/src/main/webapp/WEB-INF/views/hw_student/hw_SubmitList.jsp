<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>제출 과제 리스트 :: No.M University</title>
<style>
.tui-grid-cell .tui-grid-cell-content {
   text-align: center;
}
.modalBtn{ 
	margin-left: -30px;
	border-radius: 1em;
	background-color: lightpink;
	color: white;
	padding-left: 2em;
	padding-right: 2em;
	padding-top: 8px;
	padding-bottom: 5px;
	font-size: 20px;
	border:none;
}
.movebox{
	display: inline;
	float: right;
}
.btn15 {
	height: 15px;
}
</style>
</head>
<body>
<div class="content-page">
	<div class="card-body">
	<div align="center" style="display: inline;">
		<h2><span style="color:cornflowerblue;"> ' 현재 수강중인 강의 '</span> 의 제출한 과제목록</h2>
	</div>	
				<div class="box">			
				<div class="movebox"style=" width:100%;">
					<button style="float:right;"class="btn btn-facebook m-b-10 m-l-10 waves-effect waves-light" onclick=history.back()>과제 리스트</button>
				</div>	
				<div>
					<b style="font-weight: bold;float:right;"># 수정버튼 클릭시 등록한 과제는 <font color="red">삭제</font> 됩니다. <br># 제출기간이 지난 과제는 수정이 <font color="red">불가능 </font> 합니다.</b>
				</div>
			</div>
	<div class="gridTb1">
			<div id="grid" ></div>
		</div>
	<div id="grid"></div>
	</div>
</div>
<form action="deleteHwS" method="post" id="deleteHwSFrm" name="deleteHwSFrm">
<sec:csrfInput/>
<input type="hidden" id="registerId" name="registerId">
<input type="hidden" id="opennum" name="opennum">
</form>	


<script>
//grid start
	var a=1;
	var clsData = [
			<c:forEach items="${result }" var="list">
			{
				lname: '${list.lname}',
				lyear: '${list.lyear}',
				term : '${list.term}',
				opennum:'${list.opennum}',
				dividenum:'${list.dividenum}',
				registerId:'${list.registerId}',
				pcomment: '<div class="underline">${list.pcomment}</div>',
				pperiod: '<fmt:formatDate value="${list.registerDate }" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${list.pperiod }" pattern="yyyy-MM-d"/>',
				status: '<c:if test="${list.hwstatus >= 0 }"> <span style="color:red;"> 진행중</span></c:if> <c:if test="${list.hwstatus < 0}"><span style="color:blue;"> 마감</span></c:if>',
				score: '<c:if test="${list.score == 0}">등록된 점수없음</c:if><c:if test="${list.score != 0}">${list.score } / 20</c:if>',
				alterBtn:'<c:if test="${list.hwstatus >= 0 }"><button type="button" id="alterBtn" data-id="${list.registerId}" data-id2="${list.opennum}" data-id3="${list.hwstatus}" data-id4="${list.score}" class ="btn btn-facebook m-l-10 waves-effect waves-light btn15"> 삭제 </button></c:if><c:if test="${list.hwstatus < 0 }"><button type="button" id="alterNBtn" data-id="${list.registerId}" data-id2="${list.opennum}" data-id3="${list.hwstatus}" data-id4="${list.score}" class ="btn btn-facebook m-l-10 waves-effect waves-light btn15"> 삭제 </button></c:if>',
				lnum:'${list.lnum}',pname:'${list.pname}',submitFile:'<i id="download" data-id="${list.submitFile}" class="mdi mdi-file-import" style="cursor:pointer;">${list.submitFile}</i>'
			},
			</c:forEach>
		]; //컬럼DATA	
// GRID 를 보여준다.
	var grid = new tui.Grid( {
		bodyHeight:265,
		el: document.getElementById('grid'),
		pagination: true,   //페이징 처리
		pageOptions: {
		useClient: true,   //페이징 처리
		perPage: 6  //페이징 갯수
		},
			columns: [
				{header: '강의등록번호',name: 'opennum',width:100}, 
				{header: '강의번호',name: 'lnum',width:100}, 
				{header: '강의명',name: 'lname',width:120},
				{header: '년도',name: 'lyear',width:100}, //강의번호+분반
				{header: '학기',name: 'term',width:70}, //년도+학기
				{header: '분반',name: 'dividenum',width:70}, 
				{header: '교수명',name: 'pname',width:120}, 
				{header: '과제제목',name: 'pcomment'},
				{header: '제출기간',name: 'pperiod',width:200},
				{header: '진행상태',name: 'status',width:100},
				{header: '제출파일',name: 'submitFile',width:150},
				{header: '점수',name: 'score',width:140},
				{header: '삭제',name: 'alterBtn',width:80},
			], //컬럼갯수
		data: clsData
	});

	$("#download").click(function(){
		var a=$(this).data('id');
		console.log(a);
		var filePath ="/usr/local/apache-tomcat-9.0.52/webapps/AMS/resources/upload/hw_student/"+a;
			//"C:/Users/User/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/finalProject/resources/upload/hw_student/"+a;
			//"C:/Users/User/git/finalProject/AMS/src/main/webapp/resources/upload/hw_student/"+a;
		console.log(filePath);
		var fileName = a;
		location.href = "fileDownload?filePath="+filePath+"&fileName="+fileName;
	});
		
	$("#grid").on("click","#alterBtn",function(){
		var a=$(this).data('id');
		var b=$(this).data('id2');
		var c=$(this).data('id3');
		var d=$(this).data('id4');			
		
		deleteHwSFrm.registerId.value=a;
		deleteHwSFrm.opennum.value=b;
		
		if(c < 0){
			alert("수정이 불가능합니다.");
		}else{
			if(confirm(" 데이터가 삭제됩니다.   삭제 하시겠습니까?")==true){
				alert("작성페이지로 이동합니다.")		
				deleteHwSFrm.submit();
				}else{
					alert("취소되었습니다");
					return false;
				}
		}
		});
		$("#grid").on("click","#alterNBtn",function(){
			var a=$(this).data('id');
			var b=$(this).data('id2');
			var c=$(this).data('id3');
			var d=$(this).data('id4');			
			
			deleteHwSFrm.registerId.value=a;
			deleteHwSFrm.opennum.value=b;
			
			if(c < 0){
				alert("수정이 불가능합니다.");
			}else{
				if(confirm(" 데이터가 삭제됩니다.   삭제 하시겠습니까?")==true){
					alert("작성페이지로 이동합니다.")		
					deleteHwSFrm.submit();
					}else{
						alert("취소되었습니다");
						return false;
					}
			}
	});
		
		
</script>
</body>
</html>