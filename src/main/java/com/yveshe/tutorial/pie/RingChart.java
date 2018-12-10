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
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;

/**
 * 环形图
 *
 * @author Yves He
 *
 */
public class RingChart {

    private static PieDataset createDataset() {

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Section A", 43.2);
        dataset.setValue("Section B", 27.9);
        dataset.setValue("Section C", 79.5);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset paramPieDataset) {
        JFreeChart localJFreeChart = ChartFactory.createRingChart("Ring Chart Demo -Yves", paramPieDataset, false, true, false);
        RingPlot localRingPlot = (RingPlot) localJFreeChart.getPlot();
        localRingPlot.setLabelFont(new Font("SansSerif", 0, 12));// 设置标签字体和大小
        localRingPlot.setNoDataMessage("No data available");// 设置无数据时提示信息
        localRingPlot.setSectionDepth(0.35D);//
        localRingPlot.setCircular(true); // 设置是椭圆还是圆
        localRingPlot.setLabelGap(0.02D);// 饼图边缘和标签之间的间隙
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
