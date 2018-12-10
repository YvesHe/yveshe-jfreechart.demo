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
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import com.yveshe.utilities.ChartTutorialUtil;

/**
 * 时序图属于XY图中的一种
 *
 * @author Yves He
 *
 */
public class TimeSeriesChartDemo {

    private static XYDataset createDataset() {
        final TimeSeries series = new TimeSeries("Random Data");
        Second current = new Second();
        double value = 100.0;

        for (int i = 0; i < 4000; i++) {

            try {
                value = value + Math.random() - 0.5;
                series.add(current, new Double(value));// 每下一秒产生一个值
                current = (Second) current.next();
            } catch (SeriesException e) {
                System.err.println("Error adding to series");
            }
        }

        return new TimeSeriesCollection(series);
    }

    private static JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Computing Test", // the chart title (null permitted).
            "Seconds", // the chart title (null permitted).
            "Value", // a label for the value axis (null permitted).
            dataset, // the dataset for the chart (null permitted).
            false, // a flag specifying whether or not a legend is required.
            false, // configure chart to generate tool tips?
            false);// configure chart to generate URLs?

        // 定制样式

        return chart;
    }

    public static void main(String[] args) throws Exception {
        XYDataset xyDataset = createDataset();

        JFreeChart chart = createChart(xyDataset);

        ChartTutorialUtil.createImage(chart,
            1024, // width
            860, // height
            "TimeSeriesChartDemo.jpeg");// image name
        ChartTutorialUtil.success();

    }

}
