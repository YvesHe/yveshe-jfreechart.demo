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
package com.yveshe.customizer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import com.yveshe.utilities.ChartTutorialUtil;
import com.yveshe.utilities.CustomizerUtils;

public class ChartCustomizer {

    private static PieDataset createPieDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("IPhone 5s", new Double(20));
        dataset.setValue("SamSung Grand", new Double(20));
        dataset.setValue("MotoG", new Double(40));
        dataset.setValue("Nokia Lumia", new Double(10));
        return dataset;
    }

    private static JFreeChart createPieChart() {
        JFreeChart chart = ChartFactory.createPieChart(
            "Mobile Sales", // chart title
            createPieDataset(), // data
            true, // include legend
            false, // tooltips
            true);// urls

        return chart;
    }

    private static CategoryDataset createCategoryDataset() {
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

        return dataset;
    }

    private static JFreeChart createBarChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
            "chartTitle",
            "Category",
            "Score",
            createCategoryDataset(),
            PlotOrientation.VERTICAL,
            true, true, false);

        return barChart;
    }

    // 与BarChar构造相同,DataSet 也是createCategoryDataset
    private static JFreeChart createAreaChart() {

        JFreeChart barChart = ChartFactory.createAreaChart(

            "Title: Hello Yves", // chartTitle(标题)
            "Category", // categoryAxisLabel(X轴类别)
            "Score", // valueAxisLabel(Y轴类别)
            createCategoryDataset(), // CategoryDataset
            PlotOrientation.VERTICAL, // PlotOrientation
                                      // (方向:horizontal or vertical)
            true, // legend(图例)
            true, // tooltips(悬浮显示)
            false);

        return barChart;
    }

    // 与BarChar构造相同,DataSet 也是createCategoryDataset
    private static JFreeChart createLineChart() { // 采用的是XYPlot
        JFreeChart lineChart = ChartFactory.createLineChart(

            "Title: Hello Yves", // chartTitle(标题)
            "Category", // categoryAxisLabel(X轴类别)
            "Score", // valueAxisLabel(Y轴类别)
            createCategoryDataset(), // CategoryDataset
            PlotOrientation.VERTICAL, // PlotOrientation
                                      // (方向:horizontal or vertical)
            true, // legend(图例)
            true, // tooltips(悬浮显示)
            false);

        return lineChart;
    }

    private static XYDataset createXYDataset() {

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

    private static JFreeChart createXYChart() {// 同TimeSeries中的结构一致
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
            "Which Browser are you using?",
            "Category",
            "Score",
            createXYDataset(),
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

    private static XYDataset createTimeSeriesDataset() {
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

    // TimeSeriesChar 可以复用XYDataSet资源
    private static JFreeChart createTimeSeriesChart() {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Computing Test", // the chart title (null permitted).
            "Seconds", // the chart title (null permitted).
            "Value", // a label for the value axis (null permitted).
            createTimeSeriesDataset(), // the dataset for the chart (null
                                       // permitted).
            false, // a flag specifying whether or not a legend is required.
            false, // configure chart to generate tool tips?
            false);// configure chart to generate URLs?

        // 定制样式

        return chart;
    }

    /**
     * 采用主题的方案
     *
     * @param args
     * @throws Exception
     */
    public static void main2(String[] args) throws Exception {
        ApplicationFrame demo = new ApplicationFrame("Mobile Sales");

        CustomizerUtils.setChartTheme();

        // 二.生成报表
        JFreeChart chart = createPieChart();

        // JFreeChart chart = createBarChart();
        // JFreeChart chart = createAreaChart();
        // JFreeChart chart = createLineChart();

        // JFreeChart chart = createXYChart();
        // JFreeChart chart = createTimeSeriesChart();

        ChartPanel chartPanel = new ChartPanel(chart);
        demo.setContentPane(chartPanel);
        demo.setSize(800, 600);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

        TimeUnit.SECONDS.sleep(1);

        // 生成图片
        ChartTutorialUtil.createImage(chart, 800, 600, "PieChartCustomizer.jpeg");
        ChartTutorialUtil.success();
    }

    /**
     * 测试
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        ApplicationFrame demo = new ApplicationFrame("Mobile Sales");

        // 一.设置主题
        // 注意: 当使用ChartFactory来创建报表的时候,都会应用该主题,所以是要先设置主题,再创建报表
        CustomizerUtils.setChartTheme();

        // 二.生成报表
        // JFreeChart chart = createPieChart();
        JFreeChart chart = createBarChart();
        // JFreeChart chart = createAreaChart();
        // JFreeChart chart = createLineChart();
        // JFreeChart chart = createXYChart();
        // JFreeChart chart = createTimeSeriesChart();

        // JFreeChart 一般设置
        CustomizerUtils.setGeneral(chart);

        // CustomizerUtils.setAntiAlias(chart, true);
        // CustomizerUtils.setBorderVisible(chart, true);

        // 设置 plot和renderer渲染图表
        CustomizerUtils.setPlot(chart);

        ChartPanel chartPanel = new ChartPanel(chart);
        demo.setContentPane(chartPanel);
        demo.setSize(800, 600);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

        // 真是瞎了眼了,JFreeChart居然没有做并发处理,当生成GUI和生成文件同时进行有可能出现异常
        TimeUnit.SECONDS.sleep(1);

        // 生成图片
        ChartTutorialUtil.createImage(chart, 800, 600, "PieChartCustomizer.jpeg");
        ChartTutorialUtil.success();

    }

}
