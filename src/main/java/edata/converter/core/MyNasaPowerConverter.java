package edata.converter.core;

public interface MyNasaPowerConverter<S,D,C>{


    D sourceToDto(S source);

    C sourceToCommand(S source);

    S dtoToSource(D dto);

    S commandToSource(C command);

}
