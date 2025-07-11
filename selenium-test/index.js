const { Builder } = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');
const chromeOptions = new chrome.Options();
chromeOptions.addArguments(
  '--headless',
  '--no-sandbox',
  '--disable-dev-shm-usage',
  '--user-data-dir=/tmp/chrome-user-data'
);

(async function test() {
  let driver = await new Builder().forBrowser('chrome').setChromeOptions(chromeOptions).build();
  try {
    await driver.get('http://localhost:8080/qiita');
    const body = await driver.findElement({css: 'body'}).getText();
    if (body === 'Qiita Success') {
      console.log('Selenium Test: Success!');
    } else {
      console.error('Selenium Test: Unexpected response:', body);
    }
  } finally {
    await driver.quit();
  }
})();

(async function testTestEndpoint() {
  let driver = await new Builder().forBrowser('chrome').setChromeOptions(chromeOptions).build();
  try {
    await driver.get('http://localhost:8080/test');
    const body = await driver.findElement({css: 'body'}).getText();
    if (body === 'Test Success') {
      console.log('Selenium Test: /test endpoint Success!');
    } else {
      console.error('Selenium Test: /test endpoint Unexpected response:', body);
    }
  } finally {
    await driver.quit();
  }
})();