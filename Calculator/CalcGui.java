package Calculator;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.InsetsUIResource;
import javax.xml.transform.URIResolver;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.*;
public class CalcGui extends JFrame {

    private MainPanle       mainPanel;

    public CalcGui(){
            this.setLayout(new GridLayout(1,1));
            this.setSize(300,500);
            this.setTitle("Calculator");
     
     
            this.setIconImage((new ImageIcon(CalcGui.class.getResource("calcIco.ico"))).getImage());
            this.setLocation(new Point(400,50));
            mainPanel =  new MainPanle(this);
            this.add(mainPanel);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.revalidate();
            this.setVisible(true);

            
    }

    public static void main(String[] args) {
        CalcGui calculator =  new CalcGui();
        
    }



    
}
class MainPanle extends JPanel {

    private TitlePanel     titlePanel;
    private TextFieldPanel txtFieldPanel;
    private ButtonPanel  firstRowPanel;


    public MainPanle(Component parent){

        super(new GridBagLayout());
        this.setSize(parent.getSize());
        titlePanel    =  new TitlePanel(this);
        txtFieldPanel =  new TextFieldPanel(this);
        firstRowPanel =  new ButtonPanel(this,(JTextField)txtFieldPanel.getComponent(0));
        GridBagConstraints c  = new GridBagConstraints();
       
        c.gridx = 0;
        c.gridy=0;
        c.weighty=0.15;
        c.weightx=1;
        c.gridwidth=GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(titlePanel,c);

        c.gridx = 0;
        c.gridy=1;
        c.weighty=0.15;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(txtFieldPanel,c);

        c.gridx = 0;
        c.gridy=2;
        c.weighty=0.3;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(firstRowPanel,c);
        this.setBackground(Color.gray);
        this.revalidate();


    }

}

class TitlePanel extends JPanel {

    private JLabel titLabel;

    public TitlePanel(Component parent){
        
        this.setPreferredSize(new Dimension(parent.getWidth(), 50));

        titLabel =  new JLabel();
        titLabel.setForeground(Color.black);
        titLabel.setSize(this.getWidth(), this.getHeight());
        titLabel.setText("Calculator");
        titLabel.setForeground(Color.cyan);
        titLabel.setOpaque(true);
        titLabel.setBackground(Color.black);
        titLabel.setFont(new Font("Courier",1,18));
        this.add(titLabel);
        this.setBorder(BorderFactory.createLineBorder(Color.red,1));
        this.revalidate();

    }


}
class TextFieldPanel extends JPanel{
    private JTextField textField;

    public TextFieldPanel(Component parent){
        textField =  new JTextField("");
        textField.setFont(new Font("Symbole",1,18));
        
        this.setSize(parent.getWidth(),100);
        textField.setPreferredSize(new Dimension(this.getWidth()-20,30));
        textField.setEditable(true);
        textField.setEnabled(true);
        textField.setForeground(Color.cyan);
        textField.setBackground(Color.black);
        textField.revalidate();
        this.add(textField);
        this.setBorder(BorderFactory.createLineBorder(Color.red,1));

        this.revalidate();
}
}

class ButtonPanel extends JPanel{
    private JButton btnOne =    new JButton("1");
    private JButton btnTwo =    new JButton("2");
    private JButton btnThree =  new JButton("3");
    private JButton btnPlus =   new JButton("+");
    private JButton btnFour =   new JButton("4");
    private JButton btnFive =   new JButton("5");
    private JButton btnSix =    new JButton("6");
    private JButton btnMinus =  new JButton("-");
    private JButton btnSeven =  new JButton("7");
    private JButton btnEight =  new JButton("8");
    private JButton btnNine =   new JButton("9");
    private JButton btnDivision = new JButton("\\");
    private JButton btnZero =     new JButton("0");
    private JButton btnMultpy =   new JButton("×");
    private JButton btnEqual =   new JButton("=");
    private JButton btnOpenBracket =   new JButton("(");
    private JButton btnCloseBracket =   new JButton(")");
    private JButton btnBack =   new JButton("<");
    private JButton btnReset =   new JButton("C");

    public ButtonPanel (Component parent,JTextField textField){

        this.setLayout(new GridLayout(4,5));
        this.setSize(parent.getWidth(),200);
        this.add(btnOne);
        this.add(btnTwo);
        this.add(btnThree);
        this.add(btnBack);
        this.add(btnReset);
        this.add(btnFour);
        this.add(btnFive);
        this.add(btnSix);
        this.add(btnPlus);
        this.add(btnOpenBracket);
        this.add(btnSeven);
        this.add(btnEight);
        this.add(btnNine);
        this.add(btnMinus);
        this.add(btnCloseBracket);
        this.add(btnZero);
        this.add(btnEqual);
        JButton btn =  new JButton("");
        this.add(btn);
        this.add(btnMultpy);
        this.add(btnDivision);
        
        for (Component b : this.getComponents()){
                if (b instanceof JButton){
                   JButton button = (JButton)b;
                   button.setSize(30,30);
                   button.setBackground(Color.black);
                   button.setForeground(Color.cyan);
                   button.setFont(new Font("Courier",0,18));
                   button.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switch (button.getText())
                        {
                        case "1": case "2": case "3": case "4": case "5":
                        case "6": case "7": case "8": case "9": case "0":
                        case "+": case "-": case "×": case "\\": case "(": case ")":
                            textField.setText(textField.getText()+button.getText());
                        break;

                        case "C":
                            textField.setText("");
                        break;

                        case  "<":
                        if(textField.getText().length()>0){
                        String s =  textField.getText();
                        int l = s.length();
                        s=s.substring(0, l-1);
                        textField.setText(s);
                        }
                        break;

                        

                        }
                    }

                   } );
                    this.revalidate();
                  
                    
                }
        }
    }
    

}

