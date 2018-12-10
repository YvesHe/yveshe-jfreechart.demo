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

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

/**
 * 采用多个Series的CategoryDataset数据集
 *
 * 分别针对不同的Serie有不同的处理方式
 *
 *
 * @author Yves He
 *
 */
public class CategoryDatasetMutilSeriesLineChart {

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset localDefaultCategoryDataset = new DefaultCategoryDataset();
        localDefaultCategoryDataset.addValue(21.0D, "Series 1", "Category 1");
        localDefaultCategoryDataset.addValue(50.0D, "Series 1", "Category 2");
        localDefaultCategoryDataset.addValue(152.0D, "Series 1", "Category 3");
        localDefaultCategoryDataset.addValue(184.0D, "Series 1", "Category 4");
        localDefaultCategoryDataset.addValue(299.0D, "Series 1", "Category 5");

        localDefaultCategoryDataset.addValue(275.0D, "Series 2", "Category 1");
        localDefaultCategoryDataset.addValue(121.0D, "Series 2", "Category 2");
        localDefaultCategoryDataset.addValue(98.0D, "Series 2", "Category 3");
        localDefaultCategoryDataset.addValue(103.0D, "Series 2", "Category 4");
        localDefaultCategoryDataset.addValue(210.0D, "Series 2", "Category 5");

        localDefaultCategoryDataset.addValue(198.0D, "Series 3", "Category 1");
        localDefaultCategoryDataset.addValue(null, "Series 3", "Category 2");// null值,数据点不连续
        localDefaultCategoryDataset.addValue(55.0D, "Series 3", "Category 3");
        localDefaultCategoryDataset.addValue(34.0D, "Series 3", "Category 4");
        localDefaultCategoryDataset.addValue(77.0D, "Series 3", "Category 5");

        return localDefaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset paramCategoryDataset) {
        JFreeChart chart = ChartFactory.createLineChart("Line Chart Demo 7", "Category", "Count", paramCategoryDataset, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();

        renderer.setSeriesShapesVisible(0, true); // 显示数据点形状图形
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesVisible(2, true);
        renderer.setSeriesLinesVisible(2, false);// 取消线条显示
        renderer.setSeriesShape(2, ShapeUtilities.createDiamond(4.0F));

        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());// 设置label生成器
        renderer.setSeriesItemLabelsVisible(0, true);

        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setBaseFillPaint(Color.white);
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
