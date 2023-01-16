package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbcUtil
 * @author lzx
 *  jdbc常用工具类
 *  1.静态方法
 *  2.单例模式
 * todo
 *  利用本地线成变量 存储连接信息！确保一个程序中一个线程的多个方法获取的是同一个connection，避免多次创建连接
 *  例如service层 和dao层 属于同一个线程 不同方法使用同一个connection
 *
 * @date 2023/01/14 22:15
 **/
public class JdbcUtilV2 {
    private static DataSource dataSource = null;
    //本地线程变量 负责存储数据库的连接信息
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        // 静态代码快 初始化连接池
        Properties properties = new Properties();
        //文件 输入流
        InputStream inputStream = JdbcUtilV2.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //对外提供连接的方法
     public static Connection getConnection() throws SQLException {
        //先看本地线程变量里有没有
         if (threadLocal.get() == null) {
             threadLocal.set(dataSource.getConnection());
         }
         return threadLocal.get();
     }

     //关闭连接的方法
    public static void freeConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection != null) {
            threadLocal.remove(); //关闭连接前 移除线程本地变量
            connection.setAutoCommit(true); // 事物状态回归。 处理程序可能开启过事物
            connection.close();
        }
    }
}
