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

        for(String algorithm : problemForm.getAlgorithms()){

            String processIdentifier = ProcessUtils.generateProcessIdentifier();

            ProcessDTO processDTO = new ProcessDTO();
            processDTO.setProcessIdentifier(processIdentifier);
            processDTO.setDone(false);
            processService.save(processDTO);

            /*
            ProcessThread processThread = applicationContext.getBean(ProcessThread.class);
            processThread.setProcessIdentifier(processIdentifier);
            threadPoolTaskExecutor.execute(processThread);
            */

            processIdentifiers.add(processIdentifier);

        }

        BaseProcessThread baseProcessThread = applicationContext.getBean(BaseProcessThread.class);
        baseProcessThread.setProblemForm(problemForm);
        baseProcessThread.setProcessIdentifiers(processIdentifiers);
        threadPoolTaskExecutor.execute(baseProcessThread);

        // TODO: return ModelAndView

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("processIdentifiers", processIdentifiers);
        modelAndView.setViewName("visualizer");

        return modelAndView;

//        File file = new File("sml_input.txt");
//        try {
//            FileWriter fileWriter = new FileWriter(file);
//            fileWriter.write(smlForm.getText());
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            ProjectRepresentation projectRepresentation = CommonUtils.processInputFile(file.getAbsolutePath());
//            ProjectGenerator projectGenerator = new ProjectGenerator(new StateGenerator(), new OperatorGenerator());
//            System.out.println("TESZT - " + projectRepresentation);
//            List<ClassRepresentation> classRepresentationList = projectGenerator.generate(projectRepresentation, "kaka", "something");
//            ClassManager.clear();
//            ClassManager.addClasses(classRepresentationList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // return "redirect:./solution";
    }

    /*
    @RequestMapping(path = "/visualizer", method = RequestMethod.GET)
    public String visualizer(){
        return "visualizer";
    }
    */

}
