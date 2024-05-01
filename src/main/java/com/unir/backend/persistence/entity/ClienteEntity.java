package com.unir.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="clientes")
@Setter
@Getter
@NoArgsConstructor
public class ClienteEntity {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;

    @Column(name="correo_electronico")
    private String correoElectronico;
}


