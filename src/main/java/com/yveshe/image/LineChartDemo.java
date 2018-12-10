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

public class LineChartDemo {

    /**
     * <table style="text-align:center;" class="table table-bordered">
     * <tr>
     * <th style="text-align:center;">Year</th>
     * <th style="text-align:center;">Number OF Schools</th>
     * </tr>
     * <tr>
     * <td>1970</td>
     * <td>15</td>
     * </tr>
     * <tr>
     * <td>1980</td>
     * <td>30</td>
     * </tr>
     * <tr>
     * <td>1990</td>
     * <td>60</td>
     * </tr>
     * <tr>
     * <td>2000</td>
     * <td>120</td>
     * </tr>
     * <tr>
     * <td>2013</td>
     * <td>240</td>
     * </tr>
     * <tr>
     * <td>2014</td>
     * <td>300</td>
     * </tr>
     * </table>
     *
     * @return
     */
    private static CategoryDataset createDataset() {
        // 注意:
        // 这里我们注意到如果rowKey只有一组,本例子是只有一组为"schools"的数据时候,显示效果就只有一组数据,不会有对比数据的图显示

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(15, // value(Y轴显示值)
            "schools", // rowKey (rowKey相等的数据是同一个Series系列)
            "1970");// columnKey (X轴显示值)

        dataset.addValue(30, "schools", "1980");
        dataset.addValue(60, "schools", "1990");
        dataset.addValue(120, "schools", "2000");
        dataset.addValue(240, "schools", "2010");
        dataset.addValue(300, "schools", "2014");
        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
            "School Vs Years", // chartTitle(标题)
            "Years", // categoryAxisLabel(X轴类别)
            "Number of Schools", // valueAxisLabel(Y轴类别)
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
            "LineChartDemo.jpeg");// image name

        ChartTutorialUtil.success();

    }

}
