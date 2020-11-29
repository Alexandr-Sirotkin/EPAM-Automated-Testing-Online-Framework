package EpamLearn.service;

import EpamLearn.model.ComputeEngine;

public class ComputeEngineCreator {

  public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.computeengine.numberofinstances";
  public static final String TESTDATA_SOFTWARE = "testdata.computeengine.software";
  public static final String TESTDATA_MACHINE_CLASS = "testdata.computeengine.machineclass";
  public static final String TESTDATA_SERIES = "testdata.computeengine.series";
  public static final String TESTDATA_MACHINE_TYPE = "testdata.computeengine.machinetype";
  public static final String TESTDATA_ADD_GPUS = "testdata.computeengine.addgpus";
  public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.computeengine.numberofgpus";
  public static final String TESTDATA_GPU_TYPE = "testdata.computeengine.gputype";
  public static final String TESTDATA_LOCAL_SSD = "testdata.computeengine.localssd";
  public static final String TESTDATA_DATACENTER_LOCATION = "testdata.computeengine.datacenterlocation";
  public static final String TESTDATA_COMMITTED_USAGE = "testdata.computeengine.committedusage";
  public static final String TESTDATA_EXPECTED_ESTIMATE = "testdata.computeengine.expectedestimate";


  public static ComputeEngine withCredentialsFromProperty (){
    return new ComputeEngine(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
        TestDataReader.getTestData(TESTDATA_SOFTWARE),
        TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),
        TestDataReader.getTestData(TESTDATA_SERIES),
        TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
        Boolean.parseBoolean(TestDataReader.getTestData(TESTDATA_ADD_GPUS)),
        TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
        TestDataReader.getTestData(TESTDATA_GPU_TYPE),
        TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
        TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
        TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE),
        Double.parseDouble(TestDataReader.getTestData(TESTDATA_EXPECTED_ESTIMATE)));
  }

}
