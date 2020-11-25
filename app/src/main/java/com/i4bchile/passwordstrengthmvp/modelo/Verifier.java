package com.i4bchile.passwordstrengthmvp.modelo;

public class Verifier {

    private static final Verifier VERIFIER=new Verifier();

    private Verifier(){};

    public static Verifier getInstance(){
        return VERIFIER;
    }

    // rules

    /*  1. Longitud mínima de al menos 5 caracteres.
        2. Contenga letras mayúscula.
        3. Contenga al menos un caracter numérico.

     */

    public int verifyPassword(String password) {
        int resultado = 0;
        boolean rule1 = matchRule1(password);
        boolean rule2 = matchRule2(password);
        boolean rule3 = matchRule3(password);
        // evaluamos el cumplimiento de las reglas

        if (!rule1) {
            resultado = 0;
        } else if (!rule2) {
            resultado = 1;
        } else if (!rule3) {
            resultado = 2;
        } else resultado = 3;


        return resultado;
    }

    public boolean matchRule1(String password) {
        boolean rule1;
        rule1 = password.length() > 5;

        return rule1;
    }

    public boolean matchRule2(String password) {
        boolean rule2;
        rule2 = matchRule1(password) & !password.equals(password.toLowerCase());

        return rule2;
    }

    public boolean matchRule3(String password) {
        boolean rule3;
        rule3 = matchRule1(password) & matchRule2(password) & password.matches(".*\\d.*");
        //".*\\d.*" comprueba que haya un dígito (0-9) en cualquier posición dentro del string.
        return rule3;
    }
}