package model;

public class PadelBat {
    private final Integer id;
    private final String brand;
    private final String model;
    private final String shape;
    private final Integer weight;

    public PadelBat(Integer id, String brand, String model, String shape, Integer weight) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.shape = shape;
        this.weight = weight;
    }

    public PadelBat(String brand, String model, String shape, Integer weight) {
        this.id = null;
        this.brand = brand;
        this.model = model;
        this.shape = shape;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getShape() {
        return shape;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "PadelBat{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", shape='" + shape + '\'' +
                ", weight=" + weight +
                '}';
    }

}
