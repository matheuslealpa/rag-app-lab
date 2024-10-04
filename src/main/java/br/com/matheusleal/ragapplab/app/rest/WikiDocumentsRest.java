package br.com.matheusleal.ragapplab.app.rest;

import br.com.matheusleal.ragapplab.app.service.WikiDocumentsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wiki")
@AllArgsConstructor
public class WikiDocumentsRest {

    private final WikiDocumentsServiceImpl wikiDocumentsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> saveDocument(@RequestParam String filePath) {
        wikiDocumentsService.saveWikiDocument(filePath);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
