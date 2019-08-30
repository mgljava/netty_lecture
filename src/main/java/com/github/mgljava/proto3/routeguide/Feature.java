// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route_guide.proto

package com.github.mgljava.proto3.routeguide;

/**
 * <pre>
 * A feature names something at a given point.
 * If a feature could not be named, the name is empty.
 * </pre>
 *
 * Protobuf type {@code routeguide.Feature}
 */
public  final class Feature extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:routeguide.Feature)
    FeatureOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Feature.newBuilder() to construct.
  private Feature(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Feature() {
    name_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new Feature();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Feature(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
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
          case 10: {
            String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 18: {
            com.github.mgljava.proto3.routeguide.Point.Builder subBuilder = null;
            if (location_ != null) {
              subBuilder = location_.toBuilder();
            }
            location_ = input.readMessage(com.github.mgljava.proto3.routeguide.Point.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(location_);
              location_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
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
    return com.github.mgljava.proto3.routeguide.RouteGuideProto.internal_static_routeguide_Feature_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.github.mgljava.proto3.routeguide.RouteGuideProto.internal_static_routeguide_Feature_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Feature.class, Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile Object name_;
  /**
   * <pre>
   * The name of the feature.
   * </pre>
   *
   * <code>string name = 1;</code>
   */
  public String getName() {
    Object ref = name_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * The name of the feature.
   * </pre>
   *
   * <code>string name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    Object ref = name_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LOCATION_FIELD_NUMBER = 2;
  private com.github.mgljava.proto3.routeguide.Point location_;
  /**
   * <pre>
   * The point where the feature is detected.
   * </pre>
   *
   * <code>.routeguide.Point location = 2;</code>
   */
  public boolean hasLocation() {
    return location_ != null;
  }
  /**
   * <pre>
   * The point where the feature is detected.
   * </pre>
   *
   * <code>.routeguide.Point location = 2;</code>
   */
  public com.github.mgljava.proto3.routeguide.Point getLocation() {
    return location_ == null ? com.github.mgljava.proto3.routeguide.Point.getDefaultInstance() : location_;
  }
  /**
   * <pre>
   * The point where the feature is detected.
   * </pre>
   *
   * <code>.routeguide.Point location = 2;</code>
   */
  public com.github.mgljava.proto3.routeguide.PointOrBuilder getLocationOrBuilder() {
    return getLocation();
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (location_ != null) {
      output.writeMessage(2, getLocation());
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (location_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getLocation());
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
    if (!(obj instanceof Feature)) {
      return super.equals(obj);
    }
    Feature other = (Feature) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (hasLocation() != other.hasLocation()) return false;
    if (hasLocation()) {
      if (!getLocation()
          .equals(other.getLocation())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    if (hasLocation()) {
      hash = (37 * hash) + LOCATION_FIELD_NUMBER;
      hash = (53 * hash) + getLocation().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Feature parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Feature parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Feature parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Feature parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Feature parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Feature parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Feature parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Feature parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Feature parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Feature parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Feature parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Feature parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Feature prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
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
   * <pre>
   * A feature names something at a given point.
   * If a feature could not be named, the name is empty.
   * </pre>
   *
   * Protobuf type {@code routeguide.Feature}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:routeguide.Feature)
      com.github.mgljava.proto3.routeguide.FeatureOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.github.mgljava.proto3.routeguide.RouteGuideProto.internal_static_routeguide_Feature_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.github.mgljava.proto3.routeguide.RouteGuideProto.internal_static_routeguide_Feature_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Feature.class, Builder.class);
    }

    // Construct using com.github.mgljava.proto3.routeguide.Feature.newBuilder()
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
    @Override
    public Builder clear() {
      super.clear();
      name_ = "";

      if (locationBuilder_ == null) {
        location_ = null;
      } else {
        location_ = null;
        locationBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.github.mgljava.proto3.routeguide.RouteGuideProto.internal_static_routeguide_Feature_descriptor;
    }

    @Override
    public Feature getDefaultInstanceForType() {
      return Feature.getDefaultInstance();
    }

    @Override
    public Feature build() {
      Feature result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public Feature buildPartial() {
      Feature result = new Feature(this);
      result.name_ = name_;
      if (locationBuilder_ == null) {
        result.location_ = location_;
      } else {
        result.location_ = locationBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof Feature) {
        return mergeFrom((Feature)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Feature other) {
      if (other == Feature.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.hasLocation()) {
        mergeLocation(other.getLocation());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Feature parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (Feature) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object name_ = "";
    /**
     * <pre>
     * The name of the feature.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public String getName() {
      Object ref = name_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <pre>
     * The name of the feature.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * The name of the feature.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public Builder setName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The name of the feature.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The name of the feature.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private com.github.mgljava.proto3.routeguide.Point location_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.github.mgljava.proto3.routeguide.Point, com.github.mgljava.proto3.routeguide.Point.Builder, com.github.mgljava.proto3.routeguide.PointOrBuilder> locationBuilder_;
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.routeguide.Point location = 2;</code>
     */
    public boolean hasLocation() {
      return locationBuilder_ != null || location_ != null;
    }
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.routeguide.Point location = 2;</code>
     */
    public com.github.mgljava.proto3.routeguide.Point getLocation() {
      if (locationBuilder_ == null) {
        return location_ == null ? com.github.mgljava.proto3.routeguide.Point.getDefaultInstance() : location_;
      } else {
        return locationBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.routeguide.Point location = 2;</code>
     */
    public Builder setLocation(com.github.mgljava.proto3.routeguide.Point value) {
      if (locationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        location_ = value;
        onChanged();
      } else {
        locationBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.routeguide.Point location = 2;</code>
     */
    public Builder setLocation(
        com.github.mgljava.proto3.routeguide.Point.Builder builderForValue) {
      if (locationBuilder_ == null) {
        location_ = builderForValue.build();
        onChanged();
      } else {
        locationBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.routeguide.Point location = 2;</code>
     */
    public Builder mergeLocation(com.github.mgljava.proto3.routeguide.Point value) {
      if (locationBuilder_ == null) {
        if (location_ != null) {
          location_ =
            com.github.mgljava.proto3.routeguide.Point.newBuilder(location_).mergeFrom(value).buildPartial();
        } else {
          location_ = value;
        }
        onChanged();
      } else {
        locationBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.routeguide.Point location = 2;</code>
     */
    public Builder clearLocation() {
      if (locationBuilder_ == null) {
        location_ = null;
        onChanged();
      } else {
        location_ = null;
        locationBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.routeguide.Point location = 2;</code>
     */
    public com.github.mgljava.proto3.routeguide.Point.Builder getLocationBuilder() {
      
      onChanged();
      return getLocationFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.routeguide.Point location = 2;</code>
     */
    public com.github.mgljava.proto3.routeguide.PointOrBuilder getLocationOrBuilder() {
      if (locationBuilder_ != null) {
        return locationBuilder_.getMessageOrBuilder();
      } else {
        return location_ == null ?
            com.github.mgljava.proto3.routeguide.Point.getDefaultInstance() : location_;
      }
    }
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.routeguide.Point location = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.github.mgljava.proto3.routeguide.Point, com.github.mgljava.proto3.routeguide.Point.Builder, com.github.mgljava.proto3.routeguide.PointOrBuilder> 
        getLocationFieldBuilder() {
      if (locationBuilder_ == null) {
        locationBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.github.mgljava.proto3.routeguide.Point, com.github.mgljava.proto3.routeguide.Point.Builder, com.github.mgljava.proto3.routeguide.PointOrBuilder>(
                getLocation(),
                getParentForChildren(),
                isClean());
        location_ = null;
      }
      return locationBuilder_;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:routeguide.Feature)
  }

  // @@protoc_insertion_point(class_scope:routeguide.Feature)
  private static final Feature DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Feature();
  }

  public static Feature getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Feature>
      PARSER = new com.google.protobuf.AbstractParser<Feature>() {
    @Override
    public Feature parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Feature(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Feature> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Feature> getParserForType() {
    return PARSER;
  }

  @Override
  public Feature getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

