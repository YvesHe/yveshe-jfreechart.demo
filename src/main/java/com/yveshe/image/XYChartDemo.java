/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年7月30日
* Description:
*
* Author       YvesHe
*/
package com.yveshe.image;

import java.awt.BasicStroke;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.yveshe.utilities.ChartTutorialUtil;

public class XYChartDemo {

    /**
     * <table style="text-align:center;" class="table table-bordered">
     * <tr>
     * <td rowspan="4" style=
     * "text-align:center; vertical-align:middle; width:30%"><b>Firefox</b></td>
     * <th style="text-align:center;">Category(X)</th>
     * <th style="text-align:center;">Score(Y)</th>
     * </tr>
     * <tr>
     * <td>1.0</td>
     * <td>1.0</td>
     * </tr>
     * <tr>
     * <td>2.0</td>
     * <td>4.0</td>
     * </tr>
     * <tr>
     * <td>3.0</td>
     * <td>3.0</td>
     * </tr>
     * <tr>
     * <td rowspan="4" style=
     * "text-align:center; vertical-align:middle; width:30%"><b>Chrome</b></td>
     * <th style="text-align:center;">Category(X)</th>
     * <th style="text-align:center;">Score(Y)</th>
     * </tr>
     * <tr>
     * <td>1.0</td>
     * <td>4.0</td>
     * </tr>
     * <tr>
     * <td>2.0</td>
     * <td>5.0</td>
     * </tr>
     * <tr>
     * <td>3.0</td>
     * <td>6.0</td>
     * </tr>
     * <tr>
     * <td rowspan="4" style=
     * "text-align:center; vertical-align:middle; width:30%"><b>IE</b></td>
     * <th style="text-align:center;">Category(X)</th>
     * <th style="text-align:center;">Score(Y)</th>
     * </tr>
     * <tr>
     * <td>3.0</td>
     * <td>4.0</td>
     * </tr>
     * <tr>
     * <td>4.0</td>
     * <td>5.0</td>
     * </tr>
     * <tr>
     * <td>5.0</td>
     * <td>4.0</td>
     * </tr>
     * </table>
     *
     * @return
     */
    private static XYDataset createDataset() {

        final XYSeries firefox = new XYSeries("Firefox");
        firefox.add(1.0, 1.0);
        firefox.add(2.0, 4.0);
        firefox.add(3.0, 3.0);

        final XYSeries chrome = new XYSeries("Chrome");
        chrome.add(1.0, 4.0);
        chrome.add(2.0, 5.0);
        chrome.add(3.0, 6.0);

        final XYSeries iexplorer = new XYSeries("InternetExplorer");
        iexplorer.add(3.0, 4.0);
        iexplorer.add(4.0, 5.0);
        iexplorer.add(5.0, 4.0);

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(firefox);
        dataset.addSeries(chrome);
        dataset.addSeries(iexplorer);
        return dataset;

    }

    private static JFreeChart createChart(XYDataset dataset) {// 同TimeSeries中的结构一致
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
            "Which Browser are you using?",
            "Category",
            "Score",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.YELLOW);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));

        final XYPlot plot = xylineChart.getXYPlot();
        plot.setRenderer(renderer);

        return xylineChart;
    }

    public static void main(String[] args) throws Exception {
        XYDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);

        ChartTutorialUtil.createImage(chart,
            1024, // width
            860, // height
            "XYChartDemo.jpeg");// image name

        ChartTutorialUtil.success();

    }

}
