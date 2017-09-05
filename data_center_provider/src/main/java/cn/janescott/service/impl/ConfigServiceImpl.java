package cn.janescott.service.impl;

import cn.janescott.common.Constants;
import cn.janescott.common.ZKUtil;
import cn.janescott.domain.dto.DataBaseConfigDTO;
import cn.janescott.domain.entity.ConfigEntity;
import cn.janescott.repository.ConfigRepository;
import cn.janescott.service.ConfigService;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by scott on 2017/9/5.
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigRepository configRepository;

    @Override
    public List<ConfigEntity> getConfigs(String category) {
        Assert.notNull(category);
        return configRepository.findAllByCategory(category);
    }

    @Override
    public ConfigEntity getConfig(Long id) {
        Assert.notNull(id);
        return configRepository.getOne(id);
    }

    @Override
    public ConfigEntity getConfig(String category, String name) {
        Assert.notNull(category);
        Assert.notNull(name);
        return configRepository.getOneByCategoryAndName(category, name);
    }

    @Override
    public DataBaseConfigDTO getDataBaseConfigDTO() {
        List<ConfigEntity> configs = getConfigs(Constants.DATABASE_CONFIG_CATEGORY);
        if (!CollectionUtils.isEmpty(configs)) {
            DataBaseConfigDTO configDTO = new DataBaseConfigDTO();
            for (ConfigEntity entity : configs) {
                if (entity != null && !StringUtils.isEmpty(entity.getName())) {
                    try {
                        Field field = configDTO.getClass().getDeclaredField(entity.getName());
                        field.set(configDTO, entity.getKey());
                    } catch (Exception e){
                        //todo log配置
                        e.printStackTrace();
                    }
                }
            }
            return configDTO;
        }
        return null;
    }

    @Override
    public void updateDataBaseConfigLocal(DataBaseConfigDTO configDTO) {
        if (configDTO != null){
            Field[] declaredFields = configDTO.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                String name = field.getName();
//                String key = field.get(name);
                ConfigEntity entity = new ConfigEntity();

            }
        }
    }

    @Override
    public void updateDataBaseConfigCloud(DataBaseConfigDTO configDTO) {
        ZkClient zkClient = ZKUtil.getZKClient();
        if (!zkClient.exists(Constants.DATABASE_CONFIG)){
            zkClient.createPersistent(Constants.DATABASE_CONFIG, true);
        }
        zkClient.writeData(Constants.DATABASE_CONFIG, configDTO);
        zkClient.close();
    }

    @Override
    public void init() {
        updateDataBaseConfigCloud(getDataBaseConfigDTO());
    }
}
