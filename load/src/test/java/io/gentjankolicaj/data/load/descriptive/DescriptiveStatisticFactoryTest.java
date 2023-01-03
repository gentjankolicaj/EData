package io.gentjankolicaj.data.load.descriptive;

import io.gentjankolicaj.data.load.common.command.nasa.power.PowerPressureCommand;
import io.gentjankolicaj.data.load.statistic.core.FactoryCreator;
import io.gentjankolicaj.data.load.statistic.core.Item;
import io.gentjankolicaj.data.load.statistic.core.StatisticFactoryType;
import io.gentjankolicaj.data.load.statistic.descriptive.DescriptiveStatisticFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class DescriptiveStatisticFactoryTest {

    private static float[] testValues={1f,2.32453f,-30f,0.234f,-15.5f,100f};

    @Test
    public void getMean() {

        //This impl is ok
      DescriptiveStatisticFactory factory= (DescriptiveStatisticFactory)FactoryCreator.getFactory(StatisticFactoryType.DESCRIPTIVE);

       Float actualMedian=actualMean(testValues);
       Float expecteMedian=factory.getMean(getTestItems());

       assertEquals(actualMedian.floatValue(),expecteMedian.floatValue());



    }

    @Test
    public void getMedian() {
        //todo: I need to look into statistics to remind concepts to finish impl accordingly
        float actualMedian=actualMedian(testValues);

    }

    @Test
    public void getMode() {
    }

    @Test
    public void getFactoryType() {
    }

    public List<Item> getTestItems(){
        PowerPressureCommand o1=new PowerPressureCommand();
        o1.setValue(testValues[0]);
        PowerPressureCommand o2=new PowerPressureCommand();
        o2.setValue(testValues[1]);
        PowerPressureCommand o3=new PowerPressureCommand();
        o3.setValue(testValues[2]);
        PowerPressureCommand o4=new PowerPressureCommand();
        o4.setValue(testValues[3]);
        PowerPressureCommand o5=new PowerPressureCommand();
        o5.setValue(testValues[4]);
        PowerPressureCommand o6=new PowerPressureCommand();
        o6.setValue(testValues[5]);
        List<Item> list=new ArrayList<>();
        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
        list.add(o5);
        list.add(o6);
        return list;
    }

    private float actualMean(float[] array){
        float total=0f;
        for(float temp:array){
            total+=temp;
        }
        return total/array.length;
    }

    private float actualMedian(float[] array){
        Arrays.sort(array);
        return array[array.length/2];
    }
}