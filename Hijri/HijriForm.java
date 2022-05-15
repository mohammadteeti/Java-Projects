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
        String months []  = {"ÂÕ—Â","’·—","—»ÍŸ «Ë‰","—»ÍŸ À«ÊÍ"
                            ,"ÃÂ«œÈ «Ë‰È","ÃÂ«œÈ «Œ—…","—Ã»","‘Ÿ»«Ê"
                            ,"—Â÷«Ê","‘Ë«‰","–Ë «‰‚Ÿœ…","–Ë «‰ÕÃ…"};
        
        String days [] = {"«‰«Ë‰","«‰À«ÊÍ","«‰À«‰À","«‰—«»Ÿ","«‰Œ«Â”","«‰”«œ”","«‰”«»Ÿ","«‰À«ÂÊ","«‰ «”Ÿ","«‰Ÿ«‘—",
                         "«‰Õ«œÍ Ÿ‘—","«‰À«ÊÍ Ÿ‘—","«‰À«‰À Ÿ‘—","«‰—«»Ÿ  Ÿ‘—","«‰Œ«Â” Ÿ‘—","«‰”«œ” Ÿ‘—","«‰”«»Ÿ Ÿ‘—","«‰À«ÂÊ Ÿ‘—","«‰ «”Ÿ Ÿ‘—","«‰Ÿ‘—ËÊ",  
                          "«‰Õ«œÍ Ë«‰Ÿ‘—ËÊ","«‰À«ÊÍ Ë«‰Ÿ‘—ËÊ","«‰À«‰À Ë«‰Ÿ‘—ËÊ","«‰—«»Ÿ Ë«‰Ÿ‘—ËÊ","«‰Œ«Â” Ë«‰Ÿ‘—ËÊ","«‰”«œ” Ë«‰‘Ÿ—ËÊ",
                          "«‰”«»Ÿ Ë«‰Ÿ‘—ËÊ","«‰À«ÂÊ Ë«‰Ÿ‘—ËÊ","«‰ «”Ÿ Ë«‰Ÿ‘—ËÊ","«‰À‰«ÀËÊ"};
                        
        date = date.split(" ")[2];
        int monthNumber = Integer.parseInt(date.split("-")[1]);
        int dayNumber   = Integer.parseInt(date.split("-")[2]);
        String month    =  months[monthNumber];
        String day      =   days[dayNumber];
        String year     =  date.split("-")[0];

        JOptionPane.showMessageDialog(this, "Á‡‡‡"+ year  +  " ‰Ÿ«Â  " +  month +" ÂÊ "+ day + "«‰ÍËÁ ÁË ", "«‰ «—ÍŒ", JOptionPane.INFORMATION_MESSAGE);
        return "Á‡‡‡"+ year  +  " ‰Ÿ«Â  " +  month +" ÂÊ "+ day + "«‰ÍËÁ ÁË ";

    }

}