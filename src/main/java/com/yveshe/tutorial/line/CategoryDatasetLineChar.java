package com.yveshe.tutorial.line;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

/**
 * 数据集是构造的只有一个系列的数据集
 *
 *
 * 用途: 主要用来设置单个Series的样式显示
 *
 * @author Yves He
 *
 */
public class CategoryDatasetLineChar {

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(212.0D, "Classes", "JDK 1.0");
        dataset.addValue(504.0D, "Classes", "JDK 1.1");
        dataset.addValue(1520.0D, "Classes", "JDK 1.2");// 当为value为null时数据连线会断开
        dataset.addValue(1842.0D, "Classes", "JDK 1.3");
        dataset.addValue(2991.0D, "Classes", "JDK 1.4");
        dataset.addValue(3500.0D, "Classes", "JDK 1.5");
        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart(
            "Java Standard Class Library  -Yves", // the chart title (null
                                                  // permitted).
            null, // the label for the category axis (null permitted).
            "Class Count", // the label for the value axis (null permitted).
            dataset, // the dataset for the chart (null permitted).
            PlotOrientation.VERTICAL, // the chart orientation (horizontal or
                                      // vertical) (null not permitted).
            false, // a flag specifying whether or not a legend is required
            true, // tool tips?
            false);// URLs?

        // 添加子标题
        chart.addSubtitle(new TextTitle("Number of Classes By Release"));
        TextTitle textTitle = new TextTitle("Source: Java In A Nutshell (5th Edition) by David Flanagan (O'Reilly)");
        textTitle.setFont(new Font("SansSerif", 0, 10));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        chart.addSubtitle(textTitle);

        CategoryPlot cPlot = (CategoryPlot) chart.getPlot();
        cPlot.setRangePannable(true);
        cPlot.setRangeGridlinesVisible(false);

        // Y轴
        ValueAxis rangeAxis = cPlot.getRangeAxis();
        ((NumberAxis) rangeAxis).setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        LineAndShapeRenderer renderer = (LineAndShapeRenderer) cPlot.getRenderer();

        // 数据点外廓线设置 (注意外廓线的颜色设置)
        renderer.setBaseOutlinePaint(Color.BLUE);// 数据点外廓线显示颜色
        renderer.setDrawOutlines(true); // 数据外廓线是否显示
        renderer.setBaseOutlineStroke(new BasicStroke(2.0F));// 数据点外廓线粗细
        renderer.setBaseOutlinePaint(Color.BLUE);

        // 单个Series
        renderer.setBaseShapesVisible(true);// 数据点形状显示, false为不显示
        renderer.setSeriesShape(0, new Rectangle2D.Double(-5.0D, -5.0D, 10.0D, 10.0D));// 设置形状
        // java.awt.geom.Ellipse2D 圆
        // java.awt.geom.Rectangle2D 正方形 ...

        renderer.setUseFillPaint(true);// 数据点中是否填充其他颜色
        renderer.setSeriesFillPaint(0, Color.BLUE);// 数据点中填充颜色

        renderer.setDrawOutlines(true); // 数据外廓线是否显示
        renderer.setSeriesPaint(0, Color.YELLOW);// 设置绘制线条的颜色,包括了外廓线的颜色
        renderer.setSeriesOutlinePaint(0, Color.BLUE, true);
        renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F), true);// 数据点外廓线粗细

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