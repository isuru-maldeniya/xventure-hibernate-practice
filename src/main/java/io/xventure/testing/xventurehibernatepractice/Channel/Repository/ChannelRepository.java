package io.xventure.testing.xventurehibernatepractice.Channel.Repository;

import io.xventure.testing.xventurehibernatepractice.Channel.Entity.Channel;
import org.springframework.data.repository.CrudRepository;

public interface ChannelRepository extends CrudRepository<Channel,Integer> {
}
