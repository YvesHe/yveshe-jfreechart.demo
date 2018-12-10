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
package com.yveshe.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * JFreeChart 提供数据源
 *
 * @author Yves He
 *
 */
public class DataSourceUtil {

    // 通过Demo,我们发现JFreeChart中DataSet最终都是通过在将数据封装在DataSet后然后进行报表生成的,所以关于数据的来源可以随便自己定义

    // 1.可以来源于数据库
    // 2.也可以来源于外部的硬盘

    // 只要自己将解析的数据对应的放在DataSet中去然后再生成报表既可

    private void demoMysql() throws ClassNotFoundException, SQLException, IOException { /*
                                                                                         * Create
                                                                                         * MySQL
                                                                                         * Database
                                                                                         * Connection
                                                                                         */
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/jf_testdb",
            "root",
            ""
                + "");

        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from mobile_data");
        DefaultPieDataset dataset = new DefaultPieDataset();

        while (resultSet.next()) {
            dataset.setValue(
                resultSet.getString("mobile_brand"),
                Double.parseDouble(resultSet.getString("unit_sale")));
        }

        JFreeChart chart = ChartFactory.createPieChart(
            "Mobile Sales", // chart title
            dataset, // data
            true, // include legend
            true,
            false);

        int width = 560; /* Width of the image */
        int height = 370; /* Height of the image */
        File pieChart = new File("Pie_Chart.jpeg");
        ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
    }

}
