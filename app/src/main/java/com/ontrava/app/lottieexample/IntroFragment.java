package com.ontrava.app.lottieexample;

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
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ozan on 14/05/2017.
 */

public class IntroFragment extends Fragment {

    @BindView(R.id.intro_lottie_animation_view)
    LottieAnimationView mLottie;
    private Unbinder mUnbinder;

    public static IntroFragment newInstance(Context context) {
        return (IntroFragment) IntroFragment.instantiate(context, IntroFragment.class.getName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Override
    public void onStart() {
        super.onStart();
        mLottie.setProgress(0f);
        mLottie.playAnimation();
    }

    @Override
    public void onStop() {
        super.onStop();
        mLottie.cancelAnimation();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick(R.id.intro_button)
    public void onViewClicked() {

    }
}
