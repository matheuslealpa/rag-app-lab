package br.com.matheusleal.ragapplab.app.component;

import br.com.matheusleal.ragapplab.app.domain.WikiDocument;
import lombok.AllArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class WikiDocumentsRepository {

    private final VectorStore vectorStore;

    public void saveWikiDocument(WikiDocument wikiDocument) {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("filePath", wikiDocument.getFilePath());
        var document = new Document(wikiDocument.getContent(), metadata);
        var documents = new TokenTextSplitter().apply(List.of(document));

        vectorStore.add(documents);
    }

}
