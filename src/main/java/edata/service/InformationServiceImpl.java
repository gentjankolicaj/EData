package edata.service;

import edata.common.command.InformationCommand;
import edata.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    private final InformationRepository informationRepository;

    @Autowired
    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @Override
    public List<InformationCommand> getAllCommand() {
        return null;
    }

    @Override
    public InformationCommand saveCommand(InformationCommand informationCommand) {
        return null;
    }

    @Override
    public InformationCommand updateCommand(InformationCommand informationCommand) {
        return null;
    }

    @Override
    public InformationCommand getByIdCommand(Long id) {
        return null;
    }

    @Override
    public void deleteCommand(InformationCommand informationCommand) {

    }
}
