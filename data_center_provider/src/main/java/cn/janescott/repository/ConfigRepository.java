package cn.janescott.repository;

import cn.janescott.domain.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by scott on 2017/9/5.
 */
@Repository
public interface ConfigRepository extends JpaRepository<ConfigEntity, Long> {
    List<ConfigEntity> findAllByCategory(String category);

    ConfigEntity getOneByCategoryAndName(String category, String name);

    List<String> getDistinctCategory();
}
