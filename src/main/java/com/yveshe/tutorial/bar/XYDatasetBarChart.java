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

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.RefineryUtilities;

/**
 * 采用XYDataSet的饼状图/直方条形图
 *
 * 渲染器: StandardXYBarPainter(直方条形图),StandardXYBarPainter(饼状图)
 *
 * 注意: XYDataSet时序图是单序列的,也就是说只有一个Series
 *
 * XYDataSet数据集对应有XYPlot和XYBarRenderer
 *
 *
 * IntervalXYDataset extends XYDataset
 *
 * @author Yves He
 *
 */
public class XYDatasetBarChart {

    // 数据集
    private static IntervalXYDataset createDataset() {
        TimeSeriesCollection collection = new TimeSeriesCollection();

        TimeSeries series1 = new TimeSeries("Executions", "Year", "Count");
        try {
            series1.add(new Year(1976), new Integer(0));
            series1.add(new Year(1977), new Integer(1));
            series1.add(new Year(1978), new Integer(0));
            series1.add(new Year(1979), new Integer(2));
            series1.add(new Year(1980), new Integer(0));
            series1.add(new Year(1981), new Integer(1));
            series1.add(new Year(1982), new Integer(2));
            series1.add(new Year(1983), new Integer(5));
            series1.add(new Year(1984), new Integer(21));
            series1.add(new Year(1985), new Integer(18));
            series1.add(new Year(1986), new Integer(18));
            series1.add(new Year(1987), new Integer(25));
            series1.add(new Year(1988), new Integer(11));
            series1.add(new Year(1989), new Integer(16));
            series1.add(new Year(1990), new Integer(23));
            series1.add(new Year(1991), new Integer(14));
            series1.add(new Year(1992), new Integer(31));
            series1.add(new Year(1993), new Integer(38));
            series1.add(new Year(1994), new Integer(31));
            series1.add(new Year(1995), new Integer(56));
            series1.add(new Year(1996), new Integer(45));
            series1.add(new Year(1997), new Integer(74));
            series1.add(new Year(1998), new Integer(68));
            series1.add(new Year(1999), new Integer(98));
            series1.add(new Year(2000), new Integer(85));
            series1.add(new Year(2001), new Integer(66));
            series1.add(new Year(2002), new Integer(71));
            series1.add(new Year(2003), new Integer(65));
            series1.add(new Year(2004), new Integer(59));
            series1.add(new Year(2005), new Integer(60));
        } catch (Exception localException) {
            System.err.println(localException.getMessage());
        }
        collection.addSeries(series1);

        // TimeSeries series2 = new TimeSeries("Executions2", "Year2",
        // "Count2");
        // try {
        // series2.add(new Year(1976), new Integer(0));
        // series2.add(new Year(1977), new Integer(1));
        // series2.add(new Year(1978), new Integer(0));
        // series2.add(new Year(1979), new Integer(2));
        // series2.add(new Year(1980), new Integer(0));
        // series2.add(new Year(1981), new Integer(1));
        // series2.add(new Year(1982), new Integer(2));
        // series2.add(new Year(1983), new Integer(5));
        // series2.add(new Year(1984), new Integer(21));
        // series2.add(new Year(1985), new Integer(20));
        // series2.add(new Year(1986), new Integer(18));
        // series2.add(new Year(1987), new Integer(25));
        // series2.add(new Year(1988), new Integer(11));
        // series2.add(new Year(1989), new Integer(16));
        // series2.add(new Year(1990), new Integer(23));
        // series2.add(new Year(1991), new Integer(14));
        // series2.add(new Year(1992), new Integer(31));
        // series2.add(new Year(1993), new Integer(38));
        // series2.add(new Year(1994), new Integer(31));
        // series2.add(new Year(1995), new Integer(58));
        // series2.add(new Year(1996), new Integer(45));
        // series2.add(new Year(1997), new Integer(74));
        // series2.add(new Year(1998), new Integer(68));
        // series2.add(new Year(1999), new Integer(98));
        // series2.add(new Year(2000), new Integer(85));
        // series2.add(new Year(2001), new Integer(66));
        // series2.add(new Year(2002), new Integer(71));
        // series2.add(new Year(2003), new Integer(65));
        // series2.add(new Year(2004), new Integer(59));
        // series2.add(new Year(2005), new Integer(60));
        // } catch (Exception localException) {
        // System.err.println(localException.getMessage());
        // }
        // collection.addSeries(series2);

        return collection;
    }

    private static JFreeChart createChart(IntervalXYDataset paramIntervalXYDataset) {
        JFreeChart chart = ChartFactory.createXYBarChart(
            "State Executions - USA",
            "Year",
            true,
            "Number of People",
            paramIntervalXYDataset,
            PlotOrientation.VERTICAL,
            true,
            false,
            false);

        // 添加子标题
        chart.addSubtitle(new TextTitle("Source: http://www.amnestyusa.org/abolish/listbyyear.do", new Font("Dialog", 2, 10)));

        XYPlot xyPlot = (XYPlot) chart.getPlot();
        XYBarRenderer xyBarRenderer = (XYBarRenderer) xyPlot.getRenderer();
        xyPlot.setForegroundAlpha(0.5f);

        xyBarRenderer.setMargin(0.1D);// 设置每个柱子之间的间隙
        xyBarRenderer.setBarPainter(new StandardXYBarPainter()); // 渲染器设置图形显示的样式是条形图还是柱状图

        DateAxis domainAxis = (DateAxis) xyPlot.getDomainAxis();
        domainAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);

        // 设置最小值与y轴的Margin距离百分比(可以避免数据文字显示不了问题)
        domainAxis.setLowerMargin(0.2D);
        domainAxis.setUpperMargin(0.01D);

        return chart;
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
