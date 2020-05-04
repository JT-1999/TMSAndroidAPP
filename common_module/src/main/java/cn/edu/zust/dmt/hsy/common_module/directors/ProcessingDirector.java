package cn.edu.zust.dmt.hsy.common_module.directors;

import android.os.Bundle;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.hsy.common_module.listeners.ProcessingDirectorListener;
import cn.edu.zust.dmt.hsy.my_base_library.constants.MyExtrasConstants;
import cn.edu.zust.dmt.hsy.my_base_library.directors.BaseDirector;
import cn.edu.zust.dmt.hsy.my_base_library.interfaces.others.BaseExtrasListener;
import cn.edu.zust.dmt.hsy.my_base_library.interfaces.others.BaseContainerListener;
import cn.edu.zust.dmt.hsy.my_base_library.helpers.MyErrorHelper;

/**
 * @author MR.M
 * @version 1.0
 * @projectName TMS
 * @description $
 * @since 4/27/2020 14:21
 **/
public final class ProcessingDirector extends BaseDirector<ProcessingDirectorListener> {
    @Override
    public void loadActors(@NonNull final BaseContainerListener baseContainerListener
            , @NonNull final ProcessingDirectorListener currentDirectorListener) {
        setMyExtrasParser(baseContainerListener, currentDirectorListener);
    }

    private void setMyExtrasParser(@NonNull final BaseContainerListener baseContainerListener
            , @NonNull final ProcessingDirectorListener currentDirectorListener) {
        baseContainerListener.addMyExtrasParser(
                new MyExtrasParser(baseContainerListener, currentDirectorListener));
    }

    private static final class MyExtrasParser extends SafeDirectorInnerClass<ProcessingDirectorListener>
            implements BaseExtrasListener {
        private MyExtrasParser(@NonNull final BaseContainerListener baseContainerListener
                , @NonNull final ProcessingDirectorListener baseDirectorListener) {
            super(baseContainerListener, baseDirectorListener);
        }

        @Override
        public void parseMyExtras(@NonNull Bundle myExtras) {
            final String hintString = myExtras.getString(String.valueOf(MyExtrasConstants.TAG_PROCESSING_HINT));
            if (hintString == null) {
                MyErrorHelper.showMyNullPointerException("Hint string no longer exist!");
            } else {
                getSafeDirector().getHintTextView().setText(hintString);
            }
        }
    }
}