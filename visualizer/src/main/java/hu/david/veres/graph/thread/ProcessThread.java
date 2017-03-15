package hu.david.veres.graph.thread;

import hu.david.veres.graph.entity.ProcessEntity;
import hu.david.veres.graph.exception.result.ResultValidationException;
import hu.david.veres.graph.generator.ResultGenerator;
import hu.david.veres.graph.model.Result;
import hu.david.veres.graph.repository.ProcessRepository;
import hu.david.veres.graph.service.StorageService;
import hu.david.veres.graph.validator.ResultValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@Scope("prototype")
public class ProcessThread implements Runnable {

    private String processIdentifier;
    private MultipartFile file;

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ResultGenerator resultGenerator;

    @Autowired
    private ResultValidator resultValidator;

    public String getProcessIdentifier() {
        return processIdentifier;
    }

    public void setProcessIdentifier(String processIdentifier) {
        this.processIdentifier = processIdentifier;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public void run() {

        // GENERATE RESULT
        Result result = null;
        try {
            result = resultGenerator.generate(file);
        } catch (IOException e) {
            finishAndUpdateEntity(processIdentifier, true, null);
            e.printStackTrace();
            return;
        }

        // VALIDATE RESULT
        try {
            resultValidator.validate(result);
        } catch (ResultValidationException e) {
            finishAndUpdateEntity(processIdentifier, true, null);
            e.printStackTrace();
            return;
        }

        // STORE FILES
        try {
            storageService.storeUploadedFile(file, processIdentifier);
            storageService.storeResultInJsonFile(result, processIdentifier);
        } catch (IOException e) {
            finishAndUpdateEntity(processIdentifier, true, null);
            e.printStackTrace();
            return;
        }

        // UPDATE DATABASE
        finishAndUpdateEntity(processIdentifier, false, null);

    }

    private void finishAndUpdateEntity(String processIdentifier, boolean error, String errorMessage) {

        ProcessEntity processEntity = processRepository.findByProcessIdentifier(processIdentifier);
        processEntity.setDone(true);
        processEntity.setError(error);
        processEntity.setErrorMessage(errorMessage);
        processRepository.save(processEntity);

    }

}
