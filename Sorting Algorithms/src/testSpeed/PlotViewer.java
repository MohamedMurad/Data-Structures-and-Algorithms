package testSpeed;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PlotViewer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlotViewer window = new PlotViewer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlotViewer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int[][] selection = { { 10000, 52 }, { 20000, 1060 }, { 30000, 2465 }, { 40000, 5008 }, { 50000, 6968 },
				{ 60000, 10569 } },
				insertion = { { 10000, 76 }, { 20000, 291 }, { 30000, 650 }, { 40000, 1236 }, { 50000, 1956 },
						{ 60000, 3036 } },

				bubble = { { 10000, 281 }, { 20000, 1169 }, { 30000, 2698 }, { 40000, 4729 }, { 50000, 7444 },
						{ 60000, 10501 } },
				quick = { { 10000, 1 }, { 20000, 2 }, { 30000, 2 }, { 40000, 5 }, { 50000, 4 }, { 60000, 5 } },
				heap = { { 10000, 5 }, { 20000, 9 }, { 30000, 13 }, { 40000, 19 }, { 50000, 19 }, { 60000, 22 } };
		Plot plot = new Plot(selection, insertion, bubble, quick, heap);
		plot.setVisible(true);

	}

}
