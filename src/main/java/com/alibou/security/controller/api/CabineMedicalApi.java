package com.alibou.security.controller.api;

import com.alibou.security.dto.CabineMedicalDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.alibou.security.utils.Constants.CABINEMEDICAL_ENDPOINT;

@Tag(name = CABINEMEDICAL_ENDPOINT)
public interface CabineMedicalApi {
    @PostMapping(value = CABINEMEDICAL_ENDPOINT+"/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Enregistrer une cabine Medical", description = "Cette methode permet d'enregistrer ou modifier une cabineMedical",
            responses = {
                    @ApiResponse(responseCode = "200", description = "L'objet cabineMedical cree / modifie"),
                    @ApiResponse(responseCode = "400", description = "L'objet cabineMedical n'est pas valide")
            }
    )
    ResponseEntity<CabineMedicalDto> save(@RequestBody CabineMedicalDto dto);
    @GetMapping(value = CABINEMEDICAL_ENDPOINT+"/id/{idCabineMedical}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un cabineMedical par ID", description = "Cette methode permet de chercher une cabineMedical par son ID",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le cabineMedical a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun cabineMedical n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<CabineMedicalDto> findById(@PathVariable("idCabineMedical") Integer id);
    @GetMapping(value = CABINEMEDICAL_ENDPOINT+"/name/{nomCabineMedical}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une cabineMedical par Nom", description = "Cette methode permet de chercher une cabineMedical par son Nom",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Le cabineMedical a ete trouve dans la BDD"),
                    @ApiResponse(responseCode = "404", description = "Aucun cabineMedical n'existe dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<CabineMedicalDto> findByName(@PathVariable("nomCabineMedical") String nom);
    @GetMapping(value = CABINEMEDICAL_ENDPOINT+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des cabineMedical", description = "Cette methode permet de chercher et renvoyer la liste des cabineMedical qui existent dans la BDD",
            responses = {
                    @ApiResponse(responseCode = "200",description = "La liste des cabineMedical / Une liste vide"),

            }
    )
    ResponseEntity<List<CabineMedicalDto>> findAll();
    ResponseEntity<List<CabineMedicalDto>> findAllCabineMedicalBayCommune(Integer idCommune);
    @DeleteMapping(CABINEMEDICAL_ENDPOINT+"/delete/{idCabineMedical}")
    @Operation(summary = "Supprimer un cabineMedical", description = "Cette methode permet de supprimer une cabineMedical par ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Le cabineMedical a ete supprime")
            }
    )
    ResponseEntity delete(@PathVariable("idCabineMedical") Integer id);
}
