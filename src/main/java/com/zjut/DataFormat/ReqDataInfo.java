// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: test.proto

package com.zjut.DataFormat;

public final class ReqDataInfo {
  private ReqDataInfo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface ReqDataOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
    
    // required int32 head = 1;
    boolean hasHead();
    int getHead();
    
    // required int32 dev_id = 2;
    boolean hasDevId();
    int getDevId();
    
    // required int32 ad_id = 3;
    boolean hasAdId();
    int getAdId();
    
    // required string end = 4;
    boolean hasEnd();
    String getEnd();
  }
  public static final class ReqData extends
      com.google.protobuf.GeneratedMessage
      implements ReqDataOrBuilder {
    // Use ReqData.newBuilder() to construct.
    private ReqData(Builder builder) {
      super(builder);
    }
    private ReqData(boolean noInit) {}
    
    private static final ReqData defaultInstance;
    public static ReqData getDefaultInstance() {
      return defaultInstance;
    }
    
    public ReqData getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.zjut.DataFormat.ReqDataInfo.internal_static_ReqData_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.zjut.DataFormat.ReqDataInfo.internal_static_ReqData_fieldAccessorTable;
    }
    
    private int bitField0_;
    // required int32 head = 1;
    public static final int HEAD_FIELD_NUMBER = 1;
    private int head_;
    public boolean hasHead() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public int getHead() {
      return head_;
    }
    
    // required int32 dev_id = 2;
    public static final int DEV_ID_FIELD_NUMBER = 2;
    private int devId_;
    public boolean hasDevId() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    public int getDevId() {
      return devId_;
    }
    
    // required int32 ad_id = 3;
    public static final int AD_ID_FIELD_NUMBER = 3;
    private int adId_;
    public boolean hasAdId() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    public int getAdId() {
      return adId_;
    }
    
    // required string end = 4;
    public static final int END_FIELD_NUMBER = 4;
    private java.lang.Object end_;
    public boolean hasEnd() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    public String getEnd() {
      java.lang.Object ref = end_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (com.google.protobuf.Internal.isValidUtf8(bs)) {
          end_ = s;
        }
        return s;
      }
    }
    private com.google.protobuf.ByteString getEndBytes() {
      java.lang.Object ref = end_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
        end_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    
    private void initFields() {
      head_ = 0;
      devId_ = 0;
      adId_ = 0;
      end_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      if (!hasHead()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasDevId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasAdId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasEnd()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, head_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, devId_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt32(3, adId_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, getEndBytes());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, head_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, devId_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, adId_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, getEndBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static com.zjut.DataFormat.ReqDataInfo.ReqData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.zjut.DataFormat.ReqDataInfo.ReqData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.zjut.DataFormat.ReqDataInfo.ReqData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.zjut.DataFormat.ReqDataInfo.ReqData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.zjut.DataFormat.ReqDataInfo.ReqData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.zjut.DataFormat.ReqDataInfo.ReqData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.zjut.DataFormat.ReqDataInfo.ReqData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.zjut.DataFormat.ReqDataInfo.ReqData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.zjut.DataFormat.ReqDataInfo.ReqData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.zjut.DataFormat.ReqDataInfo.ReqData parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.zjut.DataFormat.ReqDataInfo.ReqData prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.zjut.DataFormat.ReqDataInfo.ReqDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.zjut.DataFormat.ReqDataInfo.internal_static_ReqData_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.zjut.DataFormat.ReqDataInfo.internal_static_ReqData_fieldAccessorTable;
      }
      
      // Construct using com.zjut.DataFormat.ReqDataInfo.ReqData.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        head_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        devId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        adId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        end_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.zjut.DataFormat.ReqDataInfo.ReqData.getDescriptor();
      }
      
      public com.zjut.DataFormat.ReqDataInfo.ReqData getDefaultInstanceForType() {
        return com.zjut.DataFormat.ReqDataInfo.ReqData.getDefaultInstance();
      }
      
      public com.zjut.DataFormat.ReqDataInfo.ReqData build() {
        com.zjut.DataFormat.ReqDataInfo.ReqData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private com.zjut.DataFormat.ReqDataInfo.ReqData buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        com.zjut.DataFormat.ReqDataInfo.ReqData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public com.zjut.DataFormat.ReqDataInfo.ReqData buildPartial() {
        com.zjut.DataFormat.ReqDataInfo.ReqData result = new com.zjut.DataFormat.ReqDataInfo.ReqData(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.head_ = head_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.devId_ = devId_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.adId_ = adId_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.end_ = end_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.zjut.DataFormat.ReqDataInfo.ReqData) {
          return mergeFrom((com.zjut.DataFormat.ReqDataInfo.ReqData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.zjut.DataFormat.ReqDataInfo.ReqData other) {
        if (other == com.zjut.DataFormat.ReqDataInfo.ReqData.getDefaultInstance()) return this;
        if (other.hasHead()) {
          setHead(other.getHead());
        }
        if (other.hasDevId()) {
          setDevId(other.getDevId());
        }
        if (other.hasAdId()) {
          setAdId(other.getAdId());
        }
        if (other.hasEnd()) {
          setEnd(other.getEnd());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        if (!hasHead()) {
          
          return false;
        }
        if (!hasDevId()) {
          
          return false;
        }
        if (!hasAdId()) {
          
          return false;
        }
        if (!hasEnd()) {
          
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              head_ = input.readInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              devId_ = input.readInt32();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              adId_ = input.readInt32();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              end_ = input.readBytes();
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // required int32 head = 1;
      private int head_ ;
      public boolean hasHead() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public int getHead() {
        return head_;
      }
      public Builder setHead(int value) {
        bitField0_ |= 0x00000001;
        head_ = value;
        onChanged();
        return this;
      }
      public Builder clearHead() {
        bitField0_ = (bitField0_ & ~0x00000001);
        head_ = 0;
        onChanged();
        return this;
      }
      
      // required int32 dev_id = 2;
      private int devId_ ;
      public boolean hasDevId() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      public int getDevId() {
        return devId_;
      }
      public Builder setDevId(int value) {
        bitField0_ |= 0x00000002;
        devId_ = value;
        onChanged();
        return this;
      }
      public Builder clearDevId() {
        bitField0_ = (bitField0_ & ~0x00000002);
        devId_ = 0;
        onChanged();
        return this;
      }
      
      // required int32 ad_id = 3;
      private int adId_ ;
      public boolean hasAdId() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      public int getAdId() {
        return adId_;
      }
      public Builder setAdId(int value) {
        bitField0_ |= 0x00000004;
        adId_ = value;
        onChanged();
        return this;
      }
      public Builder clearAdId() {
        bitField0_ = (bitField0_ & ~0x00000004);
        adId_ = 0;
        onChanged();
        return this;
      }
      
      // required string end = 4;
      private java.lang.Object end_ = "";
      public boolean hasEnd() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      public String getEnd() {
        java.lang.Object ref = end_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
          end_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      public Builder setEnd(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        end_ = value;
        onChanged();
        return this;
      }
      public Builder clearEnd() {
        bitField0_ = (bitField0_ & ~0x00000008);
        end_ = getDefaultInstance().getEnd();
        onChanged();
        return this;
      }
      void setEnd(com.google.protobuf.ByteString value) {
        bitField0_ |= 0x00000008;
        end_ = value;
        onChanged();
      }
      
      // @@protoc_insertion_point(builder_scope:ReqData)
    }
    
    static {
      defaultInstance = new ReqData(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:ReqData)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_ReqData_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ReqData_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ntest.proto\"C\n\007ReqData\022\014\n\004head\030\001 \002(\005\022\016\n" +
      "\006dev_id\030\002 \002(\005\022\r\n\005ad_id\030\003 \002(\005\022\013\n\003end\030\004 \002(" +
      "\tB\"\n\023com.zjut.DataFormatB\013ReqDataInfo"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_ReqData_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_ReqData_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_ReqData_descriptor,
              new java.lang.String[] { "Head", "DevId", "AdId", "End", },
              com.zjut.DataFormat.ReqDataInfo.ReqData.class,
              com.zjut.DataFormat.ReqDataInfo.ReqData.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}
