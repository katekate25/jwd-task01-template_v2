package by.tc.task01.entity;

import java.util.Objects;

public class Laptop implements Appliance {

    private String id;
    private Double batteryCapacity;
    private String os;
    private Integer memoryRom;
    private Integer systemMemory;
    private Double cpu;
    private Integer displayInches;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(Integer memoryRom) {
        this.memoryRom = memoryRom;
    }

    public Integer getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(Integer systemMemory) {
        this.systemMemory = systemMemory;
    }

    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    public Integer getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(Integer displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return id.equals(laptop.id) && batteryCapacity.equals(laptop.batteryCapacity) && os.equals(laptop.os) && memoryRom.equals(laptop.memoryRom) && systemMemory.equals(laptop.systemMemory) && cpu.equals(laptop.cpu) && displayInches.equals(laptop.displayInches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id='" + id + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", os='" + os + '\'' +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", cpu=" + cpu +
                ", displayInches=" + displayInches +
                '}';
    }
}