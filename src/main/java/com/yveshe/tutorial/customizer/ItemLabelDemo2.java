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

import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

/**
 * 用途: 目的是在每个系列的标签上显示出值和百分比值（这个百分比值，这个系列在 某一部分的条形直方图或全部条形直方图的总值中的比值）
 *
 * @author YvesHe
 *
 */
public class ItemLabelDemo2 {
    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100.0D, "S1", "C1");
        dataset.addValue(44.299999999999997D, "S1", "C2");
        dataset.addValue(93.0D, "S1", "C3");
        dataset.addValue(80.0D, "S2", "C1");
        dataset.addValue(75.099999999999994D, "S2", "C2");
        dataset.addValue(15.1D, "S2", "C3");
        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset paramCategoryDataset) {
        JFreeChart chart = ChartFactory.createBarChart("Item Label Demo -Yves", "Category", "Value", paramCategoryDataset, PlotOrientation.HORIZONTAL, true, true, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        plot.setRangePannable(true);
        plot.setRangeZeroBaselineVisible(true);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setUpperMargin(0.25D);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBaseItemLabelsVisible(true);
        renderer.setItemLabelAnchorOffset(7.0D);
        renderer.setBaseItemLabelGenerator(new LabelGenerator(null));

        // 标准的渲染器为长方条形图
        renderer.setBarPainter(new StandardBarPainter());

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
        private final Integer category;
        private final NumberFormat formatter = NumberFormat.getPercentInstance();// 当前默认语言环境的百分比格式

        public LabelGenerator(int paramInt) {
            this(new Integer(paramInt));
        }

        public LabelGenerator(Integer paramInteger) {
            super("", NumberFormat.getInstance());
            this.category = paramInteger;
        }

        public String generateLabel(CategoryDataset dataset, int series, int category) {
            String result = null;
            double base = 0.0;
            if (this.category != null) {
                final Number b = dataset.getValue(series, this.category.intValue());
                base = b.doubleValue();
            } else {
                base = calculateSeriesTotal(dataset, series);
            }
            Number value = dataset.getValue(series, category);
            if (value != null) {
                final double v = value.doubleValue();
                // you could apply some formatting here
                result = value.toString()
                    + " (" + this.formatter.format(v / base) + ")";
            }
            return result;
        }

        /**
         * Calculates a series total.
         *
         * @param dataset
         *            the dataset.
         * @param series
         *            the series index.
         *
         * @return The total.
         */
        private double calculateSeriesTotal(CategoryDataset dataset, int series) {
            double d = 0.0D;
            for (int i = 0; i < dataset.getColumnCount(); i++) {
                Number value = dataset.getValue(series, i);
                if (value != null)
                    d += value.doubleValue();
            }
            return d;
        }
    }

}
