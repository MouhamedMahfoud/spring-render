package com.alibou.security.controller.api;

import com.alibou.security.dto.WilayaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.alibou.security.utils.Constants.WILAYA_ENDPOINT;

@Tag(name = WILAYA_ENDPOINT)
public interface WilayaApi {
    @PostMapping(value = WILAYA_ENDPOINT+"/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Enregistrer une wilaya", description = "Cette methode permet d'enregistrer ou modifier une wilaya",
            responses = {
                    @ApiResponse(responseCode = "200", description = "L'objet wilaya cree / modifie"),
                    @ApiResponse(responseCode = "400", description = "L'objet wilaya n'est pas valide")
            }
    )
    ResponseEntity<WilayaDto> save(@RequestBody WilayaDto dto);
    @GetMapping(value = WILAYA_ENDPOINT+"/id/{idWilaya}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un wilaya par ID", description = "Cette methode permet de chercher une wilaya par son ID",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le wilaya a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun wilaya n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<WilayaDto> findById(@PathVariable("idWilaya") Integer id);
    @GetMapping(value = WILAYA_ENDPOINT+"/name/{nomWilaya}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une wilaya par Nom", description = "Cette methode permet de chercher une wilaya par son Nom",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le wilaya a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun wilaya n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<WilayaDto> findByName(@PathVariable("nomWilaya") String nom);
    @GetMapping(value = WILAYA_ENDPOINT+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des wilayas", description = "Cette methode permet de chercher et renvoyer la liste des wilayas qui existent dans la BDD",
            responses = {
                    @ApiResponse(responseCode = "200",description = "La liste des wilayas / Une liste vide"),

            }
    )
    ResponseEntity<List<WilayaDto>> findAll();
    @DeleteMapping(WILAYA_ENDPOINT+"/delete/{idWilaya}")
    @Operation(summary = "Supprimer un wilaya", description = "Cette methode permet de supprimer une wilaya par ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Le wilaya a ete supprime")
            }
    )
    ResponseEntity delete(@PathVariable("idWilaya") Integer id);
}
