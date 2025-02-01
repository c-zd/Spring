<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力内容の確認</title>
</head>
<body>
	<h1>入力内容の確認</h1>
	<p>以下の内容でログインします。</p>
	<form action="" method="post">
		<table border="0">
			<tr>
				<th>ログインID</th>
				<td>${member.loginId }</td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td>${member.password }</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="確定">
				</th>
			</tr>
		</table>
	</form>
<a href="login">内容を修正する</a>
</body>
</html>