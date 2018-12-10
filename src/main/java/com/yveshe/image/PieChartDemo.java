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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.yveshe.utilities.ChartTutorialUtil;

public class PieChartDemo {

    /**
     * <table style="text-align:center;" class="table table-bordered">
     * <tr>
     * <th style="text-align:center;">S.No</th>
     * <th style="text-align:center;">Mobile Brands</th>
     * <th style="text-align:center;">Sales (UNITS per day)</th>
     * </tr>
     * <tr>
     * <td>1</td>
     * <td>Iphone 5S</td>
     * <td>20</td>
     * </tr>
     * <tr>
     * <td>2</td>
     * <td>Samsung Grand</td>
     * <td>20</td>
     * </tr>
     * <tr>
     * <td>3</td>
     * <td>MOTO G</td>
     * <td>40</td>
     * </tr>
     * <tr>
     * <td>4</td>
     * <td>Nokia Lumia</td>
     * <td>10</td>
     * </tr>
     * </table>
     *
     * @return
     */
    public static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("IPhone 5s", new Double(-2));
        dataset.setValue("SamSung Grand", new Double(20));
        dataset.setValue("MotoG", new Double(40));
        dataset.setValue("Nokia Lumia", new Double(10));
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
            "Title: Hello Yves!", // chart title(标题)
            dataset, // data
            false, // legend(图例)
            true, // tooltips (数据提示框指的当鼠标悬停在某点上时，以框的形式提示该点的数据)
            true); // urls

        // 定制样式
        PiePlot pieplot = (PiePlot) chart.getPlot();
        pieplot.setExplodePercent("IPhone 5s", 0.5);
        pieplot.setExplodePercent("Nokia Lumia", 0.2);

        return chart;
    }

    public static void main(String[] args) throws Exception {
        JFreeChart chart = createChart(createDataset());

        // set pixel
        int width = 1024;
        int height = 860;
        ChartTutorialUtil.createImage(chart, width, height, "PieChartDemo.jpeg");
        ChartTutorialUtil.success();
    }

}