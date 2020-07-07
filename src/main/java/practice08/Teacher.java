package practice08;

public class Teacher extends Person {
    private final Klass[] klass;

    public Teacher(int id, String name, int age, Klass... klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return this.klass[0];
    }

    @Override
    public String introduce() {
        String basicIntroduce = super.introduce() + " I am a Teacher. I teach ";
        return this.klass.length > 0 ? basicIntroduce + "Class " + this.klass[0].getNumber() +"." : basicIntroduce + "No Class.";
    }

    public String introduceWith(Student student) {
        return getKlass().equals(student.getKlass()) ? super.introduce() + " I am a Teacher. I teach " + student.getName() + "." :
                super.introduce() + " I am a Teacher. I don't teach " + student.getName() + '.';
    }
}
