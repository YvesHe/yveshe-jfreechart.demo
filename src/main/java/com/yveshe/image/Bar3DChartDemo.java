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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.yveshe.utilities.ChartTutorialUtil;

/**
 * 3DBar(3D柱状图)
 *
 * @author Yves He
 *
 */
public class Bar3DChartDemo {

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
     * <td><b>FIAT</b></td>
     * <td>1.0</td>
     * <td>3.0</td>
     * <td>5.0</td>
     * <td>5.0</td>
     * </tr>
     * <tr>
     * <td><b>AUDI</b></td>
     * <td>5.0</td>
     * <td>6.0</td>
     * <td>10.0</td>
     * <td>4.0</td>
     * </tr>
     * <tr>
     * <td><b>FORD</b></td>
     * <td>4.0</td>
     * <td>2.0</td>
     * <td>3.0</td>
     * <td>6.0</td>
     * </tr>
     * </table>
     *
     * @return
     */
    private static CategoryDataset createDataset() {
        final String fait = "FAIT";
        final String audi = "AUDI";
        final String ford = "FORD";
        final String speed = "Speed";
        final String popular = "Popular";
        final String mailage = "Mailage";
        final String userrating = "User Rating";
        final String safety = "safety";
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, fait, speed);
        dataset.addValue(4.0, fait, popular);
        dataset.addValue(3.0, fait, userrating);
        dataset.addValue(5.0, fait, mailage);
        dataset.addValue(5.0, fait, safety);

        dataset.addValue(5.0, audi, speed);
        dataset.addValue(7.0, audi, popular);
        dataset.addValue(6.0, audi, userrating);
        dataset.addValue(10.0, audi, mailage);
        dataset.addValue(4.0, audi, safety);

        dataset.addValue(4.0, ford, speed);
        dataset.addValue(3.0, ford, popular);
        dataset.addValue(2.0, ford, userrating);
        dataset.addValue(3.0, ford, mailage);
        dataset.addValue(6.0, ford, safety);

        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart3D(
            "Car Usage Statistics", // chartTitle(标题)
            "Category", // categoryAxisLabel(X轴类别)
            "Score", // valueAxisLabel(Y轴类别)
            dataset, // CategoryDataset
            PlotOrientation.VERTICAL, // PlotOrientation
            // (方向:horizontal or vertical)
            true, // legend(图例)
            true, // tooltips(悬浮显示)
            false);// urls

        // 定制样式

        return chart;
    }

    public static void main(String[] args) throws Exception {
        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);

        ChartTutorialUtil.createImage(chart,
            1024, // width
            860, // height
            "Bar3DChartDemo.jpeg");// image name
        ChartTutorialUtil.success();

    }

}
