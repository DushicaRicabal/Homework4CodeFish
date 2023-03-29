package sleniumRecap;

public class InterviewQuestions {
    /*
    1-What are the Advantages and disadvantages of Selenium?
    Advantages:
                *free resource
                *it supports multiple languages and browsers
                *it has big comunity
    Disadvantages:
                  * you can not automate captca, pictures,mobile aplications etc
                  *there is no direct call (customer service) fod support
                  *it  only automates web application(browser)
                  *it does not have any system to generate report so we use external resources(testNg, cumber,etc..
    2-What type of testing can you automate with Selenium ?
       *Regression
       *Smoke
       *Functional test(Positive and negative testing)
   3-What are the test types you do not automate with Selenium?
       *Performance testing (Jmeter-->it is not hard to learn )
       *Manual Testing
       *NonFunctional testing (stress testing, loading testing, performance )
       *Adhoc Testing (randomly testing -monkey testing)
   4-What is Locator in Selenium ? What type of locators do you use in your Framework?
      -->Locator is a way to find element/s from DOM (Development Tool/page)
     The Locators that I amusing in my framework are:
       -->ID --finds the element with ID attribute
       -->ClassName-->find the element with Name  attribute
       -->TagName--finds the element with TagName
       -->LinkText--finds the element with "a" tagnemw or "text"
       -->PartialLinkText--finds the element with "a"tagname and "partialtext" or fullText
       -->CSS--find the element with ( id or css)--for id( #) for class(.)
       -->Xpath-- find the element with XPATH ,.=,contains
   5-How do you handle dynamic elements in UI automation?
       -->In my project I have faced many dynamic elements during the UI  automation
          --To handle this issue I did:
              **I use parent child relationship for the elements
              ***I use different ways to locate the element ( like following -sibiling, preceding sibiling, contains, etc)
              *I found the element with different attributes which is not dynamic
  6-Difference between driver.get() and driver.navigate()  ?
      Navigate()-->it doesnt Wait Webelement to be loaded form page,
      it waits for only specific elements that you are looking from page )
                -->It has methods( to, refresh,back,forward
      Get() -->It waits all the Webelements to be loaded
            -->It does not have any methods
  7-Difference between driever.close() and driver.quit()?
            Driver.close-- it specificaly closes the window that our driver is pointing.
            *--it closes only one tab
            Driver.quit()-- it closes all the tabs opened during the automation run.

  8-What is Xpath and can you tell me types of Xpath? Which one do you use the most?
     8.1--What is the difference between Absolute and Relative Xpat?
      -->XPATH is one of the locator that I use in Selenium to find the element.
      -->There are two types of Xpath:
     Absolute Xpath:
          *It goes from all the way top(html) to child
          *It starts with single slash (/)
     Relative Xpath:
        *it goes directly to the child or parent/child
         example://div[@id='parent]//a[.='child']//parent child
         example://div[@id='parent]//following-sibilings::a//following sibiling
        *it starts with double slash(//)

   NOTE:The most use is the Relative Xpath  since it is more functional and effective to locate the element.

   9-How do you handle drop-downs?(static or dynamic drop-down)
      In my project , I was handling the drop -downs with different ways:
      First: I would definitey check the tag of the WebElement(location)
            *If  the location has "SELECT" tagName  then->I useSELECT CLASS
            exp:Select select= new Select(locationOfElement);
            *If the location  doesn't have SELECT  tagname then -->I can use:
               -->Action class  method like clikck  or Weblements method click and choose option
               -->I would use sendKeys() to choose the option .
  10-Can you tell me what do you know aboutSelect class and it's methods?
      Select class is a way to handnle Drop-downs:
      -->IT is really uesfull  for my project.
      -->The WebElement must have Select Tagname

      Select select =newSelect(location of webelement):
          *select.selectByvisibletext("textValue")
          *select.selectByValue("value")
          *select.selectByIndex("indexNumber")
          *select.getFirstSelectedOtpion()-it will give you default option selected
          *select.getOptions()--it will give you all options(List<String>)

   11-What is kind of exceptions have you faced in your Automation Framework?
       -->NOSUCHELEMENT EXCEPTION

       -->STALEELEMENTREFERENCE EXCEPTION

       -->ELEMENT INTERCEPTED EXCEPTION
       -->NO SUCH WINDOW EXCEPTION
       -->NO SUCH FRAME EXCEPTION
       -->TESNG EXCEPTION
       --?UNHANDLED ALERT EXCEPTION

       -->ELEMENT ISNOT INTERACTABLE EXCEPTION
       -->TIMEOUT EXCEPTION
       -->INVALID SELECTOR EXCEPTION

  12-How do you handle Stale Element Reference Exception?
      In my project this exception is one of the hard ones that was giving me headache:

      -->This excpetion happens when:
           -The DOM is not updated fast
           -The dom's element values is changed
           -The page is refreshed
      -->Wait times might  solve the issue
           - I would use Thread.sleep or Explicitly wait with condition
           **-I would reassign and reinitialize the webelement
           -I would refresh the page

   13-How do you handle pop-ups?    Can you tell me the method that you handle JS alert?
   pop up means allert

       There are different types of pop-ups that I faced during automation?
       1-OperationSystem -OS pop-ups -we can not handle directly with Selenium
       2- HTML  alert /pop-up: I just need to find element and click on it (like OK or Cancel Button )
       3-Java Script alert/pop-up : I handle it with Alert Interface
           Alert alert=driver.switchTo().alert();
           alert.accept()-->it clicks "OK" button from alert
           alert.dismiss()--> it clicks "CANCEL" button from alert
           alert.getText()-->it gets the text from alert
           alert.sendKeys()-->it sends key to the alert.

    14-What do you know about iframe? and how do you handle this in your automation ?

        -Iframe is html inside the html.
        -It is used in protection purposes
        -widely used for advertizment-ads, documents or videos

        -->First switch your frames  based on the values of your WebELement:
             -->driver.switchTo.frame(id or name)
             -->driver.switchTo.frame(WebElement)
             -->driver.switchTo.frame(index)
             -->driver.switchTo.ParentFrame()-->It will go to the parent Frame
             -->driver.switchTo.DefaultContent()-->It will no matter what  go to the main html directly
                                                   >no matter what how many times you switch your frames from parent

        NOTE:If you do not handle this ifrae , you will get NOSUCHElement exception
       NOTE:If the Value  of switchframe is wrong, you will get NoSUCHFRAME exception
  15-What do you know About Class and can you tell me the methods you used the most during automation?
  Actions class basicaly  does the functionality  of mouse. I can say it is relly  useful  in same cases during
   my automation to handle same elements . some of the important methods are :
   IQ:*****-->ContextClick--> it right clicks on the WebElement        ======IQ stands for Interview Question ====
             -->DoubleClick -->it double clicks the element
             -->DragaAndDrop-->it drags and drops  the element from one spot to the another spot
             --->ClickAndHold-->it clicks and holds the element
             **--->MoveToElement--it hovers over the element
             -->release--it releases the element that you are holding ( it mostly comes after clickAndHold)
             --click() --it clicks the element
             --sendKeys()--it sends the key
        **** --perform()-It performs the actions method (Without that it will not work )

   16- What is the diference driver.findELement ad driver.findELements?

    * Find Element:  1-driver.findELement(By.locator(");Syntax
                     2-REturns single WebElement
                     3-Once it fails , it throws NOSUCHELEMENT exception
   *Find elements:   1-driver.findElements(By.locator(");Syntax
                     2-Returns list<WEbElement>
                     3-once it fails it returns nothing ( empty list )
 17-Can you tell me some driver and some WEbElement methods you use during automation mostly ?
    Driver Methods : * get() * navigate() *getTitle() *getCurrentURL(), *switchTo(),*Quit(),*close(),*GetWindowHandle/s,*manage()

    WebElement Methods : * click(),*sendKeys(),*getText(),*isDisplayed(),*isSelected(),*getAttribute(),*getCSSVAlue(),*getclear(),*submit()
 18-What is the difference  difference between  check-box  and radio button?
    Check box -You can click multiple boxes
    RadioButton-You can choose only one ussualy it is cirlce
 19-How do you use multiple  windows in automation?  and What is the difference bwtween getWindowHandle(), and getWindowHandles()  ?

     --to be able to handle the windows :
         i need to switch  my driver  into the specific window with my logic
             Set<STring> allWindows=driver.getWindowHandles();
             for(string pageID:allWindows){
             driver.switchTo.window(pageId)
             if(driver.getTitle.contains(ExpectedTitle){
             break;}

    1-Use Get windowHandles  to store  all pages id and Set
    2-loop trough  all pages  and switch
    3-Break the loop  when title is what I am looking for

    NOTE: Get WindowHanle-->return string with single page id
          Get WindowHandles -->return Set<String> with all unique page ids

 20-How do you scroll -up  in WebBrowser during Automation?

    --I mostly  use JS scrollIntoView script. ( I store it in my Browser Utils for any time usage)
     actions.scrollByAmount(x,y)
     Keys.PageUp or Down  fast up or fast down on the page
     Keys.Arrow or Down -slowly up and down page moves

 21-How do you upload file in Selenium?




  -->Fist of all you need to find  the location  of Choose Button
  -->Find the path of the file that you are going to attach (//C://Users///usa.png
  -->Then send the keys  of locations to the choosen button


22- Wha tis the difference Assert and SoftAssert?
Assert: is a class that has some methods to validate actual and expected data .
Assert.assertEquals, assertTrue

*when it fails it throws exception  right away and do not execute the next line of code.

SoftAssert: is a class that have some methods to calidate actual and expected data.
* WE need to create an object
SoftAssert soft Assert = new SoftAssert();
When it fails does not throw an exception athen it keep executing the next codes .
*You must use Assert.all () to make it work properly othervis eit will pass all the time.


23-Can you tell me about your Singleton pattern design ?>>Can you make the constructor private static and final ?

Since I like Singleton logic because int he past I waws working on my driver and getting lots of null pointer exception
With the help of singeton i centralise my driver which reduces amount of exceptions like that.
Which means it is more reliable and safe to use
I basicaly ENCAPSULATE MY singletone
I need to have private Webdriver  and constructor
Put if condition  to check my driver is null or not
create public method to call it from other classes
24-What kind of TestNg Annotaiton do you use in your project?>
25-Can you tell me What is the purpose of @Paramater Annotation usage( please check the sublime )
26-What do you know about DataProvider And why do you use it >
27-What do you know about wait times and  can you tell me the diference between Thread .sleep implicitly explicitly  fluent wait ?





























     */
}
