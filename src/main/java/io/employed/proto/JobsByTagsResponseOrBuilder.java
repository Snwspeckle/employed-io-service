// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol/job/job_request.proto

package io.employed.proto;

public interface JobsByTagsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:employed.io.JobsByTagsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .employed.io.Job jobs = 1;</code>
   */
  java.util.List<Job>
      getJobsList();
  /**
   * <code>repeated .employed.io.Job jobs = 1;</code>
   */
  Job getJobs(int index);
  /**
   * <code>repeated .employed.io.Job jobs = 1;</code>
   */
  int getJobsCount();
  /**
   * <code>repeated .employed.io.Job jobs = 1;</code>
   */
  java.util.List<? extends JobOrBuilder>
      getJobsOrBuilderList();
  /**
   * <code>repeated .employed.io.Job jobs = 1;</code>
   */
  JobOrBuilder getJobsOrBuilder(
          int index);
}
