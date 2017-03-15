package hu.david.veres.graph.controller;

import hu.david.veres.graph.entity.ProcessEntity;
import hu.david.veres.graph.repository.ProcessRepository;
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
    private ProcessRepository processRepository;

    @RequestMapping(path = "/{processIdentifier}", method = RequestMethod.GET)
    public ModelAndView getProcess(@PathVariable("processIdentifier") String processIdentifier) {

        ModelAndView modelAndView = new ModelAndView();

        ProcessEntity processEntity = processRepository.findByProcessIdentifier(processIdentifier);

        modelAndView.addObject("processEntity", processEntity);

        modelAndView.setViewName("process");

        return modelAndView;

    }

}
