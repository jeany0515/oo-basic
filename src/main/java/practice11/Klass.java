package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> member = new ArrayList<>();
    private List<JoinListener> joinListeners = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {

        return "Class " + this.number;
    }

    public void assignLeader(Student leader) {
        if (isIn(leader)) {
            this.leader = leader;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public Student getLeader() {
        return this.leader;
    }

    public void appendMember(Student student) {
        if (!isIn(student)) {
            this.member.add(student);
            joinListeners.forEach(listener -> listener.notifyJoin(student));
        }
    }

    public void registerJoinListener(JoinListener joinListener) {
        joinListeners.add(joinListener);
    }

    private boolean isIn(Student student) {
        return this.member.contains(student);
    }
}
