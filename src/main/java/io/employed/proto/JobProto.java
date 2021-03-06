// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol/job/job.proto

package io.employed.proto;

public final class JobProto {
  private JobProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employed_io_Job_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employed_io_Job_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employed_io_Job_SalaryRange_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employed_io_Job_SalaryRange_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\026protocol/job/job.proto\022\013employed.io\032\036p" +
      "rotocol/common/location.proto\032\036protocol/" +
      "common/industry.proto\032\036protocol/company/" +
      "company.proto\032\"protocol/recruiter/recrui" +
      "ter.proto\"\337\007\n\003Job\022\016\n\006job_id\030\001 \001(\t\022\r\n\005tit" +
      "le\030\002 \001(\t\022\023\n\013description\030\003 \001(\t\022\031\n\021short_d" +
      "escription\030\004 \001(\t\022%\n\007company\030\005 \001(\0132\024.empl" +
      "oyed.io.Company\022)\n\trecruiter\030\006 \001(\0132\026.emp" +
      "loyed.io.Recruiter\022\'\n\010industry\030\007 \001(\0162\025.e" +
      "mployed.io.Industry\0228\n\017employment_type\030\010",
      " \001(\0162\037.employed.io.Job.EmploymentType\022\020\n" +
      "\006salary\030\t \001(\005H\000\0224\n\014salary_range\030\n \001(\0132\034." +
      "employed.io.Job.SalaryRangeH\000\022\'\n\010locatio" +
      "n\030\013 \001(\0132\025.employed.io.Location\022\027\n\017number" +
      "_of_hires\030\014 \001(\005\022\033\n\023required_experience\030\r" +
      " \001(\t\022\034\n\024preferred_experience\030\016 \001(\t\022\016\n\006sk" +
      "ills\030\017 \003(\t\022\030\n\020responsibilities\030\020 \001(\t\022\022\n\n" +
      "experience\030\021 \001(\005\0228\n\017education_level\030\022 \003(" +
      "\0162\037.employed.io.Job.EducationLevel\022\014\n\004ta" +
      "gs\030\023 \003(\t\0325\n\013SalaryRange\022\022\n\nmin_salary\030\001 ",
      "\001(\005\022\022\n\nmax_salary\030\002 \001(\005\"j\n\016EmploymentTyp" +
      "e\022\r\n\tFULL_TIME\020\000\022\r\n\tPART_TIME\020\001\022\014\n\010CONTR" +
      "ACT\020\002\022\016\n\nINTERNSHIP\020\003\022\r\n\tTEMPORARY\020\004\022\r\n\t" +
      "VOLUNTEER\020\005\"\326\001\n\016EducationLevel\022\027\n\023HIGH_S" +
      "CHOOL_DIPLOMA\020\000\022\025\n\021ASSOCIATES_DEGREE\020\001\022\024" +
      "\n\020BACHELORS_DEGREE\020\002\022\022\n\016MASTERS_DEGREE\020\003" +
      "\022%\n!MASTER_OF_BUSINESS_ADMINISTRATION\020\004\022" +
      "\030\n\024DOCTOR_OF_PHILOSOPHY\020\005\022\026\n\022DOCTOR_OF_M" +
      "EDICINE\020\006\022\021\n\rDOCTOR_OF_LAW\020\007B\r\n\013salary_t" +
      "ypeB\037\n\021io.employed.protoB\010JobProtoP\001b\006pr",
      "oto3"
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
          io.employed.proto.LocationProto.getDescriptor(),
          IndustryProto.getDescriptor(),
          CompanyProto.getDescriptor(),
          io.employed.proto.RecruiterProto.getDescriptor(),
        }, assigner);
    internal_static_employed_io_Job_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_employed_io_Job_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employed_io_Job_descriptor,
        new String[] { "JobId", "Title", "Description", "ShortDescription", "Company", "Recruiter", "Industry", "EmploymentType", "Salary", "SalaryRange", "Location", "NumberOfHires", "RequiredExperience", "PreferredExperience", "Skills", "Responsibilities", "Experience", "EducationLevel", "Tags", "SalaryType", });
    internal_static_employed_io_Job_SalaryRange_descriptor =
      internal_static_employed_io_Job_descriptor.getNestedTypes().get(0);
    internal_static_employed_io_Job_SalaryRange_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employed_io_Job_SalaryRange_descriptor,
        new String[] { "MinSalary", "MaxSalary", });
    io.employed.proto.LocationProto.getDescriptor();
    IndustryProto.getDescriptor();
    CompanyProto.getDescriptor();
    io.employed.proto.RecruiterProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
