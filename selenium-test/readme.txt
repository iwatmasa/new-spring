Seleniumを使ったテスト

０．環境設定
以下のツールでSeleniumを使ったテスト環境を設定しています。

【テストツール】
・Selenium 4.34.0
 
【テスト用スクリプト言語】
・Python 3.13.5
・JavaScript（node.js 22.16.0）
・Google Chrome 138.0.7204.97
・chromedriver_binary 137.0.7151.119.0

１．JavaScriptを使ったSeleniumテストの作成
対象のソースを表示した状態で、GitHub Copilotのチャットに以下を入力する。
※デフォルトのSeleniumテストはJavaScriptで生成さえれる

```
/// tests
// test関数が正しく動作するかSeleniumでテストする
```
index.jsにテストコードが生成される。

２．JavaScriptを使ったSeleniumテストの実行
以下のコマンドで、テストを実行する。

node index.js

３．Pythonを使ったSeleniumテストの作成
対象のソースを表示した状態で、GitHub Copilotのチャットに以下を入力する。

```
/// tests
// test関数が正しく動作するかpythonを使ったSeleniumでテストする
```
test.pyにテストコードが生成される。

４．Pythonを使ったSeleniumテストの実行
以下のコマンドで、テストを実行する。

 python test.py
 