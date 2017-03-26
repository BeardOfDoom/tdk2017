package hu.david.veres.graph.controller;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.form.ProblemForm;
import hu.david.veres.graph.form.SmlForm;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.thread.BaseProcessThread;
import hu.david.veres.graph.thread.ProcessThread;
import hu.david.veres.graph.util.ProcessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProblemController {

    @Autowired
    private ProcessService processService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(path = "/problem", method = RequestMethod.GET)
    public String problemPage(Model model) {
        model.addAttribute("problemForm", new ProblemForm());
        return "problem";
    }

    @RequestMapping(path = "/problem", method = RequestMethod.POST)
    public ModelAndView problemPost(@ModelAttribute("problemForm") ProblemForm problemForm) {

        List<String> processIdentifiers = new ArrayList<>();

        for (String algorithm : problemForm.getAlgorithms()) {

            String processIdentifier = ProcessUtils.generateProcessIdentifier();

            ProcessDTO processDTO = new ProcessDTO();
            processDTO.setProcessIdentifier(processIdentifier);
            processDTO.setDone(false);
            processService.save(processDTO);

            processIdentifiers.add(processIdentifier);

        }

        BaseProcessThread baseProcessThread = applicationContext.getBean(BaseProcessThread.class);
        baseProcessThread.setProblemForm(problemForm);
        baseProcessThread.setProcessIdentifiers(processIdentifiers);
        threadPoolTaskExecutor.execute(baseProcessThread);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("processIdentifiers", processIdentifiers);
        modelAndView.setViewName("visualizer");

        return modelAndView;

    }

}
