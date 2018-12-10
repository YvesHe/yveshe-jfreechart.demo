/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年8月7日
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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author YvesHe
 *
 */
public class CategoryDatasetTest {

    private static CategoryDataset readData() {
        String url = "jdbc:mysql://localhost:3306/jfreechartdb?useUnicode=true&characterEncoding=UTF8";
        String user = "root";
        String password = "root";

        JDBCCategoryDataset dataset = null;
        String sql = "SELECT * FROM CATEGORYDATA1;";
        Connection con = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取连接
            con = DriverManager.getConnection(url, user, password);

            dataset = new JDBCCategoryDataset(con);
            dataset.executeQuery(sql);
            // 结果集第一列列头是row key,从第二列开始每一列的列头都是一个column key,前面共用row
            // key,具体的值为column key对应的值

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart(
            "Java Standard Class Library  -Yves", // the chart title (null
                                                  // permitted).
            null, // the label for the category axis (null permitted).
            "Class Count", // the label for the value axis (null permitted).
            dataset, // the dataset for the chart (null permitted).
            PlotOrientation.VERTICAL, // the chart orientation (horizontal or
                                      // vertical) (null not permitted).
            false, // a flag specifying whether or not a legend is required
            true, // tool tips?
            false);// URLs?

        return chart;
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
}
