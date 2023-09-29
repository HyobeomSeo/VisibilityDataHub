package visibility.datahub.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import visibility.datahub.model.rcv.train.dto.TrainTrackingLocationDto;

@Mapper
public interface TrainTrackingLocationMapper {
    List<TrainTrackingLocationDto> findAll();
    TrainTrackingLocationDto findById(Integer id);
    void insert(TrainTrackingLocationDto location);
    void update(TrainTrackingLocationDto location);
    void deleteById(Integer id);
}
