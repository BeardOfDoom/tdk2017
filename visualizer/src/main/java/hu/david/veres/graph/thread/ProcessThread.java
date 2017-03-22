package hu.david.veres.graph.thread;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.exception.result.ResultValidationException;
import hu.david.veres.graph.generator.ResultGenerator;
import hu.david.veres.graph.model.Result;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
import hu.david.veres.graph.validator.ResultValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Scope("prototype")
public class ProcessThread implements Runnable {

    private String processIdentifier;
    private String absoluteFileName;

    @Autowired
    private ProcessService processService;

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

    public String getAbsoluteFileName() {
        return absoluteFileName;
    }

    public void setAbsoluteFileName(String absoluteFileName) {
        this.absoluteFileName = absoluteFileName;
    }

    @Override
    public void run() {

        // CHECK THE REQUIRED FIELDS
        if (processIdentifier == null || absoluteFileName == null) {
            finishAndUpdateProcess(processIdentifier, true, "error.unexpected.error");
            return;
        }

        // CHECK IF FILE EXISTS
        File file = new File(absoluteFileName);
        if (!file.exists()) {
            finishAndUpdateProcess(processIdentifier, true, "error.file.file.not.exists");
            return;
        }

        // GENERATE RESULT
        Result result = null;
        try {
            result = resultGenerator.generate(file);
        } catch (IOException e) {
            storageService.deleteUploadedFile(processIdentifier);
            finishAndUpdateProcess(processIdentifier, true, null);
            e.printStackTrace();
            return;
        }

        // VALIDATE RESULT
        try {
            resultValidator.validate(result);
        } catch (ResultValidationException e) {
            storageService.deleteUploadedFile(processIdentifier);
            finishAndUpdateProcess(processIdentifier, true, null);
            e.printStackTrace();
            return;
        }

        // STORE FILES
        try {
            storageService.storeResultInJsonFile(result, processIdentifier);
        } catch (IOException e) {
            storageService.deleteUploadedFile(processIdentifier);
            finishAndUpdateProcess(processIdentifier, true, null);
            e.printStackTrace();
            return;
        }

        // UPDATE DATABASE
        finishAndUpdateProcess(processIdentifier, false, null);

    }

    private void finishAndUpdateProcess(String processIdentifier, boolean error, String errorMessage) {

        ProcessDTO processDTO = processService.getProcessByIdentifier(processIdentifier);
        processDTO.setDone(true);
        processDTO.setError(error);
        processDTO.setErrorMessage(errorMessage);
        processService.save(processDTO);

    }

}
