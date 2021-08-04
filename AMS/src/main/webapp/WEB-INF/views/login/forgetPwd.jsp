<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>로그인 페이지</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css" />
<link rel="stylesheet" href="resources/css/loginCss.css" />
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<img src="resources/loginpicture/logo.png" id="icon" alt="No.M mark" />
			</div>

			<div class="forgot">
				<h2>비밀번호찾기</h2>
				<ol class="list-unstyled">
					<li><span class="text-primary text-medium">1. </span>자신의 학번과
						이메일을 입력해주세요.</li>
					<li><span class="text-primary text-medium">2. </span>이메일에 도착한
						인증번호를 입력해주세요.</li>
					<li><span class="text-primary text-medium">3. </span>비밀번호 재설정을
						해주세요.</li>
				</ol>
			</div>
			<form class="card mt-4" action="forgetPwdAut" method="post" id="forgetPwdAuth">
				<div class="card-body">
					<div class="form-group">
						<label for="email-for-pass">학번을 입력해주세요</label> <input
							class="form-control" name="sid" type="text" id="sid-for-pass"
							placeholder="12345678"/>
					</div>
					<div class="form-group">
						<label for="email-for-pass">이메일 주소를 입력해 주세요</label> <input
							class="form-control" name="email" type="email"
							id="email-for-pass" placeholder="abcd@email.com"
							/>
					</div>
					<input type="hidden" name="sname" id="sname" />
				</div>
				<div class="card-footer">
					<button class="btn btn-success" type="button" onclick="check()">비밀번호 재설정</button>
					<button class="btn btn-danger" type="button" onclick="location.href='goLogin'">돌아가기</button>
				</div>
			</form>
		</div>
	</div>
	<script src="resources/js/forgetPwd.min.js"></script>
</body>
</html>
