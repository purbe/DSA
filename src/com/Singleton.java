package com;// Java program implementing com.Singleton class
// with using getInstance() method

// Class 1
// Helper class

class Singleton {
    // Static variable reference of single_instance
    // of type com.Singleton
    private static Singleton single_instance = null;

    // Declaring a variable of type String
    public String s;

    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private Singleton()
    {
        s = "Hello I am a string part of com.Singleton class";
    }

    // Static method
    // Static method to create instance of com.Singleton class
    public static synchronized Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
}

// Class 2
// Main class
class GFG {
    // Main driver method
    public static void main(String args[])
    {
        // Instantiating com.Singleton class with variable x
        Singleton x = Singleton.getInstance();

        // Instantiating com.Singleton class with variable y
        Singleton y = Singleton.getInstance();

        // Instantiating com.Singleton class with variable z
        Singleton z = Singleton.getInstance();

        // Printing the hash code for above variable as
        // declared
        System.out.println("Hashcode of x is "
                + x.hashCode());
        System.out.println("Hashcode of y is "
                + y.hashCode());
        System.out.println("Hashcode of z is "
                + z.hashCode());

        // Condition check
        if (x == y && y == z) {

            // Print statement
            System.out.println(
                    "Three objects point to the same memory location on the heap i.e, to the same object");
        }

        else {
            // Print statement
            System.out.println(
                    "Three objects DO NOT point to the same memory location on the heap");
        }
    }
}
