package by.tc.task01.entity;

import java.util.Objects;

/**
 *VacuumCleaner
 */
public class VacuumCleaner implements Appliance {

    private String id;
    private Integer powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private Integer motorSpeedRegulation;
    private Integer cleaningWidth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public Integer getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(Integer motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public Integer getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(Integer cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return id.equals(that.id) && powerConsumption.equals(that.powerConsumption) && filterType.equals(that.filterType) && bagType.equals(that.bagType) && wandType.equals(that.wandType) && motorSpeedRegulation.equals(that.motorSpeedRegulation) && cleaningWidth.equals(that.cleaningWidth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "id='" + id + '\'' +
                ", powerConsumption=" + powerConsumption +
                ", filterType='" + filterType + '\'' +
                ", bagType='" + bagType + '\'' +
                ", wandType='" + wandType + '\'' +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                '}';
    }
}
