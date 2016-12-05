package pl.allegro.tech.hermes.api;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;
import java.util.Objects;

public class SubscriptionFetchingConfiguration {
    private static final int DEFAULT_MAX_FETCH_BYTES = 100 * 1024;

    private int maxPartitionFetchBytes;

    public SubscriptionFetchingConfiguration() {
        this(DEFAULT_MAX_FETCH_BYTES);
    }

    public SubscriptionFetchingConfiguration(int maxPartitionFetchBytes) {
        this.maxPartitionFetchBytes = maxPartitionFetchBytes;
    }

    public int getMaxPartitionFetchBytes() {
        return maxPartitionFetchBytes;
    }

    @JsonCreator
    public static SubscriptionFetchingConfiguration create(Map<String, Object> properties) {
        return new SubscriptionFetchingConfiguration(
                (Integer) properties.getOrDefault("maxPartitionFetchBytes", DEFAULT_MAX_FETCH_BYTES)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionFetchingConfiguration that = (SubscriptionFetchingConfiguration) o;
        return maxPartitionFetchBytes == that.maxPartitionFetchBytes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxPartitionFetchBytes);
    }
}
