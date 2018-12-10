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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.yveshe.utilities.ChartTutorialUtil;

/**
 * Bar Chart(柱状图Demo)
 *
 * @author Yves He
 *
 */
public class BarChartDemo {

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
    private static CategoryDataset createDataset() {
        final String fiat = "FIAT";
        final String audi = "AUDI";
        final String ford = "FORD";
        final String speed = "Speed";
        final String millage = "Millage";
        final String userrating = "User Rating";
        final String safety = "safety";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(
            1.0, // value(Y轴显示值)
            fiat, // rowKey (rowKey相等的数据是同一个Series系列)
            speed);// columnKey (X轴显示值)

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

        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
            "Title: Hello Yves", // chartTitle(标题)
            "Category", // categoryAxisLabel(X轴类别)
            "Score", // valueAxisLabel(Y轴类别)
            createDataset(), // CategoryDataset
            PlotOrientation.VERTICAL, // PlotOrientation
                                      // (方向:horizontal or vertical)
            true, // legend(图例)
            true, // tooltips(悬浮显示)
            false);// urls

        // 定制样式

        return barChart;
    }

    public static void main(String[] args) throws Exception {
        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);

        ChartTutorialUtil.createImage(chart,
            1024, // width
            860, // height
            "BarChart.jpeg");// image name

        ChartTutorialUtil.success();

    }

}