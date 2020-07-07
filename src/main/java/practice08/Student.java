package practice08;

public class Student extends Person{
    private final Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return this.klass;
    }

    @Override
    public String introduce() {
        String basicIntroduce = super.introduce() + " I am a Student. ";
        boolean isLeader = klass.getLeader() != null && klass.getLeader().getName().equals(getName());
        String studentIntroduce = isLeader ? String.format("I am Leader of Class %s.", klass.getNumber()) : String.format("I am at Class %s.", klass.getNumber());

        return basicIntroduce + studentIntroduce;
    }
}
