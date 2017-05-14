package com.ontrava.app.lottieexample;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ozan on 14/05/2017.
 */

public class EndFragment extends Fragment {

    @BindView(R.id.end_lottie_animation_view_emoji)
    LottieAnimationView mEmojiLottie;
    @BindView(R.id.end_lottie_animation_view_loading)
    LottieAnimationView mLoadingLottie;
    private Unbinder mUnbinder;

    public static EndFragment newInstance(Context context) {
        return (EndFragment) EndFragment.instantiate(context, EndFragment.class.getName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_end, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLoadingLottie.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mLoadingLottie.setVisibility(View.INVISIBLE);
                mEmojiLottie.setVisibility(View.VISIBLE);
                mEmojiLottie.setProgress(0f);
                mEmojiLottie.playAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mLoadingLottie.setProgress(0f);
        mLoadingLottie.playAnimation();
    }

    @Override
    public void onStop() {
        super.onStop();
        mLoadingLottie.cancelAnimation();
        mEmojiLottie.cancelAnimation();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
