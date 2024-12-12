package com.mycompany.tp.dsw.service;

import javax.swing.JOptionPane;

public class MensajeAlerta {

    // Método para mostrar un mensaje de error
    public static void mostrarError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(
                null, // Componente padre
                mensaje, // Mensaje a mostrar
                titulo, // Título de la ventana
                JOptionPane.ERROR_MESSAGE // Tipo de mensaje
        );
    }

    // Método para mostrar un mensaje de información
    public static void mostrarInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(
                null, // Componente padre
                mensaje, // Mensaje a mostrar
                titulo, // Título de la ventana
                JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje
        );
    }

    // Método para mostrar un mensaje de pregunta
    public static void mostrarPregunta(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(
                null, // Componente padre
                mensaje, // Mensaje a mostrar
                titulo, // Título de la ventana
                JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }

    // Método para mostrar un mensaje simple (sin icono)
    public static void mostrarSimple(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(
                null, // Componente padre
                mensaje, // Mensaje a mostrar
                titulo, // Título de la ventana
                JOptionPane.PLAIN_MESSAGE // Tipo de mensaje
        );
    }

    // Método para mostrar un cuadro de confirmación con tipo advertencia
    public static Integer mostrarConfirmacion(String mensaje, String titulo, java.awt.Component parent) {
        return JOptionPane.showConfirmDialog(
                parent, // Componente padre
                mensaje, // Mensaje a mostrar
                titulo, // Título de la ventana
                JOptionPane.YES_NO_OPTION, // Opciones de respuesta
                JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }

}
