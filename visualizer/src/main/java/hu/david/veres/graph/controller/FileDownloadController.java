package hu.david.veres.graph.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping(path = "/file")
public class FileDownloadController {

    // TODO: get it from the property file
    private static final String UPLOADED_FILE_FOLDER_NAME = "upload";

    @RequestMapping(path = "/uploaded/{fileName}", method = RequestMethod.GET)
    public void donwloadUploadedFile(@PathVariable("fileName") String fileName, HttpServletResponse response){

        // TODO: only TXT now!!!
        File file = new File(UPLOADED_FILE_FOLDER_NAME + "/" + fileName + ".txt");

        if(!file.exists()){
            // TODO: error
        }

        response.setContentType("text/plain");

        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));

        response.setContentLength((int)file.length());

        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(path = "/json/{fileName}", method = RequestMethod.GET)
    public void downloadJsonFile(HttpServletResponse response, @PathVariable("fileName") String fileName){

        File file = new File("json/" + fileName + ".json");

        response.setContentType("application/javascript");

        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));

        response.setContentLength((int)file.length());

        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(path = "/static", method = RequestMethod.GET)
    public void staticDonwload(HttpServletResponse response){

        File file = new File("json/graph.json");

        response.setContentType("application/javascript");

        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));

        response.setContentLength((int)file.length());

        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
