# X-Team 74 Style Guide

We want to stick to class code formatting as much as possible because it's what we are used to reading. Also, we emphasize readability over sexiness. This means all one line if statements and loops should be written out so it's easier to read.

## Naming conventions

We want to generally follow accepted naming convention like UpperCamelCase, using underscores for spaces, etc. Generally, as long as a name isn't too generic and is clearly defined it is a good name

### Examples
* interfaces
* classes
* exception types
* fields
* methods
* parameters
* local variables
* instance constants
* class constants

## Commenting style for public and private members of a class or interface:

Use JavaDoc comments with two * on the first line. Here is an example:
```java
/**
* This method does X
* @param param1 - What param1 does
* @return What method returns
*/
```
For inline comments only a double slash should be used. Here is an example: 
```java
//Inline comment
```

### Examples

* classes
* fields
* constructors
* methods
* coding style (brackets, horizontal, and vertical spacing) for:
  * if statements
  * switch statement
  * while loops
  * for loops
  * enhanced for loops
