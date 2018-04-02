// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol/match/match_request.proto

package io.employed.proto;

public final class MatchRequestProto {
  private MatchRequestProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employed_io_MatchesByUserIdsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employed_io_MatchesByUserIdsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employed_io_MatchesByUserIdsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employed_io_MatchesByUserIdsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employed_io_CreateMatchRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employed_io_CreateMatchRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employed_io_CreateMatchResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employed_io_CreateMatchResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employed_io_RejectMatchRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employed_io_RejectMatchRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employed_io_RejectMatchResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employed_io_RejectMatchResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employed_io_MatchesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employed_io_MatchesResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\"protocol/match/match_request.proto\022\013em" +
      "ployed.io\032\034protocol/common/status.proto\032" +
      "\032protocol/match/match.proto\"+\n\027MatchesBy" +
      "UserIdsRequest\022\020\n\010user_ids\030\001 \003(\t\"?\n\030Matc" +
      "hesByUserIdsResponse\022#\n\007matches\030\001 \003(\0132\022." +
      "employed.io.Match\"<\n\022CreateMatchRequest\022" +
      "\017\n\007user_id\030\001 \001(\t\022\025\n\rmatch_user_id\030\002 \001(\t\"" +
      "]\n\023CreateMatchResponse\022#\n\006status\030\001 \001(\0162\023" +
      ".employed.io.Status\022!\n\005match\030\002 \001(\0132\022.emp" +
      "loyed.io.Match\"<\n\022RejectMatchRequest\022\017\n\007",
      "user_id\030\001 \001(\t\022\025\n\rmatch_user_id\030\002 \001(\t\":\n\023" +
      "RejectMatchResponse\022#\n\006status\030\001 \001(\0162\023.em" +
      "ployed.io.Status\"4\n\017MatchesResponse\022!\n\005m" +
      "atch\030\001 \003(\0132\022.employed.io.MatchB(\n\021io.emp" +
      "loyed.protoB\021MatchRequestProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          StatusProto.getDescriptor(),
          MatchProto.getDescriptor(),
        }, assigner);
    internal_static_employed_io_MatchesByUserIdsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_employed_io_MatchesByUserIdsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employed_io_MatchesByUserIdsRequest_descriptor,
        new String[] { "UserIds", });
    internal_static_employed_io_MatchesByUserIdsResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_employed_io_MatchesByUserIdsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employed_io_MatchesByUserIdsResponse_descriptor,
        new String[] { "Matches", });
    internal_static_employed_io_CreateMatchRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_employed_io_CreateMatchRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employed_io_CreateMatchRequest_descriptor,
        new String[] { "UserId", "MatchUserId", });
    internal_static_employed_io_CreateMatchResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_employed_io_CreateMatchResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employed_io_CreateMatchResponse_descriptor,
        new String[] { "Status", "Match", });
    internal_static_employed_io_RejectMatchRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_employed_io_RejectMatchRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employed_io_RejectMatchRequest_descriptor,
        new String[] { "UserId", "MatchUserId", });
    internal_static_employed_io_RejectMatchResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_employed_io_RejectMatchResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employed_io_RejectMatchResponse_descriptor,
        new String[] { "Status", });
    internal_static_employed_io_MatchesResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_employed_io_MatchesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employed_io_MatchesResponse_descriptor,
        new String[] { "Match", });
    StatusProto.getDescriptor();
    MatchProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
