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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;

public class PieChart {

    private static PieDataset createDataset() {

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Section A", 43.2);
        dataset.setValue("Section B", 27.9);
        dataset.setValue("Section C", 79.5);
        return dataset;
    }

    public static void main(String[] args) {

        // create a chart...
        JFreeChart chart = ChartFactory.createPieChart(
            "Sample Pie Chart -Yves", // chart title: 图表标题
            createDataset(), // data: 数据集
            true, // legend: 图例
            true, // tooltips: 图表工具条
            false // URLs: URLS
        );

        customizer(chart);

        customizer2(chart);

        customizer3(chart);

        customizer4(chart);

        customizer5(chart);

        customizer6(chart);

        customizer7(chart);

        customizer8(chart);

        // create and display a frame...
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);

    }

    // 片区颜色(SectionPaint)
    private static void customizer(JFreeChart chart) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Section A", new Color(200, 255, 255));
        plot.setSectionPaint("Section B", Color.BLUE);
        plot.setSectionPaint("Section C", Color.YELLOW);
    }

    // 完全关闭/开启片区外廓
    private static void customizer2(JFreeChart chart) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false); // true

    }

    // 控制片区外廓
    private static void customizer3(JFreeChart chart) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBaseSectionOutlinePaint(Color.RED);
        plot.setBaseSectionOutlineStroke(new BasicStroke(1f));
        plot.setSectionOutlinesVisible(true);
    }

    // 忽略空置、 零值
    private static void customizer4(JFreeChart chart) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setIgnoreZeroValues(true);
        plot.setIgnoreNullValues(true);
    }

    // 片区图例
    private static void customizer5(JFreeChart chart) {
    }

    // 取出某个片区(Exploded Sections)
    private static void customizer6(JFreeChart chart) {
        PiePlot pieplot = (PiePlot) chart.getPlot();
        pieplot.setExplodePercent("Section A", 0.3);
    }

    // 设置dataset为null时显示的提示信息
    private static void customizer7(JFreeChart chart) {
        PiePlot pieplot = (PiePlot) chart.getPlot();
        pieplot.setNoDataMessage("没有有效的数据显示!");// 设置提示信息内容。
        pieplot.setNoDataMessageFont(new Font("黑体", 2, 20));// 设置提示信息的字体和大小。
        pieplot.setNoDataMessagePaint(Color.red); // 设置提示信息字体的颜色。
    }

    // 自定义标签显示
    private static void customizer8(JFreeChart chart) {
        PiePlot pieplot = (PiePlot) chart.getPlot();
        pieplot.setLabelGenerator(new YvesCustomLabelGenerator());
    }

    // 自定义标签产生器
    static class YvesCustomLabelGenerator implements PieSectionLabelGenerator {

        // 产生标签,返回null时不显示
        public String generateSectionLabel(PieDataset piedataset, Comparable comparable) {
            String string = null;

            if (piedataset != null && !comparable.equals("Section A")) {
                string = comparable.toString();
            }
            return string;
        }

        public AttributedString generateAttributedSectionLabel(PieDataset piedataset, Comparable comparable) {
            Object object = null;
            String string = comparable.toString();
            String string_0_ = (string + " : " + String.valueOf(piedataset.getValue(comparable)));
            AttributedString attributedstring = new AttributedString(string_0_);
            attributedstring.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, 0, string.length() - 1);
            return attributedstring;
        }

    }
}
