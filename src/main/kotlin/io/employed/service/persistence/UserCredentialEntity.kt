package io.employed.service.persistence

import org.springframework.cassandra.core.PrimaryKeyType
import org.springframework.data.cassandra.mapping.Column
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.mapping.Table
import java.util.UUID

@Table(value = "users_credentials")
data class UserCredentialEntity(
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    val login: String,

    @Column
    val password: String,

    @Column(value = "user_id")
    val userId: UUID
)