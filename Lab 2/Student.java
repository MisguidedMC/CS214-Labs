public class Student implements Comparable<Student>{
    private final String name;
    private double GPA;

    public Student(String name,double GPA){
        this.name =name;
        this.GPA=GPA;
    }

    public String getName(){
        return this.name;
    }
    public double getGPA(){
        return this.GPA;
    }
    public void setGPA(double GPA){
        this.GPA=GPA;
    }
    @Override
    public String toString(){
        return "Student name: " + this.name +" and GPA is: " + this.GPA;
    }
    @Override
    public int compareTo(Student that){
        if(this.GPA>that.GPA){
            return -1;
        }else if(this.GPA<that.GPA){
            return 1;
        }else{
            return this.name.compareTo(that.name);
        }
    }
}
