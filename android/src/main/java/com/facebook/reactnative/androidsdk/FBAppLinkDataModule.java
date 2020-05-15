/**
 * Copyright (c) 2014-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use,
 * copy, modify, and distribute this software in source code or binary form for use
 * in connection with the web services and APIs provided by Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use of
 * this software is subject to the Facebook Developer Principles and Policies
 * [http://developers.facebook.com/policy/]. This copyright notice shall be
 * included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.facebook.reactnative.androidsdk;

import android.support.annotation.Nullable;

import com.facebook.applinks.AppLinkData;
import com.facebook.applinks.FacebookAppLinkResolver;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

public class FBAppLinkDataModule extends ReactContextBaseJavaModule {

	private class CompletionHandler implements AppLinkData.CompletionHandler {

		private Promise mPromise;

		public CompletionHandler(final Promise promise) {
			mPromise = promise;
		}

        /**
         * This method is called when deferred app link data has been fetched. If no app link data
         * was found, this method is called with null
         *
         * @param appLinkData The app link data that was fetched. Null if none was found.
         */
		@Override
        void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
            if (appLinkData == null) {
			    mPromise.resolve(null);
            } else {
			    mPromise.resolve(appLinkData.getTargetUri().toString());
            }
		}
    }

    private ReactApplicationContext mReactContext;

    public FBAppLinkDataModule(ReactApplicationContext reactContext) {
		super(reactContext);
		mReactContext = reactContext;
    }

    public String getName() {
        return "FBAppLinkData";
    }

	@ReactMethod
    public void fetchDeferredAppLinkData(final Promise promise) {
        AppLinkData.fetchDeferredAppLinkData(mReactContext, new CompletionHandler(promise));
    }
}
