package edata.converter.core;

import org.springframework.core.convert.converter.Converter;

public interface MyConverter  <S,D,C>{


   D sourceToDto(S source);

   C sourceToCommand(S source);

   S dtoToSource(D dto);

   S commandToSource(C command);

}
