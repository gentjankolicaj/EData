package io.gentjankolicaj.data.load.converter.core;

import java.util.List;

public interface MyConverter<S, D, C> {


    D sourceToDto(S source);

    C sourceToCommand(S source);

    S dtoToSource(D dto);

    S commandToSource(C command);

    List<D> sourceToDto(List<S> source);

    List<C> sourceToCommand(List<S> source);
}
