package hu.david.veres.graph.controller;

import generator.*;
import hu.david.veres.graph.form.SmlForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import representation.ClassRepresentation;
import representation.ProjectRepresentation;
import utils.CommonUtils;
import misc.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Controller
public class SMLController {

    @RequestMapping(path = "/sml", method = RequestMethod.GET)
    public String sml(Model model) {
        model.addAttribute("smlForm", new SmlForm());
        return "sml";
    }

    @RequestMapping(path = "/sml", method = RequestMethod.POST)
    public String smlPost(@ModelAttribute("smlForm") SmlForm smlForm) {

        File file = new File("sml_input.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(smlForm.getText());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ProjectRepresentation projectRepresentation = CommonUtils.processInputFile(file.getAbsolutePath());
            ProjectGenerator projectGenerator = new ProjectGenerator(new StateGenerator(), new OperatorGenerator());
            System.out.println("TESZT - " + projectRepresentation);
            List<ClassRepresentation> classRepresentationList = projectGenerator.generate(projectRepresentation, "kaka", "something");
            ClassManager.clear();
            ClassManager.addClasses(classRepresentationList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:./solution";
    }

}
