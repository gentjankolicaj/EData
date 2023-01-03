package io.gentjankolicaj.data.load.statistic.inferential;

import io.gentjankolicaj.data.load.statistic.core.AbstractStatisticFactory;
import io.gentjankolicaj.data.load.statistic.core.StatisticFactoryType;

public class InferentialStatisticFactory extends AbstractStatisticFactory {


    @Override
    public StatisticFactoryType getFactoryType() {
        return StatisticFactoryType.INFERENTIAL;
    }

}
