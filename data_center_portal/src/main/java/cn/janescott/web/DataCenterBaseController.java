package cn.janescott.web;

import cn.janescott.dto.DataBaseConfigDTO;
import cn.janescott.facade.DataCenterFacade;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by scott on 2017/9/6.
 */
@Controller
@RequestMapping("/base")
public class DataCenterBaseController {
    @Reference(version = "1.0.0")
    private DataCenterFacade facade;

    @RequestMapping("/index")
    @ResponseBody
    public DataBaseConfigDTO init(){
        return facade.getDataBaseConfig();
    }
}
