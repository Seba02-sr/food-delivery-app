package com.mycompany.tp.dsw.service;

import javax.swing.JOptionPane;

public class MensajeAlerta {

    // Metodo para mostrar un mensaje de error
    public static void mostrarError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.ERROR_MESSAGE);
    }

    // Metodo para mostrar un mensaje de informacion
    public static void mostrarInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Metodo para mostrar un mensaje de pregunta
    public static void mostrarPregunta(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.QUESTION_MESSAGE);
    }

    // Metodo para mostrar un mensaje simple (sin icono)
    public static void mostrarSimple(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.PLAIN_MESSAGE);
    }

    // Metodo para mostrar un cuadro de confirmacion con tipo advertencia
    public static Integer mostrarConfirmacion(String mensaje, String titulo, java.awt.Component parent) {
        return JOptionPane.showConfirmDialog(
                parent,
                mensaje,
                titulo,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
    }

}
