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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

/**
 * 3DPieChart 大部分设置羽PieChart设置类似,重复的设置参看PieChart
 *
 * 注意: 3DPie不支持取出某个片区
 *
 * @author Yves He
 *
 */
public class Pie3DChart {

    private static PieDataset createDataset() {

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Section A", 43.2);
        dataset.setValue("Section B", 27.9);
        dataset.setValue("Section C", 79.5);
        return dataset;
    }

    public static void main(String[] args) {

        // create a chart...
        JFreeChart chart = ChartFactory.createPieChart3D( // 产生PieChart3D
            "Sample Pie Chart -Yves", // chart title: 图表标题
            createDataset(), // data: 数据集
            true, // legend: 图例
            true, // tooltips: 图表工具条
            false // URLs: URLS
        );

        customizer(chart);

        // create and display a frame...
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);

    }

    private static void customizer(JFreeChart chart) {
        PiePlot3D pieplot3d = (PiePlot3D) chart.getPlot();
        pieplot3d.setStartAngle(180.0); // 设置旋转角度。
        pieplot3d.setDirection(Rotation.CLOCKWISE);// 设置旋转方向，Rotation.CLOCKWISE
                                                   // 为顺时针
        pieplot3d.setForegroundAlpha(0.5F);// 设置图表透明图0.0~1.0范围。
                                           // 0.0为完全透明，1.0为完全不透明

        pieplot3d.setNoDataMessage("No data to display"); // 设置Dataset为null无数据显示时提示
    }

}
