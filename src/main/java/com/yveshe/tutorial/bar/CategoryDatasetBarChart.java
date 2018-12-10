/**
*
* Copyright:   Copyright (c)2016
* Company:     YvesHe
* @version:    1.0
* Create at:   2018年8月6日
* Description:
*
* Author       YvesHe
*/
package com.yveshe.tutorial.bar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

/**
 * 采用CategoryDataset的饼状图/直方条形图<br>
 *
 * 渲染器: StandardXYBarPainter(直方条形图),StandardXYBarPainter(饼状图)
 *
 *
 * 注意: CategoryDataset支持多系列,也就是说可以存在多个Series
 *
 *
 * CategoryDataset数据集对应有CategoryPlot和CategoryItemRenderer,
 * 本例子总Barchart对应BarRenderer(本例子没有强转而已)
 *
 * BarRenderer implements CategoryItemRenderer
 *
 *
 * @author Yves He
 *
 */
public class CategoryDatasetBarChart {

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row 1", "Column 1");
        dataset.addValue(5.0, "Row 1", "Column 2");
        dataset.addValue(3.0, "Row 1", "Column 3");
        dataset.addValue(2.0, "Row 2", "Column 1");
        dataset.addValue(3.0, "Row 2", "Column 2");
        dataset.addValue(2.0, "Row 2", "Column 3");
        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
            "BarChartDemo -Yves", // chart title
            "Category", // domain axis label
            "Value", // range axis label
            dataset, // data
            PlotOrientation.VERTICAL, // orientation
            true, // include legend
            true, // tooltips?
            // 图表的信息提示，是否要添加，有一个标志来控制——在上面的例子中，我们将这个标
            // 识设置为true，因此当我们在一个swing应用窗口显示这个图表时，我们会看到这个信息
            // 提示。

