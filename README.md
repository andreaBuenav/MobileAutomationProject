# Mobile Automation Project
## Content table
 [Description](#description)<br/>
 [Disclaimers](#disclaimers)<br/>
 [Capabilities.json](#capabilities.json)<br/>
 [Contact](#contact)<br/>
 [Clone this](#clone) <br/>

 <br/>
 <br/>

### Description
This is a web automation project for the apk [ Web driver.io](https://github.com/webdriverio/native-demo-app/releases).<br/>
We will test different methods  to be able to know how the page is working for each one of them, and at the same time<br/>
register all the problems that the users encounter.<br/><br/>

### Disclaimers
1. The project is made with an openjdk-23.<br/>
2. There are 4 types of test that will be done one after another, this means that:<br/>
   - A press all the buttons test will be done first <br/><br/)
   - A sign up test will be done second.<br/><br/>
   - Then a login test will be done.<br/><br/>
   - Finally a swipe in different directions test will be done.<br/><br/>
3.JavaFaker was used to provide all the names, last names mails and passwords, meaning that every test has a different user with different
 personal data to interact with the page.<br/>
6. If the Android version of the project is not compatible with your device's Android version, please go back to the content table and select "Capabilities.json"
   and follow all the steps to change the Android version of the source code.<br/>
8. All the tests have a comment to know where the test of that user failed.

### Capabilities.json 
[ChromeDriver for testing](https://googlechromelabs.github.io/chrome-for-testing/)<br/>      
 To set the new chrome driver just delete the one in this path of the project: PomPractice/drivers/chromedriver.exe
then drag the new chromedriver.exe that you downloaded into the path where the deleted chromedriver was originally.<br/>

### Contact 
for any questions or suggestions pleasse contact to this mail:<br/>
[Mail](andrea.buenaventura@globant.com)<br/>

### Clone
git clone https://github.com/andreaBuenav/SourceDemoAutomationProject.git

