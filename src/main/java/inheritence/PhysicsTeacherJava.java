package inheritence;

class TeacherJava {
    String designation = "Teacher";
    String collegeName = "Beginnersbook";
    void does(){
        System.out.println("Teaching");
    }
}

public class PhysicsTeacherJava extends TeacherJava {
    String mainSubject = "Physics";
    public static void main(String args[]){
        PhysicsTeacherJava obj = new PhysicsTeacherJava();
        System.out.println(obj.collegeName);
        System.out.println(obj.designation);
        System.out.println(obj.mainSubject);
        obj.does();
    }
}