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
    public DataBaseConfigDTO getDataBaseConfigDTO(List<ConfigEntity> configs) {
        DataBaseConfigDTO configDTO = new DataBaseConfigDTO();

        return null;
    }

    @Override
    public void updateDataBaseConfigLocal(DataBaseConfigDTO configDTO) {

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
        List<String> categories = configRepository.getDistinctCategory();
        if (!CollectionUtils.isEmpty(categories)) {
            for (String category : categories) {
                if (!StringUtils.isEmpty(category)) {
                    try {
                        List<ConfigEntity> configs = getConfigs(category);
                        Class<?> aClass = Class.forName(category);
                        Object instance = aClass.newInstance();
                        if (instance instanceof DataBaseConfigDTO) {

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
