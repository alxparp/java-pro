# Java Pro

The goals of the project are repetition and practice of Java SE (Collections, Map, Stream API, I/O, net - sockets...), GIT, OOP, Algorithms, SQL. Below, each topic has its own task, and each task is in a separate branch.


## GIT - [PAV_01](https://github.com/alxparp/java-pro/tree/PAV_01)

1. Create an account on any free remote git repository provider.
2. Create a public repository with the name of the current group
3. Initialize a readme.md file with a brief description of what you expect to learn from this group
4. Add readme.md to the main branch of the remote repository
5. Initialize .gitignore file and add exception files: .idea, .git
6. Add .gitignore to the master branch of the remote repository
7. Attach the link to the repository as a completed task


## OOP - [PAV_2](https://github.com/alxparp/java-pro/tree/PAV_2)

1. Create an empty project in IntelliJ
2. Create the "Employee" class with fields: name, position, email, phone, age.
3. The constructor of the class must fill these fields when creating the object. Ensure encapsulation of internal class properties.
4. Create two classes with the same name SameName. (Use packages)
5. Create a Car class with a public start method. The start method calls the following methods:
- startElectricity()
- startCommand()
- startFuelSystem()

The listed methods are an internal (hidden) part of the complex start method. They essentially reflect the internal behavior of the Car class and should not be used outside of that class.


## Inheritance - [PAV_03](https://github.com/alxparp/java-pro/tree/PAV_03)

1. Create an empty project in IntelliJ
2. Create Dog and Cat classes with inheritance from the Animal class.
3. All animals can run and swim. The length of the obstacle is passed to each method as a parameter. The result of the action will be printing to the console. (For example, dogBobik.run(150); -> 'Bobik ran 150 m');
4. Each animal has restrictions on actions (running: cat 200 m, dog 500 m; swimming: cat cannot swim, dog 10 m).
5. * Add count of created cats, dogs and animals.


## Collections (lists) - [PAV_04](https://github.com/alxparp/java-pro/tree/PAV_04)

1. Create a countOccurance method that accepts a string list as a parameter and an arbitrary string. The list is filled with arbitrary words of 10-20 pieces, which can be repeated an unlimited number of times. Count how many times the string passed as the second argument occurs.

2. Create a toList method that accepts a complete array of arbitrary length as input. Convert the array into a list of the appropriate data type and return from the method.

Example:

Was Array [1, 2, 3]
List became [1, 2, 3]


3. Create a findUnique method that accepts as input a numeric list consisting of arbitrary values that can be repeated an unlimited number of times. A new numeric list containing only unique numbers should be returned.

4. ** Create a calcOccurance method that accepts a string list as a parameter. The list is filled with arbitrary words of 10-20 pieces, which can be repeated an unlimited number of times. Calculate how many times each word occurs. Output the result to the console.

Example:

bird: 2
Fox: 1
cat: 1


4. *** Create a findOccurance method that accepts a string list as a parameter. The list is filled with arbitrary words of 10-20 pieces, which can be repeated an unlimited number of times. Calculate how many times each word occurs. Return the result as a list of structures describing the repetition of each individual word taken.

Example:

[
    {name: "bird", occurrence: 2},
    {name: "fox", occurrence: 1},
    {name: "cat", occurrence: 1}
]


0. Create a new phonebook package.
1. Create a class Telephone Directory.
2. Create a Record class.
3. The Record class stores Name and Phone.
4. The Phone Book class stores many records of the Record data type.
5. In the Telephone Directory class, implement the add method. The method adds an Entry to the Phone Book.

Note: Multiple phones can be stored under one last name, so multiple entries are possible.

6. Implement the find() method in the Telephone Directory class. The method searches for a specific record by name. If a record is found (the first one found), then it must be returned, otherwise null is returned.

7. This implies compliance with the known (at the moment) rules for writing code in OVP and the rules of "Code Purity".

8. * In the Telephone Directory class, implement the findAll() method. The method searches for records by name. If records are found then they must be returned, otherwise null is returned.

This implementation is caused by the fact that several phones can be stored under one surname, and when requesting a specific name, all available records must be returned.


## Map - [PAV_05](https://github.com/alxparp/java-pro/tree/PAV_05)

0. Create a FileNavigator class. The class is designed to store a list of files that are located on a specific path.
For example: /path/to/file-> [files.txt, firstApp.java]

1. Create the FileData class. The class represents a specific file and consists of: file name, size in bytes, file path.

2. Implement the add method in the FileNavigator class. This method adds the file at the specified path. If the path already exists, the new file must be added to the list already associated with the corresponding path. IMPORTANT: Path is a unique value and must not be repeated.

3. Implement the find method in the FileNavigator class. The method returns a list of files associated with the path passed as a parameter.

4. Implement the filterBySize method in the FileNavigator class. The method returns a list of files whose size (in bytes) does not exceed the value passed as a parameter.

