package EpamLearn.model;


import java.util.Objects;

public class ComputeEngine {

  private String numberOfInstances;
  private String software;
  private String machineClass;
  private String series;
  private String machineType;
  private boolean addGPUs;
  private String numberOfGPUs;
  private String GPUType;
  private String localSSD;
  private String datacenterLocation;
  private String committedUsage;
  private Double expectedEstimate;

  public ComputeEngine(String numberOfInstances, String software, String machineClass,
      String series, String machineType, boolean addGPUs, String numberOfGPUs,
      String GPUType, String localSSD, String datacenterLocation, String committedUsage,
      double expectedEstimate) {
    this.numberOfInstances = numberOfInstances;
    this.software = software;
    this.machineClass = machineClass;
    this.series = series;
    this.machineType = machineType;
    this.addGPUs = addGPUs;
    this.numberOfGPUs = numberOfGPUs;
    this.GPUType = GPUType;
    this.localSSD = localSSD;
    this.datacenterLocation = datacenterLocation;
    this.committedUsage = committedUsage;
    this.expectedEstimate = expectedEstimate;
  }

  public String getNumberOfInstances() {
    return numberOfInstances;
  }

  public String getSoftware() {
    return software;
  }

  public String getMachineClass() {
    return machineClass;
  }

  public String getSeries() {
    return series;
  }

  public String getMachineType() {
    return machineType;
  }

  public boolean getAddGPUs() {
    return addGPUs;
  }

  public String getNumberOfGPUs() {
    return numberOfGPUs;
  }

  public String getGPUType() {
    return GPUType;
  }

  public String getLocalSSD() {
    return localSSD;
  }

  public String getDatacenterLocation() {
    return datacenterLocation;
  }

  public String getCommittedUsage() {
    return committedUsage;
  }

  public Double getExpectedEstimate() {
    return expectedEstimate;
  }

  @Override
  public String toString() {
    return "ComputeEngine{" +
        "numberOfInstances='" + numberOfInstances + '\'' +
        ", software='" + software + '\'' +
        ", machineClass='" + machineClass + '\'' +
        ", series='" + series + '\'' +
        ", machineType='" + machineType + '\'' +
        ", addGPUs='" + addGPUs + '\'' +
        ", numberOfGPUs='" + numberOfGPUs + '\'' +
        ", GPUType='" + GPUType + '\'' +
        ", localSSD='" + localSSD + '\'' +
        ", datacenterLocation='" + datacenterLocation + '\'' +
        ", committedUsage='" + committedUsage + '\'' +
        ", expectedEstimate='" + expectedEstimate + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComputeEngine that = (ComputeEngine) o;
    return Objects.equals(numberOfInstances, that.numberOfInstances) &&
        Objects.equals(software, that.software) &&
        Objects.equals(machineClass, that.machineClass) &&
        Objects.equals(series, that.series) &&
        Objects.equals(machineType, that.machineType) &&
        Objects.equals(addGPUs, that.addGPUs) &&
        Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
        Objects.equals(GPUType, that.GPUType) &&
        Objects.equals(localSSD, that.localSSD) &&
        Objects.equals(datacenterLocation, that.datacenterLocation) &&
        Objects.equals(committedUsage, that.committedUsage) &&
        Objects.equals(expectedEstimate, that.expectedEstimate);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(numberOfInstances, software, machineClass, series, machineType, addGPUs, numberOfGPUs,
            GPUType, localSSD, datacenterLocation, committedUsage, expectedEstimate);
  }
}
