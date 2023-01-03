package io.gentjankolicaj.data.load.statistic.core;

import io.gentjankolicaj.data.load.statistic.descriptive.DescriptiveStatisticFactory;
import io.gentjankolicaj.data.load.statistic.inferential.InferentialStatisticFactory;

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
