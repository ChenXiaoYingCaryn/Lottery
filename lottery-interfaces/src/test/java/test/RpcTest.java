package test;

import cn.hutool.json.JSONUtil;
import cn.itedus.lottery.LotteryApplication;
import cn.itedus.lottery.rpc.IActivityBooth;
import cn.itedus.lottery.rpc.req.ActivityReq;
import cn.itedus.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author xiaoying
 * @create 2024/7/7 15:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryApplication.class)
public class RpcTest {

    private Logger logger = LoggerFactory.getLogger(RpcTest.class);

    @Reference(interfaceClass = IActivityBooth.class, url = "dubbo://127.0.0.1:20880")
    private IActivityBooth iActivityBooth;

    @Test
    public void test_rpc(){
        ActivityReq req = new ActivityReq();
        req.setActivityId(100002L);
        ActivityRes res = iActivityBooth.queryActivityById(req);
        logger.info("测试结果：{}", JSONUtil.toJsonStr(res));
    }

}
