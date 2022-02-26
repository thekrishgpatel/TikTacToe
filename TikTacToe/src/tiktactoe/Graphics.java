package tiktactoe;

import java.lang.Object;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  

public class Graphics extends JFrame implements ItemListener, ActionListener {
	
	JButton button[] = new JButton[9]; 
	JFrame frame; 
	
	protected Graphics() {
		
		initialize(); 
		
	}
	
	private void initialize() {
		
//		frame = new JFrame(); 
//		frame.setLayout(new BorderLayout(10, 5));
//		frame.setSize(600, 1000);
//		
//		JPanel panel = new JPanel(); 
//		frame.setVisible(true);
		frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public void setButton() 
	
	{
        JPanel buttonPanel = new JPanel();
        JPanel containerPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,3));
        
        for ( int i = 0; i < 9; i++ )
        {
        	button[i] = new JButton(Integer.toString(i));
        	button[i].setFont(new Font("Arial", Font.PLAIN, 40));
        	button[i].addActionListener(new ActionListener() {

        	    @Override
        	    public void actionPerformed(ActionEvent e) {
        	        System.out.println(this);
        	    }
        	});
        	buttonPanel.add(button[i]);
        }
        
        buttonPanel.setPreferredSize(new Dimension(300, 400));
        containerPanel.add(buttonPanel);

        frame.getContentPane().add(containerPanel);
        frame.pack();
        frame.setVisible(true);
        
        button[5].setText("X"); 
		
		// redo 
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
