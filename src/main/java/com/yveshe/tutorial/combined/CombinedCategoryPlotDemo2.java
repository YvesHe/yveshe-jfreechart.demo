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
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedRangeCategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

/**
 * 共用y轴(这里图片展示顺序为横向)
 *
 * @author Yves He
 *
 */
public class CombinedCategoryPlotDemo2 {

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
        dataset.addValue(1.0D, str1, str3);
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
        String str3 = "Sector 1";
        String str4 = "Sector 2";
        String str5 = "Sector 3";
        String str6 = "Sector 4";
        dataset.addValue(11.0D, str1, str3);
        dataset.addValue(14.0D, str1, str4);
        dataset.addValue(13.0D, str1, str5);
        dataset.addValue(15.0D, str1, str6);
        dataset.addValue(15.0D, str2, str3);
        dataset.addValue(17.0D, str2, str4);
        dataset.addValue(16.0D, str2, str5);
        dataset.addValue(18.0D, str2, str6);
        return dataset;
    }

    private static JFreeChart createChart() {
        CategoryDataset dataset1 = createDataset1();
        CategoryAxis categoryAxis1 = new CategoryAxis("Class 1");
        categoryAxis1.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryAxis1.setMaximumCategoryLabelWidthRatio(5.0F);
        LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
        renderer1.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        CategoryPlot subplot1 = new CategoryPlot(dataset1, categoryAxis1, null, renderer1);
        subplot1.setDomainGridlinesVisible(true);

        CategoryDataset dataset2 = createDataset2();
        CategoryAxis categoryAxis2 = new CategoryAxis("Class 2");
        categoryAxis2.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryAxis2.setMaximumCategoryLabelWidthRatio(5.0F);
        BarRenderer renderer2 = new BarRenderer();
        renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        CategoryPlot subplot2 = new CategoryPlot(dataset2, categoryAxis2, null, renderer2);
        subplot2.setDomainGridlinesVisible(true);
        NumberAxis rangeAxis2 = new NumberAxis("Value");

        CombinedRangeCategoryPlot combinedPlot = new CombinedRangeCategoryPlot(rangeAxis2);
        combinedPlot.setRangePannable(true);
        combinedPlot.add(subplot1, 3);
        combinedPlot.add(subplot2, 2);
        combinedPlot.setOrientation(PlotOrientation.HORIZONTAL);

        JFreeChart chart = new JFreeChart("Combined Range Category Plot Demo -Yves", new Font("SansSerif", 1, 12), combinedPlot, true);
        ChartUtilities.applyCurrentTheme(chart);
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
