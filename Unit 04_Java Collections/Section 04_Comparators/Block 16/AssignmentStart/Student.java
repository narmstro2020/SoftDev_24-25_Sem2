public class Student {
    String name;
    int grade;
    int age;

    public Student(String name, int grade, int age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Grade: %d, Age: %d", name, grade, age);
    }
}