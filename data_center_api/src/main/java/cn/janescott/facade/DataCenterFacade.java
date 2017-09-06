package cn.janescott.facade;

import cn.janescott.dto.DataBaseConfigDTO;

/**
 * Created by scott on 2017/9/5.
 */
public interface DataCenterFacade {
    /**
     * 初始化zookeeper配置节点数据
     * 暂时只有数据库配置数据，如果需要增加，
     * 可以在init实现中增加
     */
    void init();

    /**
     * 更新配置
     * @param configDTO
     */
    void updateDataBaseConfig(DataBaseConfigDTO configDTO);

    DataBaseConfigDTO getDataBaseConfig();
}
