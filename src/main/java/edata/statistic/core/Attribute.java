package edata.statistic.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attribute implements Comparator {

    private String name;
    private Float value;


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
