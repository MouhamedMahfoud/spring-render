package com.alibou.security.controller.api;

import com.alibou.security.dto.PharmacieDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.alibou.security.utils.Constants.PHARMACIE_ENDPOINT;

@Tag(name=PHARMACIE_ENDPOINT)
public interface PharmacieApi {
    @PostMapping(value = PHARMACIE_ENDPOINT+"/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Enregistrer une pharmacie", description = "Cette methode permet d'enregistrer ou modifier une pharmacie",
            responses = {
                    @ApiResponse(responseCode = "200", description = "L'objet pharmacie cree / modifie"),
                    @ApiResponse(responseCode = "400", description = "L'objet pharmacie n'est pas valide")
            }
    )
    ResponseEntity<PharmacieDto> save(@RequestBody PharmacieDto dto);
    @GetMapping(value = PHARMACIE_ENDPOINT+"/id/{idPharmacie}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un pharmacie par ID", description = "Cette methode permet de chercher une pharmacie par son ID",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le pharmacie a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun pharmacie n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<PharmacieDto> findById(@PathVariable("idPharmacie") Integer id);
    @GetMapping(value = PHARMACIE_ENDPOINT+"/name/{nomPharmacie}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une Pharmacie par Nom", description = "Cette methode permet de chercher une Pharmacie par son Nom",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le Pharmacie a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun Pharmacie n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<PharmacieDto> findByName(@PathVariable("nomPharmacie") String nom);
    @GetMapping(value = PHARMACIE_ENDPOINT+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "liste Phormacie", description = "Cette methode permet de chercher une Pharmacie par son Nom",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le Pharmacie a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun Pharmacie n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<List<PharmacieDto>> findAll();
    ResponseEntity<List<PharmacieDto>> findAllPharmacieBayCommune(Integer idCommune);
    @DeleteMapping(PHARMACIE_ENDPOINT+"/delete/{idPharmacie}")
    @Operation(summary = "Supprimer un Pharmacie", description = "Cette methode permet de supprimer une Pharmacie par ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Le Pharmacie a ete supprime")
            }
    )
    ResponseEntity delete(@PathVariable("idPharmacie") Integer id);
}
