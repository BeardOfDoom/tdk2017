package hu.david.veres.graph.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.david.veres.graph.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageServiceImpl implements StorageService {

    private static final String EXTENSION_TXT = ".txt";
    private static final String EXTENSION_JSON = ".json";
    private static final String SLASH = "/";

    @Value("${file.upload.folder}")
    private String fileUploadFolderName;

    @Value("${file.json.folder}")
    private String jsonFolderName;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void storeUploadedFile(MultipartFile file, String newFileName) throws IOException {

        Path fileUploadFolderLocation = Paths.get(fileUploadFolderName);

        Files.copy(file.getInputStream(), fileUploadFolderLocation.resolve(newFileName + EXTENSION_TXT));

    }

    @Override
    public void storeResultInJsonFile(Result result, String newFileName) throws IOException {

        Path jsonFolderLocation = Paths.get(jsonFolderName);

        File file = new File(jsonFolderLocation.toString() + SLASH + newFileName + EXTENSION_JSON);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, result);

    }

}
