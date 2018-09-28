GlobalVariable of type java.util.Map in Katalon Studio
==========

# What is this?

This is a Katalon Studio project for demonstration purpose.
You can clone this out to your PC and run in your Katalon Studio.

This project is made to propose a solution to a post in the Katalon Forum: https://forum.katalon.com/discussion/9854/import-export-function-for-test-case-variables#latest

The original problem raised in the post was:
>Having a lot of Test Cases and typing variables for each one requires to type it repeatedly.

I would like to propose using a GlobalVariable of type java.util.Map as a single container of data.

# How to run the demo

1. start your Katalon Studio, open this project
1. please note that a Profile `default` defines a GlobalVariable named `MEMORY` of type `java.util.Map`.
1. select `Test Suites/TS0` and run it

# Processing

1. `GlobalVariable.MEMORY` is initialized with values: `['A':'a', 'B':'b', 'C':'c', 'D':'d', 'E':'e']`
2. Test Suite `TS0` execute a series of test cases: `TC1`, `TC2`, `TC3`.
4. Each test cases prints `MEMORY`, and update it.

# Code
The source of test cases is very simple. For example, `TC1` is as simple as this:  
```
import internal.GlobalVariable as GlobalVariable

Map memory = (Map)GlobalVariable.MEMORY
CustomKeywords.'my.MemoryManager.retrieve'(memory)  # retrieve memory
memory.put('A', "TC1 said hello")
GlobalVariable.MEMORY = memory                      
```

# Output

TC1 prints the MEMORY, as follows:
```
key=A,value=a
key=B,value=b
key=C,value=c
key=D,value=d
key=E,value=e
```

TC2 prints the MEMORY, as follows:
```
key=A,value=TC1 said hello
key=B,value=b
key=C,value=c
key=D,value=d
key=E,value=e
```

TC3 prints the MEMORY, as follows:
```
key=A,value=TC1 said hello
key=B,value=TC2 said welcome
key=C,value=c
key=D,value=d
key=E,value=e
```

TC4 prints the MEMORY, as follows:
```
key=A,value=TC1 said hello
key=B,value=TC2 said welcome
key=C,value=TC3 said goodbye
key=D,value=d
key=E,value=e
```

Please not that the `GlobalVariable.memory` is shared by test cases and update by them.

# Conclusion

Each test cases declares single variable `Map memory` which contains multiple key=value pairs. There is less need to type variable names repeatedly for every test cases.
