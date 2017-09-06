package cn.janescott.facade.impl;

import cn.janescott.dto.DataBaseConfigDTO;
import cn.janescott.facade.DataCenterFacade;
import cn.janescott.service.ConfigService;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * Created by scott on 2017/9/5.
 */
@Service(version = "1.0.0")
public class DataCenterFacadeImpl implements DataCenterFacade {
    @Resource
    private ConfigService configService;

    @Override
    public void init() {
        configService.init();
    }

    @Override
    public void updateDataBaseConfig(DataBaseConfigDTO configDTO) {
        configService.updateDataBaseConfigLocal(configDTO);
        configService.updateDataBaseConfigCloud();
    }

    @Override
    public DataBaseConfigDTO getDataBaseConfig() {
        return configService.getDataBaseConfigDTO();
    }
}
