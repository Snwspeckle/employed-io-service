// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol/recruiter/recruiter_request.proto

package io.employed.proto;

public final class RecruiterRequestProto {
  private RecruiterRequestProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employed_io_RecruitersResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employed_io_RecruitersResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n*protocol/recruiter/recruiter_request.p" +
      "roto\022\013employed.io\032\"protocol/recruiter/re" +
      "cruiter.proto\"@\n\022RecruitersResponse\022*\n\nr" +
      "ecruiters\030\001 \003(\0132\026.employed.io.RecruiterB" +
      ",\n\021io.employed.protoB\025RecruiterRequestPr" +
      "otoP\001b\006proto3"
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
          RecruiterProto.getDescriptor(),
        }, assigner);
    internal_static_employed_io_RecruitersResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_employed_io_RecruitersResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employed_io_RecruitersResponse_descriptor,
        new String[] { "Recruiters", });
    RecruiterProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
