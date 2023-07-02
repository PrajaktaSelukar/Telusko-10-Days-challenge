import java.lang.annotation.*;

//@Target(ElementType.TYPE)
// Annotation mention both Target and Retention - must

// this helps to give annotation for different bets simultaneously
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface CricketPlayer {
    String country() ;
    int age();
}
//@ => tells compiler that it's not an interface, and an annotation type is created, which you can add as supplement information to your source code.
//
//@CricketPlayer(country = "India", age = 26)
@CricketPlayer(country = "india",age = 24) // using default given so error gone
class Virat
{
    @CricketPlayer(country = "africa",age = 45)
    int runs;
    int innings;

    @CricketPlayer(country = "abc",age = 2)
    public void setRuns(int runs){
        this.runs = runs;
    }

    public void setInnings(int innings){
        this.innings = innings;
    }

    public int getRuns(){
        return this.runs;
    }
    public int getInnings(){
        return this.innings;
    }
}

public class LaunchAnn {
    public static void main(String[] args) {
        Virat v = new Virat();
        v.setRuns(15000);
        v.setInnings(250);

        System.out.println(v.getRuns());
        System.out.println(v.getInnings());

        // fetch values of Annotation using Reflection API
        Class c_info = v.getClass();
        Annotation at = c_info.getAnnotation(CricketPlayer.class);
        CricketPlayer cp = (CricketPlayer) at;

        System.out.println("Age : " + cp.age());
        System.out.println("Country : " + cp.country());
    }
}
