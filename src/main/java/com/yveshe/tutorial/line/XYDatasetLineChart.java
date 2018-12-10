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
package com.yveshe.tutorial.line;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

/**
 * XY数据集
 *
 *
 * 本例子主要采用统一的对所有的Series生效的配置设置
 *
 * @author Yves He
 *
 */
public class XYDatasetLineChart {
    private static XYDataset createDataset() {
        XYSeries series1 = new XYSeries("First");
        series1.add(1.0D, 1.0D);
        series1.add(2.0D, 4.0D);
        series1.add(3.0D, 3.0D);
        series1.add(4.0D, 5.0D);
        series1.add(5.0D, 5.0D);
        series1.add(6.0D, 7.0D);
        series1.add(7.0D, 7.0D);
        series1.add(8.0D, 8.0D);
        XYSeries series2 = new XYSeries("Second");
        series2.add(1.0D, 5.0D);// X轴值,Y轴值
        series2.add(2.0D, null);// null值数据点断开,x轴不能为null
        series2.add(3.0D, 6.0D);
        series2.add(4.0D, 8.0D);
        series2.add(5.0D, 4.0D);
        series2.add(6.0D, 4.0D);
        series2.add(7.0D, 2.0D);
        series2.add(8.0D, 1.0D);
        XYSeries series3 = new XYSeries("Third");
        series3.add(3.0D, 4.0D);
        series3.add(4.0D, 3.0D);
        series3.add(5.0D, 2.0D);
        series3.add(6.0D, 3.0D);
        series3.add(7.0D, 6.0D);
        series3.add(8.0D, 3.0D);
        series3.add(9.0D, 4.0D);
        series3.add(10.0D, 3.0D);

        XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(series1);
        collection.addSeries(series2);
        collection.addSeries(series3);
        return collection;
    }

    private static JFreeChart createChart(XYDataset paramXYDataset) {
        JFreeChart chart = ChartFactory.createXYLineChart("Line Chart Demo -Yves", "X", "Y", paramXYDataset, PlotOrientation.VERTICAL, true, true, false);

        XYPlot xyPlot = (XYPlot) chart.getPlot();

        // 设置轴的平移值
        xyPlot.setDomainPannable(true);
        xyPlot.setRangePannable(true);

        // 我们将默认刻度值（允许显示小数）改成只显示整数的刻度值
        NumberAxis rangeAxis = (NumberAxis) xyPlot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) xyPlot.getRenderer();
        // 设置所有Series的样式
        // 开启数据点
        renderer.setBaseShapesVisible(true);
        renderer.setBaseShapesFilled(true);

        // 开启数据集显示形状和数据点填充颜色 (前提在`开启数据点`的前提下)
        renderer.setUseFillPaint(true);// 开启数据点中填充颜色
                                       // (开启使用数据填充,会发现数据点颜色被填充,只有`开启数据点`情况才生效)
        renderer.setBaseFillPaint(Color.PINK, true);// 数据点中填充颜色设置(颜色统一设置,只有setUseFillPaint设置为true才生效)

        renderer.setDrawOutlines(true); // 数据外廓线是否显示(只有setUseFillPaint设置为true才生效)
        renderer.setBaseOutlineStroke(new BasicStroke(2f), true);// 数据外廓线粗细设置,只有setDrawOutlines设置为true才生效

        // 设置所有形状(包括形状的大小)
        renderer.setShape(new Rectangle2D.Double(-10.0D, -10.0D, 20.0D, 20.0D));

        // 设置所有外廓线大小
        renderer.setOutlineStroke(new BasicStroke(2.0F));// 批量设置外廓线大小

        // 设置所有线条粗细
        renderer.setStroke(new BasicStroke(9.0F)); // 该版本setBaseStrok无效果,如果是想统一设置,需要用setStroke来设置

        // 设置所有线条是否可见
        renderer.setLinesVisible(true);// false为取消所有线条可见

        // 设置所有label
        renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator("{2}"));
        // {0}为SeriesKeyName {1} 为x值, {2}为Y值
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelFont(new Font("Dialog", 1, 14));
        // renderer.setBasePositiveItemLabelPosition(position);

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
