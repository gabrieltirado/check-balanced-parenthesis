package com.encora;

import java.util.Objects;
import java.util.Stack;

/***
 *
 * Implementar un algoritmo que indique si una expresión compuesta por paréntesis está o no bien balanceada.
 * Paréntesis válidos: (, ), {, }, [, ]
 *
 * Ejemplos:
 * (): bien balanceado
 * ((): mal balanceado
 * ({}): bien balanceado
 * ({)}: mal balanceado
 * )(: mal balanceado
 * [{[]}()]: bien balanceado
 * {}(): bien balanceado
 * {}: bien balanceado
 */

class CheckBalancedParenthesis {
    public static void main(String[] args) {

        //Definir tipos de variables para parentesis.
        //Recibir expresión y hacer split
        //\( verificar su correspondiente par )
        //Creo la pila
        //Loop : hasta string lenght. Va hasta el final
        //Simbolo que abre Apilar(Simbolo). Desapilar() Compare. Si el ultimo correponde a cierre -> balanceado = true.
        // [{
        String expresion = "[{[]}()]";
        //String expresion = "(()*";
        boolean balanceado = isBalanceado(expresion);

        if (balanceado) {
            System.out.println("La expresión está balanceada");
        } else {
            System.out.println("La expresión no está balanceada");
        }


    }

    /**
     * Clase para validar si una expresión de parentesis está balanceada.
     * Esta solución implementa una Pila.
     * @param expresion
     * @return
     */
    public static boolean isBalanceado(String expresion) {

        // Se valida mediante regex [(){}\[\]] que la expresión solo tenga los caracteres permitidos (, ), {, }, [, ]
        if (!expresion.matches("^[(){}\\[\\]]*$")) {
            System.out.println("La expresión contiene caracteres invalidos");
            return false;
        }

        String[] elements = expresion.split("");
        String s;
        boolean balanceado = false;

        Stack<String> stack = new Stack<>();
        for (String element : elements) {
            /* Por cada simbolo validamos si es de apertura y lo apilamos */
            if (Objects.equals(element, "(") | Objects.equals(element, "[") | Objects.equals(element, "{")) {
                stack.push(element);
                balanceado = false;
            } else {
                /* Si no estamos ante un simbolo de apertura sino de cierra, desapilamos y validamos el par */
                if (!stack.empty()) {
                    s = stack.pop();
                    if (Objects.equals(s, "(")) {
                        if (Objects.equals(element, ")")) {
                            balanceado = true;
                        } else {
                            balanceado = false;
                            break;
                        }
                    }
                    if (Objects.equals(s, "[")) {
                        if (Objects.equals(element, "]")) {
                            balanceado = true;
                        } else {
                            balanceado = false;
                            break;
                        }
                    }
                    if (Objects.equals(s, "{")) {
                        if (Objects.equals(element, "}")) {
                            balanceado = true;
                        } else {
                            balanceado = false;
                            break;
                        }
                    }
                }
            }
        }

        /* Se realiza una ultima validación de la pila
        * si esta aun tiene elementos al finalizar la revisión
        * entonces no expresion no está balanceada */
        if (!stack.isEmpty()) {
            balanceado = false;
        }

        return balanceado;
    }
}