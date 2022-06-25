package IOC.beans.bean02;

public class Student {
    private String name;
    private int age;
    private School school;

    public Student() {
        System.out.println("Student无参数构造方法");
    }

    //创建有参数构造方法
    public Student(String myname, int myage, School myschool) {
        System.out.println("Student有参数构造方法");
        //给属性一次赋值
        this.name = myname;
        this.age = myage;
        this.school = myschool;
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
