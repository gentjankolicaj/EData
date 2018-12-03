package edata.converter.core;

import java.util.List;

public interface MyNasaPowerConverter<S,D,C>{


    D sourceToDto(S source);

    C sourceToCommand(S source);

    S dtoToSource(D dto);

    S commandToSource(C command);

    List<D> sourceToDto(List<S> source);

    List<C> sourceToCommand(List<S> source);

    Iterable<D> sourceToDto(Iterable<S> source);

    Iterable<C> sourceToCommand(Iterable<S> source);

}
