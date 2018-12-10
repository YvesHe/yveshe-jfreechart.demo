/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年8月7日
* Description:
*
* Author       YvesHe
*/
package com.yveshe.tutorial.bar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.ClusteredXYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.RefineryUtilities;

public class ClusteredXYBar {
    private static IntervalXYDataset createDataset() {
        TimeSeries localTimeSeries1 = new TimeSeries("Series 1");
        localTimeSeries1.add(new Day(1, 1, 2003), 54.299999999999997D);
        localTimeSeries1.add(new Day(2, 1, 2003), 20.300000000000001D);
        localTimeSeries1.add(new Day(3, 1, 2003), 43.399999999999999D);
        localTimeSeries1.add(new Day(4, 1, 2003), -12.0D);
        TimeSeries localTimeSeries2 = new TimeSeries("Series 2");
        localTimeSeries2.add(new Day(1, 1, 2003), 8.0D);
        localTimeSeries2.add(new Day(2, 1, 2003), 16.0D);
        localTimeSeries2.add(new Day(3, 1, 2003), 21.0D);
        localTimeSeries2.add(new Day(4, 1, 2003), 5.0D);
        TimeSeriesCollection localTimeSeriesCollection = new TimeSeriesCollection();
        localTimeSeriesCollection.addSeries(localTimeSeries1);
        localTimeSeriesCollection.addSeries(localTimeSeries2);
        return localTimeSeriesCollection;
    }

    private static JFreeChart createChart(IntervalXYDataset paramIntervalXYDataset) {
        JFreeChart localJFreeChart = ChartFactory.createXYBarChart("XY Bar Chart Demo 2", "Date", true, "Y", paramIntervalXYDataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot localXYPlot = (XYPlot) localJFreeChart.getPlot();
        localXYPlot.setDomainPannable(true);
        localXYPlot.setRangePannable(false);
        ClusteredXYBarRenderer localClusteredXYBarRenderer = new ClusteredXYBarRenderer(0.0D, false);
        localXYPlot.setRenderer(localClusteredXYBarRenderer);
        localClusteredXYBarRenderer.setDrawBarOutline(false);
        return localJFreeChart;
    }

    public static void main(String[] args) {

        // create a chart...
        JFreeChart chart = createChart(createDataset());

        // create and display a frame...
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);

    }

}
