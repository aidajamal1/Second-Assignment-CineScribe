# Report Is In The End Of README

# Second Assignment: CineScribe 🎥
Welcome to your second assignment in the Advanced Programming course! In this project, you'll be tasked with building a Java application that acts as a simple movie aggregator, fetching data from both the IMDB and Actor API to provide information about movies and actors/actresses.

## Objectives ✏️
By completing this assignment, you will:

- Reinforce your understanding of Object-Oriented Programming (OOP) principles and apply them effectively.
- Gain familiarity with the process of issuing HTTP requests to APIs and parsing JSON data in Java.
- Learn to manage and track changes in your project using Git.
## Prerequisites ✅
Before getting started, ensure you have the following installed:

- Java 21
- Git
- Gradle as a package manager
## Tasks 📝
1. Fork this repository and clone it to your local machine.
2. Create a new branch named develop and switch to it. All development should be done in this branch.
3. Get an API key from https://omdbapi.com (for Movie class) and https://api-ninjas.com/api/celebrity (for actor class). You need to sign up and verify your account.
4. Design Movie and Actor classes with appropriate methods and attributes. Complete the methods in the code and add at least one new attribute for each class, then write a new method to get the attribute's proper value using JSON string.
5. Implement a menu in your Main class. This menu should allow users to:

 	- Enter the name of a movie and display information extracted from the JSON object in the console, including the list of actors.
	- Choose an actor from the displayed list and view their information in the console. If the actor is deceased, display him/her date of death.

6. Add error handling to handle cases where the API returns an error or the movie/actor name is not found. For instance, if the user enters the movie name "Tis Is Us," and the API responds with {"Response":"False","Error":"Movie not found!"}, the program should prompt the user to enter a new movie name until a valid one is provided.
7. Write a comprehensive report detailing the tasks you have completed and any challenges you encountered. **Your report should be written in Markdown format.** You can write your report in the provided Report-Template.md file located within the repository, which serves as a simple template for structuring your report.
8. Commit your changes and push them to your GitHub repository.
9. Submit a pull request from your develop branch to your main branch. Your mentor will review the pull request and merge it upon approval.

## Evaluation 📃
Your submission will be evaluated based on the following criteria:

- Your code should pass all the tests provided in the test directory.
- Error-free compilation and execution of your code. 
- Accurate retrieval and presentation of movie and actor data through the methods written.
- Clear code structure, readability, thorough commenting, and adherence to clean code principles.

**Note: Usage of ChatGPT or any other AI generative model to complete any part of this assignment is strictly prohibited. Violation will result in a score of 0 without warnings.**

## Bonus Objectives ✒️
For additional challenges and learning opportunities, consider the following bonus objectives:

- Enhance your classes to display more comprehensive information about movies and actors.
- Revise your report to provide more detailed insights into your approach and challenges faced.
- Utilize Postman for API testing and exploration. Postman is a powerful API client that simplifies the process of testing, documenting, and sharing APIs. It provides an intuitive interface for sending HTTP requests, allowing developers to explore and interact with APIs effortlessly.
- Provide a simple GUI (Graphical User Interface) for your project. The recommended library to do so is JavaFX. JavaFX empowers developers to create dynamic and engaging user interfaces for their Java applications, offering a modern and versatile platform for building cross-platform desktop, web, and mobile applications

## Submission ⌛
The deadline for submitting your code is Thursday, March 7 (17th of Esfand).

## Resources 📚
For assistance with this assignment, you may refer to the following resources:

🔗 [How to Write a Good README File for Your GitHub Project](https://www.freecodecamp.org/news/how-to-write-a-good-readme-file/)

🔗 [A Simple Readme Template](https://gist.github.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc)

🔗 [Markdown Cheet Sheet](https://www.freecodecamp.org/news/markdown-cheat-sheet/)

🔗 [Getting Json Data From A RESTFUL API Using Java](https://medium.com/swlh/getting-json-data-from-a-restful-api-using-java-b327aafb3751)

🔗 [Uploading a File and JSON Data in Postman](https://www.baeldung.com/postman-upload-file-json)

🔗 [Send API requests and get response data in Postman](https://learning.postman.com/docs/sending-requests/requests/)

🔗 [Getting Started With Javafx](https://openjfx.io/openjfx-docs/)

🔗 [JavaFX Tutorial by Jenkov](https://jenkov.com/tutorials/javafx/index.html)

# Report

# گزارش پروژه

## وظایف انجام شده
۱- **پیاده‌سازی کلاس Movie**:

    افزودن متدهایی برای بازیابی داده‌های فیلم، استخراج تعداد رأی‌های IMDb، رتبه‌بندی و فهرست بازیگران از پاسخ JSON
    استفاده از کتابخانه org.json برای تجزیه JSON

۲- **پیاده‌سازی کلاس Actors**:

    افزودن متدهایی برای بازیابی داده‌های بازیگر، استخراج ارزش خالص، بررسی زنده بودن بازیگر و دریافت تاریخ مرگ از پاسخ JSON
    
    استفاده از کتابخانه org.json برای تجزیه JSON

۳- **ایجاد کلاس Main**:

    پیاده‌سازی منویی برای تعامل با کاربر
    
    امکان ورود نام فیلم توسط کاربر، بازیابی داده‌های فیلم و نمایش اطلاعات شامل فهرست بازیگران
    
    امکان انتخاب بازیگر از فهرست و نمایش اطلاعات وی، شامل تاریخ مرگ در صورت فوت
    
    افزودن مدیریت خطا برای مواردی که نام فیلم یا بازیگر یافت نمی‌شود یا API خطایی برمی‌گرداند

## چالش‌های مواجه شده

 ۱- **مدیریت تجزیه JSON**:
 
    تجزیه پاسخ JSON از API به دلیل ساختار لانه‌ای داده‌ها در ابتدا چالش‌برانگیز بود
    
    راه‌حل: استفاده از کتابخانه org.json برای ساده‌سازی فرایند تجزیه

۲- **مدیریت خطا**:

    مدیریت خطاهای API و ورودی‌های کاربر نیاز به توجه دقیقی داشت تا برنامه دوستانه و مقاوم باقی بماند
    
    راه‌حل: پیاده‌سازی حلقه‌ای برای درخواست نام فیلم معتبر از کاربر و افزودن بررسی‌های خطا در پاسخ JSON

۳- **محدودیت‌های نرخ API**:

    مواجهه با محدودیت‌های نرخ در هنگام تست API باعث تأخیر در توسعه شد
    
    راه‌حل: استفاده از داده‌های شبیه‌سازی شده برای تست و محدود کردن تعداد درخواست‌های API

## نتیجه‌گیری

این پروژه به‌طور موفقیت‌آمیزی عملکردهای مورد نیاز برای تعامل با OMDb API و API Ninjas را پیاده‌سازی کرده و یک رابط کاربری دوستانه برای بازیابی و نمایش اطلاعات درباره فیلم‌ها و بازیگران فراهم می‌کند. با وجود برخی چالش‌ها، راه‌حل‌های پیاده‌سازی شده اطمینان از مقاومت و قابلیت اطمینان برنامه را فراهم کرده است
 
 
