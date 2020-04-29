package cn.edu.zust.dmt.hsy.myannotationslibrary.interfaces;

import java.util.Map;

import cn.edu.zust.dmt.hsy.myannotationslibrary.constants.MyRouterPaths;

/**
 * @author MR.M
 * @version 1.0
 * @projectName TMS
 * @description $
 * @since 4/12/2020 22:12
 **/
public interface IMyRouterRecorder {
    /**
     * @description methods stores map for {@link MyRouterPaths} to targetClass path
     */
    Map<MyRouterPaths, String> getRouterMap();
}
