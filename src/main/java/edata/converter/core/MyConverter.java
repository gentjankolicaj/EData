package edata.converter.core;

import org.springframework.core.convert.converter.Converter;

import java.util.List;

public interface MyConverter  <S,D,C>{


   D sourceToDto(S source);

   C sourceToCommand(S source);

   S dtoToSource(D dto);

   S commandToSource(C command);

   List<D> sourceToDto(List<S> source);

   List<C> sourceToCommand(List<S> source);
}
