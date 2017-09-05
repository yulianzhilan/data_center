package cn.janescott.facade;

import cn.janescott.domain.dto.DataBaseConfigDTO;

/**
 * Created by scott on 2017/9/5.
 */
public interface DataCenterFacade {
    void init();

    void updateDataBaseConfig(DataBaseConfigDTO configDTO);
}
