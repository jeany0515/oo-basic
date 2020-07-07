package practice06;

public class Teacher extends Person {
    private final int[] klass;

    public Teacher(String name, int age, int ... klass) {
        super(name, age);
        this.klass = klass;
    }

    public int getKlass() {
        return this.klass[0];
    }

    @Override
    public String introduce() {
        String basicIntroduce = super.introduce() + " I am a Teacher. I teach ";
        return this.klass.length > 0 ? basicIntroduce + "Class " + this.klass[0] +"2." : basicIntroduce + "No Class.";
    }
}
