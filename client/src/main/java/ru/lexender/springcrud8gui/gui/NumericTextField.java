package ru.lexender.springcrud8gui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NumericTextField extends JTextField {
    private boolean isFloat;

    public NumericTextField(boolean isfloat) {
        super();
        setPreferredSize(new Dimension(150, 30)); // Установка размера поля ввода
        addKeyListener(new NumericKeyListener()); // Добавление слушателя событий для проверки вводимых символов
        this.isFloat = isfloat;
    }

    private class NumericKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (isFloat) {
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
                    e.consume(); // Если введенный символ не является цифрой или символом удаления, игнорируем его
                }
            } else {
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume(); // Если введенный символ не является цифрой или символом удаления, игнорируем его
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // Не используется
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // Не используется
        }
    }
}
