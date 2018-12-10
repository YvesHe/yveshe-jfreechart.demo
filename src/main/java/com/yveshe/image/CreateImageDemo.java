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

import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * use jfreechart create image demo (创建图片Demo)
 *
 * @author Yves He
 *
 */
public class CreateImageDemo {

    /**
     * <table style="text-align:center;" class="table table-bordered">
     * <tr>
     * <th style="text-align:center;">Car</th>
     * <th style="text-align:center;">Speed</th>
     * <th style="text-align:center;">User Rating</th>
     * <th style="text-align:center;">Millage</th>
     * <th style="text-align:center;">Safety</th>
     * </tr>
     * <tr>
     * <td><b>Fiat</b></td>
     * <td>1.0</td>
     * <td>3.0</td>
     * <td>5.0</td>
     * <td>5.0</td>
     * </tr>
     * <tr>
     * <td><b>Audi</b></td>
     * <td>5.0</td>
     * <td>6.0</td>
     * <td>10.0</td>
     * <td>4.0</td>
     * </tr>
     * <tr>
     * <td><b>Ford</b></td>
     * <td>4.0</td>
     * <td>2.0</td>
     * <td>3.0</td>
     * <td>6.0</td>
     * </tr>
     * </table>
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        final String fiat = "FIAT";
        final String audi = "AUDI";
        final String ford = "FORD";
        final String speed = "Speed";
        final String millage = "Millage";
        final String userrating = "User Rating";
        final String safety = "safety";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, fiat, speed);
        dataset.addValue(3.0, fiat, userrating);
        dataset.addValue(5.0, fiat, millage);
        dataset.addValue(5.0, fiat, safety);

        dataset.addValue(5.0, audi, speed);
        dataset.addValue(6.0, audi, userrating);
        dataset.addValue(10.0, audi, millage);
        dataset.addValue(4.0, audi, safety);

        dataset.addValue(4.0, ford, speed);
        dataset.addValue(2.0, ford, userrating);
        dataset.addValue(3.0, ford, millage);
        dataset.addValue(6.0, ford, safety);

        JFreeChart barChart = ChartFactory.createBarChart(
            "CAR USAGE STATIStICS",
            "Category", "Score",
            dataset, PlotOrientation.VERTICAL,
            true, true, false);

        int width = 640; /* Width of the image */
        int height = 480; /* Height of the image */
        File BarChart = new File("out/BarChart.jpeg");
        ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);
    }
}