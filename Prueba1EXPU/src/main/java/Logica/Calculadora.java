package Logica;

/**
 *
 * @author Cristopher Matus
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Calculadora {
    private static double memoryValue = 0.0; // Variable para almacenar el valor en memoria

    public static void main(String[] args) {
        JFrame frame = new JFrame("Memory Clear Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Crear un botón para MC (Memory Clear)
        JButton mcButton = new JButton("MC");
        mcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el botón MC, se borra el valor en memoria
                memoryValue = 0.0;
                JOptionPane.showMessageDialog(frame, "Valor en memoria eliminado (MC)");
            }
        });

        // Agregar un atajo de teclado (CTRL+L) para el botón MC
        mcButton.setMnemonic(KeyEvent.VK_L);
        mcButton.setDisplayedMnemonicIndex(5); // Índice de la letra "L" en el texto del botón

        // Crear un panel para colocar el botón
        JPanel panel = new JPanel();
        panel.add(mcButton);

        // Agregar el panel al marco
        frame.add(panel, BorderLayout.CENTER);

        // Escuchar combinación de teclas CTRL+L
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_L) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    // Cuando se presiona CTRL+L, se ejecuta la acción del botón MC
                    memoryValue = 0.0;
                    JOptionPane.showMessageDialog(frame, "Valor en memoria eliminado (CTRL+L)");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        // Hacer que el marco sea el foco para que pueda recibir eventos de teclado
        frame.setFocusable(true);
        frame.requestFocus();

        frame.setVisible(true);
    }
}

