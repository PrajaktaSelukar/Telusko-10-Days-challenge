@FunctionalInterface
interface Demo{
    void display();
//    void add();
}

class Animal
{
    public void eat(){
        System.out.println("Animal eats");
    }
    public void animalAlwaysHuntsAndEats(){
        System.out.println("Animal eats");
    }
}
class Tiger extends Animal{
    public void eat(){
        System.out.println("Tiger hunts and eat");
    }
    // Override to change parent in child
    @Override
    public void animalAlwaysHuntsAndEats(){
        System.out.println("Animal eats");
    }
}

// as you give interface, methods inside it as public and abstract
// lambda expression can be written if there is functional interface(any interface with only one abstract method
public class LaunchAnn2 {
    public static void main(String[] args) {
        Demo d = () -> {
            System.out.println("Lambda");
        };
        //U cannot implement lambda expression with 2 abstract methods inside it. Above one will give error
        // whenever you are defining a functional interface in Java use this Annotation FunctionalInterface
        // Here FunctionalInterface tells that don't use second method

        // Annotation is replacement of XML

    }
}
