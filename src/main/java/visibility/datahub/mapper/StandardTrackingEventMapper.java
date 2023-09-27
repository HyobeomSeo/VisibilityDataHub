package visibility.datahub.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import visibility.datahub.model.rcv.std.StandardTrackingEvent;

@Mapper
public interface StandardTrackingEventMapper {
	List<StandardTrackingEvent> findAll();

	StandardTrackingEvent findById(Integer id);

	List<StandardTrackingEvent> findByTrackingDataNo(String trackingDataNo);
	
	void insert(StandardTrackingEvent event);

	void update(StandardTrackingEvent event);

	void deleteById(Integer id);
}
