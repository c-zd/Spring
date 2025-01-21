<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>温泉手帳 | Home</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
        <aside class="btn">
            <button>温泉登録</button>
            <button type="button" class="sort">50音順で並び替え</button>
            <select class="fliter">
                <option value="">地域別しぼり込み</option>
                <option value="hokkaidou">北海道</option>
                <option value="touhoku">東北</option>
                <option value="kantou">関東</option>
                <option value="cyubu">中部</option>
                <option value="kinki">近畿</option>
                <option value="cyugokushikoku">中国・四国</option>
                <option value="kyusyu">九州</option>
                <option value="okinawa">沖縄</option>
            </select>
            <!--ログアウトしますか？の確認を入れる。okなら/home.htmlに遷移する-->
            <a href="">ログアウト</a>
        </aside>

    <header>
        <h1>温泉手帳</h1>
    </header>

    <main>
        <ul class="list">
            <li>北海道: 登別温泉</li>
            <li>青森県: 十和田湖温泉</li>
            <li>秋田県: 男鹿温泉</li>
            <li>岩手県: 花巻温泉郷</li>
        </ul>
    </main>



</body>
</html>