<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>未ログイン | 個別情報</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <aside class="update">
        <button>更新する</button>
    </aside>

    <div class="flex-container">
        <section class="getinfo">
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
        </section><!--/.getinfo-->

        <section class="photo">
            <!--DBに登録された写真に置き換える-->
            <img src="https://placehold.jp/400x300.png" alt="">
        </section><!--/.getimg-->
    </div><!--/.flex-container-->

    <article>
        <textarea name="" id="" rows="30" cols="80" placeholder="@@@@@"></textarea>
    </article>


</body>
</html>