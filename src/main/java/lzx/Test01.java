package lzx;

import org.junit.jupiter.api.Test;
import utils.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author lzx
 * @date 2023/01/15 19:56
 **/

public class Test01 extends BaseDao {

    @Test
    public void testSelect () throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        String sql = "select * from tb_video_info";
        List<VideoInfo> videoInfos = executeSelect(VideoInfo.class, sql);
        System.out.println("videoInfos.toString() = " + videoInfos.toString());
    }
}
