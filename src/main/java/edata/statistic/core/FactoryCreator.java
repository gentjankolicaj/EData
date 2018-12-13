package edata.statistic.core;

import edata.statistic.descriptive.DescriptiveStatisticFactory;
import edata.statistic.inferential.InferentialStatisticFactory;

public class FactoryCreator {

    public static AbstractStatisticFactory getFactory(StatisticFactoryType type){
        if(type.equals(StatisticFactoryType.DESCRIPTIVE)){
            return new DescriptiveStatisticFactory();
        }else if(type.equals(StatisticFactoryType.INFERENTIAL)){
            return new InferentialStatisticFactory();
        }else{
            return null;
        }
    }
}
