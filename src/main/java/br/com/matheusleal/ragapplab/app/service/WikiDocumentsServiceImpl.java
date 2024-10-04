package br.com.matheusleal.ragapplab.app.service;

import br.com.matheusleal.ragapplab.app.component.WikiDocumentsRepository;
import br.com.matheusleal.ragapplab.app.domain.WikiDocument;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;

@Service
@AllArgsConstructor
public class WikiDocumentsServiceImpl {

    private final WikiDocumentsRepository wikiDocumentsRepository;

    @SneakyThrows
    public void saveWikiDocument(String filePath) {
        var content = Files.readString(Path.of(filePath));
        var wikiDocument = new WikiDocument();
        wikiDocument.setFilePath(filePath);
        wikiDocument.setContent(content);
        wikiDocumentsRepository.saveWikiDocument(wikiDocument);
    }
}
