package io.gentjankolicaj.app.edata.load.mapper;

import io.gentjankolicaj.app.edata.commons.domain.PressureUnit;
import io.gentjankolicaj.app.edata.load.command.PressureUnitCmd;
import io.gentjankolicaj.app.edata.load.dto.PressureUnitDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PressureUnitMapper {
    PressureUnitMapper INSTANCE = Mappers.getMapper(PressureUnitMapper.class);

    @Mapping(source = "unitCode", target = "unitCode")
    @Mapping(source = "unitName", target = "unitName")
    @Mapping(source = "unitDescription", target = "unitDescription")
    PressureUnitDTO sourceToDto(PressureUnit source);

    @Mapping(source = "unitCode", target = "unitCode")
    @Mapping(source = "unitName", target = "unitName")
    @Mapping(source = "unitDescription", target = "unitDescription")
    PressureUnitCmd sourceToCommand(PressureUnit source);

    @Mapping(source = "unitCode", target = "unitCode")
    @Mapping(source = "unitName", target = "unitName")
    @Mapping(source = "unitDescription", target = "unitDescription")
    PressureUnit dtoToSource(PressureUnitDTO dto);

    @Mapping(source = "unitCode", target = "unitCode")
    @Mapping(source = "unitName", target = "unitName")
    @Mapping(source = "unitDescription", target = "unitDescription")
    PressureUnit commandToSource(PressureUnitCmd command);

    List<PressureUnitDTO> sourceToDto(List<PressureUnit> source);

    List<PressureUnitCmd> sourceToCommand(List<PressureUnit> source);
}
