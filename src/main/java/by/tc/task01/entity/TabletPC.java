package by.tc.task01.entity;

import java.util.Objects;

public class TabletPC implements Appliance {
    private String id;
    private Integer batteryCapacity;
    private Integer displayInches;
    private Integer memoryRom;
    private Integer flashMemoryCapacity;
    private String color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Integer getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(Integer displayInches) {
        this.displayInches = displayInches;
    }

    public Integer getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(Integer memoryRom) {
        this.memoryRom = memoryRom;
    }

    public Integer getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(Integer flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabletPC tabletPC = (TabletPC) o;
        return id.equals(tabletPC.id) && batteryCapacity.equals(tabletPC.batteryCapacity) && displayInches.equals(tabletPC.displayInches) && memoryRom.equals(tabletPC.memoryRom) && flashMemoryCapacity.equals(tabletPC.flashMemoryCapacity) && color.equals(tabletPC.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "id='" + id + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryRom=" + memoryRom +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }
}
