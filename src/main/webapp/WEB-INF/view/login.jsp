<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>温泉探訪システム</h1>
		<form action="" method="post">
		    <p>ログインID</p>
		    <input type="text" name="loginId" value="${member.loginId }">
		    <p>パスワード</p>
		    <input type="password" name="password" value="${member.password }">
		    <p><input type="submit" value="ログイン"></p>
		</form>
    <a href="home">戻る</a>
</body>
</html>