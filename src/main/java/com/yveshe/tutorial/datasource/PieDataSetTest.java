/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年8月8日
* Description:
*
* Author       YvesHe
*/
package com.yveshe.tutorial.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.jfree.ui.RefineryUtilities;

public class PieDataSetTest {

    private static PieDataset readData() {
        String url = "jdbc:mysql://localhost:3306/jfreechartdb?useUnicode=true&characterEncoding=UTF8";
        String user = "root";
        String password = "root";

        JDBCPieDataset dataset = null;
        String sql = "SELECT * FROM PIEDATA1;";
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取连接
            Connection con = DriverManager.getConnection(url, user, password);

            dataset = new JDBCPieDataset(con);
            dataset.executeQuery(sql);// 查询结构仅仅支持两列,否则报错,第一列是key,第二列为value

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (dataset != null) {
                dataset.close();
            }
        }
        return dataset;
    }

    public static void main(String[] args) {

        // create a chart...
        JFreeChart chart = createChart(readData());

        // create and display a frame...
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);
    }

    private static JFreeChart createChart(PieDataset readData) {
        // create a chart...
        JFreeChart chart = ChartFactory.createPieChart3D( // 产生PieChart3D
            "Sample Pie Chart -Yves", // chart title: 图表标题
            readData(), // data: 数据集
            true, // legend: 图例
            true, // tooltips: 图表工具条
            false // URLs: URLS
        );
        return chart;
    }

}
