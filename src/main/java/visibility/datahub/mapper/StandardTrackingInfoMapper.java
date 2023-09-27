package visibility.datahub.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import visibility.datahub.model.rcv.std.StandardTrackingInfo;

@Mapper
public interface StandardTrackingInfoMapper {
	List<StandardTrackingInfo> findAll();

	StandardTrackingInfo findById(Integer id);

	List<StandardTrackingInfo> findByTrackingDataNo(String trackingDataNo);

	void insert(StandardTrackingInfo info);

	void update(StandardTrackingInfo info);

	void deleteById(Integer id);
}
