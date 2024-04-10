package GUI_Programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgressBarDemo extends JFrame implements ActionListener {
	public final static int ONE_SECOND = 100;
	private JProgressBar progressBar;
	private Timer timer;
	private JButton startBtn;
	
	public ProgressBarDemo(String s) {
		super(s);
		
		startBtn = new JButton("Start");
		startBtn.addActionListener(this);
		
		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		
		JPanel progressPanel = new JPanel();
		progressPanel.add(startBtn);
		progressPanel.add(progressBar);
		
		this.getContentPane().add(progressPanel, BorderLayout.NORTH);
		
		timer = new Timer(ONE_SECOND, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				progressBar.setValue(progressBar.getValue() + 1);
				if (progressBar.getValue() == progressBar.getMaximum()) {
					timer.stop();
					startBtn.setEnabled(true);
					progressBar.setValue(progressBar.getMinimum());
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		startBtn.setEnabled(false);
		timer.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgressBarDemo frame = new ProgressBarDemo("Progress bar demo");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
