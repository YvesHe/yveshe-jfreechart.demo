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

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

import com.yveshe.utilities.ChartTutorialUtil;

/**
 * 气泡图(Y轴数值越大,气泡越大)
 *
 * @author Yves He
 *
 */
public class BubbleChartDemo {

    /**
     * <table style="text-align:center;" class="table table-bordered">
     * <tr>
     * <th colspan="9" style="text-align:center;">WEIGHT</th>
     * </tr>
     * <tr>
     * <td rowspan="8" style="text-align:center;vertical-align:middle;"><b>AGE
     * </b></td>
     * <td></td>
     * <td>30</td>
     * <td>40</td>
     * <td>50</td>
     * <td>60</td>
     * <td>70</td>
     * <td>80</td>
     * <td></td>
     * </tr>
     * <tr>
     * <td>10</td>
     * <td>4</td>
     * <td></td>
     * <td></td>
     * <td></td>
     * <td></td>
     * <td></td>
     * <td rowspan="8" style="text-align:center;vertical-align:middle"><b>WORK
     * </b></td>
     * </tr>
     * <tr>
     * <td>20</td>
     * <td></td>
     * <td>5</td>
     * <td></td>
     * <td></td>
     * <td></td>
     * <td></td>
     * </tr>
     * <tr>
     * <td>30</td>
     * <td></td>
     * <td></td>
     * <td>10</td>
     * <td></td>
     * <td></td>
     * <td></td>
     * </tr>
     * <tr>
     * <td>40</td>
     * <td></td>
     * <td></td>
     * <td></td>
     * <td>8</td>
     * <td></td>
     * <td></td>
     * </tr>
     * <tr>
     * <td>50</td>
     * <td></td>
     * <td></td>
     * <td></td>
     * <td></td>
     * <td>9</td>
     * <td></td>
     * </tr>
     * <tr>
     * <td>60</td>
     * <td></td>
     * <td></td>
     * <td></td>
     * <td></td>
     * <td></td>
     * <td>6</td>
     * </tr>
     * </table>
     *
     * @return
     */
    private static XYZDataset createDataset() {
        DefaultXYZDataset defaultxyzdataset = new DefaultXYZDataset();
        double ad[] = { 30, 40, 50, 60, 70, 80 };// Y轴值
        double ad1[] = { 10, 20, 30, 40, 50, 60 };// X轴值
        double ad2[] = { 4, 5, 10, 8, 9, 6 }; // XY点位确定下来的值
        double ad3[][] = { ad, ad1, ad2 };
        defaultxyzdataset.addSeries("Series 1", ad3);// 一组气泡

        // 自定义第二组气泡
        // double yves1[] = { 10, 40, 20, 60, 40, 80 };
        // double yves2[] = { 10, 20, 30, 40, 50, 60 };
        // double yves3[] = { 4, 5, 20, 10, 9, 6 };
        // double yves[][] = { yves1, yves2, yves3 };
        // defaultxyzdataset.addSeries("Series 2", yves);

        return defaultxyzdataset;
    }

    private static JFreeChart createChart(XYZDataset xyzdataset) {
        JFreeChart jfreechart = ChartFactory.createBubbleChart(
            "AGE vs WEIGHT vs WORK", // chartTitle(标题) (null permitted).
            "Weight", // a label for the X-axis (null permitted).
            "AGE", // a label for the Y-axis (null permitted).
            xyzdataset, // data
            PlotOrientation.HORIZONTAL, // Orientation(horizontal or vertical))
            true, true, false);// legend(图例), tooltips(悬浮显示),urls

        // 定制样式
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        xyplot.setForegroundAlpha(0.65F);
        XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        xyitemrenderer.setSeriesPaint(0, Color.blue);
        NumberAxis numberaxis = (NumberAxis) xyplot.getDomainAxis();
        numberaxis.setLowerMargin(0.2);
        numberaxis.setUpperMargin(0.5);
        NumberAxis numberaxis1 = (NumberAxis) xyplot.getRangeAxis();
        numberaxis1.setLowerMargin(0.8);
        numberaxis1.setUpperMargin(0.9);

        return jfreechart;
    }

    public static void main(String[] args) throws Exception {
        XYZDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);

        ChartTutorialUtil.createImage(chart,
            1024, // width
            860, // height
            "BubbleChartDemo.jpeg");// image name

        ChartTutorialUtil.success();

    }

}
