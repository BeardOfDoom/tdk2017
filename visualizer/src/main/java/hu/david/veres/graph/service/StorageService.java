package hu.david.veres.graph.service;

import hu.david.veres.graph.model.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {

    void storeUploadedFile(MultipartFile file, String newFileName) throws IOException;

    void storeResultInJsonFile(Result result, String newFileName) throws IOException;

}
