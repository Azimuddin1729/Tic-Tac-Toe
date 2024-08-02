package tictactoe;
import javax.swing.*;
import java.awt.*;//this contains font,borderlayout class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener{
    private
    JLabel heading;
    JLabel timer;
    Font style1=new Font("Arial",Font.BOLD,50);
    Font style2=new Font("Comic Sans MS",Font.BOLD,30);
    JPanel board;
    JButton[] buttons=new JButton[9];
    boolean alice=true;
    boolean bob=false;
    int winningpos [][]={
        {0,1,2},
        {3,4,5},
        {6,7,8},
        {0,3,6},
        {1,4,7},
        {2,5,8},
        {0,4,8},
        {2,4,6}
    };
    boolean gameplay=true;
     
    public
    Game(){
       System.out.println("Welcome to Tic Tac Toe Game");
       setTitle("Tic Tac Toe Game");
       setSize(700,700);
       setIconImage(new ImageIcon ("tictactoe/images/images.png").getImage());


       //difff background colors like:
         //Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.PINK,Color.ORANGE


       getContentPane().setBackground(Color.CYAN);
       setLayout(new BorderLayout());


       heading=new JLabel("Tic Tac Toe");
       heading.setFont(style1);
       heading.setHorizontalAlignment(SwingConstants.CENTER);
       //adding color to heading
       heading.setForeground(Color.RED);
       add( heading,BorderLayout.NORTH);

       timer=new JLabel("Timer:");
       timer.setFont(style2);
       timer.setHorizontalAlignment(SwingConstants.CENTER);
       add(timer,BorderLayout.SOUTH);

       
       Thread t=new Thread(){
           public void run(){
               int sec=0;
               while(true){
                   try{
                       timer.setText("Timer: "+sec+" secs");
                       sec++;
                       Thread.sleep(1000);
                   }catch(Exception e){
                       e.printStackTrace();
                   }
               }
           }
       };
       t.start();


       board=new JPanel();
       board.setLayout(new GridLayout(3,3));
       for(int i=1;i<=9;i++){
           JButton btn=new JButton();
        //    btn.setIcon(new ImageIcon("tictactoe/images/zero4.png"));
           btn.setFont(style2);
           buttons[i-1]=btn;
           board.add(btn);
           btn.addActionListener(this);
           btn.setName(String.valueOf(i-1));
       }
       add(board,BorderLayout.CENTER);


       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
          JButton clickedButton=(JButton)e.getSource();
        
         if(gameplay==false){
            JOptionPane.showMessageDialog(this,"Game Over Already");
            return;
         }


         if(bob&&clickedButton.getText().equals("")){
                clickedButton.setText("X");
                bob=false;
                alice=true;
        }
        else if(alice&&clickedButton.getText().equals("")){
            clickedButton.setText("O");
            bob=true;
            alice=false;
        }
        else{
            JOptionPane.showMessageDialog(this,"Already Occupied");
        }

        for(int i=0;i<8;i++){
            String s1=buttons[winningpos[i][0]].getText();
            String s2=buttons[winningpos[i][1]].getText();
            String s3=buttons[winningpos[i][2]].getText();
            if(s1.equals("O")&&s2.equals("O")&&s3.equals("O")){
                JOptionPane.showMessageDialog(this,
                "Alice Wins");
                gameplay=false;
                //if new game needs to be started
                int check=JOptionPane.showConfirmDialog(this,"Do you want to play again?");
                if(check==0){
                    for(int j=0;j<9;j++){
                        buttons[j].setText("");
                    }
                    gameplay=true;
                }
                else{
                    System.exit(0);
                }
                break;
            }
            if(s1.equals("X")&&s2.equals("X")&&s3.equals("X")){
                JOptionPane.showMessageDialog(this,"Bob Wins");
                gameplay=false;
                int check=JOptionPane.showConfirmDialog(this,"Do you want to play again?");
                if(check==0){
                    for(int j=0;j<9;j++){
                        buttons[j].setText("");
                    }
                    gameplay=true;
                }
                else{
                    System.exit(0);
                }
                break;
            }

        }

        for(int i=0;i<9;i++){
            if(buttons[i].getText().equals("")){
                break;
            }
            else if(i==8){
                JOptionPane.showMessageDialog(this,"Match Draw");
                gameplay=false;
                int check=JOptionPane.showConfirmDialog(this,"Do you want to play again?");
                if(check==0){
                    for(int j=0;j<9;j++){
                        buttons[j].setText("");
                    }
                    gameplay=true;
                }
                else{
                    System.exit(0);
                }
            }
        }



    }

        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
}
