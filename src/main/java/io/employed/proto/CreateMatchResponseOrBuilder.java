// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol/match/match_request.proto

package io.employed.proto;

public interface CreateMatchResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:employed.io.CreateMatchResponse)
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
   * <code>.employed.io.Match match = 2;</code>
   */
  boolean hasMatch();
  /**
   * <code>.employed.io.Match match = 2;</code>
   */
  io.employed.proto.Match getMatch();
  /**
   * <code>.employed.io.Match match = 2;</code>
   */
  io.employed.proto.MatchOrBuilder getMatchOrBuilder();
}