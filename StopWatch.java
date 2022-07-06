import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopWatch implements ActionListener {
    JFrame jFrame=new JFrame();
    JButton startB=new JButton("start");
    JButton resetB=new JButton("reset");
    JLabel time=new JLabel();
    int elapsedTime=0;
    int seconds=0;
    int minutes=0;
    int hours=0;
    boolean started=false;//to determine whether time has started or not;
    String  second_s=String.format("%02d",seconds);
    String minutes_m=String.format("%02d",minutes);
    String hours_h=String.format("%02d",hours);
    Timer timer=new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime+=1000;
            hours=(elapsedTime/3600000);
            minutes=(elapsedTime/60000)%60;
            seconds=(elapsedTime/1000)%60;
            second_s=String.format("%02d",seconds);
            minutes_m=String.format("%02d",minutes);
            hours_h=String.format("%02d",hours);
            time.setText(hours_h+":"+minutes_m+":"+second_s);
        }
    });
    StopWatch()
    {   time.setText(hours_h+":"+minutes_m+":"+second_s);
        time.setBounds(100,100,200,100);
        time.setFont(new Font("Verdana",Font.PLAIN,35));
        time.setBorder(BorderFactory.createBevelBorder(1));
        time.setOpaque(true);
        time.setHorizontalAlignment(JLabel.CENTER);
        startB.setFont(new Font("Ink Free",Font.PLAIN,20));
        startB.setBounds(100,200,100,50);
        startB.setFocusable(false);
        startB.addActionListener(this);
        resetB.setBounds(200,200,100,50);
        resetB.setFont(new Font("Ink Free",Font.PLAIN,20));
        resetB.setFocusable(false);
        resetB.addActionListener(this);
        jFrame.add(startB);
        jFrame.add(resetB);
        jFrame.add(time);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(420,420);
        jFrame.getContentPane().setBackground(new Color(0x1234566));
        jFrame.setLayout(null);
        jFrame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startB){
            if(started==false) {
                start();
                started=true;
                startB.setText("stop");
            }
            else
            {  stop();
                started=false;
                startB.setText("start");

            }
        }
        if(e.getSource()==resetB)
        {
            started=false;
            startB.setText("start");
            reset();
        }
    }
    public void start()
    {
        timer.start();
    }
    public void stop() {
        timer.stop();
    }
    public void reset(){
        timer.stop();
        elapsedTime=0;
        seconds=0;
        minutes=0;
        hours=0;
        second_s=String.format("%02d",seconds);
        minutes_m=String.format("%02d",minutes);
        hours_h=String.format("%02d",hours);
        time.setText(hours_h+":"+minutes_m+":"+second_s);

    }
}
