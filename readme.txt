Spring Bootのテスト用ソース

１．プロジェクトについて
spring-boot-test配下にSTS（spring tool suite）を使った作成したSpringBootのプロジェクトが配置されています。
以下のコマンドで、対象プロジェクトに移動。

cd spring-boot-test

２．ビルド方法(前回ビルド結果を削除して再ビルド)
以下のコマンドを実行。

mvn clean package

ローカルリポジトリを別の場所に変更する場合は、settings.xmlを作成して、以下の様にコマンドを実行する。
mvn clean package -s ../../.m2/settings.xml

３．SpringBootアプリケーション起動

java -jar target/spring-boot-test-0.0.1-SNAPSHOT.jar

４．SpringBootのAPI呼び出し

４．１テスト
URL：http://localhost:8080/test

現在時刻を取得して以下の形式の文字列をボディ部分に返却する。
"TestRepository#execute - yyyy/MM/dd HH:mm:ss"

４．１Quuitaのユーザ情報取得
URL：http://localhost:8080/qiita

【実行例】
```
TestRepository#execute - 2025/06/30 14:20:01
```

「https://qiita.com/api/v2/users/hrk_okd」に接続して、応答結果のJSON電文から項目を取得する。
取得した項目から以下の項目のみを設定して応答電文のボディ部分にtoString()メソッドで文字列化して返却する。

    ・id：QiitaのID（id）を取得して設定
    ・qiitaId：QiitaのID（id）を取得して設定
    ・itemsCount：投稿数（itemsCount）を取得して設定
    ・websiteUrl：ウェブサイトのURL（websiteUrl）を取得して設定

【実行例】
```
QiitaUserInfoView(id=hrk_okd, qiitaId=hrk_okd, itemsCount=13, websiteUrl=https://ritsuan-eng.com/)
```
