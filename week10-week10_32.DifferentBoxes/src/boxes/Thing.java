package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Thing compare = (Thing) obj;
        if (this.hashCode() == obj.hashCode()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
    
    

}
