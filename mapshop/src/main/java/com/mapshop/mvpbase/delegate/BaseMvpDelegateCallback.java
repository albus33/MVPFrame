/*
 * Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mapshop.mvpbase.delegate;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mapshop.mvpbase.MvpPresenter;
import com.mapshop.mvpbase.MvpView;


public interface BaseMvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> {

  /**
   * Creates the presenter instance
   *
   * @return the created presenter instance
   */
  @NonNull
  public P createPresenter();

  /**
   * Get the presenter. If null is returned, then a internally a new presenter instance gets
   * created
   * by calling {@link #createPresenter()}
   *
   * @return the presenter instance. can be null.
   */
  public P getPresenter();

  /**
   * Sets the presenter instance
   *
   * @param presenter The presenter instance
   */
  public void setPresenter(P presenter);

  /**
   * Get the MvpView for the presenter
   *
   * @return The view associated with the presenter
   */
  public V getMvpView();

  /**
   * Indicate whether the retain instance feature is enabled by this view or not
   *
   * @return true if the view has  enabled retaining, otherwise false.
   * @see #setRetainInstance(boolean)
   */
  public boolean isRetainInstance();

  /**
   * Mark this instance as retaining. This means that the feature of a retaining instance is
   * enabled.
   *
   * @param retainingInstance true if retaining instance feature is enabled, otherwise false
   * @see #isRetainInstance()
   */
  public void setRetainInstance(boolean retainingInstance);

  /**
   * Indicates whether or not the the view will be retained during next screen orientation change.
   * This boolean flag is used for {@link MvpPresenter#detachView(boolean)}
   * as parameter. Usually you should take {@link Activity#isChangingConfigurations()} into
   * account. The difference between {@link #shouldInstanceBeRetained()} and {@link
   * #isRetainInstance()} is that {@link #isRetainInstance()} indicates that retain instance
   * feature is enabled or disabled while {@link #shouldInstanceBeRetained()} indicates if the
   * view is going to be destroyed permanently and hence should no more be retained (i.e. Activity
   * is finishing and not just screen orientation changing)
   *
   * @return true if the instance should be retained, otherwise false
   */
  public boolean shouldInstanceBeRetained();
}

