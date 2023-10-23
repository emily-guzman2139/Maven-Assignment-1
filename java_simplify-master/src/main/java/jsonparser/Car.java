package jsonparser;

public class Car {
    private String model;
    private String make;
    private String years;

    public Car(String model, String make, String years) {
        this.model = model;
        this.make = make;
        this.years = years;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
}
