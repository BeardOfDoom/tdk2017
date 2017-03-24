package hu.david.veres.graph.controller;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
import hu.david.veres.graph.thread.ProcessThread;
import hu.david.veres.graph.util.ProcessUtils;
import hu.david.veres.graph.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/graph")
public class GraphController {

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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(name = "processIdentifier", required = false) String processIdentifier) {

        if (processIdentifier == null) {

            ModelAndView modelAndView = new ModelAndView("graph");
            return modelAndView;

        } else {

            ProcessDTO processDTO = processService.getProcessByIdentifier(processIdentifier);

            if (processDTO == null) {

                // TODO: property
                ModelAndView modelAndView = new ModelAndView("graph");
                modelAndView.addObject("error", "GRAPH NOT FOUND");
                return modelAndView;

            } else {

                ModelAndView modelAndView = new ModelAndView("redirect:./graph/view/" + processIdentifier);
                return modelAndView;

            }

        }

    }

    /*
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public ModelAndView test(@ModelAttribute("outputPaths") List<String> outputPaths){

        List<String> processIdentifiers = new ArrayList<>();

        for(String outputPath : outputPaths){

            String processIdentifier = ProcessUtils.generateProcessIdentifier();

            File file = new File(outputPath);

            ProcessDTO processDTO = new ProcessDTO();
            processDTO.setProcessIdentifier(processIdentifier);
            processDTO.setDone(false);
            processService.save(processDTO);

            ProcessThread processThread = applicationContext.getBean(ProcessThread.class);
            processThread.setAbsoluteFileName(file.getAbsolutePath());
            processThread.setProcessIdentifier(processIdentifier);
            threadPoolTaskExecutor.execute(processThread);

            processIdentifiers.add(processIdentifier);

        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("processIdentifiers", processIdentifiers);
        modelAndView.setViewName("visualizer");

        return modelAndView;
    }
    */

    @RequestMapping(path = "/view/{processIdentifier}", method = RequestMethod.GET)
    public ModelAndView getProcess(@PathVariable("processIdentifier") String processIdentifier) {

        ModelAndView modelAndView = new ModelAndView();

        ProcessDTO processDTO = processService.getProcessByIdentifier(processIdentifier);

        modelAndView.addObject("processEntity", processDTO);

        modelAndView.setViewName("view");

        return modelAndView;

    }

}
