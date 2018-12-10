/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年8月9日
* Description:
*
* Author       YvesHe
*/
package com.yveshe.tutorial.multiple;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RefineryUtilities;

/**
 * 多轴和多数据源图表
 *
 * 示例一: 相同的图表类型
 *
 * @author YvesHe
 *
 */
public class MultipleAxisDemo {

    private static JFreeChart createChart() {
        XYDataset dataset = createDataset("Series 1", 100.0D, new Minute(), 200);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Multiple Axis Demo -Yves", "Time of Day", "Primary Range Axis", dataset, true, true, false);
        chart.addSubtitle(new TextTitle("Four datasets and four range axes."));// 子标题

        /** chart主题立即生效 **/
        // 将当前主题应用于指定的图表。 提供此方法是为了方便，主题本身存储在ChartFactory类中。
        // 可以理解流程主题中有对Renderer修饰的一系列属性,会覆盖之前以前的设置
        ChartUtilities.applyCurrentTheme(chart);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setDomainPannable(true);// x轴自动增长
        plot.setRangePannable(true);// y轴自动增长
        plot.getRenderer().setSeriesPaint(0, Color.BLACK);// 设置主plot为黑色

        // 主Plot是从0开始,其他的Plot从1开始
        // 1
        NumberAxis axis1 = new NumberAxis("Range Axis 2");
        axis1.setAutoRangeIncludesZero(false);
        plot.setRangeAxis(1, axis1);// 添加到Y轴上
        plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);// 设置坐标轴位置
        XYDataset dataset2 = createDataset("Series 2", 1000.0D, new Minute(), 170);
        plot.setDataset(1, dataset2);
        plot.mapDatasetToRangeAxis(1, 1);
        StandardXYItemRenderer renderer1 = new StandardXYItemRenderer();
        plot.setRenderer(1, renderer1);

        renderer1.setSeriesPaint(0, Color.red);
        axis1.setLabelPaint(Color.red);
        axis1.setTickLabelPaint(Color.red);

        // 2
        NumberAxis axis2 = new NumberAxis("Range Axis 3");
        plot.setRangeAxis(2, axis2);
        XYDataset dataset3 = createDataset("Series 3", 10000.0D, new Minute(), 170);
        plot.setDataset(2, dataset3);
        plot.mapDatasetToRangeAxis(2, 2);
        StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
        plot.setRenderer(2, renderer2);

        renderer2.setSeriesPaint(0, Color.blue);
        axis2.setLabelPaint(Color.blue);
        axis2.setTickLabelPaint(Color.blue);

        // 3
        NumberAxis axis3 = new NumberAxis("Range Axis 4");
        plot.setRangeAxis(3, axis3);
        XYDataset dataset4 = createDataset("Series 4", 25.0D, new Minute(), 200);
        plot.setDataset(3, dataset4);
        plot.mapDatasetToRangeAxis(3, 3);
        StandardXYItemRenderer renderer3 = new StandardXYItemRenderer();
        plot.setRenderer(3, renderer3);

        renderer3.setSeriesPaint(0, Color.green);
        axis3.setLabelPaint(Color.green);
        axis3.setTickLabelPaint(Color.green);

        return chart;
    }

    private static XYDataset createDataset(String paramString, double paramDouble, RegularTimePeriod paramRegularTimePeriod, int paramInt) {
        TimeSeries series = new TimeSeries(paramString);
        RegularTimePeriod timePeriod = paramRegularTimePeriod;
        double d = paramDouble;
        for (int i = 0; i < paramInt; i++) {
            series.add(timePeriod, d);
            timePeriod = timePeriod.next();
            d *= (1.0D + (Math.random() - 0.495D) / 10.0D);
        }

        TimeSeriesCollection collection = new TimeSeriesCollection();
        collection.addSeries(series);
        return collection;
    }

    public static void main(String[] args) {

        // create a chart...
        JFreeChart chart = createChart();

        // create and display a frame...
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);

    }

}
