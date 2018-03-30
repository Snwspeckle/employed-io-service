// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol/user.proto

package io.employed.proto;

/**
 * Protobuf type {@code employed.io.Users}
 */
public  final class Users extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:employed.io.Users)
    UsersOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Users.newBuilder() to construct.
  private Users(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Users() {
    users_ = java.util.Collections.emptyList();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Users(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              users_ = new java.util.ArrayList<User>();
              mutable_bitField0_ |= 0x00000001;
            }
            users_.add(
                input.readMessage(User.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        users_ = java.util.Collections.unmodifiableList(users_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return UserProto.internal_static_employed_io_Users_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return UserProto.internal_static_employed_io_Users_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Users.class, Builder.class);
  }

  public static final int USERS_FIELD_NUMBER = 1;
  private java.util.List<User> users_;
  /**
   * <code>repeated .employed.io.User users = 1;</code>
   */
  public java.util.List<User> getUsersList() {
    return users_;
  }
  /**
   * <code>repeated .employed.io.User users = 1;</code>
   */
  public java.util.List<? extends UserOrBuilder>
      getUsersOrBuilderList() {
    return users_;
  }
  /**
   * <code>repeated .employed.io.User users = 1;</code>
   */
  public int getUsersCount() {
    return users_.size();
  }
  /**
   * <code>repeated .employed.io.User users = 1;</code>
   */
  public User getUsers(int index) {
    return users_.get(index);
  }
  /**
   * <code>repeated .employed.io.User users = 1;</code>
   */
  public UserOrBuilder getUsersOrBuilder(
      int index) {
    return users_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < users_.size(); i++) {
      output.writeMessage(1, users_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < users_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, users_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof Users)) {
      return super.equals(obj);
    }
    Users other = (Users) obj;

    boolean result = true;
    result = result && getUsersList()
        .equals(other.getUsersList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getUsersCount() > 0) {
      hash = (37 * hash) + USERS_FIELD_NUMBER;
      hash = (53 * hash) + getUsersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Users parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Users parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Users parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Users parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Users parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Users parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Users parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Users parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Users parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Users parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Users parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Users parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Users prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code employed.io.Users}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:employed.io.Users)
      io.employed.proto.UsersOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return UserProto.internal_static_employed_io_Users_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return UserProto.internal_static_employed_io_Users_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Users.class, Builder.class);
    }

    // Construct using io.employed.proto.Users.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getUsersFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (usersBuilder_ == null) {
        users_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        usersBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return UserProto.internal_static_employed_io_Users_descriptor;
    }

    public Users getDefaultInstanceForType() {
      return Users.getDefaultInstance();
    }

    public Users build() {
      Users result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public Users buildPartial() {
      Users result = new Users(this);
      int from_bitField0_ = bitField0_;
      if (usersBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          users_ = java.util.Collections.unmodifiableList(users_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.users_ = users_;
      } else {
        result.users_ = usersBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof Users) {
        return mergeFrom((Users)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Users other) {
      if (other == Users.getDefaultInstance()) return this;
      if (usersBuilder_ == null) {
        if (!other.users_.isEmpty()) {
          if (users_.isEmpty()) {
            users_ = other.users_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureUsersIsMutable();
            users_.addAll(other.users_);
          }
          onChanged();
        }
      } else {
        if (!other.users_.isEmpty()) {
          if (usersBuilder_.isEmpty()) {
            usersBuilder_.dispose();
            usersBuilder_ = null;
            users_ = other.users_;
            bitField0_ = (bitField0_ & ~0x00000001);
            usersBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getUsersFieldBuilder() : null;
          } else {
            usersBuilder_.addAllMessages(other.users_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Users parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (Users) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<User> users_ =
      java.util.Collections.emptyList();
    private void ensureUsersIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        users_ = new java.util.ArrayList<User>(users_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        User, User.Builder, UserOrBuilder> usersBuilder_;

    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public java.util.List<User> getUsersList() {
      if (usersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(users_);
      } else {
        return usersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public int getUsersCount() {
      if (usersBuilder_ == null) {
        return users_.size();
      } else {
        return usersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public User getUsers(int index) {
      if (usersBuilder_ == null) {
        return users_.get(index);
      } else {
        return usersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public Builder setUsers(
        int index, User value) {
      if (usersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUsersIsMutable();
        users_.set(index, value);
        onChanged();
      } else {
        usersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public Builder setUsers(
        int index, User.Builder builderForValue) {
      if (usersBuilder_ == null) {
        ensureUsersIsMutable();
        users_.set(index, builderForValue.build());
        onChanged();
      } else {
        usersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public Builder addUsers(User value) {
      if (usersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUsersIsMutable();
        users_.add(value);
        onChanged();
      } else {
        usersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public Builder addUsers(
        int index, User value) {
      if (usersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUsersIsMutable();
        users_.add(index, value);
        onChanged();
      } else {
        usersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public Builder addUsers(
        User.Builder builderForValue) {
      if (usersBuilder_ == null) {
        ensureUsersIsMutable();
        users_.add(builderForValue.build());
        onChanged();
      } else {
        usersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public Builder addUsers(
        int index, User.Builder builderForValue) {
      if (usersBuilder_ == null) {
        ensureUsersIsMutable();
        users_.add(index, builderForValue.build());
        onChanged();
      } else {
        usersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public Builder addAllUsers(
        Iterable<? extends User> values) {
      if (usersBuilder_ == null) {
        ensureUsersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, users_);
        onChanged();
      } else {
        usersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public Builder clearUsers() {
      if (usersBuilder_ == null) {
        users_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        usersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public Builder removeUsers(int index) {
      if (usersBuilder_ == null) {
        ensureUsersIsMutable();
        users_.remove(index);
        onChanged();
      } else {
        usersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public User.Builder getUsersBuilder(
        int index) {
      return getUsersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public UserOrBuilder getUsersOrBuilder(
        int index) {
      if (usersBuilder_ == null) {
        return users_.get(index);  } else {
        return usersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public java.util.List<? extends UserOrBuilder>
         getUsersOrBuilderList() {
      if (usersBuilder_ != null) {
        return usersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(users_);
      }
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public User.Builder addUsersBuilder() {
      return getUsersFieldBuilder().addBuilder(
          User.getDefaultInstance());
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public User.Builder addUsersBuilder(
        int index) {
      return getUsersFieldBuilder().addBuilder(
          index, User.getDefaultInstance());
    }
    /**
     * <code>repeated .employed.io.User users = 1;</code>
     */
    public java.util.List<User.Builder>
         getUsersBuilderList() {
      return getUsersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        User, User.Builder, UserOrBuilder>
        getUsersFieldBuilder() {
      if (usersBuilder_ == null) {
        usersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            User, User.Builder, UserOrBuilder>(
                users_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        users_ = null;
      }
      return usersBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:employed.io.Users)
  }

  // @@protoc_insertion_point(class_scope:employed.io.Users)
  private static final Users DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Users();
  }

  public static Users getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Users>
      PARSER = new com.google.protobuf.AbstractParser<Users>() {
    public Users parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Users(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Users> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Users> getParserForType() {
    return PARSER;
  }

  public Users getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

