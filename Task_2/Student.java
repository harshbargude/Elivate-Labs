public class Student {
    private long id;
    private String firtName;
    private String lastName;
    private int rollNo;
    private float marks;

    public Student(){}
    
    public Student(long id, String firtName, String lastName, int rollNo, float marks) {
        this.id = id;
        this.firtName = firtName;
        this.lastName = lastName;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirtName() {
        return firtName;
    }
    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public float getMarks() {
        return marks;
    }
    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "id=" + id + ", firtName=" + firtName + ", lastName=" + lastName + ", rollNo=" + rollNo
                + ", marks=" + marks;
    }

}
