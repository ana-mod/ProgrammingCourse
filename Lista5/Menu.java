package lista5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Menu implements ActionListener {

	public JMenuBar createMenuBar(){
		
		JMenuBar menuBar;
		JMenu menu;
		JRadioButtonMenuItem rbMenuItem;
		
		menuBar = new JMenuBar();
		
		menu = new JMenu("Choose the shape");
		//menu.setMnemonic(KeyEvent.VK_M);
		menuBar.add(menu);
		
		ButtonGroup group = new ButtonGroup();
		
		rbMenuItem = new JRadioButtonMenuItem("Rectangle");
		rbMenuItem.setSelected(false);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(this);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("Circle");
		rbMenuItem.setMnemonic(KeyEvent.VK_C);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(this);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("Polygon");
		rbMenuItem.setMnemonic(KeyEvent.VK_P);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(this);
		menu.add(rbMenuItem);
		
		return menuBar;
	}
	
	public String shape="";
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JMenuItem source = (JMenuItem)(e.getSource());
		if (source.getText()=="Rectangle") 
		{
			shape = "r"; //rectangle chosen
			
		}
		else if (source.getText()=="Circle")
		{
			shape = "c"; //circle chosen
		}
		
		else if (source.getText()=="Polygon")
		{
			shape = "p"; //polygon chosen
		}
	}
	
	public String shape(){
		return shape;
	}
}