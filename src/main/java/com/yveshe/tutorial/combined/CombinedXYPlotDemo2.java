/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年8月10日
* Description:
*
* Author       YvesHe
*/
package com.yveshe.tutorial.combined;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CombinedRangeXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RefineryUtilities;

/**
 * 组合Y-XY图区(Combined Range XY Plot)
 *
 * 共用Y轴的XYPlot
 *
 * @author Yves He
 *
 */
public class CombinedXYPlotDemo2 {

    public static void main(String[] args) {

        // create a chart...
        JFreeChart chart = createCombinedChart();

        // create and display a frame...
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);

    }

    private static JFreeChart createCombinedChart() {
        // create subplot 1...
        IntervalXYDataset dataset1 = createDataset1();
        XYBarRenderer renderer1 = new XYBarRenderer(0.2D);
        renderer1.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0,000.0")));
        renderer1.setBarPainter(new StandardXYBarPainter());// 标准的渲染器(支持颜色渐变)
        XYPlot plot1 = new XYPlot(dataset1, new DateAxis("Date"), null, renderer1);

        // create subplot 2...
        XYDataset dataset2 = createDataset2();
        StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
        renderer2.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0,000.0")));
        XYPlot plot2 = new XYPlot(dataset2, new DateAxis("Date"), null, renderer2);

        NumberAxis rangeAxis = new NumberAxis("Value");
        rangeAxis.setTickMarkInsideLength(3.0F);

        CombinedRangeXYPlot combinedRangeXYPlot = new CombinedRangeXYPlot(rangeAxis);
        combinedRangeXYPlot.add(plot1, 1);
        combinedRangeXYPlot.add(plot2, 1);

        JFreeChart chart = new JFreeChart("Combined (Range) XY Plot -Yves", JFreeChart.DEFAULT_TITLE_FONT, combinedRangeXYPlot, true);
        return chart;
    }

    private static IntervalXYDataset createDataset1() {
        TimeSeries localTimeSeries = new TimeSeries("Series 1");
        localTimeSeries.add(new Day(1, 3, 2002), 12353.299999999999D);
        localTimeSeries.add(new Day(2, 3, 2002), 13734.4D);
        localTimeSeries.add(new Day(3, 3, 2002), 14525.299999999999D);
        localTimeSeries.add(new Day(4, 3, 2002), 13984.299999999999D);
        localTimeSeries.add(new Day(5, 3, 2002), 12999.4D);
        localTimeSeries.add(new Day(6, 3, 2002), 14274.299999999999D);
        localTimeSeries.add(new Day(7, 3, 2002), 15943.5D);
        localTimeSeries.add(new Day(8, 3, 2002), 14845.299999999999D);
        localTimeSeries.add(new Day(9, 3, 2002), 14645.4D);
        localTimeSeries.add(new Day(10, 3, 2002), 16234.6D);
        localTimeSeries.add(new Day(11, 3, 2002), 17232.299999999999D);
        localTimeSeries.add(new Day(12, 3, 2002), 14232.200000000001D);
        localTimeSeries.add(new Day(13, 3, 2002), 13102.200000000001D);
        localTimeSeries.add(new Day(14, 3, 2002), 14230.200000000001D);
        localTimeSeries.add(new Day(15, 3, 2002), 11235.200000000001D);
        TimeSeriesCollection localTimeSeriesCollection = new TimeSeriesCollection(localTimeSeries);
        return localTimeSeriesCollection;
    }

    private static XYDataset createDataset2() {
        TimeSeries localTimeSeries = new TimeSeries("Series 2");
        localTimeSeries.add(new Day(3, 3, 2002), 6853.1999999999998D);
        localTimeSeries.add(new Day(4, 3, 2002), 9642.2999999999993D);
        localTimeSeries.add(new Day(5, 3, 2002), 8253.5D);
        localTimeSeries.add(new Day(6, 3, 2002), 5352.3000000000002D);
        localTimeSeries.add(new Day(7, 3, 2002), 3532.0D);
        localTimeSeries.add(new Day(8, 3, 2002), 2635.3000000000002D);
        localTimeSeries.add(new Day(9, 3, 2002), 3998.1999999999998D);
        localTimeSeries.add(new Day(10, 3, 2002), 1943.2D);
        localTimeSeries.add(new Day(11, 3, 2002), 6943.8999999999996D);
        localTimeSeries.add(new Day(12, 3, 2002), 7843.1999999999998D);
        localTimeSeries.add(new Day(13, 3, 2002), 6495.3000000000002D);
        localTimeSeries.add(new Day(14, 3, 2002), 7943.6000000000004D);
        localTimeSeries.add(new Day(15, 3, 2002), 8500.7000000000007D);
        localTimeSeries.add(new Day(16, 3, 2002), 9595.8999999999996D);
        return new TimeSeriesCollection(localTimeSeries);
    }

}
