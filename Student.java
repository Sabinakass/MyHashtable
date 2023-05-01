public class Student {
    private String name;
    private int id;

    public Student(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 23 * result + id;
        result = 23 * result + (name == null ? 0 : name.hashCode());
        return result;
    }
}
