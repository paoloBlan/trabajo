package com.api.cliente.Validacion;

public class ConstValidation {
    public static final String MESSAGE_VACIO = "el campo no puede estar vacio"; 
    public static final String PATTERN_LETRAS =  "^[A-Za-záéíóúÁÉÍÓÚÑñ ]+$"; 
    public static final String MESSAGE_LETRAS_ESPACIOS = "Solo se admite letras"; 
    public static final int MAX_45 = 45;
    public static final String MESSAGE_MAX_45 = "Máximo 45 caracteres.";
    public static final String MESSAGE_EMAIL = "Formato incorrecto"; 
    public static final String PATTERN_TELEFONO =  "^\\+?[0-9]{7,15}$";
    public static final String MESSAGE_TELEFONO =  "Número de teléfono inválido. Debe contener entre 7 y 15 dígitos y puede incluir un prefijo ";
    public static final String PATTERN_NUMERO = "^[0-9]{7,15}$";
    public static final String MESSAGE_NUMERO = "solo numero";
    public static final String MESSAGE_NULL = "Campo obligatorio";
    public static final String MESSAGE_NUM_POSITVO = "El ID del cliente debe ser un número positivo.";

}
