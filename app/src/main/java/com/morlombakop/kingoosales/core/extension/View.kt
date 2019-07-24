/*
 * Created by Mbakop Ngongang Morlo on 7/23/19 4:45 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/23/19 4:45 PM
 */

package com.morlombakop.kingoosales.core.extension


import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition

fun View.cancelTransition() {
  transitionName = null
}

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() {
  this.visibility = View.VISIBLE
}

fun View.invisible() {
  this.visibility = View.GONE
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
  LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.loadFromUrl(url: String) =
  Glide.with(this.context.applicationContext)
    .load(url)
    .transition(DrawableTransitionOptions.withCrossFade())
    .into(this)

fun ImageView.loadUrlAndPostponeEnterTransition(url: String, activity: FragmentActivity) {
  val target: Target<Drawable> = ImageViewBaseTarget(this, activity)
  Glide.with(context.applicationContext).load(url).into(target)
}

private class ImageViewBaseTarget(var imageView: ImageView, var activity: FragmentActivity?) :
  CustomViewTarget<ImageView, Drawable>(imageView) {
  override fun onResourceCleared(placeholder: Drawable?) {
    imageView.setImageDrawable(placeholder)
    activity = null
  }

  override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
    imageView.setImageDrawable(resource)
    activity?.supportStartPostponedEnterTransition()
  }

  override fun onLoadFailed(errorDrawable: Drawable?) {
    // TODO log the error somewhere please
    activity?.supportStartPostponedEnterTransition()
  }
}
