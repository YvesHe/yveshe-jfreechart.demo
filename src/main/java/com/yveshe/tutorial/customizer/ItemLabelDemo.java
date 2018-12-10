/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年8月8日
* Description:
*
* Author       YvesHe
*/
package com.yveshe.tutorial.customizer;

import java.awt.Font;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

/**
 * 自定义标签显示
 *
 * 用途: 在第一个实例中，目的就是当当条目的值大于某个限定的值时，就显示该标签。
 *
 * @author Yves He
 *
 */
public class ItemLabelDemo {
    private static CategoryDataset createDataset() {
        DefaultCategoryDataset datasete = new DefaultCategoryDataset();
        datasete.addValue(11.0D, "S1", "C1");
        datasete.addValue(44.299999999999997D, "S1", "C2");
        datasete.addValue(93.0D, "S1", "C3");
        datasete.addValue(35.600000000000001D, "S1", "C4");
        datasete.addValue(75.099999999999994D, "S1", "C5");
        return datasete;
    }

    private static JFreeChart createChart(CategoryDataset paramCategoryDataset) {
        JFreeChart chart = ChartFactory.createBarChart("Item Label Demo 1", "Category", "Value", paramCategoryDataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRangePannable(true);
        plot.setRangeZeroBaselineVisible(true);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setUpperMargin(0.15D);

        CategoryItemRenderer renderer = plot.getRenderer();

        // 标准的渲染器为长方条形图
        ((BarRenderer) renderer).setBarPainter(new StandardBarPainter());

        // 设置标签生成器
        renderer.setBaseItemLabelGenerator(new LabelGenerator(50.0D));
        renderer.setBaseItemLabelFont(new Font("Serif", 0, 20));
        renderer.setBaseItemLabelsVisible(true);

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

    static class LabelGenerator extends AbstractCategoryItemLabelGenerator implements CategoryItemLabelGenerator {
        private final double threshold;

        public LabelGenerator(double paramDouble) {
            super("", NumberFormat.getInstance());
            this.threshold = paramDouble;
        }

        // 显示值大于threshold的标签
        public String generateLabel(CategoryDataset dataset, int row, int column) {
            String str = null;
            Number localNumber = dataset.getValue(row, column);
            if (localNumber != null) {
                double d = localNumber.doubleValue();
                if (d > this.threshold)
                    str = localNumber.toString();
            }
            return str;
        }
    }

}
