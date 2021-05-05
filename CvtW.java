import java.awt.event.*;
import javax.swing.*;
/*
 * Assessment Group 18
 * CS12S2
 * Kurt Jayson Zacarias, Justine Gayle Nacional
 * Assignment Module 6
 */
public class CvtW extends JFrame{
    private JLabel sentenceLabel, wordLabel, convertLabel;
    private JLabel firstLabel, ofLabel,secondLabel;
    private JLabel wrdNone, cvtNone;
    private JTextField sentenceTextField;
    private JButton setButton, previousButton, nextButton;

    String[] sentence = null;
    String[] newSentence = null;
    String[] vowels = {"a", "e", "i", "o", "u"};
    int count = 0;

    public CvtW()
    {
        sentenceLabel = new JLabel("Sentence");
        sentenceTextField = new JTextField();
        setButton = new JButton("Set");
        wordLabel= new JLabel("Word: ");
        wrdNone = new JLabel("N/A");
        convertLabel = new JLabel("Converted: ");
        cvtNone = new JLabel("N/A");
        previousButton = new JButton("Previous");
        firstLabel = new JLabel("0");
        ofLabel = new JLabel(" of ");
        secondLabel = new JLabel("0");
        nextButton = new JButton("Next");
        setLayout(null);

        sentenceLabel.setBounds(0,10,100,30);
        sentenceTextField.setBounds(54,0,176,50);
        sentenceTextField.setColumns(10);
        setButton.setBounds(230,0,54,49);

        wordLabel.setBounds(0,63,100,30);
        wrdNone.setBounds(75,65,100,30);

        convertLabel.setBounds(148,65,100,30);
        cvtNone.setBounds(225,65,100,30);

        previousButton.setBounds(0,110,95,50);

        firstLabel.setBounds(123,120,100,25);
        ofLabel.setBounds(130,120,100,25);
        secondLabel.setBounds(150,120,100,25);
        nextButton.setBounds(189,110,95,50);

        add(sentenceLabel);
        add(cvtNone);
        add(sentenceTextField);
        add(setButton);
        add(wordLabel
    );
        add(wrdNone);
        add(convertLabel);
        add(previousButton);
        add(firstLabel);
        add(ofLabel);
        add(secondLabel);
        add(nextButton);

        setButton.addActionListener(new MakeSet());
        previousButton.addActionListener(new PreviousWord());
        nextButton.addActionListener(new NextWord());
    }
    public class MakeSet implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            String words = sentenceTextField.getText();
            
            words = words.replaceAll("[^\\p{Alpha} ]","").toLowerCase();

            sentence = words.split(" ");

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

            firstLabel.setText(String.valueOf(count + 1)); 
            secondLabel.setText(String.valueOf(newSentence.length)); 

            wrdNone.setText(sentence[0]); 
            cvtNone.setText(newSentence[0]);
            sentenceTextField.setText(words);
        }
    }
    public class PreviousWord implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if (count > 0)
            {
                count--;
                wrdNone.setText(sentence[count]);
                cvtNone.setText(newSentence[count]);
                firstLabel.setText(String.valueOf(count + 1));
            }
            else if (firstLabel.getText().equals("1"))
            {
                count = newSentence.length-1;
                wrdNone.setText(sentence[count]);
                cvtNone.setText(newSentence[count]);
                firstLabel.setText(String.valueOf(count + 1));
            }
        }
    }
    
    public class NextWord implements  ActionListener{
        public void actionPerformed(ActionEvent ae)
        {
            if((count < newSentence.length) && !(firstLabel.getText().equals(secondLabel.getText())))
            {
                count++;
                wrdNone.setText(sentence[count]);
                cvtNone.setText(newSentence[count]);
                firstLabel.setText(String.valueOf(count + 1));

            }
            else if (firstLabel.getText().equals(secondLabel.getText()))
            {
                count = 0;
                wrdNone.setText(sentence[count]);
                cvtNone.setText(newSentence[count]);
                firstLabel.setText(String.valueOf(count + 1));
            }
        }
    }
    public static void main(String[] args)
    {
        CvtW frame = new CvtW();
        frame.setTitle("Converter");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}