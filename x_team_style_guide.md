# X-Team 74 Style Guide

We want to stick to class code formatting as much as possible because it's what we are used to writing. Our main philosihpy is to emphasize readability over shortness of code. This means all if statements and loops should have brackets with code on the next line (even if the code is a one-liner). Also, a significant convention is to have the first bracket on the same line as the declaration (see class example).

## Naming conventions

We want to generally follow accepted naming convention like UpperCamelCase, using underscores for spaces, etc. Generally, as long as a name isn't too generic and is clearly defined it is a good name

### Examples
* Interfaces, Classes, and Exception Types :
  * Start with a capital letter, and all new words should be capitalized
```java
public class NewClass{

}

public interface NewInterface{

}

public class NewException extends Exception{

}
```
* Fields, Methods, Parameters, and Local Variables:
  * Start with a lower case letter, no spaces or underscores, distinguish words with capital letters
```java
<T> field1;
<T> field2;

public newMethod(<T> newParameter1, <T> newParameter2) {
  <T> localVariable1;
  <T> localVariable2;
}
```
* Instance Constants and Class Constants
  * Capitalize all letters in name. If more than one word, separate with an underscore.
```java
public final SIZE = 10;

public final SIZE_OF_SIDE = 25;

```
## Commenting style for public and private members of a class or interface:

Use JavaDoc comments with two * on the first line. JavaDocs should be used for classes, constructors, and methods.
Here is an example:
```java
/**
* This method does X
* @param param1 - What param1 does
* @return What method returns
*/
```
For inline comments only a double slash should be used for shorter comments. Longer blocks of comments should use the commenting block. Use these for anything other than classes, constructors, and methods. Here is an example: 
```java
//Inline comment
/*
*This also works too
*/
```

### Examples

* classes
```java
  public class MyClass {
      //Class code
  }
  ```
* fields
```java
  public int myInt;
  ```
* constructors
```java
  public Car(T obj){
      //Constructor code
  }
  ```
* methods
```java
  public void newMethod(T obj){
      //Method code
  }
  ```
* coding style (brackets, horizontal, and vertical spacing) for:
  * if statements: 
  ```java
  if (1 == 0) { 
       System.out.print("Hello World");
  }
  ```
  * switch statement:
  ```java
  switch (course) { 
      case 1:  dateTime = 1; 
          break; 
      default: dateTime = 0; 
          break; 
  }
  ```
  * while loops: 
  ```java
  while(true) { 
 	    System.out.println("Hello World"); 
  }
  ```
  * for loops
  ```java
  for (initialization; condition; increment/decrement) { 
      //code
  } 
  ```
  * enhanced for loops
  ```java
  for (String element : array) {
      //code 
  }
  ```

