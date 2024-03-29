package io.gentjankolicaj.app.edata.load.mapper;

import io.gentjankolicaj.app.edata.commons.domain.Information;
import io.gentjankolicaj.app.edata.load.command.InformationCmd;
import io.gentjankolicaj.app.edata.load.dto.InformationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InformationMapper {
    InformationMapper INSTANCE = Mappers.getMapper(InformationMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "informationScope", target = "informationScope")
    @Mapping(source = "field", target = "field")
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "tip", target = "tip")
    InformationDTO sourceToDto(Information source);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "informationScope", target = "informationScope")
    @Mapping(source = "field", target = "field")
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "tip", target = "tip")
    InformationCmd sourceToCommand(Information source);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "informationScope", target = "informationScope")
    @Mapping(source = "field", target = "field")
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "tip", target = "tip")
    Information dtoToSource(InformationDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "informationScope", target = "informationScope")
    @Mapping(source = "field", target = "field")
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "tip", target = "tip")
    Information commandToSource(InformationCmd command);

    List<InformationDTO> sourceToDto(List<Information> source);

    List<InformationCmd> sourceToCommand(List<Information> source);
}
