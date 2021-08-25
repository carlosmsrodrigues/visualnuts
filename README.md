# Visual Nuts exercise

This a maven project and can be run using a terminal and a few maven commands. 
To execute this project you need to have maven installed in your machine.
Consider install maven through this site [maven](https://maven.apache.org/install.html) 

- Go to the project folder and execute the following command to compile the code: mvn clean install
```sh
mvn clean install
```
- Then run the project using this command: 
```sh
mvn exec:java -Dexec.mainClass=com.visualnuts.VisualNutsApplication
```

It will show a menu where you need to select between exercise 1 and exercise 2.

Answers to the exercise:

Q: How will you keep this code safe from bugs? Show how you would guarantee that this code
keeps working when developers start making small feature adjustments. (Maybe we would
want to print the first 500 numbers, ...).

A: A good way to improve this code is to put the range number as a parameter so that we can choose if we want to print 100,200 or 500.
Also, we should validate if the number is positive or if the parameter is not null and a valid number.
In case of error, we should handle the exception to make the error more friendly and to avoid unexpected errors in our application.
Another thing we can do is covering our code with unit tests and acceptance tests/integration tests.