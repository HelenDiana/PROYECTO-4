package com.api.mscustomer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class Customer {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String dni;
    // Constructor
    public Customer(int id, String nombre, String apellido, String correo, String dni) {
        this.id= id;
        this.nombre= nombre;
        this.apellido= apellido;
        this.correo= correo;
        this.dni= dni;
    }
}