package cn.janescott.common;

import cn.janescott.facade.DataCenterFacade;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;

/**
 * 服务启动之后执行的一些操作。
 * Created by scott on 2017/9/6.
 * @Url http://blog.csdn.net/lmy86263/article/details/52368334
 */
@Order(1)
public class StartupRunner implements CommandLineRunner{
    @Resource
    private DataCenterFacade facade;

    @Override
    public void run(String... args) throws Exception {
        facade.init();
    }
}
