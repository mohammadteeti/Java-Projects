package Hijri;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTreeUI.ComponentHandler;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.util.Calendar;
import java.util.Date;


public class HijriForm extends JFrame {

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
        JLabel label = new JLabel();
        label.setSize(this.getSize());
        
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panel.add(label);
        this.add(panel);

        Taskbar t1=  Taskbar.getTaskbar();
        if (t1.isTaskbarSupported())
            {
              double maxHeight =  GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight();
              double taskbarHeight  =  screenHeight-maxHeight;

              this.setLocation((int) (screenWidth - myWidth), (int)(screenHeight-taskbarHeight-myHeight));
            }
            this.setAlwaysOnTop(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setUndecorated(true);
            this.setVisible(true);
            label.setFont(new Font("Andalus",Font.ITALIC,18));
            label.setText(getDateFormat(date));
            label.setSize(label.getPreferredSize());
            panel.setSize(panel.getPreferredSize());
            this.setSize(this.getPreferredSize());
            label.repaint();
            panel.repaint();
            this.repaint();

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
        String month    =  months[monthNumber];
        String day      =   days[dayNumber];
        String year     =  date.split("-")[0];

        JOptionPane.showMessageDialog(this, "����"+ year  +  " ����  " +  month +" �� "+ day + "����� �� ", "�������", JOptionPane.INFORMATION_MESSAGE);
        return "����"+ year  +  " ����  " +  month +" �� "+ day + "����� �� ";

    }

}