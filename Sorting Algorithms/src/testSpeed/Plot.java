package testSpeed;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

import java.awt.BasicStroke;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import dataStructure.BinaryHeap;
import sortingAlgorithm.SortingMethod;
import sortingAlgorithm.BubbleSort;
import sortingAlgorithm.HeapSort;
import sortingAlgorithm.InsertionSort;
import sortingAlgorithm.QuickSort;
import sortingAlgorithm.SelectionSort;



import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class Plot extends ApplicationFrame {
	public Plot(int[][] selection, int[][] insertion,int[][] bubble, int[][] quick, int[][] heap) {
		super("Sorting Algorithms");
		JFreeChart xylineChart = ChartFactory.createXYLineChart("Which sort is more better?", "Array Size", "Running Time",
				createDataset(selection,insertion, bubble, quick, heap), PlotOrientation.VERTICAL, true, true,
				false);

		ChartPanel chartPanel = new ChartPanel(xylineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		final XYPlot plot = xylineChart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.GREEN);
		renderer.setSeriesPaint(2, Color.YELLOW);
		renderer.setSeriesPaint(3, Color.blue);
		renderer.setSeriesPaint(4, Color.pink);
		renderer.setSeriesPaint(5, Color.cyan);

		renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		renderer.setSeriesStroke(1, new BasicStroke(2.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		renderer.setSeriesStroke(3, new BasicStroke(2.0f));
		renderer.setSeriesStroke(4, new BasicStroke(2.0f));
		renderer.setSeriesStroke(5, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		setContentPane(chartPanel);
		JButton cancel = new JButton("Cancel");
		
	}

	private XYDataset createDataset(int[][] selection, int[][] insertion, int[][] bubble ,int[][] quick , int[][] heap) {
		final XYSeries selectionSort = get(selection, "Selection sort");
		final XYSeries insertionSort = get(insertion, "Insertion sort");
		final XYSeries bubbleSort = get(bubble, "Bubble sort");
		final XYSeries quickSort = get(quick, "Quick sort");
		final XYSeries heapSort = get(heap, "Heap sort");
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(selectionSort);
		dataset.addSeries(insertionSort);
		dataset.addSeries(bubbleSort);
		dataset.addSeries(quickSort);
		dataset.addSeries(heapSort);
		return dataset;
	}

	private XYSeries get(int[][] array, String name) {
		final XYSeries temp = new XYSeries(name);
		for (int i = 0; i < array.length; i++) {
			temp.add((double) array[i][0], (double) array[i][1]);
		}
		return temp;
	}
}