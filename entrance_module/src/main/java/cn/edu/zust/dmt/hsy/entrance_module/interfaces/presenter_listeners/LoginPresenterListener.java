package cn.edu.zust.dmt.hsy.entrance_module.interfaces.presenter_listeners;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.hsy.common_module.views.combined.cm_MyFormBar;
import cn.edu.zust.dmt.hsy.entrance_module.datas.remote.response.LoginResponseData;
import cn.edu.zust.dmt.hsy.my_base_library.interfaces.others.BaseNetworkCallback;
import cn.edu.zust.dmt.hsy.my_base_library.interfaces.presenter_listeners.BasePresenterListener;

/**
 * @author MR.M
 * @version 1.0
 * @projectName TMS
 * @description $
 * @since 5/22/2020 20:38
 **/
public interface LoginPresenterListener extends BasePresenterListener {
    /**
     * @return {@link TextView} contains voucher string
     */
    @NonNull
    cm_MyFormBar getVoucherBar();

    /**
     * @return {@link TextView} contains password string
     */
    @NonNull
    cm_MyFormBar getPasswordBar();

    /**
     * @return {@link View} for trigger login event by click
     */
    @NonNull
    View getLoginClickableView();

    /**
     * @return {@link BaseNetworkCallback} contains view actions
     */
    @NonNull
    BaseNetworkCallback<LoginResponseData> getLoginCallback();

    /**
     * @description contains method for illegal voucher input
     */
    void getVoucherInputError();

    /**
     * @description contains method for illegal password input
     */
    void getPasswordInputError();

    /**
     * @description contains method for illegal login request
     */
    void getLoginError();
}
