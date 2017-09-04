package view;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import dataStructure.BinaryHeap;

public class SortingGui extends Canvas implements Runnable  {
	JFrame frame=new JFrame();
	JButton btn = new JButton("submit");
	JRadioButton heapSort = new JRadioButton("Heap Sort");
	JRadioButton mergeSort = new JRadioButton("Merge Sort");
	JRadioButton quickSort = new JRadioButton("Quick Sort");
	Dimension a = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	int w = a.width / 2, l = a.height / 10;
	int we=w,le=l;
	//private GraphicsEnvironment ge;
//	private GraphicsDevice gd;
	BinaryHeap binaryHeap =new BinaryHeap(new int[] {1,2,6,4});
	public SortingGui() {
		// ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		// gd = ge.getDefaultScreenDevice();
		JPanel panal = new JPanel(new FlowLayout());
		
		frame.setVisible(true);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		// this.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sorting Gui");

		/// ButtonGroup buttonGroup = new ButtonGroup();
		// buttonGroup.add(heapSort);
		// buttonGroup.add(mergeSort);
		// buttonGroup.add(quickSort);

		// btn.addActionListener(this);
		// panal.add(mergeSort);
		// panal.add(quickSort);
		// panal.add(heapSort);
		// panal.add(btn);

		frame.add(this);

	}
	/*
	public synchronized void run() {
	    while (true) {
	        //THIS LOOP WORKS FINE.
	        this.repaint();
	    }
	}*/
	public static void main(String[] args) {
		
		SortingGui a = new SortingGui();
		a.revalidate();
		a.repaint();

	}

	
	@Override
	public void paint(Graphics g) {

		super.paint(g);
		tree(g, w, l, 0);
		binaryHeap.build_max_heap();
		tree(g, w, l, 0);
		revalidate();
		repaint();
		
//		int w = a.width / 2, l = a.height / 10;
//		int we=w,le=l;
//		g.drawRect(w, l, 50, 50);
//		g.drawLine(w + 50, l + 50, w + 100, l + 100);
//		g.drawLine(w, l + 50, w - 100, l + 100);
//		w += 100;
//		l += 100;
//		g.drawRect(w, l, 50, 50);
//		g.drawLine(w + 50, l + 50, w + 100, l + 100);
//		g.drawLine(w, l + 50, w - 100, l + 100);

		//g.drawString(new Integer(2).toString(), a.width / 2, a.height / 10);
//		w =we- 100;
//		l =le+ 100;
//		g.drawRect(w, l, 50, 50);
//		g.drawLine(w + 50, l + 50, w + 100, l + 100);
//		g.drawLine(w, l + 50, w - 100, l + 100);
//		try {
//		    Thread.sleep(1000);
//		} catch(InterruptedException ex) {
//		    Thread.currentThread().interrupt();
//		}
//		we=we- 100;
//		le =le+ 100;
//		g.drawRect(w, l, 50, 50);
//		g.drawLine(w + 50, l + 50, w + 100, l + 100);
//		g.drawLine(w, l + 50, w - 100, l + 100);
//		//delay();
//		w += 100;
//		l += 100;
//		g.drawRect(w, l, 50, 50);
//		g.drawLine(w + 50, l + 50, w + 100, l + 100);
//		g.drawLine(w, l + 50, w - 100, l + 100);
//		g.drawString(new Integer(2).toString(), a.width / 2, a.height / 10);
//		//delay();
//		w =we- 100;
//		l =le+ 100;
//		g.drawRect(w, l, 50, 50);
//		g.drawLine(w + 50, l + 50, w + 100, l + 100);
//		g.drawLine(w, l + 50, w - 100, l + 100);
//		g.drawString(new Integer(2).toString(), a.width / 2, a.height / 10);

	}
	
	
	public void tree(Graphics g,int w,int l,int counter){
	//	if(!(binaryHeap.hasLeftChild(counter)))return;
		
			g.drawOval(w, l, 50, 50);
			g.drawLine(w + 50, l + 50, w + 100, l + 100);
			g.drawLine(w, l + 50, w - 100, l + 100);
			g.drawString(new Integer(binaryHeap.data[counter]).toString(), w+25, l+30);
		
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println(counter);
		if((binaryHeap.hasLeftChild(counter)))tree(g,w-100,l+100,binaryHeap.leftChildIndex(counter));//left
		if((binaryHeap.hasRightChild(counter)))tree(g,w+100,l+100,binaryHeap.rightChildIndex(counter));//right
		
	}
	
	
	@Override
	public void run() {
		 while (true) {
		        //THIS LOOP WORKS FINE.
		        
		    }		
	}
}
