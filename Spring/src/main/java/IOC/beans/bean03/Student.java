package IOC.beans.bean03;

public class Student {
    private String name;
    private int age;
    private School school;

    public Student() {
        System.out.println("Student无参数构造方法");
    }

    public void setSchool(School school) {
        System.out.println("setSchool:" + school);
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setAge:" + age);
        this.age = age;
    }

    public void setEmail(String email) {
        System.out.println(email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
