package com.exam.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 */
public class PageCalculateUtil {

    public static final Integer WINDOW_SIZE = 5;       // 分页的滑动窗口大小

    /**
     * 计算页码工具(默认窗口大小为5)
     *暂时只知道不足5的返回全部，比5大的，返回的5个整数，当前页面在第3个
     *
     * @param page      当前页
     * @param totalPage 总共页码
     * @return
     */
    public static List<Integer> getPageNumbers(Integer page, Integer totalPage) {
        return getPageNumbers(page, totalPage, WINDOW_SIZE);
    }

    /**
     * 计算页码工具
     *
     * @param page       当前页
     * @param totalPage  总共页码
     * @param windowSize 窗口大小
     * @return
     */
    public static List<Integer> getPageNumbers(Integer page, Integer totalPage, Integer windowSize) {

        List<Integer> pageNumbers = new ArrayList<Integer>();

        if (totalPage <= windowSize) {  //如果全部的页数比滑动窗口小的话，把所有的页号加入到List中
            for (int i = 1; i <= totalPage; i++) {
                pageNumbers.add(i);
            }
        } else {
            if (page <= (1 + windowSize / 2)) {
                for (int i = 1; i <= windowSize; i++) {
                    pageNumbers.add(i);
                }
            } else if (page >= totalPage - windowSize / 2) {
                for (int i = windowSize; i >= 1; i--) {
                    pageNumbers.add(totalPage - i + 1);
                }
            } else {
                for (int i = 1, offset = -1 * windowSize / 2; i <= windowSize; i++, offset++) {
                    pageNumbers.add(page + offset);
                }
            }
        }

        return pageNumbers;
    }
}
