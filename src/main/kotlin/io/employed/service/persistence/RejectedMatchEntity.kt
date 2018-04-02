package io.employed.service.persistence

import org.springframework.cassandra.core.PrimaryKeyType
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.mapping.Table
import java.util.UUID

@Table(value = "rejected_matches")
data class RejectedMatchEntity(
    @PrimaryKeyColumn(name = "user_id", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    val userId: UUID,

    @PrimaryKeyColumn(name = "match_user_id", type = PrimaryKeyType.PARTITIONED, ordinal = 1)
    val matchUserId: UUID
)