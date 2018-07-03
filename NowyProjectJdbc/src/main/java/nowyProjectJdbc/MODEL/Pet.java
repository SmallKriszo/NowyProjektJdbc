package nowyProjectJdbc.MODEL;

public class Pet {

    private int id;
    private String kind;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Pet(int id, String kind, String name, int age) {
        this.id = id;
        this.kind = kind;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
