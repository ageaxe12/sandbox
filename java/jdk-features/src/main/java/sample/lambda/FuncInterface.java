package sample.lambda;



// Java program to demonstrate lambda expressions 
// to implement a user defined functional interface. 
  
// A sample functional interface (An interface with 
// single abstract method 
interface FuncInterface 
{ 
    // An abstract function 
    int abstractFun(int x); 

    // An abstract function wont work
    //String secondFun(String x); 

    
    // A non-abstract (or default) function 
    default void normalFun() 
    { 
       System.out.println("Hello"); 
    } 
} 
  