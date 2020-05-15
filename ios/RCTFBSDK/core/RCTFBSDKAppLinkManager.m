// Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
//
// You are hereby granted a non-exclusive, worldwide, royalty-free license to use,
// copy, modify, and distribute this software in source code or binary form for use
// in connection with the web services and APIs provided by Facebook.
//
// As with any software that integrates with the Facebook platform, your use of
// this software is subject to the Facebook Developer Principles and Policies
// [http://developers.facebook.com/policy/]. This copyright notice shall be
// included in all copies or substantial portions of the software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
// FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
// COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
// IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
// CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


#import <Foundation/Foundation.h>

#import "RCTFBSDKAppLinkManager.h"
#import <FBSDKCoreKit/FBSDKCoreKit.h>

#import "RCTFBSDKAccessToken.h"

#import <React/RCTUtils.h>

#import "RCTConvert+FBSDKAccessToken.h"

@implementation RCTFBSDKAppLinkManager

RCT_EXPORT_MODULE(FBAppLinkData);

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

#pragma mark - React Native Methods

RCT_EXPORT_METHOD(fetchDeferredAppLinkData:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
  FBSDKDeferredAppLinkHandler handler = ^(NSURL *url, NSError *error) {
    if (error) {
      resolve(nil);
    } else {
      NSString *urlString = [url absoluteString];
      resolve(urlString);
    }
  };

  [FBSDKAppLinkUtility fetchDeferredAppLink:handler];
}

@end
