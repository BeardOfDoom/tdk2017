package hu.david.veres.graph.controller;


import hu.david.veres.graph.form.SolutionForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SolutionController {

    @RequestMapping(path = "/solution", method = RequestMethod.GET)
    public String sml(Model model) {
        model.addAttribute("solutionForm", new SolutionForm());
        return "solution";
    }

    @RequestMapping(path = "/solution", method = RequestMethod.POST)
    public String smlPost(@ModelAttribute("solutionForm") SolutionForm solutionForm, Model model, RedirectAttributes redirectAttributes) {

//        UserInput userInput = SolutionFormToUserInputConverter.convert(solutionForm);
//        try {
//            SolutionMaker solutionMaker = new SolutionMaker(ClassManager.getFilePaths(), userInput);
//            List<String> outputPaths = solutionMaker.start();
//            redirectAttributes.addFlashAttribute("outputPaths", outputPaths);
//            return "redirect:./graph/test";
//        } catch (TemporaryFolderCreationException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (CompilationException e) {
//            e.printStackTrace();
//        } catch (WrongFileExtensionException e) {
//            e.printStackTrace();
//        } catch (StateInitializationException e) {
//            e.printStackTrace();
//        } catch (OperatorInitializationException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (TemporaryFolderDeletionException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (OperatorNotFoundException e) {
//            e.printStackTrace();
//        } catch (StateNotFoundException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        System.out.println("SOLUTION - " + solutionForm);
//        model.addAttribute("solutionForm", new SolutionForm());

        return "solution";
    }

}
