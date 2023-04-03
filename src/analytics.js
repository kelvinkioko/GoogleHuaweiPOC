import googleAnalytics from '@react-native-firebase/analytics';
import {NativeModules} from 'react-native';

const logEvent = async (name, params) => {
  const {flavor} = await NativeModules.BuildConfig.getFlavor();
  if (flavor === 'huawei') {
    NativeModules.HMSAnalytics.logEvent(name, JSON.stringify(params));
    return;
  }
  googleAnalytics().logEvent(name, params);
};

const setUserProperty = async (name, value) => {
  const {flavor} = await NativeModules.BuildConfig.getFlavor();
  if (flavor === 'huawei') {
    NativeModules.HMSAnalytics.setUserProfile(name, value);
    return;
  }
  googleAnalytics().setUserProperty(name, value);
};

export default {
  logEvent,
  setUserProperty,
};
