// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol/common/location.proto

package io.employed.proto;

public interface LocationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:employed.io.Location)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.employed.io.Address address = 1;</code>
   */
  boolean hasAddress();
  /**
   * <code>.employed.io.Address address = 1;</code>
   */
  Address getAddress();
  /**
   * <code>.employed.io.Address address = 1;</code>
   */
  AddressOrBuilder getAddressOrBuilder();

  /**
   * <code>double latitude = 2;</code>
   */
  double getLatitude();

  /**
   * <code>double longitude = 3;</code>
   */
  double getLongitude();
}