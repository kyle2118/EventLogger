package beans;

public class Client {
    private int id;
    private String name;
    private String greeting;

    public Client() {
        int id = (int)(Math.random() * 1000);
        String name = "Default name";
        String greeting = "Default greeting";

    }
    public Client(int id, String name, String greeting) {
        this.id = id;
        this.name = name;
        this.greeting = greeting;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGreeting() { return greeting; }
    public void setGreeting(String greeting) { this.greeting = greeting; }
}
