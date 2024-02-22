package com.alibou.security.controller.api;

import com.alibou.security.dto.UtilisateurDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.alibou.security.utils.Constants.UTILISATEUR_ENDPOINT;

@Tag(name=UTILISATEUR_ENDPOINT)
public interface UtilisateurApi {
    @PostMapping(value = UTILISATEUR_ENDPOINT+"/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Enregistrer un utilisateur", description = "Cette methode permet d'enregistrer ou modifier un utilisateur",
            responses = {
                    @ApiResponse(responseCode = "200", description = "L'objet utilisateur cree / modifie"),
                    @ApiResponse(responseCode = "400", description = "L'objet utilisateur n'est pas valide")
            }
    )
    ResponseEntity<UtilisateurDto> save(@RequestBody UtilisateurDto dto);
    @GetMapping(value = UTILISATEUR_ENDPOINT+"/id/{idUtilisateur}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un utilisateur par ID", description = "Cette methode permet de chercher une utilisateur par son ID",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le utilisateur a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun utilisateur n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<UtilisateurDto> findById(@PathVariable("idUtilisateur") Integer id);
    @GetMapping(value = UTILISATEUR_ENDPOINT+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des utilisateurs", description = "Cette methode permet de chercher et renvoyer la liste des utilisateurs qui existent dans la BDD",
            responses = {
                    @ApiResponse(responseCode = "200",description = "La liste des utilisateurs / Une liste vide"),

            }
    )
    ResponseEntity<List<UtilisateurDto>> findAll();
    @DeleteMapping(UTILISATEUR_ENDPOINT+"/delete/{idUtilisateur}")
    @Operation(summary = "Supprimer un utilisateur", description = "Cette methode permet de supprimer une utilisateur par ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Le utilisateur a ete supprime")
            }
    )
    ResponseEntity delete(@PathVariable("idUtilisateur") Integer id);
    ResponseEntity<UtilisateurDto> findByEmail(String email);
}
