<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登録画面</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
        <aside class="register">
        <!-- 登録しました！の小さいウィンドウが出てhomeに戻る -->
            <button class="btn" onclick="location.href='http://localhost:8080/Spring/home'">登録する</button>
        </aside>

        <div class="flex-container">
            <section class="input-info">
                <!--のちにDBから情報を得る操作に書き換える-->
                <form action="" method="post">
                    <div>
                        <p>温泉名:</p>
                        <input type="text">
                    </div>
                    <div>
                        <p>所在地:</p>
                        <input type="text">
                    </div>
                </form>
            </section><!--/.input-info-->

            <section class="input-img">
                <p>写真のアップロード:</p>
                <!--ファイル送信先URL未入力-->
                <!--ファイルを選択ボタンを押すとつながる場所はどう書くんだ？-->
                <form action="" method="post" enctype="multipart/form-data">
                <input type="file" name="file">
                 </form>
            </section><!--/.input-img-->
        </div><!--/.flex-container-->

        <article>
            <textarea name="" id="" rows="30" cols="80" placeholder="@@@@@"></textarea>
        </article>

</body>
</html>