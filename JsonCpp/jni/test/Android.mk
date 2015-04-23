LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := main  
# for jsoncpp
LOCAL_CPPFLAGS := -DJSON_IS_AMALGAMATION
LOCAL_SRC_FILES := main.cpp
LOCAL_C_INCLUDES := $(LOCAL_PATH)/../jsoncpp
# it is used for ndk-r5
# if you build with ndk-r4, comment it
# because the new Windows toolchain doesn't support Cygwin's drive
# mapping (i.e /cygdrive/c/ instead of C:/)
LOCAL_LDLIBS := -L$(call host-path, $(LOCAL_PATH)/../../libs/armeabi) \
-ljsoncpp -llog
include $(BUILD_SHARED_LIBRARY)