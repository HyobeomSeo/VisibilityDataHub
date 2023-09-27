package visibility.datahub.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import visibility.datahub.model.rcv.std.StandardTrackingData;

@Mapper
public interface StandardTrackingDataMapper {
	List<StandardTrackingData> findAll();

	StandardTrackingData findByTrackingDataNo(String trackingDataNo);

	void insert(StandardTrackingData trackingData);

	void update(StandardTrackingData trackingData);

	void deleteByTrackingDataNo(String trackingDataNo);
}
