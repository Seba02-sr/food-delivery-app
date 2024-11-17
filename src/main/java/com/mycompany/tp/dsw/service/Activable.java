package com.mycompany.tp.dsw.service;

import java.time.LocalDate;

public interface Activable {
    void setActivo(Boolean activo);

    Boolean getActivo();

    void setFechaEliminacion(LocalDate fechaEliminacion);

    LocalDate getFechaEliminacion();
}
