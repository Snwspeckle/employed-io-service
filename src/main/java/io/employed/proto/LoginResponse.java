// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol/login/login_request.proto

package io.employed.proto;

/**
 * Protobuf type {@code employed.io.LoginResponse}
 */
public  final class LoginResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:employed.io.LoginResponse)
    LoginResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LoginResponse.newBuilder() to construct.
  private LoginResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LoginResponse() {
    status_ = 0;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LoginResponse(
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
          case 8: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          case 18: {
            User.Builder subBuilder = null;
            if (user_ != null) {
              subBuilder = user_.toBuilder();
            }
            user_ = input.readMessage(User.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(user_);
              user_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            JobSeeker.Builder subBuilder = null;
            if (userTypeCase_ == 3) {
              subBuilder = ((JobSeeker) userType_).toBuilder();
            }
            userType_ =
                input.readMessage(JobSeeker.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((JobSeeker) userType_);
              userType_ = subBuilder.buildPartial();
            }
            userTypeCase_ = 3;
            break;
          }
          case 34: {
            Recruiter.Builder subBuilder = null;
            if (userTypeCase_ == 4) {
              subBuilder = ((Recruiter) userType_).toBuilder();
            }
            userType_ =
                input.readMessage(Recruiter.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((Recruiter) userType_);
              userType_ = subBuilder.buildPartial();
            }
            userTypeCase_ = 4;
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return LoginRequestProto.internal_static_employed_io_LoginResponse_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return LoginRequestProto.internal_static_employed_io_LoginResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            LoginResponse.class, Builder.class);
  }

  private int userTypeCase_ = 0;
  private Object userType_;
  public enum UserTypeCase
      implements com.google.protobuf.Internal.EnumLite {
    JOB_SEEKER(3),
    RECRUITER(4),
    USERTYPE_NOT_SET(0);
    private final int value;
    private UserTypeCase(int value) {
      this.value = value;
    }
    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @Deprecated
    public static UserTypeCase valueOf(int value) {
      return forNumber(value);
    }

    public static UserTypeCase forNumber(int value) {
      switch (value) {
        case 3: return JOB_SEEKER;
        case 4: return RECRUITER;
        case 0: return USERTYPE_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public UserTypeCase
  getUserTypeCase() {
    return UserTypeCase.forNumber(
        userTypeCase_);
  }

  public static final int STATUS_FIELD_NUMBER = 1;
  private int status_;
  /**
   * <code>.employed.io.Status status = 1;</code>
   */
  public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.employed.io.Status status = 1;</code>
   */
  public Status getStatus() {
    Status result = Status.valueOf(status_);
    return result == null ? Status.UNRECOGNIZED : result;
  }

  public static final int USER_FIELD_NUMBER = 2;
  private User user_;
  /**
   * <code>.employed.io.User user = 2;</code>
   */
  public boolean hasUser() {
    return user_ != null;
  }
  /**
   * <code>.employed.io.User user = 2;</code>
   */
  public User getUser() {
    return user_ == null ? User.getDefaultInstance() : user_;
  }
  /**
   * <code>.employed.io.User user = 2;</code>
   */
  public UserOrBuilder getUserOrBuilder() {
    return getUser();
  }

  public static final int JOB_SEEKER_FIELD_NUMBER = 3;
  /**
   * <code>.employed.io.JobSeeker job_seeker = 3;</code>
   */
  public boolean hasJobSeeker() {
    return userTypeCase_ == 3;
  }
  /**
   * <code>.employed.io.JobSeeker job_seeker = 3;</code>
   */
  public JobSeeker getJobSeeker() {
    if (userTypeCase_ == 3) {
       return (JobSeeker) userType_;
    }
    return JobSeeker.getDefaultInstance();
  }
  /**
   * <code>.employed.io.JobSeeker job_seeker = 3;</code>
   */
  public JobSeekerOrBuilder getJobSeekerOrBuilder() {
    if (userTypeCase_ == 3) {
       return (JobSeeker) userType_;
    }
    return JobSeeker.getDefaultInstance();
  }

  public static final int RECRUITER_FIELD_NUMBER = 4;
  /**
   * <code>.employed.io.Recruiter recruiter = 4;</code>
   */
  public boolean hasRecruiter() {
    return userTypeCase_ == 4;
  }
  /**
   * <code>.employed.io.Recruiter recruiter = 4;</code>
   */
  public Recruiter getRecruiter() {
    if (userTypeCase_ == 4) {
       return (Recruiter) userType_;
    }
    return Recruiter.getDefaultInstance();
  }
  /**
   * <code>.employed.io.Recruiter recruiter = 4;</code>
   */
  public RecruiterOrBuilder getRecruiterOrBuilder() {
    if (userTypeCase_ == 4) {
       return (Recruiter) userType_;
    }
    return Recruiter.getDefaultInstance();
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
    if (status_ != Status.SUCCESS.getNumber()) {
      output.writeEnum(1, status_);
    }
    if (user_ != null) {
      output.writeMessage(2, getUser());
    }
    if (userTypeCase_ == 3) {
      output.writeMessage(3, (JobSeeker) userType_);
    }
    if (userTypeCase_ == 4) {
      output.writeMessage(4, (Recruiter) userType_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (status_ != Status.SUCCESS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, status_);
    }
    if (user_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getUser());
    }
    if (userTypeCase_ == 3) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, (JobSeeker) userType_);
    }
    if (userTypeCase_ == 4) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, (Recruiter) userType_);
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
    if (!(obj instanceof LoginResponse)) {
      return super.equals(obj);
    }
    LoginResponse other = (LoginResponse) obj;

    boolean result = true;
    result = result && status_ == other.status_;
    result = result && (hasUser() == other.hasUser());
    if (hasUser()) {
      result = result && getUser()
          .equals(other.getUser());
    }
    result = result && getUserTypeCase().equals(
        other.getUserTypeCase());
    if (!result) return false;
    switch (userTypeCase_) {
      case 3:
        result = result && getJobSeeker()
            .equals(other.getJobSeeker());
        break;
      case 4:
        result = result && getRecruiter()
            .equals(other.getRecruiter());
        break;
      case 0:
      default:
    }
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
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    if (hasUser()) {
      hash = (37 * hash) + USER_FIELD_NUMBER;
      hash = (53 * hash) + getUser().hashCode();
    }
    switch (userTypeCase_) {
      case 3:
        hash = (37 * hash) + JOB_SEEKER_FIELD_NUMBER;
        hash = (53 * hash) + getJobSeeker().hashCode();
        break;
      case 4:
        hash = (37 * hash) + RECRUITER_FIELD_NUMBER;
        hash = (53 * hash) + getRecruiter().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static LoginResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static LoginResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static LoginResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static LoginResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static LoginResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static LoginResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static LoginResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static LoginResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static LoginResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static LoginResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static LoginResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static LoginResponse parseFrom(
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
  public static Builder newBuilder(LoginResponse prototype) {
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
   * Protobuf type {@code employed.io.LoginResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:employed.io.LoginResponse)
      LoginResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return LoginRequestProto.internal_static_employed_io_LoginResponse_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return LoginRequestProto.internal_static_employed_io_LoginResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              LoginResponse.class, Builder.class);
    }

    // Construct using io.employed.proto.LoginResponse.newBuilder()
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
      }
    }
    public Builder clear() {
      super.clear();
      status_ = 0;

      if (userBuilder_ == null) {
        user_ = null;
      } else {
        user_ = null;
        userBuilder_ = null;
      }
      userTypeCase_ = 0;
      userType_ = null;
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return LoginRequestProto.internal_static_employed_io_LoginResponse_descriptor;
    }

    public LoginResponse getDefaultInstanceForType() {
      return LoginResponse.getDefaultInstance();
    }

    public LoginResponse build() {
      LoginResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public LoginResponse buildPartial() {
      LoginResponse result = new LoginResponse(this);
      result.status_ = status_;
      if (userBuilder_ == null) {
        result.user_ = user_;
      } else {
        result.user_ = userBuilder_.build();
      }
      if (userTypeCase_ == 3) {
        if (jobSeekerBuilder_ == null) {
          result.userType_ = userType_;
        } else {
          result.userType_ = jobSeekerBuilder_.build();
        }
      }
      if (userTypeCase_ == 4) {
        if (recruiterBuilder_ == null) {
          result.userType_ = userType_;
        } else {
          result.userType_ = recruiterBuilder_.build();
        }
      }
      result.userTypeCase_ = userTypeCase_;
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
      if (other instanceof LoginResponse) {
        return mergeFrom((LoginResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(LoginResponse other) {
      if (other == LoginResponse.getDefaultInstance()) return this;
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (other.hasUser()) {
        mergeUser(other.getUser());
      }
      switch (other.getUserTypeCase()) {
        case JOB_SEEKER: {
          mergeJobSeeker(other.getJobSeeker());
          break;
        }
        case RECRUITER: {
          mergeRecruiter(other.getRecruiter());
          break;
        }
        case USERTYPE_NOT_SET: {
          break;
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
      LoginResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (LoginResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int userTypeCase_ = 0;
    private Object userType_;
    public UserTypeCase
        getUserTypeCase() {
      return UserTypeCase.forNumber(
          userTypeCase_);
    }

    public Builder clearUserType() {
      userTypeCase_ = 0;
      userType_ = null;
      onChanged();
      return this;
    }


    private int status_ = 0;
    /**
     * <code>.employed.io.Status status = 1;</code>
     */
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.employed.io.Status status = 1;</code>
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.employed.io.Status status = 1;</code>
     */
    public Status getStatus() {
      Status result = Status.valueOf(status_);
      return result == null ? Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.employed.io.Status status = 1;</code>
     */
    public Builder setStatus(Status value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.employed.io.Status status = 1;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private User user_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        User, User.Builder, UserOrBuilder> userBuilder_;
    /**
     * <code>.employed.io.User user = 2;</code>
     */
    public boolean hasUser() {
      return userBuilder_ != null || user_ != null;
    }
    /**
     * <code>.employed.io.User user = 2;</code>
     */
    public User getUser() {
      if (userBuilder_ == null) {
        return user_ == null ? User.getDefaultInstance() : user_;
      } else {
        return userBuilder_.getMessage();
      }
    }
    /**
     * <code>.employed.io.User user = 2;</code>
     */
    public Builder setUser(User value) {
      if (userBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        user_ = value;
        onChanged();
      } else {
        userBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.employed.io.User user = 2;</code>
     */
    public Builder setUser(
        User.Builder builderForValue) {
      if (userBuilder_ == null) {
        user_ = builderForValue.build();
        onChanged();
      } else {
        userBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.employed.io.User user = 2;</code>
     */
    public Builder mergeUser(User value) {
      if (userBuilder_ == null) {
        if (user_ != null) {
          user_ =
            User.newBuilder(user_).mergeFrom(value).buildPartial();
        } else {
          user_ = value;
        }
        onChanged();
      } else {
        userBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.employed.io.User user = 2;</code>
     */
    public Builder clearUser() {
      if (userBuilder_ == null) {
        user_ = null;
        onChanged();
      } else {
        user_ = null;
        userBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.employed.io.User user = 2;</code>
     */
    public User.Builder getUserBuilder() {
      
      onChanged();
      return getUserFieldBuilder().getBuilder();
    }
    /**
     * <code>.employed.io.User user = 2;</code>
     */
    public UserOrBuilder getUserOrBuilder() {
      if (userBuilder_ != null) {
        return userBuilder_.getMessageOrBuilder();
      } else {
        return user_ == null ?
            User.getDefaultInstance() : user_;
      }
    }
    /**
     * <code>.employed.io.User user = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        User, User.Builder, UserOrBuilder>
        getUserFieldBuilder() {
      if (userBuilder_ == null) {
        userBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            User, User.Builder, UserOrBuilder>(
                getUser(),
                getParentForChildren(),
                isClean());
        user_ = null;
      }
      return userBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        JobSeeker, JobSeeker.Builder, JobSeekerOrBuilder> jobSeekerBuilder_;
    /**
     * <code>.employed.io.JobSeeker job_seeker = 3;</code>
     */
    public boolean hasJobSeeker() {
      return userTypeCase_ == 3;
    }
    /**
     * <code>.employed.io.JobSeeker job_seeker = 3;</code>
     */
    public JobSeeker getJobSeeker() {
      if (jobSeekerBuilder_ == null) {
        if (userTypeCase_ == 3) {
          return (JobSeeker) userType_;
        }
        return JobSeeker.getDefaultInstance();
      } else {
        if (userTypeCase_ == 3) {
          return jobSeekerBuilder_.getMessage();
        }
        return JobSeeker.getDefaultInstance();
      }
    }
    /**
     * <code>.employed.io.JobSeeker job_seeker = 3;</code>
     */
    public Builder setJobSeeker(JobSeeker value) {
      if (jobSeekerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        userType_ = value;
        onChanged();
      } else {
        jobSeekerBuilder_.setMessage(value);
      }
      userTypeCase_ = 3;
      return this;
    }
    /**
     * <code>.employed.io.JobSeeker job_seeker = 3;</code>
     */
    public Builder setJobSeeker(
        JobSeeker.Builder builderForValue) {
      if (jobSeekerBuilder_ == null) {
        userType_ = builderForValue.build();
        onChanged();
      } else {
        jobSeekerBuilder_.setMessage(builderForValue.build());
      }
      userTypeCase_ = 3;
      return this;
    }
    /**
     * <code>.employed.io.JobSeeker job_seeker = 3;</code>
     */
    public Builder mergeJobSeeker(JobSeeker value) {
      if (jobSeekerBuilder_ == null) {
        if (userTypeCase_ == 3 &&
            userType_ != JobSeeker.getDefaultInstance()) {
          userType_ = JobSeeker.newBuilder((JobSeeker) userType_)
              .mergeFrom(value).buildPartial();
        } else {
          userType_ = value;
        }
        onChanged();
      } else {
        if (userTypeCase_ == 3) {
          jobSeekerBuilder_.mergeFrom(value);
        }
        jobSeekerBuilder_.setMessage(value);
      }
      userTypeCase_ = 3;
      return this;
    }
    /**
     * <code>.employed.io.JobSeeker job_seeker = 3;</code>
     */
    public Builder clearJobSeeker() {
      if (jobSeekerBuilder_ == null) {
        if (userTypeCase_ == 3) {
          userTypeCase_ = 0;
          userType_ = null;
          onChanged();
        }
      } else {
        if (userTypeCase_ == 3) {
          userTypeCase_ = 0;
          userType_ = null;
        }
        jobSeekerBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.employed.io.JobSeeker job_seeker = 3;</code>
     */
    public JobSeeker.Builder getJobSeekerBuilder() {
      return getJobSeekerFieldBuilder().getBuilder();
    }
    /**
     * <code>.employed.io.JobSeeker job_seeker = 3;</code>
     */
    public JobSeekerOrBuilder getJobSeekerOrBuilder() {
      if ((userTypeCase_ == 3) && (jobSeekerBuilder_ != null)) {
        return jobSeekerBuilder_.getMessageOrBuilder();
      } else {
        if (userTypeCase_ == 3) {
          return (JobSeeker) userType_;
        }
        return JobSeeker.getDefaultInstance();
      }
    }
    /**
     * <code>.employed.io.JobSeeker job_seeker = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        JobSeeker, JobSeeker.Builder, JobSeekerOrBuilder>
        getJobSeekerFieldBuilder() {
      if (jobSeekerBuilder_ == null) {
        if (!(userTypeCase_ == 3)) {
          userType_ = JobSeeker.getDefaultInstance();
        }
        jobSeekerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            JobSeeker, JobSeeker.Builder, JobSeekerOrBuilder>(
                (JobSeeker) userType_,
                getParentForChildren(),
                isClean());
        userType_ = null;
      }
      userTypeCase_ = 3;
      onChanged();;
      return jobSeekerBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        Recruiter, Recruiter.Builder, RecruiterOrBuilder> recruiterBuilder_;
    /**
     * <code>.employed.io.Recruiter recruiter = 4;</code>
     */
    public boolean hasRecruiter() {
      return userTypeCase_ == 4;
    }
    /**
     * <code>.employed.io.Recruiter recruiter = 4;</code>
     */
    public Recruiter getRecruiter() {
      if (recruiterBuilder_ == null) {
        if (userTypeCase_ == 4) {
          return (Recruiter) userType_;
        }
        return Recruiter.getDefaultInstance();
      } else {
        if (userTypeCase_ == 4) {
          return recruiterBuilder_.getMessage();
        }
        return Recruiter.getDefaultInstance();
      }
    }
    /**
     * <code>.employed.io.Recruiter recruiter = 4;</code>
     */
    public Builder setRecruiter(Recruiter value) {
      if (recruiterBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        userType_ = value;
        onChanged();
      } else {
        recruiterBuilder_.setMessage(value);
      }
      userTypeCase_ = 4;
      return this;
    }
    /**
     * <code>.employed.io.Recruiter recruiter = 4;</code>
     */
    public Builder setRecruiter(
        Recruiter.Builder builderForValue) {
      if (recruiterBuilder_ == null) {
        userType_ = builderForValue.build();
        onChanged();
      } else {
        recruiterBuilder_.setMessage(builderForValue.build());
      }
      userTypeCase_ = 4;
      return this;
    }
    /**
     * <code>.employed.io.Recruiter recruiter = 4;</code>
     */
    public Builder mergeRecruiter(Recruiter value) {
      if (recruiterBuilder_ == null) {
        if (userTypeCase_ == 4 &&
            userType_ != Recruiter.getDefaultInstance()) {
          userType_ = Recruiter.newBuilder((Recruiter) userType_)
              .mergeFrom(value).buildPartial();
        } else {
          userType_ = value;
        }
        onChanged();
      } else {
        if (userTypeCase_ == 4) {
          recruiterBuilder_.mergeFrom(value);
        }
        recruiterBuilder_.setMessage(value);
      }
      userTypeCase_ = 4;
      return this;
    }
    /**
     * <code>.employed.io.Recruiter recruiter = 4;</code>
     */
    public Builder clearRecruiter() {
      if (recruiterBuilder_ == null) {
        if (userTypeCase_ == 4) {
          userTypeCase_ = 0;
          userType_ = null;
          onChanged();
        }
      } else {
        if (userTypeCase_ == 4) {
          userTypeCase_ = 0;
          userType_ = null;
        }
        recruiterBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.employed.io.Recruiter recruiter = 4;</code>
     */
    public Recruiter.Builder getRecruiterBuilder() {
      return getRecruiterFieldBuilder().getBuilder();
    }
    /**
     * <code>.employed.io.Recruiter recruiter = 4;</code>
     */
    public RecruiterOrBuilder getRecruiterOrBuilder() {
      if ((userTypeCase_ == 4) && (recruiterBuilder_ != null)) {
        return recruiterBuilder_.getMessageOrBuilder();
      } else {
        if (userTypeCase_ == 4) {
          return (Recruiter) userType_;
        }
        return Recruiter.getDefaultInstance();
      }
    }
    /**
     * <code>.employed.io.Recruiter recruiter = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Recruiter, Recruiter.Builder, RecruiterOrBuilder>
        getRecruiterFieldBuilder() {
      if (recruiterBuilder_ == null) {
        if (!(userTypeCase_ == 4)) {
          userType_ = Recruiter.getDefaultInstance();
        }
        recruiterBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Recruiter, Recruiter.Builder, RecruiterOrBuilder>(
                (Recruiter) userType_,
                getParentForChildren(),
                isClean());
        userType_ = null;
      }
      userTypeCase_ = 4;
      onChanged();;
      return recruiterBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:employed.io.LoginResponse)
  }

  // @@protoc_insertion_point(class_scope:employed.io.LoginResponse)
  private static final LoginResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new LoginResponse();
  }

  public static LoginResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LoginResponse>
      PARSER = new com.google.protobuf.AbstractParser<LoginResponse>() {
    public LoginResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new LoginResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LoginResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<LoginResponse> getParserForType() {
    return PARSER;
  }

  public LoginResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

