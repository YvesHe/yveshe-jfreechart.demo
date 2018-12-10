/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年8月2日
* Description:
*
* Author       YvesHe
*/
package com.yveshe.image;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.yveshe.utilities.ChartTutorialUtil;

/**
 * 3DPie(3D饼状图)
 *
 * @author Yves He
 *
 */
public class Pie3DChartDemo {

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
    private static DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("IPhone 5s", new Double(20));
        dataset.setValue("SamSung Grand", new Double(20));
        dataset.setValue("MotoG", new Double(40));
        dataset.setValue("Nokia Lumia", new Double(10));

        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart3D(
            "Mobile Sales", // chart title(标题)
            dataset, // dataset
            true, // include legend (图例)
            true, // tooltips(悬浮显示)
            false);// urls

        // 定制样式
        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(270);
        plot.setForegroundAlpha(0.60f);
        plot.setInteriorGap(0.02);

        return chart;
    }

    public static void main(String[] args) throws Exception {
        DefaultPieDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);

        ChartTutorialUtil.createImage(chart,
            1024, // width
            860, // height
            "Pie3DChartDemo.jpeg");// image name
        ChartTutorialUtil.success();

    }

}
