package hu.david.veres.graph.controller;

import hu.david.veres.graph.entity.ProcessEntity;
import hu.david.veres.graph.exception.file.FileValidationException;
import hu.david.veres.graph.repository.ProcessRepository;
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

@Controller
public class FileUploadController {

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private FileValidator fileValidator;

    @RequestMapping("/upload")
    public String loadPage() {
        return "test";
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            fileValidator.validate(file);
        } catch (FileValidationException e) {
            e.printStackTrace();

            ModelAndView modelAndView = new ModelAndView("test");
            modelAndView.addObject("errorMessage", e.getErrorMessage());
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("test");

        String processIdentifier = ProcessUtils.generateProcessIdentifier();

        // TODO: use service and dto instead of repository and entity
        ProcessEntity processEntity = new ProcessEntity();
        processEntity.setProcessIdentifier(processIdentifier);
        processEntity.setDone(false);
        processRepository.save(processEntity);

        ProcessThread processThread = applicationContext.getBean(ProcessThread.class);
        processThread.setFile(file);
        processThread.setProcessIdentifier(processIdentifier);
        threadPoolTaskExecutor.execute(processThread);

        modelAndView.addObject("processIdentifier", processIdentifier);

        return modelAndView;

    }

}
