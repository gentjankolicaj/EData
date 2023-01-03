package io.gentjankolicaj.data.load.service;

import io.gentjankolicaj.data.load.common.command.InformationCommand;

import java.util.List;

public interface InformationService {

    List<InformationCommand> getAllCommand();

    InformationCommand saveCommand(InformationCommand informationCommand);

    InformationCommand updateCommand(InformationCommand informationCommand);

    InformationCommand getByIdCommand(Long id);

    void deleteCommand(InformationCommand informationCommand);
}
