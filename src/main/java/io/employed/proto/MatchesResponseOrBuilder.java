// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol/match/match_request.proto

package io.employed.proto;

public interface MatchesResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:employed.io.MatchesResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .employed.io.Match match = 1;</code>
   */
  java.util.List<Match>
      getMatchList();
  /**
   * <code>repeated .employed.io.Match match = 1;</code>
   */
  Match getMatch(int index);
  /**
   * <code>repeated .employed.io.Match match = 1;</code>
   */
  int getMatchCount();
  /**
   * <code>repeated .employed.io.Match match = 1;</code>
   */
  java.util.List<? extends io.employed.proto.MatchOrBuilder> 
      getMatchOrBuilderList();
  /**
   * <code>repeated .employed.io.Match match = 1;</code>
   */
  io.employed.proto.MatchOrBuilder getMatchOrBuilder(
          int index);
}
