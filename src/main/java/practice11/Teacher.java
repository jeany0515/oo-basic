package practice11;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements JoinListener {
    private final List<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.classes = new ArrayList<>();
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        classes.forEach(klass -> {
            klass.registerJoinListener(this);
        });
    }

    @Override
    public String introduce() {
        String basicIntroduce = super.introduce() + " I am a Teacher. I teach ";
        if (classes.size() == 0) {
            return basicIntroduce + "No Class.";
        } else {
            List<String> arr = new ArrayList<>();
            for (int i = 0; i < getClasses().size(); i++) {
                arr.add(String.valueOf(getClasses().get(i).getNumber()));
            }
            return basicIntroduce + "Class " + String.join(", ", arr) + ".";
        }
    }

    public List<Klass> getClasses() {
        return this.classes;
    }

    public boolean isTeaching(Student student) {
        return getClasses().contains(student.getKlass());
    }

    public String introduceWith(Student student) {
        return getClasses().contains(student.getKlass()) ? super.introduce() + " I am a Teacher. I teach " + student.getName() + "." :
                super.introduce() + " I am a Teacher. I don't teach " + student.getName() + '.';
    }

    @Override
    public void notifyJoin(Student student) {
        String notification = String.format("I am %s. I know %s become Leader of %s.", getName(), student.getName(), student.getKlass().getDisplayName());
        System.out.println(notification);
    }
}
