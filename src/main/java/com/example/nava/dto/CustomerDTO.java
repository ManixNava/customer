package com.example.nava.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;

/**
 * @brief CRee este objeto para mantener separado los datos de entrada de los modelos/entidades/dominios
 * @author Manuel Nava
 * **/
@Data // Con este se generan los getter y setter por detras y hace que el código se vea más limpio
public class CustomerDTO {


    private String id;
    private String firstName;
    private String lastName;

    // Aquí indico el formato en los que debe de venir dicha fecha
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOfBirth;
}
