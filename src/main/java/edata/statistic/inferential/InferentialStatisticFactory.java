package edata.statistic.inferential;

import edata.statistic.core.AbstractStatisticFactory;
import edata.statistic.core.StatisticFactoryType;

public class InferentialStatisticFactory extends AbstractStatisticFactory {


    @Override
    public StatisticFactoryType getFactoryType() {
        return StatisticFactoryType.INFERENTIAL;
    }

}
