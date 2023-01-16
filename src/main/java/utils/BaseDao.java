package utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseDao封装dao公共代码
 *  todo
 *   1。DQL（select）
 *   2。非DQL
 *
 * @author lzx
 * @date 2023/01/14 23:08
 **/
public abstract class BaseDao {

    //非 DQL
    public int executeUpdate(String sql, Object... params) throws SQLException {
        //params java的可变参数 类似于数组

        Connection connection = JdbcUtilV2.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        for (int i = 1; i <= params.length; i++) {
            ps.setObject(i, params[i - 1]);
        }

        int rows = ps.executeUpdate();

        ps.close();
        if (connection.getAutoCommit()) {
            // 如果未开启事物 可以关闭 .开启事务 就不用管连接了，业务层去处理
            JdbcUtilV2.freeConnection();
        }
        return rows;
    }

    /**
     * DQL  数据库表对应一个java 实体类,将查询结果封装到一个实体类中，返回一个实体类的集合
     * <T> 声明一个泛型，不确定类型
     * 1。确定泛型
     * 2。要使用反射技术给属性赋值
     */
    public <T> List<T> executeSelect(Class<T> clazz, String sql) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Connection connection = JdbcUtilV2.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<T> list = new ArrayList<>();

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {

            T t = clazz.newInstance(); //调用类的无参构造函数 实例化对象！

            for (int i = 1; i <= columnCount; i++) {
                Object value = rs.getObject(i);
                String columnName = metaData.getColumnName(i);

                //反射 给对象的属性赋值
                Field field = clazz.getDeclaredField(columnName);

                // 处理sql中datatime 和java中Date类型不匹配问题
                if (value.getClass().toString().equals("class java.time.LocalDateTime")) {
                    value = Timestamp.valueOf((LocalDateTime) value);
                }

                field.setAccessible(true); // 属性可以设置，目的是打破private 的修饰限制
                /**
                 *  参数1：要赋值的对象 如果属性是静态的，第一个参数可以不填（null）
                 *  参数2： 具体的属性值
                 */
                field.set(t, value);
            }
            list.add(t);
        }
        // 关闭资源
        rs.close();
        ps.close();
        if (connection.getAutoCommit()) {
            // 没有事务 可以关闭
            JdbcUtilV2.freeConnection();
        }
        return list;
    }
}
