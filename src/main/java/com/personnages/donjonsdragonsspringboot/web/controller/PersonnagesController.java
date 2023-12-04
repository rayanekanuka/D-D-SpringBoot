package com.personnages.donjonsdragonsspringboot.web.controller;

import com.personnages.donjonsdragonsspringboot.dao.PersonnagesDao;
import com.personnages.donjonsdragonsspringboot.exception.ResourceNotFoundException;
import com.personnages.donjonsdragonsspringboot.model.Personnage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RestController indique que cette classe va pouvoir traiter les requêtes que nous allons définir.
 * Il indique aussi que chaque méthode va renvoyer directement la réponse JSON à l'utilisateur
 */
@RestController
public class PersonnagesController {
    private final PersonnagesDao personnagesDao;

    public PersonnagesController(PersonnagesDao personnagesDao) {
        this.personnagesDao = personnagesDao;
    }

    /**
     * Lit toute la liste des personnages
     *
     * @return les infos des personnages
     */
    @Operation(summary = "Récupère une liste de personnages")
    @GetMapping("/Personnages")
    public List<Personnage> listePersonnages() {
        return personnagesDao.findAll();
    }

    /**
     * Lit le personnage identifié par un id
     *
     * @param id pour
     * @return un id du personnage
     */

    @Operation(summary = "Récupère les infos d'un personnage selon son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personnage trouvé",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class))}),
            @ApiResponse(responseCode = "400", description = "Personnage introuvable",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Personnage non accessible",
                    content = @Content)})
    @GetMapping("/Personnages/{id}")
    public Personnage afficherUnPersonnage(@Validated @PathVariable int id) {
        return personnagesDao.findById(id);
    }

    /**
     * Ajoute un personnage
     * @param personnages
     * @return
     */
    @Operation(summary = "Ajoute un personnage")
    @PostMapping("/Personnages")
    public Personnage ajouterUnPersonnage(@Validated @RequestBody Personnage personnages) {
        return personnagesDao.save(personnages);
    }

    /**
     * Modifie un personnage identifié par un id
     *
     * @param
     * @return
     */
    @Operation(summary = "Modifie un personnage selon son id")
    @PutMapping("/Personnages/{id}")
    public ResponseEntity<Personnage> modifierUnPersonnage(@Validated @PathVariable int id, @RequestBody Personnage personnage) {
        Personnage updatePersona = personnagesDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le héros n'existe pas sous cet ID" + id));
        updatePersona.setNom(personnage.getNom());
        updatePersona.setType(personnage.getType());
        updatePersona.setVie(personnage.getVie());
        personnagesDao.save(updatePersona);

        return ResponseEntity.ok(updatePersona);
    }

    /**
     * Supprime un personnage identifié par un id
     *
     * @param id
     * @return
     */
    @Operation(summary = "Supprime un personnage selon son id")
    @DeleteMapping("/Personnages/{id}")
    public void supprimerUnPersonnage(@Validated @PathVariable int id) {
        personnagesDao.deleteById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
