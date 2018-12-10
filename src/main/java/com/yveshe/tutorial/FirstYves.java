/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年8月3日
* Description:
*
* Author       YvesHe
*/
package com.yveshe.tutorial;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.yveshe.utilities.ChartTutorialUtil;

public class FirstYves {

    private static PieDataset createDataset() {

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 43.2);
        dataset.setValue("Category 2", 27.9);
        dataset.setValue("Category 3", 79.5);
        return dataset;
    }

    public static void main(String[] args) throws Exception {

        // 1.create a dataset...
        PieDataset dataset = createDataset();

        // 2.create a chart...
        JFreeChart chart = ChartFactory.createPieChart(
            "Sample Pie Chart",
            dataset,
            true, // legend?
            true, // tooltips?
            false // URLs?
        );

        // 3.set show...

        // SectionPaint (区片颜色)
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Category 1", new Color(200, 255, 255));// 指定某个Comparable的颜色,未指定的会随机选择
        plot.setSectionPaint("Category 2", new Color(200, 200, 255));

        // SectionOutline(片区外廓)
        plot.setBaseSectionOutlinePaint(Color.YELLOW);
        plot.setBaseSectionOutlineStroke(new BasicStroke(1f));

        plot.setSectionOutlinesVisible(true);
        plot.setSectionOutlinePaint("Category 1", Color.BLUE);// 外廓颜色
        plot.setSectionOutlinePaint("Category 2", null);// 颜色设置成null或者不设置,则使用基层的设置BaseSectionOutlinePaint
        // 外廓颜色,null，则系统将使用基本层里面的设置
        plot.setSectionOutlineStroke("Category 1", new BasicStroke(8.f));// 外廓线条粗细

        // 4.create result...
        ChartTutorialUtil.createChartGUI(chart);
        TimeUnit.SECONDS.sleep(1);
        ChartTutorialUtil.createImage(chart, "FirstYves.jpeg");
        ChartTutorialUtil.success();
    }

}