package hu.david.veres.graph.controller;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @RequestMapping(path = "/{processIdentifier}", method = RequestMethod.GET)
    public ModelAndView getProcess(@PathVariable("processIdentifier") String processIdentifier) {

        ModelAndView modelAndView = new ModelAndView();

        ProcessDTO processDTO = processService.getProcessByIdentifier(processIdentifier);

        modelAndView.addObject("processEntity", processDTO);

        modelAndView.setViewName("process");

        return modelAndView;

    }

}
