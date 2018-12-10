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

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CenterTextMode;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RefineryUtilities;

/**
 * 环形图2
 *
 * @author Yves He
 *
 */
public class RingChart2 {

    private static PieDataset createDataset() {
        DefaultPieDataset localDefaultPieDataset = new DefaultPieDataset();
        localDefaultPieDataset.setValue("A", new Double(0.653D));
        localDefaultPieDataset.setValue("B", new Double(0.347D));
        return localDefaultPieDataset;
    }

    private static JFreeChart createChart(PieDataset paramPieDataset) {
        RingPlot localRingPlot = new RingPlot(paramPieDataset);
        localRingPlot.setCenterTextMode(CenterTextMode.VALUE);
        localRingPlot.setCenterTextFont(new Font("SansSerif", 1, 24));
        localRingPlot.setCenterTextColor(Color.LIGHT_GRAY);
        localRingPlot.setCenterTextFormatter(new DecimalFormat("0.0%"));

        JFreeChart localJFreeChart = new JFreeChart("Machine Capacity -Yves", JFreeChart.DEFAULT_TITLE_FONT, localRingPlot, false);
        localJFreeChart.setBackgroundPaint(new GradientPaint(new Point(0, 0), new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));

        TextTitle localTextTitle = localJFreeChart.getTitle();
        localTextTitle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        localTextTitle.setPaint(new Color(240, 240, 240));
        localTextTitle.setFont(new Font("Arial", 1, 26));

        localRingPlot.setBackgroundPaint(null);
        localRingPlot.setOutlineVisible(false);
        localRingPlot.setLabelGenerator(null);
        localRingPlot.setSectionPaint("A", Color.ORANGE);
        localRingPlot.setSectionPaint("B", new Color(100, 100, 100));
        localRingPlot.setSectionDepth(0.05D);
        localRingPlot.setSectionOutlinesVisible(false);
        localRingPlot.setShadowPaint(null);
        return localJFreeChart;
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
