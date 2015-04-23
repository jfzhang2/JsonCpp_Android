LOCAL_PATH := $(call my-dir)  
include $(CLEAR_VARS)  
  
subdirs := $(LOCAL_PATH)/test/Android.mk  
subdirs += $(LOCAL_PATH)/jsoncpp/Android.mk  
  
include $(subdirs) 