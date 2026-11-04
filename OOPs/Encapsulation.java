public class Encapsulation {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();
        obj.setId(1);
        obj.setName("John Doe");

        System.out.println("ID: " + obj.getId());
        System.out.println("Name: " + obj.getName());
    }
}
