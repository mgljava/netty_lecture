// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route_guide.proto

package com.github.mgljava.protobuf_grpc.routeguide;

public interface FeatureDatabaseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:routeguide.FeatureDatabase)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  java.util.List<Feature>
      getFeatureList();
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  Feature getFeature(int index);
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  int getFeatureCount();
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  java.util.List<? extends com.github.mgljava.protobuf_grpc.routeguide.FeatureOrBuilder>
      getFeatureOrBuilderList();
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  com.github.mgljava.protobuf_grpc.routeguide.FeatureOrBuilder getFeatureOrBuilder(
      int index);
}