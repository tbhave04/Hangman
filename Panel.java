package com.company;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Panel extends JPanel{
    JTextField box;
    JLabel picture;
    JLabel fillWord;
    JButton button;
    Hangman hangman;
    JLabel used;
    JLabel enter;

    public Panel(String word){
        hangman = new Hangman(word);
        setLayout(new BorderLayout());

        JPanel subpanel = new JPanel();
        subpanel.setLayout(new FlowLayout());
        enter = new JLabel("Enter a letter: ");
        subpanel.add(enter);
        box = new JTextField(10);
        box.setHorizontalAlignment(SwingConstants.CENTER);
        box.addKeyListener(new Key());
        subpanel.add(box);
        button = new JButton("Enter");
        button.addActionListener(new Listener());
        subpanel.add(button);
        add(subpanel, BorderLayout.NORTH);

        picture = new JLabel();
        picture.setIcon(new ImageIcon("hangman1.png"));
        add(picture, BorderLayout.CENTER);

        JPanel subpanel2 = new JPanel();
        subpanel2.setLayout(new GridLayout(2,1));

        fillWord = new JLabel(hangman.arrayToString(hangman.fillArray));
        fillWord.setHorizontalAlignment(SwingConstants.CENTER);
        fillWord.setFont (fillWord.getFont ().deriveFont (32.0f));
        subpanel2.add(fillWord);
        used = new JLabel();
        used.setText(hangman.used);
        used.setHorizontalAlignment(SwingConstants.CENTER);
        used.setFont(used.getFont ().deriveFont(14.0f));
        subpanel2.add(used);
        add(subpanel2, BorderLayout.SOUTH);


    }

    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String text = box.getText();
            box.setText("");
            hangman.doTurn(text);
            fillWord.setText(hangman.arrayToString(hangman.fillArray));
            used.setText(hangman.used);

            int turns = hangman.turns;
            String number = Integer.toString(turns);
            picture.setIcon(new ImageIcon("hangman" + number + ".png"));

            if(turns==8){
                button.setEnabled(false);
                box.setText("GAME OVER :(");
                fillWord.setText(hangman.wordArray);
            }

            if(hangman.hasNextTurn() == false){
                button.setEnabled(false);
                box.setText("YOU WIN!");
            }

        }
    }

    private class Key implements KeyListener{
        @Override public void keyTyped(KeyEvent e){}
        @Override public void keyPressed(KeyEvent e){}
        @Override
        public void keyReleased(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                button.doClick();
            }
        }
    }

}
