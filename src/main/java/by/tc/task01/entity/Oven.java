package by.tc.task01.entity;

import java.util.Objects;

/**
 * Oven
 */
public class Oven implements Appliance {

    private String id;
    private Integer capacity;
    private Integer powerConsumption;
    private Integer weight;
    private Integer depth;
    private Integer height;
    private Integer width;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oven oven = (Oven) o;
        return id.equals(oven.id) && capacity.equals(oven.capacity) && powerConsumption.equals(oven.powerConsumption) && weight.equals(oven.weight) && depth.equals(oven.depth) && height.equals(oven.height) && width.equals(oven.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacity, powerConsumption, weight, depth, height, width);
    }

    @Override
    public String toString() {
        return "Oven{" +
                "id='" + id + '\'' +
                ", capacity=" + capacity +
                ", powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", depth=" + depth +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
