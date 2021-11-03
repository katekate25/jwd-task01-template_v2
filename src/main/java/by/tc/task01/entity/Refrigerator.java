package by.tc.task01.entity;

import java.util.Objects;

/**
 * Refrigerator
 */
public class Refrigerator implements Appliance{
    private String id;
    private Integer freezerCapacity;
    private Integer powerConsumption;
    private Integer weight;
    private Double overallCapacity;
    private Integer height;
    private Integer width;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(Integer freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
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

    public Double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(Double overallCapacity) {
        this.overallCapacity = overallCapacity;
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
        Refrigerator that = (Refrigerator) o;
        return id.equals(that.id) && freezerCapacity.equals(that.freezerCapacity) && powerConsumption.equals(that.powerConsumption) && weight.equals(that.weight) && overallCapacity.equals(that.overallCapacity) && height.equals(that.height) && width.equals(that.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, freezerCapacity, powerConsumption, weight, overallCapacity, height, width);
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "id='" + id + '\'' +
                ", freezerCapacity=" + freezerCapacity +
                ", powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
