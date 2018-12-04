package edata.common.command;

import edata.common.enums.InformationScope;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationCommand {

    private Long id;

    private LanguageCommand languageCommand;

    private InformationScope informationScope;

    private String field;

    private String subject;

    private String message;

    private String title;

    private String tip;

}
