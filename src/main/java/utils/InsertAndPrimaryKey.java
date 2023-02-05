package utils;

import org.junit.jupiter.api.Test;

import java.sql.*;

/***
 * @Author: lzx
 * @Description: 插入数据 并且获取数据库自增主键
 * @Date: 2023/1/16
 **/
public class InsertAndPrimaryKey extends BaseDao {

    @Test
    public void TestPrimaryKey() throws SQLException {
        Connection connection = JdbcUtilV2.getConnection();
        String sql = "insert into user(id,name) values(?,?);";

        //todo 创建ps时，告知携带数据库的自增主键
        PreparedStatement ps = connection.prepareStatement(sql, Statement.NO_GENERATED_KEYS);
        ps.setObject(1,6);
        ps.setObject(2,"lzx");
        int i = ps.executeUpdate();
        if (i>0){
            System.out.println("插入成功");
            //todo 获取ps装自增主键的结果集，取出自增主键。 注意：一次插入 rs 只有一行一列 （id=1）
            ResultSet rs_Keys = ps.getGeneratedKeys();
            rs_Keys.next();
            int primaryKey = rs_Keys.getInt(1);
            System.out.println("回显主键为：primaryKey = " + primaryKey);
        }
    }
}
