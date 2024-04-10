package GUI_Programming;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import java.awt.*;
import java.awt.event.*;

public class DemoPopupMenu extends JFrame {
	JPopupMenu popupMenu;
	JMenuItem cutItem, copyItem, pasteItem, helpItem;
	JTextArea textArea;
	
	public DemoPopupMenu(String s) {
		super(s);
		textArea = new JTextArea("Nhap chuot phai vao Frame nay \n de su dung popup menu");
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		
		getContentPane().add(textArea);
		
		popupMenu = new JPopupMenu("My Popup Menu");
		
		// Components
		cutItem = new JMenuItem("Cut");
		copyItem = new JMenuItem("Copy");
		pasteItem = new JMenuItem("Paste");
		helpItem = new JMenuItem("Help");
		
		popupMenu.add(cutItem);
		popupMenu.add(copyItem);
		popupMenu.add(pasteItem);
		popupMenu.addSeparator();
		popupMenu.add(helpItem);
		
		PopupMenuListener pml = new PopupMenuListener();		
		textArea.addMouseListener((MouseListener) pml);
	}
	
	class PopupMenuListener extends MouseAdapter {
		private void showPopup(MouseEvent e) {
			if (e.isPopupTrigger()) {
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
		
		public void mousePressed(MouseEvent e) {
			showPopup(e);
		}
		
		public void mouseReleased(MouseEvent e) {
			showPopup(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoPopupMenu frame = new DemoPopupMenu("My Popup menu");
		frame.setSize(350, 150);
		frame.setVisible(true);
	}

}
