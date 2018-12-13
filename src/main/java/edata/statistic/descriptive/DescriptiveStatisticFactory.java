package edata.statistic.descriptive;

import edata.statistic.core.*;

import java.util.List;

public class DescriptiveStatisticFactory extends AbstractStatisticFactory {


    public Float getMean(List<Item> itemList){
      Float totalSum= BasicOperations.getSum(itemList);
      return totalSum/itemList.size();
    }

    public Float getMedian(List<Item> itemList){
        return BasicOperations.getMedian(itemList);
    }

    public Float getMode(List<Item> itemList){
        return null;
    }

    @Override
    public StatisticFactoryType getFactoryType() {
        return StatisticFactoryType.DESCRIPTIVE;
    }

}
