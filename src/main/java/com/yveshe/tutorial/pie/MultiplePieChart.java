/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年8月6日
* Description:
*
* Author       YvesHe
*/
package com.yveshe.tutorial.pie;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class MultiplePieChart {

    private static CategoryDataset createDataset() {
        double[][] ds = { { 3.0, 4.0, 3.0, 5.0 }, { 5.0, 7.0, 6.0, 8.0 },
            { 5.0, 7.0, Double.NaN, 3.0 }, { 1.0, 2.0, 3.0, 4.0 },
            { 2.0, 3.0, 2.0, 3.0 } };
        CategoryDataset categorydataset = DatasetUtilities.createCategoryDataset("Region ", "Sales/Q", ds);
        return categorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset) {
        JFreeChart jfreechart = ChartFactory.createMultiplePieChart(// 创建多个饼图的图表
            "Multiple Pie Chart  -Yves",
            categorydataset,
            TableOrder.BY_ROW,
            true, true, false);
        MultiplePiePlot multiplepieplot = (MultiplePiePlot) jfreechart.getPlot();
        JFreeChart jfreechart_0_ = multiplepieplot.getPieChart();// 获得单个饼图的图表。
        PiePlot pieplot = (PiePlot) jfreechart_0_.getPlot();
        pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
        pieplot.setLabelFont(new Font("SansSerif", 0, 8));
        pieplot.setInteriorGap(0.3);
        return jfreechart;
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
