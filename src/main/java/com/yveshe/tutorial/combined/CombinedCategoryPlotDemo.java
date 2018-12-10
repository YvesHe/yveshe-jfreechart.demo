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

import java.awt.Font;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

/**
 * 组合图表
 *
 *
 * 共用X轴
 *
 * @author YvesHe
 *
 */
public class CombinedCategoryPlotDemo {

    public static CategoryDataset createDataset1() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String str1 = "First";
        String str2 = "Second";
        String str3 = "Type 1";
        String str4 = "Type 2";
        String str5 = "Type 3";
        String str6 = "Type 4";
        String str7 = "Type 5";
        String str8 = "Type 6";
        String str9 = "Type 7";
        String str10 = "Type 8";
        dataset.addValue(1.0D, str1, str3);// value,series,category
        dataset.addValue(4.0D, str1, str4);
        dataset.addValue(3.0D, str1, str5);
        dataset.addValue(5.0D, str1, str6);
        dataset.addValue(5.0D, str1, str7);
        dataset.addValue(7.0D, str1, str8);
        dataset.addValue(7.0D, str1, str9);
        dataset.addValue(8.0D, str1, str10);
        dataset.addValue(5.0D, str2, str3);
        dataset.addValue(7.0D, str2, str4);
        dataset.addValue(6.0D, str2, str5);
        dataset.addValue(8.0D, str2, str6);
        dataset.addValue(4.0D, str2, str7);
        dataset.addValue(4.0D, str2, str8);
        dataset.addValue(2.0D, str2, str9);
        dataset.addValue(1.0D, str2, str10);
        return dataset;
    }

    public static CategoryDataset createDataset2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String str1 = "Third";
        String str2 = "Fourth";
        String str3 = "Type 1";
        String str4 = "Type 2";
        String str5 = "Type 3";
        String str6 = "Type 4";
        String str7 = "Type 5";
        String str8 = "Type 6";
        String str9 = "Type 7";
        String str10 = "Type 8";
        dataset.addValue(11.0D, str1, str3);
        dataset.addValue(14.0D, str1, str4);
        dataset.addValue(13.0D, str1, str5);
        dataset.addValue(15.0D, str1, str6);
        dataset.addValue(15.0D, str1, str7);
        dataset.addValue(17.0D, str1, str8);
        dataset.addValue(17.0D, str1, str9);
        dataset.addValue(18.0D, str1, str10);
        dataset.addValue(15.0D, str2, str3);
        dataset.addValue(17.0D, str2, str4);
        dataset.addValue(16.0D, str2, str5);
        dataset.addValue(18.0D, str2, str6);
        dataset.addValue(14.0D, str2, str7);
        dataset.addValue(14.0D, str2, str8);
        dataset.addValue(12.0D, str2, str9);
        dataset.addValue(11.0D, str2, str10);
        return dataset;
    }

    private static JFreeChart createChart() {

        // dataset
        CategoryDataset dataset1 = createDataset1();

        // NumberAxis
        NumberAxis rangeAxis1 = new NumberAxis("Value");
        rangeAxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // Renderer
        LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
        renderer1.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

        CategoryPlot subplot1 = new CategoryPlot(dataset1, null, rangeAxis1, renderer1);// 第二个参数domainAxis设置为null
        subplot1.setDomainGridlinesVisible(true);

        /////////////////////////////////////////////////////////////////////////

        CategoryDataset dataset2 = createDataset2();

        NumberAxis rangeAxis2 = new NumberAxis("Value");
        rangeAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer2 = new BarRenderer();
        renderer2.setBarPainter(new StandardBarPainter());// 标准的渲染器(支持颜色渐变)
        renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

        CategoryPlot subplot2 = new CategoryPlot(dataset2, null, rangeAxis2, renderer2);// 第二个参数domainAxis设置为null
        subplot2.setDomainGridlinesVisible(true);

        CategoryAxis domainAxis = new CategoryAxis("Category"); // 共用X轴

        // 组合Plot
        CombinedDomainCategoryPlot combinedPlot = new CombinedDomainCategoryPlot(domainAxis);
        combinedPlot.add(subplot1, 2);// subplot, weight
        combinedPlot.add(subplot2, 1);

        subplot1.setAxisOffset(RectangleInsets.ZERO_INSETS); // 设置轴偏移（数据区和轴之间的间隙）
        subplot2.setAxisOffset(RectangleInsets.ZERO_INSETS);

        JFreeChart chart = new JFreeChart("Combined Domain Category Plot Demo -Yves", new Font("SansSerif", 1, 12), combinedPlot, true);

        return chart;
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
