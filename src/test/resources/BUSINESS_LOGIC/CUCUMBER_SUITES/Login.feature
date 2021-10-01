Feature: Login feature functionality

Background: user is successfully logged in
Given user opens "Chrome" browser and exe "F:\\Selenium+Webdriver+java\\Softwares\\chromedriver_win32\\chromedriver.exe"
Given user enters url "https://www.flipkart.com/"
Given user cancel the initial login window
Given user move on Login button


@SmokeTest
Scenario Outline: login functionality with valid username and valid password
When user click on my profile
When user enter <username> as  username
When user enter <password> as  password
When user click on Login button
Then validate Login page
Then close browser Window

Examples:
       |username|password|
       |9834963085|@@Maahi@@c123|
       |9834053310|dddssssd@#|
       |9834963085|@@Maahi@@C123|
       |9834963085|password123|





























