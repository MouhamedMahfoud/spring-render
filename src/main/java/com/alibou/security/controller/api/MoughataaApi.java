package com.alibou.security.controller.api;

import com.alibou.security.dto.MoughataaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.alibou.security.utils.Constants.MOUGHATAA_ENDPOINT;

@Tag(name=MOUGHATAA_ENDPOINT)
public interface MoughataaApi {
    @PostMapping(value = MOUGHATAA_ENDPOINT+"/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Enregistrer une moughatas", description = "Cette methode permet d'enregistrer ou modifier une moughatas",
            responses = {
                    @ApiResponse(responseCode = "200", description = "L'objet moughatas cree / modifie"),
                    @ApiResponse(responseCode = "400", description = "L'objet moughatas n'est pas valide")
            }
    )
    ResponseEntity<MoughataaDto> save(@RequestBody MoughataaDto dto);
    @GetMapping(value = MOUGHATAA_ENDPOINT+"/id/{idMougatas}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un moughataa par ID", description = "Cette methode permet de chercher une moughataa par son ID",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le moughataa a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun moughataa n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<MoughataaDto> findById(@PathVariable("idMougatas") Integer id);
    @GetMapping(value = MOUGHATAA_ENDPOINT+"/name/{nomMougatas}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une moughataa par Nom", description = "Cette methode permet de chercher une moughataa par son Nom",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le moughataa a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun moughataa n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<MoughataaDto> findByName(@PathVariable("nomMougatas") String nom);
    @GetMapping(value = MOUGHATAA_ENDPOINT+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des moughataas", description = "Cette methode permet de chercher et renvoyer la liste des moughataas qui existent dans la BDD",
            responses = {
                    @ApiResponse(responseCode = "200",description = "La liste des moughataas / Une liste vide"),

            }
    )
    ResponseEntity<List<MoughataaDto>> findAll();
    ResponseEntity<List<MoughataaDto>> findAllMoughataaByWilaya(Integer idWilaya);

    @DeleteMapping(MOUGHATAA_ENDPOINT+"/delete/{idMougatas}")
    @Operation(summary = "Supprimer un moughataa", description = "Cette methode permet de supprimer une moughataa par ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Le moughataa a ete supprime")
            }
    )
    ResponseEntity delete(@PathVariable("idMougatas") Integer id);
}
