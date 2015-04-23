#include <jni.h>
#include <android/log.h>
#include "json/json.h"

#define  LOG_TAG    "main"
#define  LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)

extern "C"
{
jstring Java_com_kevin_tutorial_jsoncpp_ToUseJsoncppActivity_toBuildJson(JNIEnv*  env, jobject thiz,jint id,jstring name){
  jboolean isCopy = 0;
  const char* c_name = env->GetStringUTFChars(name, &isCopy);
  LOGD("on calling,id:%d,name:%s",id,c_name);
  // to build a json object with id and name
  Json::Value user;
  user["id"] = id;
  user["name"] = c_name;
  const char* json_str = user.toStyledString().c_str();
  jstring result = env->NewStringUTF(json_str);
  env->ReleaseStringUTFChars(name,c_name);
  return result;
} /* Java_com_kevin_tutorial_jsoncpp_ToUseJsoncppActivity_toBuildJson */

} /* extern "C" */
