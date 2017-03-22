package hu.david.veres.graph.controller;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.exception.file.FileValidationException;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
import hu.david.veres.graph.thread.ProcessThread;
import hu.david.veres.graph.util.ProcessUtils;
import hu.david.veres.graph.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @Autowired
    private ProcessService processService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private FileValidator fileValidator;

    @Autowired
    private StorageService storageService;

    @RequestMapping("/upload")
    public String loadPage() {
        return "upload";
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            fileValidator.validate(file);
        } catch (FileValidationException e) {
            e.printStackTrace();

            ModelAndView modelAndView = new ModelAndView("upload");
            modelAndView.addObject("response", true);
            modelAndView.addObject("errorMessage", e.getErrorMessage());
            return modelAndView;
        }

        String processIdentifier = ProcessUtils.generateProcessIdentifier();

        File savedFile = null;
        try {
            savedFile = storageService.storeUploadedFile(file, processIdentifier);
        } catch (IOException e) {
            e.printStackTrace();

            ModelAndView modelAndView = new ModelAndView("upload");
            modelAndView.addObject("response", true);
            modelAndView.addObject("errorMessage", "error.file.save.error");
            return modelAndView;
        }

        ProcessDTO processDTO = new ProcessDTO();
        processDTO.setProcessIdentifier(processIdentifier);
        processDTO.setDone(false);
        processService.save(processDTO);

        ProcessThread processThread = applicationContext.getBean(ProcessThread.class);
        processThread.setAbsoluteFileName(savedFile.getAbsolutePath());
        processThread.setProcessIdentifier(processIdentifier);
        threadPoolTaskExecutor.execute(processThread);

        ModelAndView modelAndView = new ModelAndView("upload");
        modelAndView.addObject("response", true);
        modelAndView.addObject("processIdentifier", processIdentifier);

        return modelAndView;

    }

}