5. Implement the remove method in the FileNavigator class. The method removes the path and its associated files based on the path value passed as a parameter.

6. * Implement the sortBySize method in the FileNavigator class. The method sorts all available files by size (ascending), then returns a list of the sorted files.

7. ** Implement a consistency check in the add method in the FileNavigator class. Do not allow adding values and report this in the console when trying to add a FileData value whose path value does not match the path-key leading to the list of files.

Example:
There must be an error because the key path and the file path do not match
Path: /path/to/file
FileData: {name: ..., size: ..., path: /another/path/}


## Stream API - [PAV_06](https://github.com/alxparp/java-pro/tree/PAV_06)

IMPORTANTLY! All tasks are performed exclusively using the Stream API

1.1 The Product class is given, which consists of the following properties:
- type
- price

1.2 Implement a method to get all products in the form of a list, the category of which is equivalent to "Book" and the price is more than 250.

2.1 The Product class is given, which consists of the following properties:
- type
- price
- the possibility of applying a discount

2.2 Implement the method of obtaining all products as a list, the category of which is equivalent to "Book" and with the possibility of applying a discount. The final list must contain products with a 10% discount applied.

So, if Product A was priced at 1.0 USD, its final price will remain at 0.9 USD

3.1 This Product class, which consists of properties:
- type
- price
- the possibility of applying a discount

3.2 Implement the method of obtaining the cheapest product from the “Book” category

3.3 In the event that no product is found (a situation where there is no product with a category), throw an exception with the message “Product [category: category_name] not found”.

4.1 This Product class, which consists of properties:
- type
- price
- the possibility of applying a discount
- added date (you can use data type java.time.LocalDate, java.time.LocalDateTime or java.util.Date)

4.2 Implement a method to get the last three added products

5.1 This Product class, which consists of properties:
- type
- price
- the possibility of applying a discount
- added date (you can use data type java.time.LocalDate, java.time.LocalDateTime or java.util.Date)

5.2 Implement a method of calculating the total cost of products that meet the following criteria:
- the product was added during the current year
- the product has the type "Book"
- the price of the product does not exceed 75

** 6.1 The Product class is given, which consists of the following properties:
- ID number
- type
- price
- the possibility of applying a discount
– date of addition (you can use data type java.time.LocalDate, java.time.LocalDateTime or java.util.Date)

** 6.2 Implement the method of grouping objects by product type. Thus, the result of the method execution will be the “Dictionary” data type, which stores the key-value pair: {type: list_of_products}

Example:
{
"Book",
[
{type: “Book”, price: 100, discount: false, createDate: 01-01 -2022},
{…},
{…}
]
},
{
"Toy",
[
{type: “Toy”, price: 100, discount: true, createDate: 10–102022},
{…}
]
}


## I/O - [PAV_07](https://github.com/alxparp/java-pro/tree/PAV_07)

You need to create a console application that will have the following functionality:

1. you will be prompted to enter the name of the book and if the book is not in the root of the project (where exactly to store the books is up to you, but everything should be stored under src/ ) Get a message in the console that there is no such book

2. If there is a book, then you need to count the 10 most popular words that have more than 2 characters ( hi -> no, hello -> yes) regardless of case

3. Count the total number of unique words (not characters)

4. Write the statistics that you did above to a file ( word -> number of characters) at the end of the total number of words (file name like {bookName}_statistic.txt )

5. Also output statistics to the console


## Alogorithms - [PAV_08](https://github.com/alxparp/java-pro/tree/PAV_08)

https://leetcode.com/problems/valid-palindrome/

https://leetcode.com/problems/contains-duplicate/

https://leetcode.com/problems/two-sum/


## Net (socket) - [PAV_09](https://github.com/alxparp/java-pro/tree/PAV_09)

1. You need to create an application that will be based on ServerSocket. At startup, the application listens on port 8081 and waits for 1 client to connect.

2. After the client connects to the server, they exchange greetings. Example (hello => hello).

3. If the client's greeting contains Russian letters that are not in the Ukrainian language, the service should ask "What's wrong?". If the client answers correctly, then the server should return the current date and time and say goodbye. Otherwise the client should be disabled.....


## Algorithms - [PAV_10](https://github.com/alxparp/java-pro/tree/PAV_10)

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

https://leetcode.com/problems/reverse-linked-list/


## SQL - [PAV_11](https://github.com/alxparp/java-pro/tree/PAV_11)

1. You need to write a SQL script that can create tables with such parameters

name: wallet
fields: wallet_id, currency, amount, user_id, created (date);

name: user
fields: user_id, name, surname , date_of_registration (date).

2. Tables must be associated with the public key user.user_id

3. Add multiple entries (Insert) (optional)

4. Write a query that can display the username, the name of the currency and its amount (Join)

5. You need to send one file with these scripts (via git).


## Algorithms - [PAV_18](https://github.com/alxparp/java-pro/tree/PAV_18)

https://leetcode.com/problems/roman-to-integer/
