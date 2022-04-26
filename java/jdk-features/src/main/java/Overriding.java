public class Overriding {
    public static void main(String[] args) {
        Engineer e2 = new ElectricalEngineer();
        Engineer e3 = new SoftwareEngineer();
        System.out.format("%s %s \n", e2.name(), e2.favorite());
        System.out.format("%s %s\n", e3.name(), e3.favorite());
        new Dog();
    }
}


abstract class Engineer {
    public static String name() {
        return "Engineer";
    }
    public String favorite() {
        return "Math and Physics";
    }

}
class ElectricalEngineer extends Engineer {
    public static String name() { return "Electrical Engineer" ;}
    public String favorite() { return "Electricity"; }
}
class SoftwareEngineer extends Engineer {
    public static String name() { return "Software Engineer"; }
    public String favorite() { return "Java"; }
}


class Animal {
    public Animal() { System.out.println("1"); }
    public Animal(String s) {
        this();
        System.out.println("2");
    }
}
class Dog extends Animal {
    public Dog() {
        super("3");
        System.out.println("4");
    }
}