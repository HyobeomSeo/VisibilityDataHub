package visibility.datahub.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import visibility.datahub.model.rcv.train.dto.TrainTrackingDataDto;

@Mapper
public interface TrainTrackingDataMapper {
    List<TrainTrackingDataDto> findAll();
    TrainTrackingDataDto findByIfid(String ifid);
    void insert(TrainTrackingDataDto data);
    void update(TrainTrackingDataDto data);
    void deleteByIfid(String ifid);
}

