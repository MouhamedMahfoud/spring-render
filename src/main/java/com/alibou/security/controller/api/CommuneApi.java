package com.alibou.security.controller.api;

import com.alibou.security.dto.CommuneDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.alibou.security.utils.Constants.COMMUNE_ENDPOINT;

@Tag(name = COMMUNE_ENDPOINT)
public interface CommuneApi {
    @PostMapping(value = COMMUNE_ENDPOINT+"/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Enregistrer une commune", description = "Cette methode permet d'enregistrer ou modifier une commune",
            responses = {
                    @ApiResponse(responseCode = "200", description = "L'objet commune cree / modifie"),
                    @ApiResponse(responseCode = "400", description = "L'objet commune n'est pas valide")
            }
    )
    ResponseEntity<CommuneDto> save(@RequestBody CommuneDto dto);
    @GetMapping(value = COMMUNE_ENDPOINT+"/id/{idCommune}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un commune par ID", description = "Cette methode permet de chercher une commune par son ID",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le commune a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun commune n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<CommuneDto> findById(@PathVariable("idCommune") Integer id);
    @GetMapping(value = COMMUNE_ENDPOINT+"/name/{nomCommune}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une commune par Nom", description = "Cette methode permet de chercher une commune par son Nom",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le commune a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun commune n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<CommuneDto> findByName(@PathVariable("nomCommune") String nom);
    @GetMapping(value = COMMUNE_ENDPOINT+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des communes", description = "Cette methode permet de chercher et renvoyer la liste des communes qui existent dans la BDD",
            responses = {
                    @ApiResponse(responseCode = "200",description = "La liste des communes / Une liste vide"),

            }
    )
    ResponseEntity<List<CommuneDto>> findAll();
    ResponseEntity<List<CommuneDto>> findAllCommuneBayMoughataa(Integer idMoughataa);

    @DeleteMapping(COMMUNE_ENDPOINT+"/delete/{idCommune}")
    @Operation(summary = "Supprimer un commune", description = "Cette methode permet de supprimer une commune par ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Le commune a ete supprime")
            }
    )

    ResponseEntity delete(@PathVariable("idCommune") Integer id);
}
