

public class Parent {
    private String name;
    private int year_birth;

    public Parent(int year_birth,String name){
        this.year_birth=year_birth;
        this.name=name;
    }

    @Override
    public int hashCode(){
        int result = 19;
        result = 91 * result + year_birth;
        result = 91 * result + (name == null ? 0 : name.hashCode());
        return result;
    }
}
