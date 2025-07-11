from selenium import webdriver

from selenium.webdriver.common.by import By

from selenium.webdriver.support.ui import WebDriverWait

from selenium.webdriver.support import expected_conditions as EC

import time

# Chromeオプション追加
from selenium.webdriver.chrome.options import Options
chrome_options = Options()
chrome_options.add_argument('--headless')
chrome_options.add_argument('--no-sandbox')
chrome_options.add_argument('--disable-dev-shm-usage')
chrome_options.add_argument('--user-data-dir=/tmp/chrome-user-data-py')


def test_registration(driver, wait, id_val, name_val, email_val, expect_success):

    driver.get("http://localhost:8080/registration")

    wait.until(EC.presence_of_element_located((By.ID, "employeeForm")))

    # 入力欄をクリア

    driver.find_element(By.ID, "id").clear()

    driver.find_element(By.ID, "name").clear()

    driver.find_element(By.ID, "email").clear()

    # 値をセット

    driver.find_element(By.ID, "id").send_keys(id_val)

    driver.find_element(By.ID, "name").send_keys(name_val)

    driver.find_element(By.ID, "email").send_keys(email_val)

    # 登録ボタンをクリック

    driver.find_element(By.ID, "postBtn").click()

    time.sleep(1)

    # 結果表示欄のテキストを取得

    result = driver.find_element(By.ID, "result1").text

    if expect_success:

        if "成功" in result or "登録" in result:

            print(f"登録テスト（正常系: {id_val}, {name_val}, {email_val}）: 成功")

        else:

            print(f"登録テスト（正常系: {id_val}, {name_val}, {email_val}）: 失敗（結果: {result}）")

    else:

        if "エラー" in result or "失敗" in result or result.strip() == "":

            print(f"バリデーションテスト（異常系: {id_val}, {name_val}, {email_val}）: 成功（エラー表示あり）")

        else:

            print(f"バリデーションテスト（異常系: {id_val}, {name_val}, {email_val}）: 失敗（エラー表示なし, 結果: {result})")



def main():

    driver = webdriver.Chrome(options=chrome_options)

    wait = WebDriverWait(driver, 10)

    try:

        print("ブラックボックステスト開始")



        # 正常系テスト

        test_registration(driver, wait, "1234567", "テスト太郎", "test@example.com", True)



        # 異常系テスト（ID空欄）

        test_registration(driver, wait, "", "テスト太郎", "test@example.com", False)

        # 異常系テスト（ID不正: 英字含む）

        test_registration(driver, wait, "abc1234", "テスト太郎", "test@example.com", False)

        # 異常系テスト（ID不正: 桁数不足）

        test_registration(driver, wait, "123", "テスト太郎", "test@example.com", False)

        # 異常系テスト（メールアドレス不正）

        test_registration(driver, wait, "7654321", "テスト太郎", "invalid-email", False)

        # 異常系テスト（名前空欄）

        test_registration(driver, wait, "7654322", "", "test@example.com", False)



    except Exception as e:

        print("テスト失敗:", e)

    finally:

        driver.quit()



if __name__ == "__main__":

    main()