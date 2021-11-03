package by.tc.task01.entity;

import java.util.Arrays;
import java.util.Objects;

/**
 * Speakers
 */
public class Speakers implements Appliance{
    private String id;
    private Integer powerConsumption;
    private Integer numberOfSpeakers;
    private String frequencyRange;
    private Integer cordLength;

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

    public Integer getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(Integer numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public Integer getCordLength() {
        return cordLength;
    }

    public void setCordLength(Integer cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speakers speakers = (Speakers) o;
        return id.equals(speakers.id) && powerConsumption.equals(speakers.powerConsumption) && numberOfSpeakers.equals(speakers.numberOfSpeakers) && frequencyRange.equals(speakers.frequencyRange) && cordLength.equals(speakers.cordLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, powerConsumption, numberOfSpeakers, frequencyRange, cordLength);
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "id='" + id + '\'' +
                ", powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange='" + frequencyRange + '\'' +
                ", cordLength=" + cordLength +
                '}';
    }
}
