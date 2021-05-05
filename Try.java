import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;
public class Try extends JFrame{
    private JLabel lblSentence, lblWord, lblConverted;
    private JLabel lblFirst, lblOf,lblSec;
    private JLabel wordNA, convertedNA;
    private JTextField txtSentence;
    private JButton btnSet, btnPrevious, btnNext;

    String[] sentence = null;
    String[] newSentence = null;
    String[] vowels = {"a", "e", "i", "o", "u"};
    int ctrl = 0;

    public Try()
    {
        lblSentence = new JLabel("Sentence");
        txtSentence = new JTextField();
        btnSet = new JButton("Set");
        lblWord = new JLabel("Word");
        wordNA = new JLabel("N/A");
        lblConverted = new JLabel("Converted");
        convertedNA = new JLabel("N/A");
        btnPrevious = new JButton("Previous");
        lblFirst = new JLabel("0");
        lblOf = new JLabel(" of ");
        lblSec = new JLabel("0");
        btnNext = new JButton("Next");
        setLayout(null);

        lblSentence.setBounds(0,10,100,30);
        txtSentence.setBounds(54,0,176,50);
        txtSentence.setColumns(10);
        btnSet.setBounds(230,0,54,49);

        lblWord.setBounds(0,63,100,30);
        wordNA.setBounds(75,65,100,30);

        lblConverted.setBounds(148,65,100,30);
        convertedNA.setBounds(225,65,100,30);

        btnPrevious.setBounds(0,110,95,50);

        lblFirst.setBounds(123,120,100,25);
        lblOf.setBounds(130,120,100,25);
        lblSec.setBounds(150,120,100,25);
        btnNext.setBounds(189,110,95,50);

        add(lblSentence);
        add(convertedNA);
        add(txtSentence);
        add(btnSet);
        add(lblWord);
        add(wordNA);
        add(lblConverted);
        add(btnPrevious);
        add(lblFirst);
        add(lblOf);
        add(lblSec);
        add(btnNext);

        btnSet.addActionListener(new MakeSet());
        btnPrevious.addActionListener(new PreviousWord());
        btnNext.addActionListener(new NextWord());
    }
    public class MakeSet implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            String words = txtSentence.getText();

            words = words.replaceAll("\\d","");
            words = words.replaceAll("[!@#$%^&*()]", "");

            sentence = words.toLowerCase().split(" ");

            boolean isFinished = false;
            int ptr = 0;
            String temp;
            String add = "ay";
            String removedLetter;

            String word = "";

            for(String curr : sentence) 
            {
                for(int i = 0; i < curr.length(); i++)
                {
                    for(String currVowel : vowels)
                    {
                        if(currVowel.equals(String.valueOf(curr.charAt(i))))
                        {
                            if(i == 0) 
                            {
                                add = "way";
                            }
                            ptr = i;
                            removedLetter = curr.substring(0, i);
                            temp = curr.substring(ptr);
                            curr = temp + removedLetter + add; 
                            isFinished = true;
                        }
                    }
                    if(isFinished)
                    {
                        break;
                    }
                }
                isFinished = false;
                add = "ay"; 

                if(word == "")
                {
                    word = curr;
                }
                else
                {
                    word = word +  " " + curr;
                }
            }
            newSentence = word.split(" "); 

            lblFirst.setText(String.valueOf(ctrl + 1)); 
            lblSec.setText(String.valueOf(newSentence.length)); 

            wordNA.setText(sentence[0]); 
            convertedNA.setText(newSentence[0]);
        }
    }
    public class PreviousWord implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if((ctrl < newSentence.length) && !(lblFirst.getText().equals(lblSec.getText())))
            {
                ctrl++;
                wordNA.setText(sentence[ctrl]);
                convertedNA.setText(newSentence[ctrl]);
                lblFirst.setText(String.valueOf(ctrl + 1));

            }
            else if (lblFirst.getText().equals(lblSec.getText()))
            {
                ctrl = 0;
                wordNA.setText(sentence[ctrl]);
                convertedNA.setText(newSentence[ctrl]);
                lblFirst.setText(String.valueOf(ctrl + 1));
            }
        }
    }
    
    public class NextWord implements ActionListener{
        public void actionPerformed(ActionEvent ae)
        {
            if (ctrl > 0)
            {
                ctrl--;
                wordNA.setText(sentence[ctrl]);
                convertedNA.setText(newSentence[ctrl]);
                lblFirst.setText(String.valueOf(ctrl + 1));
            }
            else if (lblFirst.getText().equals("1"))
            {
                ctrl = newSentence.length-1;
                wordNA.setText(sentence[ctrl]);
                convertedNA.setText(newSentence[ctrl]);
                lblFirst.setText(String.valueOf(ctrl + 1));
            }
        }
    }
    public static void main(String[] args)
    {
        Try frame = new Try();
        frame.setTitle("Converter");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}