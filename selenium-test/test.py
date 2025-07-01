from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
try:
    driver.get("http://localhost:8080/test")
    body = driver.find_element(By.TAG_NAME, "body").text
    if body == "Test Success":
        print("Selenium Test: /test endpoint Success!")
    else:
        print("Selenium Test: /test endpoint Unexpected response:", body)
finally:
    driver.quit()
