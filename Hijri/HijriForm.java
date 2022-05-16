package Hijri;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTreeUI.ComponentHandler;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;


public class HijriForm extends JDialog{

    public HijriForm(){
        HijrahChronology hijriClaendar  = HijrahChronology.INSTANCE;
        String date = hijriClaendar.dateNow().toString();
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d =  t.getScreenSize();

        double screenWidth  =  d.getWidth();
        double screenHeight  =  d.getHeight();

        int myWidth =  300;
        int myHeight =  30;
    
        this.setSize(new Dimension (myWidth,myHeight));
        this.setResizable(false);
        JPanel  panel = new JPanel();
        panel.setSize(this.getSize());
        JButton label = new myLabel();
        label.setSize(this.getSize());
        
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panel.add(label);
        this.add(panel);

        Taskbar t1=  Taskbar.getTaskbar();

              double maxHeight =  GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight();
              double taskbarHeight  =  screenHeight-maxHeight;

            
           
            this.setAlwaysOnTop(true);
            //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setUndecorated(true);
            this.setVisible(true);
            
            label.setFont(new Font("Times New Romans",Font.BOLD,13));
            label.setText(getDateFormat(date));
            label.setSize(label.getPreferredSize());
            myWidth= label.getWidth();
            myHeight =label.getHeight();
            this.setLocation((int) (screenWidth - myWidth), (int)(screenHeight-taskbarHeight-myHeight)-10);
            panel.setSize(panel.getPreferredSize());
            this.setSize(this.getPreferredSize());
            label.repaint();
            panel.repaint();
            this.repaint();
       label.addActionListener((ActionEvent e) -> {
           int i =  JOptionPane.showConfirmDialog(null,"Exit?","Confirm",JOptionPane.OK_CANCEL_OPTION);
           if (i==0)
               System.exit(0);
        });

    }

    public static void main(String[] args) {
        HijriForm hijri  =  new HijriForm();
   
    }

    private String getDateFormat(String date ){
        String months []  = {"����","���","���� ���","���� ����"
                            ,"����� ����","����� ����","���","�����"
                            ,"�����","����","�� ������","�� �����"};
        
        String days [] = {"�����","������","������","������","������","������","������","������","������","������",
                         "������ ���","������ ���","������ ���","������  ���","������ ���","������ ���","������ ���","������ ���","������ ���","�������",  
                          "������ ��������","������ ��������","������ ��������","������ ��������","������ ��������","������ ��������",
                          "������ ��������","������ ��������","������ ��������","��������"};
                        
        date = date.split(" ")[2];
        int monthNumber = Integer.parseInt(date.split("-")[1]);
        int dayNumber   = Integer.parseInt(date.split("-")[2]);
        
        String month    =  months[monthNumber-1];
        
        
        String haram = (monthNumber==12 || monthNumber==11 || monthNumber==1 || monthNumber==7)?"   ��� ����   ":"";
        
        
        String day      =   days[dayNumber-1];
        String year     =  date.split("-")[0];
        
      
        return day+  "  �� " +  month+ haram +"  ���� "+ year + " ����  ";

    }

 
}