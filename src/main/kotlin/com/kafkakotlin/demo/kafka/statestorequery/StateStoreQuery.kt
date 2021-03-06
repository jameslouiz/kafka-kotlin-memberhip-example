package com.kafkakotlin.demo.kafka.statestorequery

import com.kafkakotlin.demo.users.User
import org.apache.kafka.streams.StoreQueryParameters
import org.apache.kafka.streams.state.QueryableStoreTypes
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore
import org.springframework.kafka.config.StreamsBuilderFactoryBean
import org.springframework.stereotype.Component

@Component
class StateStoreQuery(
    private val streamsBuilderFactoryBean: StreamsBuilderFactoryBean
) {
    fun getStore(): ReadOnlyKeyValueStore<String, User> {
        return streamsBuilderFactoryBean
            .kafkaStreams
            .store(StoreQueryParameters.fromNameAndType("user-store", QueryableStoreTypes.keyValueStore<String, User>()))
    }
}
