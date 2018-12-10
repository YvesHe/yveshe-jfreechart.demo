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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

/**
 * A CategoryPlot with multiple datasets, axes and renderers.
 *
 * 多轴和多数据源图表
 *
 * 示例一: 不相同的图表类型
 *
 * @author YvesHe
 *
 */
public class DualAxisDemo {

    private static CategoryDataset createDataset1() {
        String str1 = "S1";
        String str2 = "S2";
        String str3 = "S3";
        String str4 = "Category 1";
        String str5 = "Category 2";
        String str6 = "Category 3";
        String str7 = "Category 4";
        String str8 = "Category 5";
        String str9 = "Category 6";
        String str10 = "Category 7";
        String str11 = "Category 8";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0D, str1, str4);// value, series, category
        dataset.addValue(4.0D, str1, str5);
        dataset.addValue(3.0D, str1, str6);
        dataset.addValue(5.0D, str1, str7);
        dataset.addValue(5.0D, str1, str8);
        dataset.addValue(7.0D, str1, str9);
        dataset.addValue(7.0D, str1, str10);
        dataset.addValue(8.0D, str1, str11);
        dataset.addValue(5.0D, str2, str4);
        dataset.addValue(7.0D, str2, str5);
        dataset.addValue(6.0D, str2, str6);
        dataset.addValue(8.0D, str2, str7);
        dataset.addValue(4.0D, str2, str8);
        dataset.addValue(4.0D, str2, str9);
        dataset.addValue(2.0D, str2, str10);
        dataset.addValue(1.0D, str2, str11);
        dataset.addValue(4.0D, str3, str4);
        dataset.addValue(3.0D, str3, str5);
        dataset.addValue(2.0D, str3, str6);
        dataset.addValue(3.0D, str3, str7);
        dataset.addValue(6.0D, str3, str8);
        dataset.addValue(3.0D, str3, str9);
        dataset.addValue(4.0D, str3, str10);
        dataset.addValue(3.0D, str3, str11);
        return dataset;
    }

    private static CategoryDataset createDataset2() {
        String str1 = "S4";
        String str2 = "Category 1";
        String str3 = "Category 2";
        String str4 = "Category 3";
        String str5 = "Category 4";
        String str6 = "Category 5";
        String str7 = "Category 6";
        String str8 = "Category 7";
        String str9 = "Category 8";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(15.0D, str1, str2);
        dataset.addValue(24.0D, str1, str3);
        dataset.addValue(31.0D, str1, str4);
        dataset.addValue(25.0D, str1, str5);
        dataset.addValue(56.0D, str1, str6);
        dataset.addValue(37.0D, str1, str7);
        dataset.addValue(77.0D, str1, str8);
        dataset.addValue(18.0D, str1, str9);
        return dataset;
    }

    private static JFreeChart createChart() {
        JFreeChart chart = ChartFactory.createBarChart("DualAxisDemo -Yves", "Category", "Value", createDataset1(), PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);

        ChartUtilities.applyCurrentTheme(chart); // 应用当前主题
        ((BarRenderer) plot.getRenderer()).setBarPainter(new StandardBarPainter());// 标准的渲染器(支持颜色渐变)

        // 设置额外图表一
        CategoryDataset dataset = createDataset2();
        plot.setDataset(1, dataset);
        plot.mapDatasetToRangeAxis(1, 1);

        NumberAxis numberAxis = new NumberAxis("Secondary");
        plot.setRangeAxis(1, numberAxis);// 设置额外图表一Y轴信息

        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        plot.setRenderer(1, renderer);// 设置额外图表一的渲染器

        // 图一的图例
        LegendTitle legendTitle1 = new LegendTitle(plot.getRenderer(0));
        legendTitle1.setMargin(new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D));
        legendTitle1.setFrame(new BlockBorder());

        // 图二的图例
        LegendTitle legendTitle2 = new LegendTitle(plot.getRenderer(1));
        legendTitle2.setMargin(new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D));
        legendTitle2.setFrame(new BlockBorder());

        // 标题容器
        BlockContainer titleContainer = new BlockContainer(new BorderArrangement());
        titleContainer.add(legendTitle1, RectangleEdge.LEFT);
        titleContainer.add(legendTitle2, RectangleEdge.RIGHT);
        titleContainer.add(new EmptyBlock(2000.0D, 0.0D));

        // 底部的复合子标题
        CompositeTitle compositeTitle = new CompositeTitle(titleContainer);
        compositeTitle.setPosition(RectangleEdge.BOTTOM);// 复合子标题放在图表的底部
        chart.addSubtitle(compositeTitle);

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
