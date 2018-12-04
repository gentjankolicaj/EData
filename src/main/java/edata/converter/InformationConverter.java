package edata.converter;

import edata.common.command.InformationCommand;
import edata.common.command.LanguageCommand;
import edata.common.domain.Information;
import edata.common.domain.Language;
import edata.common.dto.InformationDTO;
import edata.converter.core.MyConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class InformationConverter implements MyConverter<Information, InformationDTO, InformationCommand> {

    //todo to implement future converter for language because when i convert information object,
    //todo data about the country languages is lost

    public InformationConverter() {
    }

    @Override
    public InformationDTO sourceToDto(Information source) {
        return null;
    }

    @Override
    public InformationCommand sourceToCommand(Information source) {
       if(source==null){
           return null;
       }else{
           /**
            * buggy code also countries are needed to be assigned here
            */
           LanguageCommand languageCommand=new LanguageCommand();
           languageCommand.setLanguage(source.getLanguage().getLanguage());

           InformationCommand information=new InformationCommand();
           information.setId(source.getId());
           information.setInformationScope(source.getInformationScope());
           information.setField(source.getField());
           information.setSubject(source.getSubject());
           information.setTitle(source.getTitle());
           information.setMessage(source.getMessage());
           information.setTip(source.getTip());
           information.setLanguageCommand(languageCommand);

           return information;
       }
    }

    @Override
    public Information dtoToSource(InformationDTO dto) {
        return null;
    }

    @Override
    public Information commandToSource(InformationCommand command) {
        if(command==null){
            return null;
        }else{
            /**
             * buggy code also countries are needed to be assigned here
             */
            Language language=new Language();
            language.setLanguage(command.getLanguageCommand().getLanguage());

            Information information=new Information();
            information.setId(command.getId());
            information.setInformationScope(command.getInformationScope());
            information.setField(command.getField());
            information.setSubject(command.getSubject());
            information.setTitle(command.getTitle());
            information.setMessage(command.getMessage());
            information.setTip(command.getTip());
            information.setLanguage(language);

            return information;
        }
    }

    @Override
    public List<InformationDTO> sourceToDto(List<Information> source) {
        return null;
    }

    @Override
    public List<InformationCommand> sourceToCommand(List<Information> source){
            if(source==null||source.size()==0){
                return null;
            }else{
                List<InformationCommand> list=new ArrayList<>();
                for(Information temp:source){
                    list.add(sourceToCommand(temp));
                }
                return list;
            }
    }
}
