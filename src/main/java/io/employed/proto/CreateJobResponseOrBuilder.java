// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol/job/job_request.proto

package io.employed.proto;

public interface CreateJobResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:employed.io.CreateJobResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.employed.io.Status status = 1;</code>
   */
  int getStatusValue();
  /**
   * <code>.employed.io.Status status = 1;</code>
   */
  io.employed.proto.Status getStatus();

  /**
   * <code>.employed.io.Job job = 2;</code>
   */
  boolean hasJob();
  /**
   * <code>.employed.io.Job job = 2;</code>
   */
  io.employed.proto.Job getJob();
  /**
   * <code>.employed.io.Job job = 2;</code>
   */
  io.employed.proto.JobOrBuilder getJobOrBuilder();
}
