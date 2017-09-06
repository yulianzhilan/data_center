package cn.janescott.service;

import cn.janescott.dto.DataBaseConfigDTO;
import cn.janescott.domain.ConfigEntity;

import java.util.List;

/**
 * Created by scott on 2017/9/5.
 */
public interface ConfigService {

    List<ConfigEntity> getConfigs(String category);
    ConfigEntity getConfig(Long id);
    ConfigEntity getConfig(String category, String name);

    DataBaseConfigDTO getDataBaseConfigDTO();

    void updateDataBaseConfigLocal(DataBaseConfigDTO configDTO);
    void updateDataBaseConfigCloud();

    void init();
}