            false // URLs?
        );
        return chart;
    }

    public static void main(String[] args) {

        // create a chart...
        JFreeChart chart = createChart(createDataset());

        customizer(chart);

        // create and display a frame...
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);

    }

    private static void customizer(JFreeChart chart) {

        /** 一.对JFreeChart的常用设置 **/
        // 图表标题设置
        TextTitle title = new TextTitle(chart.getTitle().getText(), JFreeChart.DEFAULT_TITLE_FONT); // 还可以设置颜色,位置等...
        chart.setTitle(title);

        // 添加子标题
        chart.addSubtitle(new TextTitle("Yves", new Font("Dialog", 2, 10)));

        // 图表图例设置
        // chart.removeLegend();// 图例是默认显示的,可以remove不显示
        LegendTitle legend = chart.getLegend();
        // 图例外边线设置: 对所有类型的图表生效: Bar,Pie,Area
        if (legend != null) { // 注意时序图没有图例
            legend.setFrame(new BlockBorder(Color.RED));// 通过Color.WHITE隐藏
            legend.setItemPaint(Color.RED);// 设置图例画笔颜色(也就是文字颜色)
            legend.setBackgroundPaint(Color.DARK_GRAY);// 设置图例背景色
        }

        // 图表整个背景颜色设置
        chart.setBackgroundPaint(Color.PINK);
        Plot plot = chart.getPlot();
        // 图表绘制线条的透明度
        plot.setForegroundAlpha(1f);

        // 图表绘制背景透明度
        plot.setBackgroundAlpha(0.5F);

        // 图表绘制背景颜色
        plot.setBackgroundPaint(Color.BLUE);// 比如画图区域的背景颜色,要与报表的整个背景颜色区分开来

        // 图表绘制背景边框线设置
        plot.setOutlinePaint(Color.YELLOW);// 颜色
        plot.setOutlineStroke(new BasicStroke(2.f));// 大小
        plot.setOutlineVisible(true);// 是否显示

        CategoryPlot cPlot = chart.getCategoryPlot();
        /** 二.设置Plot范围下设置 **/

        // 设置背景中的网格线颜色,和是否显示
        cPlot.setDomainGridlinePaint(Color.white);
        cPlot.setDomainGridlinesVisible(true);// 竖线
        cPlot.setRangeGridlinePaint(Color.white);
        cPlot.setRangeGridlinesVisible(true);// 横线

        // 设置轴的平移值
        cPlot.setRangePannable(true);

        // 刻度轴刻度设置
        // Y轴设置
        NumberAxis numberaxis = (NumberAxis) cPlot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());// 设置Y轴增长单元
        numberaxis.setAutoRangeIncludesZero(true);// 起始坐标是否包括0
        // Y轴的标签通过实例化Chart的时候设置,实例化后可以通过该方法设置,null为不显示
        // numberaxis.setLabel(null);

        // Y轴显示格式定制
        // NumberAxis newNumberaxis = new NumberAxis("Percentage");// label
        // newNumberaxis.setNumberFormatOverride(new DecimalFormat("0.00%"));//
        // 显示百分比
        // cPlot.setRangeAxis(newNumberaxis);

        // X轴设置
        // 设置种类标签旋转为90度
        CategoryAxis domainAxis = cPlot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        // X轴的标签通过实例化Chart的时候设置,实例化后可以通过该方法设置,null为不显示
        // domainAxis.setLabel(null);
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);// 设置类别标签的位置

        // 设置边界数据的Margin(可以避免数据文字显示不了问题)
        domainAxis.setLowerMargin(0.2D);
        domainAxis.setUpperMargin(0.01D);

        // 标记范围值(值为3.0)
        ValueMarker localValueMarker = new ValueMarker(3.0D, new Color(200, 200, 255), new BasicStroke(1.0F), Color.BLACK, new BasicStroke(1.0F), 1.0F);
        cPlot.addRangeMarker(localValueMarker, Layer.BACKGROUND);

        /** 三.设置Renderer **/
        CategoryPlot a = null;
        CategoryItemRenderer renderer2 = a.getRenderer();

        BarRenderer renderer = (BarRenderer) cPlot.getRenderer();
        // 柱状图外廓线设置
        renderer.setDrawBarOutline(true);// 是否可见
        renderer.setBaseOutlineStroke(new BasicStroke(2.0f), true);// 外廓线粗细
        renderer.setBaseOutlinePaint(Color.BLUE); // 颜色设置
        // 注意: 基础的外廓线设置,如果只需要对指定的Series设定则使用setSeriesOutlinePaint方法

        // 设置柱状图渲染
        renderer.setBarPainter(new StandardBarPainter());// 标准的
        // renderer.setBarPainter(new GradientBarPainter()); //该渲染器颜色渐变设置无效果

        // 柱状图颜色渐变设置
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(64, 0, 0));
        GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
        GradientPaint gradientpaint3 = new GradientPaint(0.0F, 0.0F, Color.BLUE, 0.0F, 0.0F, new Color(64, 0, 0));
        renderer.setSeriesPaint(0, gradientpaint);
        renderer.setSeriesPaint(1, gradientpaint2);
        renderer.setSeriesPaint(2, gradientpaint3);

        // 柱状图标签Label设置
        renderer.setBaseItemLabelGenerator(new LabelGenerator());// 标签生成器,一定要设置
        renderer.setBaseItemLabelsVisible(true);// 是否显示标签,如果需要显示,则需要设置标签生成器
        ItemLabelPosition position1 = new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.CENTER_RIGHT, TextAnchor.CENTER_RIGHT, -1.570796326794897D);
        renderer.setBasePositiveItemLabelPosition(position1);// 设置基础的位置
        ItemLabelPosition position2 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, -1.570796326794897D);
        renderer.setPositiveItemLabelPositionFallback(position2);
        // 具体显示那些label

        // 柱状图各个Series之间的间隙大小设置
        renderer.setItemMargin(0.2f);// 0为取消两个Series之前的间隙

    }

    // 生成ItemLabel: 如果不需要显示Label,返回null值既可
    static class LabelGenerator extends StandardCategoryItemLabelGenerator {
        // StandardCategoryItemLabelGenerator
        // 提供简单API对指定Series的label进行显示或隐藏设置,但是如果是使用的自定义CategoryItemLabelGenerator则不会生效.
        // renderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);

        @Override
        public String generateLabel(CategoryDataset paramCategoryDataset, int rowKey, int columnKey) {
            Number value = paramCategoryDataset.getValue(rowKey, columnKey);
            return value.toString();
        }
    }

}
