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
 *
 * @flow
 * @format
 */
'use strict';

import {ShareContentCommonParameters} from './FBShareContent';

/**
 * A model for photo content to be shared.
 */
export type ShareStoryContent = {
  /**
   * The type of content to be shared is photo.
   */
  contentType: 'story',

  /**
   * Common parameters for share content;
   */
  commonParameters?: ShareContentCommonParameters,

  /**
   * URL for the content being shared.
   */
  contentUrl?: string,

  /**
   * Uri to an image (JPG, PNG) or video (H.264, H.265, WebM). Recommended
   * image dimensions: device fullscreen or smaller. Videos can be 1080p and
   * up to 20 seconds in duration. The Uri needs to be a content Uri to a local
   * file on device.
   */
  backgroundUrl?: string,

  /**
   * Uri to an image (JPG, PNG). Recommended dimensions: 640x480. This image
   * will be placed as a sticker over the background. The Uri needs to be a
   * content Uri to a local file on device.
   */
  stickerUrl?: string,

  /**
   * A list of hex string color values used to generate a gradient from top to
   * bottom, in the order in which they appear in the list. Note that if you
   * are passing a background asset, the asset will be used and the color list
   * will be ignored.
   */
  backgroundColors?: Array<String>,
};
