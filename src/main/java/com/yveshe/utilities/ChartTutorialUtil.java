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
package com.yveshe.utilities;

import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.ui.RefineryUtilities;

public class ChartTutorialUtil {

    public static void createImage(JFreeChart chart, String fileName) throws Exception {
        int width = 800;
        int height = 600;

        createImage(chart, width, height, fileName);
    }

    /**
     * create image jpeg
     *
     * @param chart
     * @param width
     * @param height
     * @throws Exception
     */
    public static void createImage(JFreeChart chart, int width, int height, String fileName) throws Exception {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File("out" + File.separator + fileName));
            ChartUtilities.writeChartAsJPEG(out, chart, width, height);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("error in create image");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new Exception("error in create image");
                }
            }
        }
    }

    /**
     * create gui window
     *
     * @param chart
     */
    public static void createChartGUI(JFreeChart chart) {
        ChartFrame frame = new ChartFrame("Yves-JFreeChart", chart);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);
    }

    /**
     * 设置中文主题样式 解决乱码
     */
    public static void setChineseTheme(JFreeChart chart) {
        Font FONT = new Font("宋体", Font.PLAIN, 12);

        StandardChartTheme chartTheme = new StandardChartTheme("CN");

        // 设置标题字体
        chartTheme.setExtraLargeFont(FONT);

        // 设置图例的字体
        chartTheme.setRegularFont(FONT);

        // 设置轴向的字体
        chartTheme.setLargeFont(FONT);
        chartTheme.setSmallFont(FONT);
        ChartFactory.setChartTheme(chartTheme);

        // 使当前主题马上生效
        ChartUtilities.applyCurrentTheme(chart);
    }

    public static void success() {
        System.out.println("Success!");
    }

}
