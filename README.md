# Sales Reporting for a Store

Print reports for sales made at a Store.
See this lab sheet for detailed description: [PracticeExam.pdf](https://github.com/skeoop/skeoop.github.io/blob/master/week8/PracticeExam.pdf).

This project includes a JAR file (`store.jar`) containing code for the Store, Sale, and LineItem classes that you will use.  Add the JAR to your project in Eclipse or Netbeans. See labsheet for how to add a JAR to your project.

## There are 3 problems

Use the package `store` for your solution to these three problems:

1. Write a class named SalesReport.  It prints a report of what is in one Sale.  You can run the JAR file to see a sample report.(*) A sample is also in the labsheet.

2. Write a Comparator for LineItems that orders items by description, alphabetically and ignore case.

3. Write a class named SalesAnalyzer that creates a report of how many units of each product were sold.

The structure of the classes in this lab is similar to many e-commerce applications, but simpler.

(*) To run a JAR (if it has a main class):
```
> java -jar store.jar
```
