public class A
{
    // prints instance block first and then constructor
    // if constructor is not called, then instance blocks won't be called.
    static
    {
        System.out.println("in static instance block");
    }
    public A()
    {
        System.out.println("in A constructor");
    }
    {
        System.out.println("in instance block");
    }
    public static void show ()
    {
        System.out.println("in instance static block");
    }
}
