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
		
		frame = new JFrame(); 
		frame.setLayout(new BorderLayout(10, 5));
		frame.setSize(600, 1000);
		
		JPanel panel = new JPanel(); 
		frame.setVisible(true);

	}

	
	public void setButton() 
	
	{
		int x = 0, y = 50, c = 1; 
		
		for (int i = 0; i < 9; i++)
		{
			c++; 
			x += 100; 

			button[i] = new JButton(); 
			
			if (c % 3 == 0) 
			{
				y += 100; 
				x = 100; 
			}
			
			button[i].setBounds(x, y, 100, 100);
			
			frame.add(button[i]); 
			button[i].addActionListener(null);
			
		}
		
	}
	
	
	
	public static void main(String[] arg)
	{
		Graphics c = new Graphics();  
		c.setButton(); 
        
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
